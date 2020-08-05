package com.andawell.material.dto;/**
 * @Date： 2020/5/11 20:22
 */

import com.andawell.material.utils.ValidableList;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 *@Auther:liuys
 *@Date:2020/5/11 20:22
 *@Description:
 */
@Data
@ApiModel("全新转")
public class NewRepairedDTO {
    /**
     * 保存主表，T_CK_CRK
     */
    @Valid
    private LibraryMasterDTO libraryMasterDTO;

    /**
     * T_CK_CK和T_CK_CRKQD
     */
    @Valid
    private ValidableList<OutLibraryDetailDTO> list;

    /**
     * 系统编号入参
     */
    @Valid
    private SystemNoDetailDTO systemNoDetailDTO;

    @NotBlank(message = "待修或者报废")
    @ApiModelProperty(name = "lb", value = "类别",required = true)
    private String lb;
}
