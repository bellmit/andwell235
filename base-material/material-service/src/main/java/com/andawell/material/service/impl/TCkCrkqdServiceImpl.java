package com.andawell.material.service.impl;

import com.andawell.common.util.SysUserUtils;
import com.andawell.material.dto.*;
import com.andawell.material.entity.TCkCrk;
import com.andawell.material.entity.TCkCrklb;
import com.andawell.material.entity.TCkCrkqd;
import com.andawell.material.mapper.TCkCkMapper;
import com.andawell.material.mapper.TCkCrkMapper;
import com.andawell.material.mapper.TCkCrklbMapper;
import com.andawell.material.mapper.TCkCrkqdMapper;
import com.andawell.material.query.SystemNumberQuery;
import com.andawell.material.query.TCkCkUpdateQuery;
import com.andawell.material.query.TCkCrkQuery;
import com.andawell.material.query.TCkCrkqdQuery;
import com.andawell.material.service.IBaseLibraryService;
import com.andawell.material.service.ITCkCrkqdService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.util.Utils;
import com.andawell.material.utils.ValidableList;
import com.andawell.material.vo.ZbKcVO;
import org.bouncycastle.util.Integers;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author: zje
 * @date: 2020/5/15
 * @description:
 */

@Service
public class TCkCrkqdServiceImpl implements ITCkCrkqdService {

    @Autowired
    private TCkCkMapper ckCkMapper;

    @Autowired
    private TCkCrkMapper ckCrkMapper;

    @Autowired
    private TCkCrkqdMapper ckCrkqdMapper;

    @Autowired
    private TCkCrklbMapper ckCrklbMapper;

