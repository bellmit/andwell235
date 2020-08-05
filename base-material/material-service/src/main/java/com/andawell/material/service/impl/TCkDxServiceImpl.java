package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.common.entity.search.ListPageCommon;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.util.BusinessException;
import com.andawell.material.dto.BatchChangeDTO;
import com.andawell.material.dto.LibraryInfoDTO;
import com.andawell.material.dto.TCkDxStatusDTO;
import com.andawell.material.entity.CurrencyInfo;
import com.andawell.material.entity.TCkDx;
import com.andawell.material.mapper.TCkDxMapper;
import com.andawell.material.query.CurrencyQuery;
import com.andawell.material.query.TCkDxQuery;
import com.andawell.material.service.TCkDxService;
import com.andawell.material.utils.ValidableList;
import com.andawell.material.vo.TCkDxOutLibraryVO;
import com.andawell.material.vo.TCkDxSendForRepairVO;
import com.andawell.material.vo.TCkDxStatusVO;
import com.github.pagehelper.util.StringUtil;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ElementKind;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class TCkDxServiceImpl implements TCkDxService {

    @Autowired
    private TCkDxMapper tCkDxMapper;


    /**
     *@Author: liuys
     *@Data: 2020/6/15
     *@Description: 修改待修状态
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByStatusKey(TCkDx tCkDx) {
        return tCkDxMapper.updateByStatusKey(tCkDx);
    }


    public ListPageVo<TCkDxQuery, TCkDxStatusVO> list(TCkDxQuery query) {
        return new ListPageCommon<TCkDxQuery, TCkDxStatusVO>(query,
                (q) -> tCkDxMapper.list(q)).getVo();
    }

    /**
     * 出库待修列表
     *
     * @param query
     * @return
     */
    @Override
    public ListPageVo<TCkDxQuery, TCkDxOutLibraryVO> outLibraryList(TCkDxQuery query) {
        return new ListPageCommon<TCkDxQuery, TCkDxOutLibraryVO>(query,
                (q) -> tCkDxMapper.outLibraryList(q)).getVo();
    }

    /**
     * 送修待修列表
     *
     * @param query
     * @return
     */
    @Override
    public ListPageVo<TCkDxQuery, TCkDxSendForRepairVO> getSendRepairList(TCkDxQuery query) {
        return new ListPageCommon<TCkDxQuery, TCkDxSendForRepairVO>(query,
                (q) -> tCkDxMapper.getSendRepairList(q)).getVo();
    }

    public void batchChange(BatchChangeDTO batchChangeDTO) {
        TCkDx tCkDx = new TCkDx();
        tCkDx.setZhsm(batchChangeDTO.getZhsm());
        tCkDx.setZhrq(batchChangeDTO.getZhrq());

        ValidableList<TCkDxStatusDTO> tCkDxStatusDTOS = batchChangeDTO.getTCkDxStatusDTOS();
        for (TCkDxStatusDTO tCkDxStatusVO : tCkDxStatusDTOS) {
            if(!batchChangeDTO.getStyle().equals("1"))
            {
                //不是1就对数量进行判断
                if (tCkDxStatusVO.getSl() == 1)
                {
                    throw  new BusinessException(tCkDxStatusVO.getJh()+"数量非1，不允许操作");
                }
            }
            if(tCkDxStatusVO.getSl()==0)
                throw  new BusinessException(tCkDxStatusVO.getJh()+"数量为0，不允许操作");
            tCkDx.setZl(tCkDxStatusVO.getZl().equals("21") ? "24" : "21");
            //确保唯一消息
            tCkDx.setBh(tCkDxStatusVO.getBh());
            tCkDx.setJh(tCkDxStatusVO.getJh());
            tCkDx.setDwid(tCkDxStatusVO.getDwid());
            tCkDx.setJx(tCkDxStatusVO.getJx());
            tCkDx.setXh(tCkDxStatusVO.getXh());
            tCkDx.setXz(tCkDxStatusVO.getXz());
            try {
                tCkDxMapper.updateByPrimaryKeySelective(tCkDx);
            }catch (Exception e)
            {
                e.printStackTrace();
                log.error(e.getMessage());
                throw  new BusinessException(tCkDxStatusVO.getJh()+"修改异常");
            }



        }

    }
}
