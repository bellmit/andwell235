package com.andawell.material.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/***
 * @author lhb
 * @Date: 2020/4/27 10:11
 * @Description:
 * @version : V1.0
 */
@Data
@ApiModel("货币信息")
public class CurrencyVO {

    @ApiModelProperty(value = "id", name = "id")
    private String id;

    @ApiModelProperty(value = "货币信息名称", name = "name")
    private String name;

    @ApiModelProperty(value = "货币信息代码", name = "code")
    private String code;

    @ApiModelProperty(value = "汇率", name = "code")
    private BigDecimal hl;

}
