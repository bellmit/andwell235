package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.common.util.BusinessException;
import com.andawell.common.util.SysUserUtils;
import com.andawell.material.dto.TDbDbAndQdDTO;
import com.andawell.material.dto.TDbDbqdDTO;
import com.andawell.material.dto.TDbLtsqDTO;
import com.andawell.material.dto.TDbLtsqqdDTO;
import com.andawell.material.entity.*;
import com.andawell.material.enumeration.AllotWhNumberStyle;
import com.andawell.material.enumeration.WeholeNumberStyle;
import com.andawell.material.mapper.*;
import com.andawell.material.query.TDbLtsqQuery;
import com.andawell.material.query.TDbLtsqqdQuery;
import com.andawell.material.service.ITDbLtsqService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.util.NumberUtils;
import com.andawell.material.util.Utils;
import com.andawell.material.vo.TDbLtsqVO;
import com.andawell.material.vo.TDbLtsqqdVO;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.andawell.material.constant.BusinessConstant.INVENTORY_ALREADY_EXIST;

/***
 * @author shs
 * @Date: 2020/5/13 15:42
 * @Description:
 * @version : V1.0
 */
@Service
@Slf4j
public class TDbLtsqServiceImpl implements ITDbLtsqService {
    @Autowired
    TDbLtsqMapper tDbLtsqMapper;
    @Autowired
    TDbLtsqqdMapper tDbLtsqqdMapper;

    @Autowired
    TDbZqdbMapper tDbZqdbMapper;

    @Autowired
    TDbZqdbqdMapper tDbZqdbqdMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(TDbLtsqDTO tDbLtsqDTO) {
        //申请单号生成   HCSQ+2020+用户编号+三位累加数
        //获取当前年份
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date1 = new Date();
        String numbers;
        //获取操作项目
        String project = "HCSQ";
        Integer date = Integer.parseInt(sdf.format(date1));
        //获取用户单位简码
        String user = tDbLtsqDTO.getDw();
        //获取数据库当前最大单号（三位累加）
        List<Integer> list=new ArrayList<>();
        List<String> Ids = tDbLtsqMapper.maxId();
        for (int i = 0; i < Ids.size(); i++) {
            String Id = Ids.get(i);
            String PJ = "0";
            //取后三位
            String ID = Id.substring(Id.length() - 3,Id.length());
            Integer replace=Integer.parseInt(ID);
            list.add(replace);
        }
/*      String PJ = "0";
        //取后三位
        String ID = Id.substring(Id.length() - 3,Id.length());
        Integer replace=Integer.parseInt(ID);*/
        //在原有编号+1
        Integer serial = Integer.valueOf(Collections.max(list) + 1);
        DecimalFormat decimalFormat = new DecimalFormat("000");
        String format = decimalFormat.format(serial);
        numbers = project + date + user + format;
        TDbLtsq tDbLtsq = BeanUtils.dtoTODO(tDbLtsqDTO, TDbLtsq.class);
        tDbLtsq.setLtsqdh(numbers);
        tDbLtsq.setSczt("0");
        tDbLtsqMapper.insertSelective(tDbLtsq);


        //调拨明细数据单条或者批量插入
        List<TDbLtsqqdDTO> tDbLtsqqds = tDbLtsqDTO.getTDbLtsqqds();
        for (int i = 0; i < tDbLtsqqds.size(); i++) {
            TDbLtsqqdDTO tDbLtsqqdDTO = tDbLtsqqds.get(i);
            TDbLtsqqd tDbLtsqqd = BeanUtils.dtoTODO(tDbLtsqqdDTO, TDbLtsqqd.class);
            tDbLtsqqd.setLtsqdh(numbers);
            //设置项次主键自增
            Integer xc;
            Integer XcMax = tDbLtsqMapper.XcMax();
            xc = XcMax + 1;
            tDbLtsqqd.setXc(xc);
            tDbLtsqqdMapper.insertSelective(tDbLtsqqd);
        }
        return 1;
    }

    @Override
    public List<TDbLtsq> listjd(TDbLtsqQuery query) {
        return new ListCommon<TDbLtsqQuery, TDbLtsq>(query,
                (q) -> tDbLtsqMapper.listjd(q)).get();
    }

    @Override
    public List<TDbLtsqqd> getGrundist(TDbLtsqQuery query) {
        return new ListCommon<TDbLtsqQuery, TDbLtsqqd>(query,
                (q) -> tDbLtsqqdMapper.getGrundist(q)).get();
    }


