package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.common.entity.search.ListPageCommon;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.util.BusinessException;
import com.andawell.material.dto.*;
import com.andawell.material.entity.TCkCk;
import com.andawell.material.entity.TCkCrk;
import com.andawell.material.entity.TCkPgly;
import com.andawell.material.entity.TCkPglyqd;
import com.andawell.material.mapper.TCkCkMapper;
import com.andawell.material.mapper.TCkPglyMapper;
import com.andawell.material.mapper.TCkPglyqdMapper;
import com.andawell.material.query.SystemNumberQuery;
import com.andawell.material.query.TCkPglyQuery;
import com.andawell.material.query.TCkPglyqdQuery;
import com.andawell.material.service.ITroubleShootService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.util.Utils;
import com.andawell.material.utils.ValidableList;
import com.andawell.material.vo.TCkPglyVo;
import com.andawell.material.vo.TCkPglyqdVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.andawell.material.constant.BusinessConstant.*;

/***
 * @author lhb
 * @Date: 2020/5/18 16:34
 * @Description:
 * @version : V1.0
 */
@Service
@Slf4j
public class TroubleShootService extends BaseLibraryService implements ITroubleShootService {

    @Autowired
    TCkPglyqdMapper tCkPglyqdMapper;

    @Autowired
    TCkCkMapper tCkCkMapper;

    @Autowired
    TCkPglyMapper tCkPglyMapper;

