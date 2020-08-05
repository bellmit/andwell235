package com.andawell.material.service;

import com.andawell.material.dto.NewRepairedDTO;
import com.andawell.material.dto.OutLibraryInfoDTO;

/***
 * @author lhb
 * @Date: 2020/5/18 16:23
 * @Description:
 * @version : V1.0
 */
public interface ITransFormationLibraryService {
    /**
     *@Author: liuys
     *@Data: 2020/5/11
     *@Description: 全新可用出库/全新转待修
     */
    Boolean newRepair(NewRepairedDTO newRepairedDTO);


    /**
     *@Author: liuys
     *@Data: 2020/5/11
     *@Description: 全新可用出库/全新转待修
     */
    Boolean rotateOut(OutLibraryInfoDTO outLibraryInfoDTO);

}
