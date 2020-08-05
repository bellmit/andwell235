package com.andawell.material.dto;

import com.andawell.material.utils.ValidableList;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.Valid;

/**
 * @Date： 2020/5/3 16:27
 */
@Data
@ApiModel("送修返回")
public class RepairReturnInfoDTO {
    /**
     * 保存主表，T_CK_CRK
     */
    @Valid
    private LibraryMasterDTO libraryMasterDTO;

    /**
     * 送修返回信息
     */
    @Valid
    private ValidableList<RepairReturnDTO> list;

    /**
     * 系统编号入参
     */
    @Valid
    private SystemNoDetailDTO systemNoDetailDTO;
}
