package com.andawell.material.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/***
 * @author lhb
 * @Date: 2020/4/26 17:26
 * @Description:
 * @version : V1.0
 */
@Data
@Accessors(chain = true)
public class RotateQuery {

    @ApiModelProperty(name = "lhdw", value = "轮换单位Id")
    private String lhdw;

    @ApiModelProperty(name = "jx", value = "机型")
    private String jx;

    @ApiModelProperty(name = "jh", value = "件号")
    private String jh;

    @ApiModelProperty(name = "hclb", value = "航材类别")
    private String hclb;

}
