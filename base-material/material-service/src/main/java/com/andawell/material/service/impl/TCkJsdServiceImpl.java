package com.andawell.material.service.impl;


import com.andawell.common.util.SysUserUtils;
import com.andawell.material.dto.SystemNoDetailDTO;
import com.andawell.material.dto.TCkJsdBcDTO;
import com.andawell.material.entity.TCkJsd;
import com.andawell.material.entity.TCkJsdqd;
import com.andawell.material.mapper.TCkJsdMapper;

import com.andawell.material.mapper.TCkJsdqdMapper;
import com.andawell.material.service.ITCkJsdService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Calendar;


@Service
@Slf4j
public class TCkJsdServiceImpl implements ITCkJsdService {

    @Autowired
    TCkJsdMapper tCkJsdMapper;
    @Autowired
    TCkJsdqdMapper tCkJsdqdMapper;


    /**
     * 结算单打印保存接口
     *根据tCkJsd表的主键查询出该条主键对应的所有信息
     * 封装新的合同编号以及合同号依据 插入tCkJsd
     * 遍历要插入的TCkJsdqdDTO
     * 根据tCkJsd表的主键查询出该条主键对应的所有信息
     * 重新封装编号
     * 封装修改后的新的单价
     * 根据新的单价封装总价格   插入表tCkJsdqd
     * @param tCkJsdBcDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(TCkJsdBcDTO tCkJsdBcDTO) {
        //根据tCkJsd表的主键查询出该条主键对应的所有信息
        TCkJsd tCkJsd = tCkJsdMapper.selectTCkJsd(tCkJsdBcDTO.getTCkJsdDTO().getBh(),tCkJsdBcDTO.getTCkJsdDTO().getDwid());
        //封装新的合同编号以及合同号依据
        tCkJsd.setBh(tCkJsdBcDTO.getBh());
        tCkJsd.setYj(tCkJsdBcDTO.getYj());
        //插入tCkJsd
        tCkJsdMapper.insertSelective(tCkJsd);
        //遍历要插入的TCkJsdqdDTO
        tCkJsdBcDTO.getTCkJsdqdDTO().stream().forEach(onetTCkJsdqdDTO -> {
            //根据tCkJsd表的主键查询出该条主键对应的所有信息
            TCkJsdqd tCkJsdqd = tCkJsdqdMapper.selectTCkJsdqd(onetTCkJsdqdDTO.getBh(), onetTCkJsdqdDTO.getJx(), onetTCkJsdqdDTO.getJh(), onetTCkJsdqdDTO.getXh(), onetTCkJsdqdDTO.getCxsgin(), onetTCkJsdqdDTO.getDwid(), onetTCkJsdqdDTO.getXz());
            //重新封装编号
            tCkJsdqd.setBh(tCkJsdBcDTO.getBh());
            //封装修改后的新的单价
            tCkJsdqd.setDj(onetTCkJsdqdDTO.getDj());
            //根据新的单价封装总价格
            tCkJsdqd.setZj(tCkJsdqd.getDj().multiply(BigDecimal.valueOf(tCkJsdqd.getSl())));
            //插入表tCkJsdqd
            tCkJsdqdMapper.insertSelective(tCkJsdqd);
        });


    }

    /**
     * 结算单编号查询接口
     * 数据库获取到最大的编号来生成
     */
    @Override
    public String getSystemNumber() {
        DecimalFormat decimalFormat = new DecimalFormat("0000");
        //获取当前年度
        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));
        //获取单位id
        String deptId = SysUserUtils.getUser().getDeptId();
        //获取最大编号并封装
        String Maxwh = tCkJsdMapper.maxBh(deptId);
        int maxWh=1;
        if(Maxwh!=null){
           maxWh = Integer.parseInt(Maxwh.substring(Maxwh.length() - 5, Maxwh.length()-1))+1;  //文号四位流水
        }
        return "JSD-"+deptId+"-LH"+year+"第"+decimalFormat.format(maxWh)+"号";
    }
}
