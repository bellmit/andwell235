package com.andawell.purchase.dto.htprint;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: yzy
 * @Description:
 * @Date: created in 2020/6/9 18:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class THtqdDTO {

    @ApiModelProperty(value = "机型")
    private String jxmc;


    @ApiModelProperty(value = "器材名称")
    private String jhmc;

    @ApiModelProperty(value = "器材型号")
    private String jh;

    @ApiModelProperty(value = "数量")
    private Integer sl;

    @ApiModelProperty(value = "总价")
    private Integer zj;

    @ApiModelProperty(value = "单价")
    private Integer dj;

    @ApiModelProperty(value = "备注")
    private String bz;
}
