package com.andawell.material.service.impl;

import com.andawell.common.entity.BaseUser;
import com.andawell.common.util.BusinessException;
import com.andawell.common.util.SysUserUtils;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.*;
import com.andawell.material.mapper.TTzzWzMapper;
import com.andawell.material.query.TCkCrklbQuery;
import com.andawell.material.query.TTzzWzQuery;
import com.andawell.material.service.*;
import com.andawell.material.vo.TTzzWzVO;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author:PCJ
 * @Date:2020/5/13
 * @Version:V1.0.0
 */
@Service
public class TTzzWzServiceImpl implements TTzzWzService {

    @Autowired
    private TTzzWzMapper tTzzWzMapper;

    @Autowired
    private TTzzCkService tTzzCkService;

    @Autowired
    private TTzzCrkService tTzzCrkService;

    @Autowired
    private TTzzCrkqdService tTzzCrkqdService;

    @Autowired
    private ITCkCrklbService tCkCrklbService;


    @Override
    public List<TTzzWzVO> list(TTzzWzQuery query) {
        return tTzzWzMapper.list(query);
    }

    @Override
    public void insert(TTzzWz tTzzWz) {
        TTzzWzQuery tTzzWzQuery = new TTzzWzQuery().setJh(tTzzWz.getJh());
        List<TTzzWzVO> list = tTzzWzMapper.list(tTzzWzQuery);
        if (!list.isEmpty()) {
            throw new BusinessException(NoticeConstant.RESPONSE_EXIST_ALREADY_MESSAGE + ":" + tTzzWz.toString());
        }
        tTzzWzMapper.insertSelective(tTzzWz);
    }