    /**
     * @param troubleShootingDTO
     * @Author: liuys
     * @Data: 2020/5/15
     * @Description: 排故领用出库
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean troubleShooting(TroubleShootingDTO troubleShootingDTO) {
        // 更新ckck数据
        List<TCkPglyqdDTO> list = troubleShootingDTO.getList();
        for (TCkPglyqdDTO tCkPglyqdDTO : list) {
            // 查询出ckck  核减数量
            TCkCk tCkCk =
                    tCkCkMapper.selectByPrimaryKey(
                            tCkPglyqdDTO.getDwid(),
                            tCkPglyqdDTO.getJx(),
                            tCkPglyqdDTO.getJh(),
                            tCkPglyqdDTO.getXh(),
                            tCkPglyqdDTO.getZl(),
                            "0");
            if (tCkCk==null){
                throw  new BusinessException(
                        String.format(OUT_OF_MEMORY,
                                tCkPglyqdDTO.getJh(),tCkPglyqdDTO.getXh()));
            }
            try {
                // 跟新数据
                Long count = tCkCk.getSl()-tCkPglyqdDTO.getSl();
                // 抛出异常
                if(count<0){
                    throw  new BusinessException(
                            String.format(OUT_OF_MEMORY,
                                    tCkCk.getJh(),tCkCk.getXh()));
                }
                tCkCk.setSl(tCkCk.getSl()-tCkPglyqdDTO.getSl());
                tCkCk.setBz((tCkCk.getBz()!=null?tCkCk.getBz():"")+","+tCkPglyqdDTO.getBz());
                tCkCk.setXz("2");
                tCkCkMapper.updateByDwidAndJxAndJhAndXhAndZl(tCkCk);
            }catch (BusinessException e){
                e.printStackTrace();
                log.error(e.getMessage());
                throw  new BusinessException(
                        String.format(CUt_AFTER_EXAMINATION_FAIL,
                                tCkCk.getJh(),tCkCk.getXh()));
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
                throw  new BusinessException(CUt_AFTER_EXAMINATION_FAIL);
            }
        }
        //添加领用主表和缓存表
        TCkPgly tCkPgly = BeanUtils.dtoTODO(troubleShootingDTO.getTCkPglyDTO(), TCkPgly.class);
        tCkPgly.setCjrq(new Date());
        tCkPgly.setBh(this.getShootingNumber(troubleShootingDTO.getSystemNoDetailDTO()));
        //主表索引是bh和dwid 所以不用进行try
        tCkPglyMapper.insertSelective(tCkPgly);
        for (TCkPglyqdDTO tCkPglyqdDTO : list) {
            try {
                TCkPglyqd tCkPglyqd = BeanUtils.dtoTODO(tCkPglyqdDTO, TCkPglyqd.class);
                tCkPglyqdDTO.setZddm(troubleShootingDTO.getTCkPglyDTO().getZddm());
                tCkPglyqd.setBh(tCkPgly.getBh());
                tCkPglyqd.setXz("2");
                tCkPglyqd.setCjrq(new Date());
                tCkPglyqdMapper.insertSelective(tCkPglyqd);
            } catch (Exception e) {
                e.printStackTrace();
                e.printStackTrace();
                log.error(e.getMessage());
                throw new BusinessException(
                        String.format(COLLECTION_CACHE,
                                tCkPglyqdDTO.getJx(),tCkPglyqdDTO.getJh(),
                                tCkPglyqdDTO.getXh(),tCkPglyqdDTO.getCxsgin(),
                                tCkPglyqdDTO.getDwid(), tCkPglyqdDTO.getXz()));
            }
        }
        return true;
    }

    @Override
    public ListPageVo<TCkPglyQuery, TCkPglyVo> getCollectingReturn(TCkPglyQuery query) {
        return new ListPageCommon<TCkPglyQuery, TCkPglyVo>(query,
                (q) -> tCkPglyMapper.selectByJx(q)).getVo();
    }

    /**
     *@Author: liuys
     *@Data: 2020/5/18
     *@Description: 排故领用归还
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveCollectingReturn(ReturnShootingDTO returnShootingDTO) {
        // 更新ckck数据
        List<TCkPglyqdDTO> list = returnShootingDTO.getList();
        for (TCkPglyqdDTO tCkPglyqdDTO : list) {
            // 查询出ckck  核减数量
            TCkCk tCkCk =
                    tCkCkMapper.selectByPrimaryKey(
                            tCkPglyqdDTO.getDwid(),
                            tCkPglyqdDTO.getJx(),
                            tCkPglyqdDTO.getJh(),
                            tCkPglyqdDTO.getXh(),
                            tCkPglyqdDTO.getZl(),
                            "2");
            if (tCkCk==null){
                throw  new BusinessException(
                        String.format(OUT_OF_MEMORY,
                                tCkPglyqdDTO.getJh(),tCkPglyqdDTO.getXh()));
            }
            try {
                // 跟新数据
                Long count = tCkCk.getSl()+tCkPglyqdDTO.getSl();
                // 抛出异常
                if(count<0){
                    throw  new BusinessException(
                            String.format(OUT_OF_MEMORY,
                                    tCkCk.getJh(),tCkCk.getXh()));
                }
                tCkCk.setSl(tCkCk.getSl()-tCkPglyqdDTO.getSl());
                tCkCk.setBz((tCkCk.getBz()!=null?tCkCk.getBz():"")+","+tCkPglyqdDTO.getBz());
                tCkCk.setXz("0");
                tCkCkMapper.updateByDwidAndJxAndJhAndXhAndZl(tCkCk);
            }catch (BusinessException e){
                e.printStackTrace();
                log.error(e.getMessage());
                throw  new BusinessException(
                        String.format(CUt_AFTER_EXAMINATION_FAIL,
                                tCkCk.getJh(),tCkCk.getXh()));
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
                throw  new BusinessException(CUt_AFTER_EXAMINATION_FAIL);
            }
        }
        //修改
        for (TCkPglyqdDTO tCkPglyqdDTO : list) {
            tCkPglyqdDTO.setXz("0");
            tCkPglyqdDTO.setGhrq(new Date());
            tCkPglyqdMapper.updateByBhAndJhAndXhAndJx(tCkPglyqdDTO);
        }
        return true;
    }

    /**
     * 排故出入库编号
     *
     * @param systemNoDetailDTO
     * @return
     */
    @Override
    public String getShootingNumber(SystemNoDetailDTO systemNoDetailDTO) {

        TCkPgly tCkPgly = tCkPglyMapper.selectByYjrqOne();

        SystemNumberQuery systemNumberQuery =
                new SystemNumberQuery(systemNoDetailDTO.getLbjm(), systemNoDetailDTO.getDwid());
        //获取数据库最新数据
        TCkCrk tCkCrk = this.selectByNew(systemNoDetailDTO.getLbjm().toUpperCase()
                + Utils.SING + systemNoDetailDTO.getDwid(), null);
        if (tCkPgly == null) {
            tCkPgly = new TCkPgly();
        }
        String systemNumber =
                Utils.getSystemNumberByRule(systemNumberQuery, tCkPgly.getBh());
        return systemNumber;
    }

