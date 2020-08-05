package com.andawell.material.service.impl;/**
 * @Date： 2020/5/27 8:58
 */

import com.andawell.common.entity.search.ListPageCommon;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.util.FileUtils;
import com.andawell.common.util.SQLiteUtils;
import com.andawell.common.util.SysUserUtils;
import com.andawell.material.config.SQLiteConfig;
import com.andawell.material.dto.TDbLtsqDTO;
import com.andawell.material.dto.TDbLtsqqdDTO;
import com.andawell.material.dto.ZQSaveDTO;
import com.andawell.material.entity.*;
import com.andawell.material.enumeration.ReasonStyle;
import com.andawell.material.enumeration.TableNameStyle;
import com.andawell.material.enumeration.WeholeNumberStyle;
import com.andawell.material.mapper.*;
import com.andawell.material.query.*;
import com.andawell.material.service.IBrigadeApplyService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther:liuys
 * @Date:2020/5/27 08:58
 * @Description:
 */
@Slf4j
@Service
public class BrigadeApplyServiceImpl implements IBrigadeApplyService {

    @Autowired
    TDbLtsqMapper tDbLtsqMapper;

    @Autowired
    TCkCkMapper tCkCkMapper;

    @Autowired
    TDbLtsqqdMapper tDbLtsqqdMapper;

    @Autowired
    VDwMapper vDwMapper;

    @Autowired
    TCkCrkqdMapper tCkCrkqdMapper;

    @Autowired
    TCkDxMapper tCkDxMapper;

    @Autowired
    TCkSxMapper tCkSxMapper;

    @Autowired
    THtDhqdMapper tHtDhqdMapper;

    @Autowired
    TJhJxjhMapper tJhJxjhMapper;


    @Autowired
    TDbLtsqTempMapper tDbLtsqTempMapper;

    @Autowired
    TDbLtsqqdTempMapper tDbLtsqqdTempMapper;

    @Value("${upload.path}")
    private String filepath;

    /**
     *@Author: liuys
     *@Data: 2020/5/26
     *@Description: 查询战区下旅团下的申请
     */
    @Override
    public List<TDbLtsqVO> getAllocationList(TDbLtsqQuery tDbLtsqQuery) {
        return tDbLtsqMapper.getAllocationList(tDbLtsqQuery);
    }