    @Override
    public void update(TTzzWz tTzzWz) {
        int i = tTzzWzMapper.updateByPrimaryKeySelective(tTzzWz);
        if (i < 1) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_MESSAGE + ":" + tTzzWz.toString());
        }
    }

    @Override
    public void delete(String jh) {
        int i = tTzzWzMapper.deleteByPrimaryKey(jh);
        if (i < 1) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_MESSAGE + "件号:" + jh);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertCrk(TTzzCrk tTzzCrk, List<TTzzCk> tTzzCkList, List<TTzzCrkqd> tTzzCrkqdList) {
        Date date = new Date();
        List<String> jhAndXh = tTzzCkService.listJhAndXh();
        for (TTzzCk tTzzCk : tTzzCkList) {
            if (StringUtils.isEmpty(tTzzCk.getJh()) || StringUtils.isEmpty(tTzzCk.getXh()) || tTzzCk.getSl() <= 0) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE + ":" + tTzzCk.toString());
            }
            String key = tTzzCk.getJh() + "+" + tTzzCk.getXh();
            if (!jhAndXh.isEmpty() && jhAndXh.contains(key)) {
                throw new BusinessException(NoticeConstant.RESPONSE_EXIST_ALREADY_MESSAGE + ":" + tTzzCk.toString());
            }
            tTzzCk.setRkrq(date);
            tTzzCkService.insert(tTzzCk);
            jhAndXh.add(key);
        }
        List<String> bhAndJhAndXh = tTzzCrkqdService.listBhAndJhAndXh();
        for (TTzzCrkqd tTzzCrkqd : tTzzCrkqdList) {
            if (StringUtils.isEmpty(tTzzCrkqd.getBh()) || StringUtils.isEmpty(tTzzCrkqd.getJh()) || StringUtils.isEmpty(tTzzCrkqd.getXh()) || tTzzCrkqd.getSl() <= 0) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE + ":" + tTzzCrkqd.toString());
            }
            String key1 = tTzzCrkqd.getBh() + "+" + tTzzCrkqd.getJh() + "+" + tTzzCrkqd.getXh();
            if (!bhAndJhAndXh.isEmpty() && bhAndJhAndXh.contains(key1)) {
                throw new BusinessException(NoticeConstant.RESPONSE_EXIST_ALREADY_MESSAGE + ":" + tTzzCrkqd.toString());
            }
            tTzzCrkqd.setCrklb("7001");
            tTzzCrkqd.setRq(date);
            tTzzCrkqdService.insert(tTzzCrkqd);
            bhAndJhAndXh.add(key1);
        }
        List<String> bh = tTzzCrkService.listBh();
        if (!bh.isEmpty() && bh.contains(tTzzCrk.getBh())) {
            throw new BusinessException(NoticeConstant.RESPONSE_EXIST_ALREADY_MESSAGE + ":" + tTzzCrk.toString());
        }
        tTzzCrk.setCrklb("7001");
        tTzzCrk.setRq(date);
        tTzzCrkService.insert(tTzzCrk);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCrk(TTzzCrk tTzzCrk, List<TTzzCk> tTzzCkList, List<TTzzCrkqd> tTzzCrkqdList) {
        Date date = new Date();
        for (TTzzCk tTzzCk : tTzzCkList) {
            if (StringUtils.isEmpty(tTzzCk.getJh()) || StringUtils.isEmpty(tTzzCk.getXh()) || tTzzCk.getSl() <= 0) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE + ":" + tTzzCk.toString());
            }
            Integer sl = tTzzCk.getSl();
            if (sl == null || sl <= 0) {
                throw new BusinessException(NoticeConstant.RESPONSE_NUMBER_ERROR_MESSAGE + ":" + sl);
            }
            String ssl = tTzzCkService.getSl(tTzzCk.getJh(), tTzzCk.getXh());
            if (StringUtils.isNotEmpty(ssl) && Integer.valueOf(ssl) >= sl) {
                tTzzCk.setSl(Integer.valueOf(ssl) - sl);
                tTzzCkService.update(tTzzCk);
            } else {
                throw new BusinessException(NoticeConstant.RESPONSE_NOT_ENOUGH_MESSAGE + ":" + tTzzCk);
            }
        }
        List<String> bhAndJhAndXh = tTzzCrkqdService.listBhAndJhAndXh();
        for (TTzzCrkqd tTzzCrkqd : tTzzCrkqdList) {
            if (StringUtils.isEmpty(tTzzCrkqd.getBh()) || StringUtils.isEmpty(tTzzCrkqd.getJh()) || StringUtils.isEmpty(tTzzCrkqd.getXh()) || tTzzCrkqd.getSl() <= 0) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE + ":" + tTzzCrkqd.toString());
            }
            String key = tTzzCrkqd.getBh() + "+" + tTzzCrkqd.getJh() + "+" + tTzzCrkqd.getXh();
            if (!bhAndJhAndXh.isEmpty() && bhAndJhAndXh.contains(key)) {
                throw new BusinessException(NoticeConstant.RESPONSE_EXIST_ALREADY_MESSAGE + ":" + tTzzCrkqd.toString());
            }
            tTzzCrkqd.setCrklb("7002");
            tTzzCrkqd.setRq(date);
            tTzzCrkqdService.insert(tTzzCrkqd);
            bhAndJhAndXh.add(key);
        }
        List<String> bh = tTzzCrkService.listBh();
        if (!bh.isEmpty() && bh.contains(tTzzCrk.getBh())) {
            throw new BusinessException(NoticeConstant.RESPONSE_EXIST_ALREADY_MESSAGE + ":" + tTzzCrk.toString());
        }
        tTzzCrk.setCrklb("7002");
        tTzzCrk.setRq(date);
        tTzzCrkService.insert(tTzzCrk);

    }

    @Override
    public String getBh(TTzzCrkqd tTzzCrkqd) {
        String crklb = tTzzCrkqd.getCrklb();
        String crklbjm = tCkCrklbService.getJmById(crklb);
        if (StringUtils.isEmpty(crklbjm)) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_MESSAGE + ":" + tTzzCrkqd.toString());
        }
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        BaseUser user = SysUserUtils.getUser();
        String bh = crklbjm + "-" + user.getDeptId() + "-LH" + year + "第%";
        String maxBh = tTzzCrkqdService.getMaxBh(bh);
        String s = null;
        s = StringUtils.isEmpty(maxBh) ? "0001号" : String.valueOf(10000 + Integer.valueOf(maxBh) + 1).substring(1) + "号";

        return bh.replace("%", s);
    }

    @Override
    public String getWh(TTzzCrk tTzzCrk) {
        String crklb = tTzzCrk.getCrklb();
        String crklbjm = tCkCrklbService.getJmById(crklb);
        if (StringUtils.isEmpty(crklbjm)) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_MESSAGE + ":" + tTzzCrk.toString());
        }
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        String wh =crklbjm+year+"%";
        String maxWh=tTzzCrkService.getMaxWh(wh);
        String s = null;
        s = StringUtils.isEmpty(maxWh) ? "0001" : String.valueOf(10000 + Integer.valueOf(maxWh) + 1).substring(1);
        return wh.replace("%",s);
    }
}