    /**
     *@Auther: zje
     *@Date: 2020/6/19
     *@Description: 周转转战备
     *@Param:
     *@return:
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertZB(TCkCrkqdDTO tCkCrkqdDTO) {
        TCkCrk tCkCrk = BeanUtils.dtoTODO(tCkCrkqdDTO, TCkCrk.class);
        String systemNumber = this.getCkNumber(tCkCrkqdDTO);
        tCkCrk.setBh(systemNumber);
        tCkCrk.setDwid(SysUserUtils.getUser().getDeptId());

        ckCrkMapper.insertSelective(tCkCrk);
        List<TCkCkUpdateQuery> ckcrkqds = tCkCrkqdDTO.getCkcrkqds();
        if (!CollectionUtils.isEmpty(ckcrkqds)){
            ckcrkqds.stream().forEach(ckcrkqd -> {
                TCkCrkqd tCkCrkqd = BeanUtils.dtoTODO(ckcrkqd, TCkCrkqd.class);
                ckCkMapper.updateZB(ckcrkqd);
                tCkCrkqd.setBh(systemNumber);
                tCkCrkqd.setDwid(SysUserUtils.getUser().getDeptId());
                ckCrkqdMapper.insertSelective(tCkCrkqd);
            });
        }
    }

    /**
     *@Auther: zje
     *@Date: 2020/6/19
     *@Description: 战备转周转
     *@Param:
     *@return:
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertZZ(TCkCrkqdDTO tCkCrkqdDTO) {
        TCkCrk tCkCrk = BeanUtils.dtoTODO(tCkCrkqdDTO, TCkCrk.class);
        String systemNumber = this.getRkNumber(tCkCrkqdDTO);
        tCkCrk.setBh(systemNumber);
        tCkCrk.setDwid(SysUserUtils.getUser().getDeptId());
        ckCrkMapper.insertSelective(tCkCrk);
        List<TCkCkUpdateQuery> ckcrkqds = tCkCrkqdDTO.getCkcrkqds();
        if (!CollectionUtils.isEmpty(ckcrkqds)){
            ckcrkqds.stream().forEach(ckcrkqd -> {
                TCkCrkqd tCkCrkqd = BeanUtils.dtoTODO(ckcrkqd, TCkCrkqd.class);
                ckCkMapper.updateZZ(ckcrkqd);
                tCkCrkqd.setBh(systemNumber);
                tCkCrkqd.setDwid(SysUserUtils.getUser().getDeptId());
                ckCrkqdMapper.insertSelective(tCkCrkqd);
            });
        }
    }

    @Override
    public List<ZbKcVO> list(String jh) {
        List<ZbKcVO> zbKcVOS = ckCrkqdMapper.list(jh);
        return zbKcVOS;
    }

    @Override
    public String getCkNo() {
        StringBuilder ckNo = new StringBuilder();
        TCkCrklb tCkCrklb = ckCrklbMapper.selectByPrimaryKey("6002");
        String jm = tCkCrklb.getJm();
        ckNo.append(jm);
        ckNo.append(Utils.getSysYear().substring(2,Utils.getSysYear().length()));
        String i = "";
        try {
            List<String> whs = ckCrkMapper.selectCkWh();
            List<Integer> list = whs.stream().map(wh -> {
                String number = wh.substring(wh.length() - 5, wh.length());
                int num = Integer.valueOf(number);
                return num;
            }).collect(Collectors.toList());
            String s = Collections.max(list).toString();
            i = s.substring(s.length()-3,s.length());
        } catch (Exception e) {
            e.printStackTrace();
            i = "000";
        }
        String s = String.valueOf(Integer.valueOf(i)+1000+1).substring(1);
        ckNo.append(s);
        return ckNo.toString();
    }

    @Override
    public String getrkNo() {
        StringBuilder rkNo = new StringBuilder();
        TCkCrklb tCkCrklb = ckCrklbMapper.selectByPrimaryKey("6001");
        String jm = tCkCrklb.getJm();
        rkNo.append(jm);
        rkNo.append(Utils.getSysYear().substring(2,Utils.getSysYear().length()));
        String i = "";
        try {
            List<String> whs = ckCrkMapper.selectRkWh();
            List<Integer> list = whs.stream().map(wh -> {
                String number = wh.substring(wh.length() - 5, wh.length());
                int num = Integer.valueOf(number);
                return num;
            }).collect(Collectors.toList());
            String s = Collections.max(list).toString();
            i = s.substring(s.length()-3,s.length());
        } catch (Exception e) {
            e.printStackTrace();
            i = "000";
        }
        String s = String.valueOf(Integer.valueOf(i)+1000+1).substring(1);
        rkNo.append(s);
        return rkNo.toString();
    }

    public TCkCrk selectByNew(String number, String wh) {
        return ckCrkMapper.selectByNew(number, wh);
    }

    public String getCkNumber(TCkCrkqdDTO tCkCrkqdDTO){
        TCkCrklb tCkCrklb = ckCrklbMapper.selectByPrimaryKey("6002");
        String jm = tCkCrklb.getJm();
        SystemNumberQuery systemNumberQuery =
                new SystemNumberQuery(jm, SysUserUtils.getUser().getDeptId());
        //获取数据库最新数据
        TCkCrk tCkCrk = this.selectByNew(jm.toUpperCase()
                + Utils.SING + SysUserUtils.getUser().getDeptId(), null);
        if (tCkCrk == null) {
            tCkCrk = new TCkCrk();
        }
        String systemNumber = Utils.getSystemNumberByRule(systemNumberQuery, tCkCrk.getBh());
        return systemNumber;
    }

    public String getRkNumber(TCkCrkqdDTO tCkCrkqdDTO){
        TCkCrklb tCkCrklb = ckCrklbMapper.selectByPrimaryKey("6001");
        String jm = tCkCrklb.getJm();
        SystemNumberQuery systemNumberQuery =
                new SystemNumberQuery(jm, SysUserUtils.getUser().getDeptId());
        //获取数据库最新数据
        TCkCrk tCkCrk = this.selectByNew(jm.toUpperCase()
                + Utils.SING + SysUserUtils.getUser().getDeptId(), null);
        if (tCkCrk == null) {
            tCkCrk = new TCkCrk();
        }
        String systemNumber = Utils.getSystemNumberByRule(systemNumberQuery, tCkCrk.getBh());
        return systemNumber;
    }
}