    @Override
    public String outNumber(String state) {
        TCkCrk tCkCrk = tCkCrkMapper.selectByYjrqOne();
        String[] s = tCkCrk.getWh().split("第");
        String[] s1 = new String[0];
        String s2=null;
        try {
            s1 = s[1].split("号");
            s2= s1[0].substring(s1[0].length()-3,s1[0].length());
        } catch (Exception e) {
            s2 = s[0].substring( tCkCrk.getWh().length()-3, tCkCrk.getWh().length());
        }
        Integer integer = Integer.valueOf(s2);
        integer++;
        Calendar date =Calendar.getInstance();
        int i = date.get(Calendar.MONTH)+1;
        String a=i+"";
        if(i<10){
            a="0"+i;
        }
        String wh=state+a+String.format("%03d",integer);
        return wh;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean takeOut(TroubleShootingDTO takeOutDTO) {
        //修改ckck
        ValidableList<TCkPglyqdDTO> detailDTOList = takeOutDTO.getList();
        ValidableList<OutLibraryDetailDTO> list = BeanUtils.copyValidableList(detailDTOList, OutLibraryDetailDTO.class);
        TCkPglyDTO tCkPglyDTO = takeOutDTO.getTCkPglyDTO();
        LibraryMasterDTO libraryMasterDTO = BeanUtils.dtoTODO(tCkPglyDTO, LibraryMasterDTO.class);
        for (TCkPglyqdDTO outLibraryDetailDTO : detailDTOList) {
            //先查询
            TCkCk ckCk =
                    tCkCkMapper.selectByPrimaryKey(
                            outLibraryDetailDTO.getDwid(),
                            outLibraryDetailDTO.getJx(),
                            outLibraryDetailDTO.getJh(),
                            outLibraryDetailDTO.getXh(),
                            outLibraryDetailDTO.getZl(),
                            "1");
            if (ckCk==null){
                throw  new BusinessException(
                        String.format(OUT_OF_MEMORY,
                                outLibraryDetailDTO.getJh(),outLibraryDetailDTO.getXh()));
            }
            //修改ckck
            TCkCk tCkCk = new TCkCk();
            tCkCk.setDwid(outLibraryDetailDTO.getDwid());
            tCkCk.setJx(outLibraryDetailDTO.getJx());
            tCkCk.setJh(outLibraryDetailDTO.getJh());
            tCkCk.setXh(outLibraryDetailDTO.getXh());
            tCkCk.setZl(outLibraryDetailDTO.getZl());
            //修改数据
            tCkCk.setXz("1");
            tCkCkMapper.updateByDwidAndJxAndJhAndXhAndZl(tCkCk);
            //修改pglyqd
            TCkPglyqd tCkPglyqd = new TCkPglyqd();
            //条件
            tCkPglyqd.setBh(outLibraryDetailDTO.getBh());
            tCkPglyqd.setJh( outLibraryDetailDTO.getJh());
            tCkPglyqd.setXh(outLibraryDetailDTO.getXh());
            tCkPglyqd.setJx(outLibraryDetailDTO.getJx());
            //替换
            tCkPglyqd.setXz("2");
            tCkPglyqd.setGhrq(new Date());
            TCkPglyqdDTO tCkPglyqdDTO = BeanUtils.dtoTODO(tCkPglyqd, TCkPglyqdDTO.class);
            tCkPglyqdMapper.updateByBhAndJhAndXhAndJx(tCkPglyqdDTO);
        }
        //crk和crkqd保存
        return super.saveInAndOutList(takeOutDTO.getSystemNoDetailDTO(),
                libraryMasterDTO, list);

    }

    @Override
    public List<TCkPglyqdVO> getCollectingReturnDetailed(TCkPglyqdQuery query) {
        return new ListCommon<TCkPglyqdQuery, TCkPglyqdVO>(query,
                (q) -> tCkPglyqdMapper.list(q)).get();
    }

    @Override
    public ListPageVo<TCkPglyqdQuery, TCkPglyqdVO> getCollectingTimeList(TCkPglyqdQuery query) {
        return new ListPageCommon<TCkPglyqdQuery, TCkPglyqdVO>(query,
                (q) -> tCkPglyqdMapper.timeList(q)).getVo();
    }
}
