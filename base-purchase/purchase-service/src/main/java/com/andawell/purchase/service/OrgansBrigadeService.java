package com.andawell.purchase.service;


import com.andawell.purchase.dto.TCkCrkXfDTO;
import com.andawell.material.dto.TCkCrkDTO;
import com.andawell.material.entity.TCkCrk;
import com.andawell.purchase.dto.TCkCrkXfDTO;
import com.andawell.purchase.dto.THtDTO;
import com.andawell.purchase.dto.THtXfDTO;

import com.andawell.common.util.ValidableList;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/***
 * @author gzh
 * @Date: 2020/6/10 14:05
 * @Description:
 * @version : V1.0
 */
public interface OrgansBrigadeService {

    /**
     * 机关生成合同下发旅团返回DB文件
     */
    Boolean transmission(HttpServletResponse response, ValidableList<THtXfDTO> tHtXfDTOS);


    /**
     * 合同，旅团接收数据
     * @param multipartFile
     * @return
     */
    Boolean ltReceiveData(MultipartFile multipartFile);


    /**
     * 采购数据机关接收
     * @param multipartFile
     * @return
     */
    Boolean jgReceiveCgData(MultipartFile multipartFile);

    /**
     * 保存下发数据
     * @param list
     * @return
     */
    Boolean saveReceiveData(List<THtDTO> list);

    /**
     * 机关保存上报的采购数据
     * @param list
     * @return
     */
    Boolean saveJgCgData(List<TCkCrkXfDTO> list);

    /**
     * 删除选定数据
     * @param list
     * @return
     */
    Boolean deleteReceiveData(List<THtDTO> list);

    /**
     * 删除选定数据
     * @param list
     * @return
     */
    Boolean deleteJgReceiveData(List<TCkCrkXfDTO> list);

    /**
     * 旅团合同入库单上报
     */
    Boolean ntransmission(HttpServletResponse response, ValidableList<TCkCrkXfDTO> tCkCrkXfDTOS);
}
