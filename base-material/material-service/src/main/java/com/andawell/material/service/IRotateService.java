package com.andawell.material.service;

import com.andawell.material.dto.LibraryInfoDTO;
import com.andawell.material.dto.WriteOffDTO;
import com.andawell.material.entity.TZclhHbjl;
import com.andawell.material.query.RotateQuery;

import java.util.List;

/***
 * @author zje
 * @Date: 2020/5/7
 * @Description:
 * @version : V1.0
 */
public interface IRotateService {


    /**
     * 保存轮换入库信息
     */
    Boolean rotateTypeSaveStockInfo(LibraryInfoDTO libraryInfoDTO) throws Exception;


    /**
     *轮换冲销出入库
     * @param writeOffDTO
     * @return
     */

    Boolean rotateCkCkWriteOff(WriteOffDTO writeOffDTO);

    /**
     * 根据条件查询轮换列表
     * @param rotateQuery
     * @return
     */
    List<TZclhHbjl> getRotateListByQuery(RotateQuery rotateQuery);

}
