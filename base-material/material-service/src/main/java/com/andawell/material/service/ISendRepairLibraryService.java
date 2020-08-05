package com.andawell.material.service;

import com.andawell.material.dto.LibraryInfoDTO;
import com.andawell.material.dto.RepairReturnInfoDTO;
import com.andawell.material.dto.WriteOffDTO;

/***
 * @author lhb
 * @Date: 2020/5/18 14:26
 * @Description:
 * @version : V1.0
 */
public interface ISendRepairLibraryService {


    /**
     * 送修入库
     * @param repairReturnInfoDTO
     * @return
     */
    Boolean saveInLibraryInfo(RepairReturnInfoDTO repairReturnInfoDTO);

    /**
     * 送修出库
     * @param libraryInfoDTO
     * @return
     */
    Boolean saveOutLibraryInfo(LibraryInfoDTO libraryInfoDTO);

    /**
     * 送修冲销入库
     * @param writeOffDTO
     * @return
     */
    Boolean sendRepairWriteOffIn(WriteOffDTO writeOffDTO);


    /**
     *@Author: liuys
     *@Data: 2020/5/22
     *@Description: 冲销送修出库
     */
    Boolean sendRepairWriteOffOut(WriteOffDTO writeOffDTO);

}
