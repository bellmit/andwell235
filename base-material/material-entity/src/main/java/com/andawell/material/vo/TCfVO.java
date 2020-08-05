package com.andawell.material.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: NXX012
 * @date: 2020/5/9
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("厂房列表")
public class TCfVO {

    @ApiModelProperty(value = "厂房id", name = "id", dataType = "String")
    private String id;

    @ApiModelProperty(value = "厂房简码", name = "jm", dataType = "String")
    private String jm;

    @ApiModelProperty(value = "厂房名称", name = "mc", dataType = "String")
    private String mc;
}
