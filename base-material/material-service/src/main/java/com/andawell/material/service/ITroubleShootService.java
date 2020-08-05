package com.andawell.material.service;

import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.material.dto.OutLibraryInfoDTO;
import com.andawell.material.dto.ReturnShootingDTO;
import com.andawell.material.dto.SystemNoDetailDTO;
import com.andawell.material.dto.TroubleShootingDTO;
import com.andawell.material.query.TCkPglyQuery;
import com.andawell.material.query.TCkPglyqdQuery;
import com.andawell.material.vo.TCkPglyVo;
import com.andawell.material.vo.TCkPglyqdVO;

import java.util.List;

/***
 * @author lhb
 * @Date: 2020/5/18 16:33
 * @Description:
 * @version : V1.0
 */
public interface ITroubleShootService {

    /**
     *@Author: liuys
     *@Data: 2020/5/15
     *@Description: 排故领用出库
     */
    Boolean troubleShooting(TroubleShootingDTO troubleShootingDTO);


    ListPageVo<TCkPglyQuery, TCkPglyVo> getCollectingReturn(TCkPglyQuery query);

    /**
     *@Author: liuys
     *@Data: 2020/5/18
     *@Description: 排故领用归还
     */
    Boolean saveCollectingReturn(ReturnShootingDTO returnShootingDTO);

    /**
     *@Author: liuys
     *@Data: 2020/5/19
     *@Description: 出库文号
     */
    String outNumber(String state);

    /**
     *@Author: liuys
     *@Data: 2020/5/19
     *@Description: 排故领用领出保存
     */
    Boolean takeOut(TroubleShootingDTO takeOutDTO);


    /**
     *@Author: liuys
     *@Data: 2020/5/20
     *@Description: 排故编号
     */
    String getShootingNumber(SystemNoDetailDTO systemNoDetailDTO);

    /**
     *@Author: liuys
     *@Data: 2020/5/21
     *@Description:
     */
    ListPageVo<TCkPglyqdQuery, TCkPglyqdVO> getCollectingTimeList(TCkPglyqdQuery tCkPglyqdQuery);

    List<TCkPglyqdVO> getCollectingReturnDetailed(TCkPglyqdQuery query);
}
