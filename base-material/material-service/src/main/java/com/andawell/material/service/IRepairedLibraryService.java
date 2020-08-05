package com.andawell.material.service;

import com.andawell.material.dto.*;
import com.andawell.material.entity.TCkCrk;
import com.andawell.material.entity.TCkCrklb;
import com.andawell.material.entity.TCkSx;

import java.util.List;

/***
 * 待修表CK_DX
 * @author lhb
 * @Date: 2020/4/27 14:40
 * @Description:
 * @version : V1.0
 */
public interface IRepairedLibraryService {

    /**
     * 待修入库信息
     * @param
     * @return
     */
    Boolean saveRepairedStockInfo(RepairedLibraryDTO repairedLibraryDTO) ;

    /**
     * 待修退修入库信息
     * @param
     * @return
     */
    Boolean repairReturnStatus(RepairedLibraryDTO libraryMasterDTO);

    /**
     * 修改状态
     * @param repairedLibraryDetailDTO
     * @param libraryMasterDTOO
     * @return
     */
    Boolean repairedStatus(RepairedLibraryDetailDTO repairedLibraryDetailDTO,LibraryMasterDTO libraryMasterDTOO);

    /**
     *@Author: liuys
     *@Data: 2020/5/21
     *@Description: （冲销）全新可用转待修出库
     */
    Boolean writeRotate(WriteOffDTO writeOffDTO);


    /**
     *@Author: liuys
     *@Data: 2020/5/23
     *@Description: 冲销待修发付出库
     */
    Boolean writeToRepairOut(WriteOffDTO writeOffDTO);


}
