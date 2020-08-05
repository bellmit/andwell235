package com.andawell.material.service;

import com.andawell.material.dto.*;
import com.andawell.material.entity.TCyDw;
import com.andawell.material.entity.TZyDy;
import com.andawell.material.query.KFInOutQuery;
import com.andawell.material.vo.HistoryMessageCountVO;
import com.andawell.material.vo.KFInOutMessageVO;

import java.util.List;

/***
 * @author hwd
 * @Date: 2020-05-15 18:37
 * @Description:
 * @version : V1.0
 */
public interface KFMessageService
{
    public void updateKFMessage(KFMessageDTO kfMessageDTO);

    public void updateKCMessage(List<KCMessageDTO> kcMessageDTOS);

    public void tariffRevise(List<TariffReviseDTO> tariffReviseDTOs);

    public void reviseYFMessage(List<ReviseYFMessageDTO> reviseYFMessageDTOs);

    public void repairAgreement(RepairAgreementDTO repairAgreementDTO);

    public void repairRecordSplit(RecordSplitDTO recordSplitDTO);

    public void deliveryRecordSplit(RecordSplitDTO recordSplitDTO);

    public List<HistoryMessageCountVO> gethistoryList(String dcrq, String jx);

    public List<KFInOutMessageVO> getInOutList(KFInOutQuery kfInOutDTO);

    public List<TCyDw> getCarrigeList();

}
