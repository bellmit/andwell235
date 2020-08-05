package com.andawell.material.service.impl;

import com.andawell.common.util.BusinessException;
import com.andawell.common.util.FileUtils;
import com.andawell.common.util.SQLiteUtils;
import com.andawell.material.config.SQLiteConfig;
import com.andawell.material.dto.ZQSaveDTO;
import com.andawell.material.entity.*;
import com.andawell.material.enumeration.TableNameStyle;
import com.andawell.material.enumeration.WeholeNumberStyle;
import com.andawell.material.mapper.*;
import com.andawell.material.query.TDbSjsqqdQuery;
import com.andawell.material.query.TDbSjsqqdTempQuery;
import com.andawell.material.service.ITDbJgdbService;
import com.andawell.material.util.*;
import com.andawell.material.vo.TDbSjsqAndQDVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zje
 * @date: 2020/5/28
 * @description:
 */
@Service
@Slf4j
public class TDbJgdbServiceImpl implements ITDbJgdbService {

    @Autowired
    private TDbJgdbMapper dbJgdbMapper;

    @Autowired
    private TDbJgdbqdMapper dbJgdbqdMapper;

    @Autowired
    private TDbSjsqMapper dbSjsqMapper;

    @Autowired
    private TDbSjsqqdMapper dbSjsqqdMapper;

    @Autowired
    private TDbSjsqTempMapper dbSjsqTempMapper;

    @Autowired
    private TDbSjsqqdTempMapper dbSjsqqdTempMapper;

    @Value("${upload.path}")
    private String filepath;


    @Override
    public String getAllotBh(Integer type) {
        StringBuffer bh=new StringBuffer();
        String sysYear = Utils.getSysYear();
        bh.append(sysYear);
        String documentNo = "";

        if(type.equals(1)) {
            //部队调拨
            //编号规则：4位年度+.+3位流水
            //示例：2020.004
            bh.append(".");
        }else if(type.equals(2)) {
            //工厂调拨
            //编号规则：4位年度+GC+3位流水
            //2020GC001
            bh.append("GC");
        }else {
            throw  new BusinessException("入参错误");
        }
        TDbJgdb tDbJgdb = dbJgdbMapper.selectByNew(bh.toString());
        documentNo = NumberUtils.getDocumentNo(bh, tDbJgdb==null?null:tDbJgdb.getDbbh());
        return documentNo;
    }

