package com.andawell.material.dto;

import com.andawell.material.utils.ValidableList;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.Valid;

/***
 * @author lhb
 * @Date: 2020/5/6 11:03
 * @Description:
 * @version : V1.0
 */
@Data
@ApiModel("待修入库信息")
public class RepairedLibraryDTO {

    /**
     * 保存主表，T_CK_CRK
     */
    @Valid
    private LibraryMasterDTO libraryMasterDTO;

    /**
     * T_CK_CK和T_CK_CRKQD
     */
    @Valid
    private ValidableList<RepairedLibraryDetailDTO> list;

    /**
     * 系统编号入参
     */
    @Valid
    private SystemNoDetailDTO systemNoDetailDTO;

}