    @Override
    public StockVO getStatistics(TCkCkQuery tCkCkQuery) {
        StockVO stockVO = new StockVO();
        tCkCkQuery.setXz(WeholeNumberStyle.ZERO.getName());
        //查询全新数量
        tCkCkQuery.setZl(WeholeNumberStyle.ELEVEN.getName());
        Integer qxsl = tCkCkMapper.selectByCount(tCkCkQuery);
        stockVO.setQxsl(qxsl == null ? 0: qxsl);
        //查询可用数量
        tCkCkQuery.setZl(WeholeNumberStyle.TWELVE.getName());
        Integer kysl = tCkCkMapper.selectByCount(tCkCkQuery);
        stockVO.setKysl(kysl==null ? 0:kysl);
        //查询待修数量
        TCkDxQuery tCkDxQuery = BeanUtils.dtoTODO(tCkCkQuery, TCkDxQuery.class);
        tCkDxQuery.setZl(WeholeNumberStyle.TEWENTY_ONE.getName());
        Integer dxsl = tCkDxMapper.selectByCount(tCkDxQuery);
        stockVO.setDxsl(dxsl==null?0:dxsl);
        //查询在修数量
        TCkSxQuery tCkSxQuery = BeanUtils.dtoTODO(tCkCkQuery, TCkSxQuery.class);
        tCkSxQuery.setZl(null);
        Integer zxsl = tCkSxMapper.selectByCount(tCkSxQuery);
        stockVO.setZxsl(zxsl==null?0:zxsl);
        //查询单机安装数量
        TJhJxJhQuery tJhJxJhQuery = new TJhJxJhQuery();
        tJhJxJhQuery.setJh(tCkCkQuery.getJh());
        tJhJxJhQuery.setJx(tCkCkQuery.getJx());
        Integer djazsl=tJhJxjhMapper.selectByCount(tJhJxJhQuery);
        stockVO.setDjazsl(djazsl);
        //查询合同未到数量

        Integer dhwdsl=tHtDhqdMapper.selectByCount(tCkCkQuery.getJx(),tJhJxJhQuery.getJh());
        stockVO.setDhwdsl(dhwdsl);
        return stockVO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean insert(TDbLtsqDTO tDbLtsqDTO) {
        //保存申请主信息
        TDbLtsq tDbLtsq = BeanUtils.dtoTODO(tDbLtsqDTO, TDbLtsq.class);
        String number = this.getNumber();
        tDbLtsq.setLtsqdh(number);
        tDbLtsq.setSczt(WeholeNumberStyle.ONE.getName());
        tDbLtsq.setClzt(WeholeNumberStyle.ONE.getName());
        tDbLtsq.setRq(new Date());
        tDbLtsq.setSqdw(tDbLtsqDTO.getJsdw());
        tDbLtsqMapper.insertSelective(tDbLtsq);
        //调拨明细数据单条或者批量插入
        int xc=1;
        List<TDbLtsqqdDTO> tDbLtsqqds = tDbLtsqDTO.getTDbLtsqqds();
        for (TDbLtsqqdDTO tDbLtsqqdDTO : tDbLtsqqds) {
            TDbLtsqqd tDbLtsqqd = BeanUtils.dtoTODO(tDbLtsqqdDTO, TDbLtsqqd.class);
            tDbLtsqqd.setLtsqdh(number);
            tDbLtsqqd.setXc(xc);
            tDbLtsqqdMapper.insertSelective(tDbLtsqqd);
            xc++;
        }
        return true;
    }

    /**
     *@Author: liuys
     *@Data: 2020/5/27
     *@Description: 旅团申请单号
     */
    @Override
    public String getNumber(){
        TDbLtsqQuery query = new TDbLtsqQuery();
        Calendar date =Calendar.getInstance();
        //获取用户单位简码
        String user = SysUserUtils.getUser().getDeptId();
        //判断是机关还是战区 1.是旅团申请，2.是工厂，3.是机关
        String str="HCSQ"+date.get(Calendar.YEAR)+user;
        query.setLtsqdh(str);
        //查询最新的
        TDbLtsq tDbLtsq = this.getLatest(query);
        if (tDbLtsq==null){
            return str+"001";
        }
        String ltsqdh = tDbLtsq.getLtsqdh();
        String substring = ltsqdh.substring(ltsqdh.length() - 3, ltsqdh.length());
        Integer integer = Integer.valueOf(substring);
        integer++;
        return str+String.format("%03d",integer);
    }

    @Override
    public TDbLtsq getLatest(TDbLtsqQuery query) {
        return tDbLtsqMapper.selectByLatest(query);
    }

    @Override
    public List<ReasonVO> getReason() {
        ArrayList<ReasonVO> list = new ArrayList<>();
        for (ReasonStyle value : ReasonStyle.values()) {
            ReasonVO reasonVO = new ReasonVO();
            reasonVO.setId(value.getCode());
            reasonVO.setReason(value.getDescription());
            list.add(reasonVO);
        }
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean transmission(HttpServletResponse response, List<String> ltsqdh) {
        //初始化参数
        SQLiteConfig.initial();
        //copy
        Boolean copy = FileUtils.copy();
        if(copy) {
            //更改状态，sqlite导入数据
            TDbLtsqQuery tDbLtsqQuery = new TDbLtsqQuery();
            tDbLtsqQuery.setLtsqdhs(ltsqdh);
            List<TDbLtsq>list=tDbLtsqMapper.selectByQuery(tDbLtsqQuery);
            List<TDbLtsqqd> list1 = tDbLtsqqdMapper.list(tDbLtsqQuery);
            try {
                for (TDbLtsq tDbLtsq : list) {
                    //修改上传状态
                    tDbLtsq.setSczt(WeholeNumberStyle.TWO.getName());
                    tDbLtsqMapper.updateByPrimaryKeySelective(tDbLtsq);
                }
                SQLiteUtils.transmission(list, TableNameStyle.T_DB_LTSQ.getName());
//                for (TDbLtsqqd tDbLtsqqd : list1) {
//                    SQLiteUtils.transmission(tDbLtsqqd, TableNameStyle.T_DB_LTSQQD.getName());
//                }
                SQLiteUtils.transmission(list1, TableNameStyle.T_DB_LTSQQD.getName());
                FileUtils.download(response);
                //删除db文件
                FileUtils.deleteFile();
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                log.info(e.getMessage());
                return null;
            }
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<TDbLtsqAndQDVO> upload(MultipartFile multipartFile) {
        List<TDbLtsq> tDbLtsqs=null;
        List<TDbLtsqqd> tDbLtsqqds=null;
        String upload1 = FileUtils.upload(multipartFile,filepath);
        List<TDbLtsqAndQDVO> tDbLtsqAndQDVOS = new ArrayList<>();
        SQLiteUtils.setPath(upload1);
        try {
            //查询db文件中的信息
            tDbLtsqs = SQLiteUtils.upload(new TDbLtsq(), TableNameStyle.T_DB_LTSQ.getName(),upload1);
            tDbLtsqqds = SQLiteUtils.upload(new TDbLtsqqd(), TableNameStyle.T_DB_LTSQQD.getName(),upload1);

            for (TDbLtsq tDbLtsq : tDbLtsqs) {
                //将查询出来的数据封装VO返回
                TDbLtsqAndQDVO tDbLtsqAndQDVO = BeanUtils.dtoTODO(tDbLtsq, TDbLtsqAndQDVO.class);
                List<TDbLtsqqd> collect = tDbLtsqqds.stream().filter((q) -> {
                    return q.getLtsqdh().equals(tDbLtsq.getLtsqdh());
                }).collect(Collectors.toList());
                tDbLtsqAndQDVO.setTDbLtsqqds(collect);
                tDbLtsqAndQDVOS.add(tDbLtsqAndQDVO);
            }

            //删除db文件
            FileUtils.deleteFile(upload1);
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.getMessage());
        }
        return tDbLtsqAndQDVOS;
    }

    @Override
    public ListPageVo<TDbLtsqQuery, TDbLtsqqd> getList(TDbLtsqQuery tDbLtsqQuery) {
        return new ListPageCommon<TDbLtsqQuery, TDbLtsqqd>(tDbLtsqQuery,
                (q) -> tDbLtsqqdMapper.list(q)).getVo();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveToLtHistory(List<String> ltsqdh) {
        //保存信息到历史信息库
        //从刚才上传的db文件中拿到申请单号
          //获取文件路径
        String newFile = FileUtils.getNewFile(filepath);
        try {
            List<TDbLtsq> tDbLtsqs = SQLiteUtils.upload(new TDbLtsq(), TableNameStyle.T_DB_LTSQ.getName(), newFile);
            List<TDbLtsqqd> tDbLtsqqds = SQLiteUtils.upload(new TDbLtsqqd(), TableNameStyle.T_DB_LTSQQD.getName(), newFile);

            for (String s : ltsqdh) {
                //查询编号为s的TDbLtsq TDbLtsqqd
                List<TDbLtsq> tDbLtsqs1 = tDbLtsqs.stream().filter((q) -> {
                    return q.getLtsqdh().equals(s);
                }).collect(Collectors.toList());

                List<TDbLtsqqd> collect = tDbLtsqqds.stream().filter((q) -> {
                    return q.getLtsqdh().equals(s);
                }).collect(Collectors.toList());
                //插入到数据库中
                for (TDbLtsq tDbLtsq : tDbLtsqs1) {
                    tDbLtsqMapper.updateByPrimaryKeySelective(tDbLtsq);
                }
                for (TDbLtsqqd tDbLtsqqd : collect) {
                    tDbLtsqqdMapper.updateByPrimaryKeySelective(tDbLtsqqd);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteToLtHistory(List<String> ltsqdh) {
        try {
            for (String s : ltsqdh) {
                //删除ltsq主
                tDbLtsqTempMapper.deleteByPrimaryKey(s);
                //删除明细
                tDbLtsqqdTempMapper.deleteByPrimaryKey(s);
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
    public Boolean saveToLtSQ(ZQSaveDTO zqSaveDTO) {

        try {
            //将数据插入到历史信息库中 再将逻辑库中的数据进行修改
            for (TDbLtsqAndQDVO tDbLtsqAndQDVO : zqSaveDTO.getTDbLtsqAndQDVOS()) {
                //保存信息
                try {
                    tDbLtsqTempMapper.insertSelective(BeanUtils.dtoTODO(tDbLtsqAndQDVO,TDbLtsqTemp.class));
                }catch (Exception e)
                {
                    tDbLtsqTempMapper.updateByPrimaryKeySelective(BeanUtils.dtoTODO(tDbLtsqAndQDVO,TDbLtsqTemp.class));
                }

                //修改信息
                tDbLtsqMapper.updateByPrimaryKeySelective(BeanUtils.dtoTODO(tDbLtsqAndQDVO,TDbLtsq.class));

                for (TDbLtsqqd tDbLtsqqd : tDbLtsqAndQDVO.getTDbLtsqqds()) {
                    //保存信息
                    try {
                        tDbLtsqqdTempMapper.insertSelective(BeanUtils.dtoTODO(tDbLtsqqd, TDbLtsqqdTemp.class));
                    }catch (Exception e)
                    {
                        tDbLtsqqdTempMapper.updateByPrimaryKeySelective(BeanUtils.dtoTODO(tDbLtsqqd, TDbLtsqqdTemp.class));
                    }

                    //修改信息
                    tDbLtsqqdMapper.updateByPrimaryKeySelective(tDbLtsqqd);
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
}
