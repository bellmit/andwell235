package com.andawell.material.vo;/**
 * @Date： 2020/5/13 13:59
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Auther:shs
 * @Date:2020/5/13 13:59
 * @Description:
 */
@Data
@ApiModel("报废信息")
public class TDataStateVO {

    /**
     * 单位id
     */
    @ApiModelProperty(value = "单位id", name = "dwid", dataType = "String")
    private String dwid;

    /**
     * 单位名称集合
     */
    @ApiModelProperty(value = "单位名称集合", name = "mc", dataType = "String")
    private String mc;



}

