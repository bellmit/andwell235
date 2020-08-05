package com.andawell.material.service;

import com.andawell.material.dto.ContractInfoDTO;
import com.andawell.material.dto.ContractWriteOffDto;

/***
 * @author lhb
 * @Date: 2020/5/18 14:09
 * @Description:
 * @version : V1.0
 */
public interface IContractLibraryService {


    /**
     * 订货合同入库
     * @param contractInfoDTO
     * @return
     */
    Boolean addContract(ContractInfoDTO contractInfoDTO);

    /**
     * 合同多到
     * @param contractInfoDTO
     * @return
     */
    Boolean addMultipeContract (ContractInfoDTO contractInfoDTO);

    /**
     * 合同/多到 冲销
     * @param contractWriteOffDto
     * @return
     */
    Boolean saveAndUpdateInAndOutWriteOff(ContractWriteOffDto contractWriteOffDto);


}
