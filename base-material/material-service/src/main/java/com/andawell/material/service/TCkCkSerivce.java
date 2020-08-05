package com.andawell.material.service;

import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.dto.*;
import com.andawell.material.query.TCkCkQuery;
import com.andawell.material.query.YFPlanQuery;
import com.andawell.material.vo.TCkCkPlanVO;
import com.andawell.material.vo.TCkCkVO;
import org.apache.ibatis.jdbc.Null;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/***
 * @author hwd
 * @Date: 2020-05-09 17:47
 * @Description:
 * @version : V1.0
 */
public interface TCkCkSerivce
{
    public List<TCkCkPlanVO> getList(YFPlanQuery yfPlanQuery);

    public void saveFkMessage(List<TCkCkPlanDTO>  tCkCkPlanDTO);

    public void saveYFData(List<YFDataAffirmDTO> yfDataAffirmDTOs);

    public void putYFData(List<PutYFDataDTO>putYFDataDTOS);

    public void confirmYFReceive(List<ConfirmYFReceiveDTO>confirmYFReceiveDTOs);

    public void YFCompletedShelves(List<YFCompletedShelvesDTO> yfCompletedShelvesDTOS);

    /**
     * 公共关注件
     * @param query
     * @return
     */
    ListPageVo<TCkCkQuery, TCkCkVO> listAllGz(TCkCkQuery query);

    /**
     * 个人关注件
     * @param query
     * @return
     */
    ListPageVo<TCkCkQuery, TCkCkVO> listUserGz(TCkCkQuery query);

}
