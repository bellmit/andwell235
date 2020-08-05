package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.common.util.BusinessException;
import com.andawell.material.dto.*;
import com.andawell.material.entity.*;
import com.andawell.material.mapper.TCkCkMapper;
import com.andawell.material.mapper.TCkCrkMapper;
import com.andawell.material.mapper.TCkCrkqdMapper;
import com.andawell.material.mapper.TCyDwMapper;
import com.andawell.material.query.KFInOutQuery;
import com.andawell.material.service.KFMessageService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.vo.HistoryMessageCountVO;
import com.andawell.material.vo.KFInOutMessageVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/***
 * @author hwd
 * @Date: 2020-05-15 18:38
 * @Description:
 * @version : V1.0
 */
@Service
@Slf4j
public class KFMessageServiceImpl implements KFMessageService {

    @Autowired
    private TCkCrkMapper tCkCrkMapper;

    @Autowired
    private TCkCrkqdMapper tCkCrkqdMapper;

    @Autowired
    private TCkCkMapper tCkCkMapper;

    @Autowired
    private TCyDwMapper tCyDwMapper;

    @Autowired
    BaseLibraryService baseLibraryService;

    @Override
    public void updateKFMessage(KFMessageDTO kfMessageDTO) {
        try {
            //修改
            TCkCrk tCkCrk = BeanUtils.dtoTODO(kfMessageDTO, TCkCrk.class);
            tCkCrkMapper.updateByPrimaryKeySelective(tCkCrk);
        }catch (Exception e)
        {
            e.printStackTrace();
            log.error(e.getMessage());
            throw new BusinessException(kfMessageDTO.getBh() + "修改失败");
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateKCMessage(List<KCMessageDTO> kcMessageDTOS) {
        for (KCMessageDTO kcMessageDTO : kcMessageDTOS) {
            try {
                TCkCk tCkCk = BeanUtils.dtoTODO(kcMessageDTO, TCkCk.class);
                BigDecimal bc = new BigDecimal("0");
                tCkCk.setDj(tCkCk.getDj()==null?bc:tCkCk.getDj());
                tCkCk.setSl(tCkCk.getSl()==null?0:tCkCk.getSl());
                tCkCk.setZj(tCkCk.getDj().multiply(new BigDecimal(tCkCk.getSl())));
                tCkCk.setXh(kcMessageDTO.getOldxh());
                if(kcMessageDTO.getXh()!=null)
                {
                    tCkCk.setXhs(kcMessageDTO.getXh());
                }
                tCkCkMapper.updateByPrimaryKeySelective(tCkCk);
            }catch (Exception e)
            {
                e.printStackTrace();
                log.error(e.getMessage());
                throw new BusinessException(kcMessageDTO.getJh() + "修改失败");
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void tariffRevise(List<TariffReviseDTO> tariffReviseDTOs) {
        for (TariffReviseDTO tariffReviseDTO : tariffReviseDTOs) {
            try {
                //修改T_CK_CK对应的单价和总价 以及备注
                TCkCk tCkCk = BeanUtils.dtoTODO(tariffReviseDTO, TCkCk.class);
                tCkCkMapper.updateByPrimaryKeySelective(tCkCk);
                //修改T_CK_CRKQD对应的单价和总价 以及备注
                TCkCrkqd tCkCrkqd= BeanUtils.dtoTODO(tariffReviseDTO, TCkCrkqd.class);
                //手动封装单价 总价
//                tCkCrkqd.setDj(tariffReviseDTO.getDj().intValue());
//                tCkCrkqd.setZj(tariffReviseDTO.getZj().intValue());
                BigDecimal bc = new BigDecimal("0");
                tCkCrkqd.setDj(tariffReviseDTO.getDj()==null?bc:tariffReviseDTO.getDj());
                tCkCrkqd.setSl(tariffReviseDTO.getSl()==null?0:tariffReviseDTO.getSl());
                tCkCrkqd.setZj(tCkCrkqd.getDj().multiply(new BigDecimal(tCkCrkqd.getSl())));
                tCkCrkqdMapper.updateByPrimaryKeySelective(tCkCrkqd);
            }catch (Exception e)
            {
                e.printStackTrace();
                log.error(e.getMessage());
                throw new BusinessException(tariffReviseDTO.getJh() + "修改失败");
            }

        }
    }

    @Override
    public void reviseYFMessage(List<ReviseYFMessageDTO> reviseYFMessageDTOs) {
        for (ReviseYFMessageDTO reviseYFMessageDTO : reviseYFMessageDTOs) {
            try {
                TCkCk tCkCk = BeanUtils.dtoTODO(reviseYFMessageDTO, TCkCk.class);
                tCkCkMapper.updateByPrimaryKeySelective(tCkCk);
            }catch (Exception e)
            {
                e.printStackTrace();
                log.error(e.getMessage());
                throw new BusinessException(reviseYFMessageDTO.getJh() + "修改失败");
            }
        }
    }

    @Override
    public void repairAgreement(RepairAgreementDTO repairAgreementDTO) {

        //修改T_CK_CRK中的文号
        TCkCrk tCkCrk = BeanUtils.dtoTODO(repairAgreementDTO, TCkCrk.class);
        tCkCrkMapper.updateByPrimaryKeySelective(tCkCrk);

        //修改T_CK_CRKQD中的单价和总价
        for (TariffReviseDTO tariffReviseDTO : repairAgreementDTO.getTariffReviseDTOS()) {
            //计算总价
           //tariffReviseDTO.setZj((tariffReviseDTO.getDj().multiply(BigDecimal.valueOf(tariffReviseDTO.getSl()))));
            TCkCrkqd tCkCrkqd = BeanUtils.dtoTODO(tariffReviseDTO, TCkCrkqd.class);
            //封装单价 总价
//            tCkCrkqd.setZj(tariffReviseDTO.getZj().intValue());
//            tCkCrkqd.setDj(tariffReviseDTO.getDj().intValue());
            BigDecimal bc = new BigDecimal("0");
            tCkCrkqd.setDj(tariffReviseDTO.getDj()==null?bc:tariffReviseDTO.getDj());
            tCkCrkqd.setSl(tariffReviseDTO.getSl()==null?0:tariffReviseDTO.getSl());
            tCkCrkqd.setZj(tCkCrkqd.getDj().multiply(new BigDecimal(tCkCrkqd.getSl())));


            tCkCrkqdMapper.updateByPrimaryKeySelective(tCkCrkqd);
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void repairRecordSplit(RecordSplitDTO recordSplitDTO) {
        //拿出RCK中的数据  修改编号 文号  合同号
        TCkCrk tCkCrk = tCkCrkMapper.selectByPrimaryKey(recordSplitDTO.getOldBh(), recordSplitDTO.getDwid());
        String systemNumber ="";
        if(tCkCrk!=null)
        {
            try {
                //修改数据
                //生成新编号
                systemNumber = baseLibraryService.getSystemNumber(new SystemNoDetailDTO(recordSplitDTO.getLbjm(), recordSplitDTO.getDwid()));
                tCkCrk.setBh(systemNumber);
                tCkCrk.setWh(recordSplitDTO.getWh());
                tCkCrk.setYj(recordSplitDTO.getYj());
                tCkCrk.setCjrq(new Date());
                //插入新数据
                tCkCrkMapper.insertSelective(tCkCrk);
            }catch (Exception e)
            {
                e.printStackTrace();
                log.error(e.getMessage());
                throw new BusinessException(recordSplitDTO.getOldBh() + "插入失败");
            }

        }else
        {
            throw new BusinessException(recordSplitDTO.getOldBh() + "没有该数据");
        }

        //修改明细表   修改编号
        updateTckCrkBh(systemNumber,recordSplitDTO.getTariffReviseDTOS());
    }

    @Override
    public void deliveryRecordSplit(RecordSplitDTO recordSplitDTO) {
        //拿出RCK中的数据  修改编号 文号  合同号
        TCkCrk tCkCrk = tCkCrkMapper.selectByPrimaryKey(recordSplitDTO.getOldBh(), recordSplitDTO.getDwid());
        String systemNumber ="";
        if(tCkCrk!=null)
        {
            try {
                //修改数据
                systemNumber = baseLibraryService.getSystemNumber(new SystemNoDetailDTO(recordSplitDTO.getLbjm(), recordSplitDTO.getDwid()));
                tCkCrk.setBh(systemNumber);
                tCkCrk.setWh(recordSplitDTO.getWh());
                tCkCrk.setYj(recordSplitDTO.getYj());
                if(StringUtils.isNotEmpty(recordSplitDTO.getJsdw())&&StringUtils.isNotEmpty(recordSplitDTO.getYsfs()))
                {
                    tCkCrk.setJsdw(recordSplitDTO.getJsdw());
                    tCkCrk.setYsfs(recordSplitDTO.getYsfs());
                    tCkCrk.setCjrq(new Date());
                    //插入新数据
                    tCkCrkMapper.insertSelective(tCkCrk);
                }else
                {
                    throw new BusinessException(recordSplitDTO.getOldBh() + "参数不全");
                }

            }catch (Exception e)
            {
                e.printStackTrace();
                log.error(e.getMessage());
                throw new BusinessException(recordSplitDTO.getOldBh() + "插入失败");
            }

        }else
        {
            throw new BusinessException(recordSplitDTO.getOldBh() + "没有该数据");
        }

        //修改明细表   修改编号
        updateTckCrkBh(systemNumber,recordSplitDTO.getTariffReviseDTOS());
    }

    @Override
    public List<HistoryMessageCountVO> gethistoryList(String dcrq, String jx) {
       return tCkCkMapper.getHistoryMessageCountList(dcrq,jx);
    }

    @Override
    public List<KFInOutMessageVO> getInOutList(KFInOutQuery kfInOutDTO) {
        if(kfInOutDTO.getQueryDate().equals("-"))
        {
            kfInOutDTO.setQueryDate(null);
        }
        List<KFInOutMessageVO> inOutList = tCkCkMapper.getInOutList(kfInOutDTO);
        return inOutList;
    }

    @Override
    public List<TCyDw> getCarrigeList() {
        return new ListCommon<Object, TCyDw>((query) -> tCyDwMapper.list()).get();
    }


    public void updateTckCrkBh(String bh,List<TariffReviseDTO> tariffReviseDTOS)
    {
        //修改明细表 修改编号
        /**
         *      where BH = #{bh,jdbcType=VARCHAR}
         *       and JX = #{jx,jdbcType=VARCHAR}
         *       and JH = #{jh,jdbcType=VARCHAR}
         *       and XH = #{xh,jdbcType=VARCHAR}
         *       and CXSGIN = #{cxsgin,jdbcType=VARCHAR}
         *       and DWID = #{dwid,jdbcType=VARCHAR}
         *       and XZ = #{xz,jdbcType=VARCHAR}
         */
        TCkCrkqd tCkCrkqd = new TCkCrkqd();
        for (TariffReviseDTO tariffReviseDTO : tariffReviseDTOS) {
            try {
                tCkCrkqd.setBhs(bh);
                tCkCrkqd.setBh(tariffReviseDTO.getBh());
                tCkCrkqd.setJx(tariffReviseDTO.getJx());
                tCkCrkqd.setJh(tariffReviseDTO.getJh());
                tCkCrkqd.setXh(tariffReviseDTO.getXh());
                tCkCrkqd.setCxsgin(tariffReviseDTO.getCxsgin());
                tCkCrkqd.setDwid(tariffReviseDTO.getDwid());
                tCkCrkqd.setXz(tariffReviseDTO.getXz());
                tCkCrkqdMapper.updateByPrimaryKeySelective(tCkCrkqd);
            }catch (Exception e)
            {
                e.printStackTrace();
                log.error(e.getMessage());
                throw new BusinessException(tariffReviseDTO.getJh() + "修改失败");
            }

        }
    }

}
