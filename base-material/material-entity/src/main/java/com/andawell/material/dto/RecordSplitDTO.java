package com.andawell.material.dto;

import com.andawell.material.utils.ValidableList;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/***
 * @author hwd
 * @Date: 2020-05-19 13:46
 * @Description:
 * @version : V1.0
 */
@Data
@ApiModel("记录拆分")
public class RecordSplitDTO {
    /**
     * 旧编号
     */
    @NotBlank(message = "旧编号不能为空")
    @ApiModelProperty(value = "旧编号",required = true)
    private String oldBh;

    /**
     * 新编号
     */
    @ApiModelProperty(value = "新编号",required = true)
    private String newBh;

    /**
     * 单位id
     */
    @NotBlank(message = "单位id不能为空")
    @ApiModelProperty(value = "单位id",required = true)
    private String dwid;

    /**
     * 文号
     */
    @NotBlank(message = "文号不能为空")
    @ApiModelProperty(value = "文号",required = true)
    private String wh;

    /**
     * yj
     */
    @NotBlank(message = "合同号不能为空")
    @ApiModelProperty(value = "合同号",required = true)
    private String yj;

    /**
     * 送修单位
     */
    private String jsdw;

    /**
     * 运输方式
     */
    private String ysfs;

    @NotBlank(message = "简码不能为空")
    @ApiModelProperty(value = "简码",required = true)
    private String lbjm;


    /**
     * 明细表对应的数据
     */
    @Valid
    private ValidableList<TariffReviseDTO> tariffReviseDTOS;



}
