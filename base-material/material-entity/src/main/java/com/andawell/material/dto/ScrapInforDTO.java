package com.andawell.material.dto;

import com.andawell.material.utils.ValidableList;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @Date： 2020/5/8 11:40
 */
@Data
@ApiModel("报废入库详细信息")
public class ScrapInforDTO {

    @NotBlank(message = "报废类别不能为空")
    @ApiModelProperty(name = "lb", value = "报废类别不能为空")
    private String lb;

    /**
     * 保存主表，T_CK_CRK
     */
    @Valid
    private LibraryMasterDTO libraryMasterDTO;

    /**
     *T_CK_CRKQD和T_CK_BFK
     */
    @Valid
    private ValidableList<ScrapInAndOutLibraryDetailDTO> list;

    /**
     * 系统编号入参
     */
    @Valid
    private SystemNoDetailDTO systemNoDetailDTO;
}