    @Override
    public TDbJgdb getJGDB(String sqdh) {
        TDbJgdb tDbJgdb = dbJgdbMapper.selectByPrimaryKey(sqdh);
        return tDbJgdb;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean transmission(HttpServletResponse response, List<String> sqdh) {
        if (sqdh.isEmpty()){
            throw new BusinessException("申请编号为空");
        }
        //下发，根据sqdh 查询逻辑库中的数据 根据编号查出数据
        TDbSjsqqdQuery dbSjsqqdQuery = new TDbSjsqqdQuery();
        //初始化参数
        SQLiteConfig.initial();
        //拷贝db文件
        Boolean copy = FileUtils.copy();
        if(copy)
        {
            try {
                for (String s : sqdh){
                    TDbSjsq tDbSjsq = dbSjsqMapper.selectByPrimaryKey(s);
                    //设置为已下发
                    tDbSjsq.setXfzt(WeholeNumberStyle.ONE.getName());
                    dbSjsqMapper.updateByPrimaryKeySelective(tDbSjsq);
                    //将数据存入db文件中
                    SQLiteUtils.transmission(tDbSjsq, TableNameStyle.T_DB_SJSQ.getName());
                    dbSjsqqdQuery.setSqdh(s);
                    List<TDbSjsqqd> tDbSjsqqds = dbSjsqqdMapper.selectByQuery(dbSjsqqdQuery);
                    SQLiteUtils.transmission(tDbSjsqqds,TableNameStyle.T_DB_SJSQQD.getName());
                }
                FileUtils.download(response);
                //删除临时db文件
                FileUtils.deleteFile();
            } catch (Exception e) {
                e.printStackTrace();
                throw new BusinessException("下发失败");
            }
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<TDbSjsqAndQDVO> listSqlite(MultipartFile multipartFile) {
        //将文件中数据取出
        List<TDbSjsqAndQDVO> tDbSjsqAndQDVOS = new ArrayList<>();
        try {
            String upload = FileUtils.upload(multipartFile, filepath);
            SQLiteUtils.setPath(upload);
            List<TDbSjsq> tDbSjsqs = SQLiteUtils.upload(new TDbSjsq(), TableNameStyle.T_DB_SJSQ.getName(), upload);
            List<TDbSjsqqd> tDbSjsqqds = SQLiteUtils.upload(new TDbSjsqqd(), TableNameStyle.T_DB_SJSQQD.getName(), upload);
            for (TDbSjsq tDbSjsq : tDbSjsqs) {
                TDbSjsqAndQDVO tDbSjsqAndQDVO = BeanUtils.dtoTODO(tDbSjsq, TDbSjsqAndQDVO.class);
                List<TDbSjsqqd> collect = tDbSjsqqds.stream().filter((q) -> {
                    return q.getSqdh().equals(tDbSjsq.getSqdh());
                }).collect(Collectors.toList());
                tDbSjsqAndQDVO.setTDbSjsqqds(collect);
                tDbSjsqAndQDVOS.add(tDbSjsqAndQDVO);
            }
            return tDbSjsqAndQDVOS;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("数据查询失败");
        }
    }

//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public void insertTemp(TDbjgDTO tDbjgDTO) {
//        List<TDbSjsq> tDbSjsqs = tDbjgDTO.getTDbSjsqs();
//        if (!CollectionUtils.isEmpty(tDbSjsqs)){
//            for (TDbSjsq tDbSjsq : tDbSjsqs){
//                TDbSjsqTemp tDbSjsqTemp = BeanUtils.dtoTODO(tDbSjsq, TDbSjsqTemp.class);
//                TDbSjsqTemp dbSjsqTemp = dbSjsqTempMapper.selectByPrimaryKey(tDbSjsqTemp.getSqdh());
//                if (dbSjsqTemp == null){
//                    dbSjsqTempMapper.insertSelective(tDbSjsqTemp);
//                }else {
//                    dbSjsqTempMapper.updateByPrimaryKeySelective(tDbSjsqTemp);
//                }
//            }
//        }
//        List<TDbSjsqqd> tDbSjsqqds = tDbjgDTO.getTDbSjsqqds();
//        if (!CollectionUtils.isEmpty(tDbSjsqqds)){
//            for (TDbSjsqqd tDbSjsqqd : tDbSjsqqds){
//                TDbSjsqqdTemp tDbSjsqqdTemp = BeanUtils.dtoTODO(tDbSjsqqd, TDbSjsqqdTemp.class);
//                TDbSjsqqdTemp dbSjsqqdTemp = dbSjsqqdTempMapper.selectByPrimaryKey(tDbSjsqqdTemp.getSqdh(), tDbSjsqqdTemp.getJx(), tDbSjsqqdTemp.getJh(), tDbSjsqqdTemp.getZl(), tDbSjsqqdTemp.getJsdw());
//                if (dbSjsqqdTemp == null){
//                    dbSjsqqdTempMapper.insertSelective(dbSjsqqdTemp);
//                }else {
//                    dbSjsqqdTempMapper.updateByPrimaryKeySelective(dbSjsqqdTemp);
//                }
//            }
//        }
//    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean insert(ZQSaveDTO zqSaveDTO) {
        try {
            //将sjsq中的数据存入到历史库中，在存入到逻辑库中
            for (TDbSjsqAndQDVO tDbSjsqAndQDVO : zqSaveDTO.getTDbSjsqAndQDVOS()) {
                TDbSjsq tDbSjsq = BeanUtils.dtoTODO(tDbSjsqAndQDVO, TDbSjsq.class);
                try {
                    dbSjsqMapper.insertSelective(tDbSjsq);
                }catch (Exception e)
                {
                    dbSjsqMapper.updateByPrimaryKeySelective(tDbSjsq);
                }

                //存入历史库中
                try {
                    dbSjsqTempMapper.insertSelective(BeanUtils.dtoTODO(tDbSjsqAndQDVO,TDbSjsqTemp.class));
                }catch (Exception e)
                {
                    dbSjsqTempMapper.updateByPrimaryKeySelective(BeanUtils.dtoTODO(tDbSjsqAndQDVO,TDbSjsqTemp.class));
                }

                for (TDbSjsqqd tDbSjsqqd : tDbSjsqAndQDVO.getTDbSjsqqds()) {
                    try {
                        dbSjsqqdMapper.insertSelective(tDbSjsqqd);
                    } catch (Exception e)
                    {
                        dbSjsqqdMapper.updateByPrimaryKeySelective(tDbSjsqqd);
                    }

                    //将信息存入到历史库中
                    try {
                        dbSjsqqdTempMapper.insertSelective(BeanUtils.dtoTODO(tDbSjsqqd,TDbSjsqqdTemp.class));
                    }catch (Exception e)
                    {
                        dbSjsqqdTempMapper.updateByPrimaryKeySelective(BeanUtils.dtoTODO(tDbSjsqqd,TDbSjsqqdTemp.class));
                    }

                }
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            log.error(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<String> sqdh) {
        if (CollectionUtils.isEmpty(sqdh)){
            return;
        }
        TDbSjsqqdTempQuery tDbSjsqqdTempQuery = new TDbSjsqqdTempQuery();
        for (String s : sqdh) {
            dbSjsqTempMapper.deleteByPrimaryKey(s);
            tDbSjsqqdTempQuery.setSqdh(s);
            List<TDbSjsqqdTemp> tDbSjsqqdTemps = dbSjsqqdTempMapper.selectByQuery(tDbSjsqqdTempQuery);
            if (!CollectionUtils.isEmpty(tDbSjsqqdTemps)){
                tDbSjsqqdTemps.stream().forEach(tDbSjsqqdTemp -> {
                    dbSjsqqdTempMapper.deleteByPrimaryKey(tDbSjsqqdTemp.getSqdh(),tDbSjsqqdTemp.getJx(),tDbSjsqqdTemp.getJh(),tDbSjsqqdTemp.getZl(),tDbSjsqqdTemp.getJsdw());
                });
            }
        }
    }

    @Override
    public void update(String sqdh) {
        TDbJgdb dbJgdb = dbJgdbMapper.selectByPrimaryKey(sqdh);
        dbJgdb.setClzt("1");
        dbJgdbMapper.updateByPrimaryKeySelective(dbJgdb);
    }


}