    @Override
    public TDbLtsqqdVO smList(TDbLtsqqdQuery query) {
        TDbLtsqqdVO tDbLtsqqdVO = new TDbLtsqqdVO();
        Integer qx = tDbLtsqMapper.qx(query);
        Integer ky = tDbLtsqMapper.ky(query);
        Integer dx = tDbLtsqMapper.dx(query);
        Integer zx = tDbLtsqMapper.zx(query);
        tDbLtsqqdVO.setQxsl(qx);
        tDbLtsqqdVO.setKysl(ky);
        tDbLtsqqdVO.setDxsl(dx);
        tDbLtsqqdVO.setZxsl(zx);
        return tDbLtsqqdVO;
    }

    /**
     * hwd
     * @param type 调拨类型
     * @return
     */
    @Override
    public String getAllotBh(String type) {
        StringBuffer bh = NumberUtils.getDBBhPrefix(type);
        TDbZqdb tDbDb = tDbZqdbMapper.selectByNew(bh.toString(),"1");
        String documentNo = NumberUtils.getDocumentNo(bh, tDbDb == null ? null : tDbDb.getDbbh());
        return documentNo;
    }

    /**
     * t_DB_DB 单号获取
     * @return
     */
    @Override
    public String getNumber() {
        String sbf="DB-LH"+Utils.getSysYear();
        TDbZqdb tDbDb = tDbZqdbMapper.selectByNew(sbf.toString(),"2");
        if (tDbDb==null){
         return sbf+"第0001号";
        }
        return NumberUtils.getAllocationNO(tDbDb.getDbdh(),sbf);
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveAllot(TDbDbAndQdDTO tDbDbAndQdDTO) {
        //获取调拨单号
        String documentNos = this.getNumber();
        //封装调拨单号
        tDbDbAndQdDTO.getTDbDb().setDbdh(documentNos);
        //封装申请单号 机关主动调拨 可为空
        //tDbDbAndQdDTO.getTDbDb().setSqdh(tDbDbAndQdDTO.getTDbDb().getDbbh());
        //封装发付单位
        tDbDbAndQdDTO.getTDbDb().setFfdw(Integer.parseInt(tDbDbAndQdDTO.getTDbDb().getDwid()));
        //封装文号
        tDbDbAndQdDTO.getTDbDb().setWh(AllotWhNumberStyle.JGDBWH.getName());
        //下发状态 0未下发，1以下发
        tDbDbAndQdDTO.getTDbDb().setXfzt(WeholeNumberStyle.ZERO.getName());
        //处理状态 0未处理，1以处理
        tDbDbAndQdDTO.getTDbDb().setClzt(WeholeNumberStyle.ZERO.getName());
        //上传状态
        tDbDbAndQdDTO.getTDbDb().setCszt(WeholeNumberStyle.ZERO.getName());
        //上级申请
        tDbDbAndQdDTO.getTDbDb().setSjsq(WeholeNumberStyle.ZERO.getName());
        //封装日期
        //根据调拨类别生成调拨单号
        String allotBh = getAllotBh(tDbDbAndQdDTO.getTDbDb().getDblx().toString());
        tDbDbAndQdDTO.getTDbDb().setDbbh(allotBh);
        tDbDbAndQdDTO.getTDbDb().setRq(new Date());
        try {
            tDbZqdbMapper.insertSelective(BeanUtils.dtoTODO(tDbDbAndQdDTO.getTDbDb(),TDbZqdb.class));

            for (TDbDbqdDTO tDbDbqd : tDbDbAndQdDTO.getTDbDbqds()) {
                tDbDbqd.setDbdh(documentNos);
                TDbZqdbqd tDbZqdbqd = BeanUtils.dtoTODO(tDbDbqd, TDbZqdbqd.class);
                tDbZqdbqd.setFfdw(tDbDbAndQdDTO.getTDbDb().getDwid());
                tDbZqdbqd.setJsdw(tDbDbAndQdDTO.getTDbDb().getJsdw());
                tDbZqdbqdMapper.insertSelective(tDbZqdbqd);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            log.error(e.getMessage());
            throw new BusinessException(String.format(INVENTORY_ALREADY_EXIST,
                    tDbDbAndQdDTO.getTDbDb().getJx()));
        }

        return true;
    }


}
