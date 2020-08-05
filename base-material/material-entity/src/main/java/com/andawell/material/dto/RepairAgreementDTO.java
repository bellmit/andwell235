package com.andawell.material.dto;

import com.andawell.material.utils.ValidableList;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/***
 * @author hwd
 * @Date: 2020-05-19 10:06
 * @Description:
 * @version : V1.0
 */
@Data
@ApiModel("修理合同信息修改")
public class RepairAgreementDTO {

    /**
     * 编号
     */
    @NotBlank(message = "编号不能为空")
    @ApiModelProperty(value = "编号",required = true)
    private String bh;


    /**
     * 单位id
     */
    @NotBlank(message = "单位id不能为空")
    @ApiModelProperty(value = "单位id",required = true)
    private String  dwid;


    /**
     * 合同号
     */
    @ApiModelProperty(value = "合同号")
    private String yj;

    /**
     * 明细表对应的数据
     */
    @Valid
    private ValidableList<TariffReviseDTO> tariffReviseDTOS;


}
