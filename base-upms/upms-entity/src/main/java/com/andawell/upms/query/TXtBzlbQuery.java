package com.andawell.upms.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @Author:PCJ
 * @Date:2020/5/11
 * @Version:V1.0.0
 */
@Data
@Accessors(chain = true)
@ApiModel("币种类别查询")
public class TXtBzlbQuery {

    @ApiModelProperty(name = "id", value = "id", dataType = "String")
    private String id;

    @ApiModelProperty(name = "mc", value = "mc", dataType = "String")
    private String mc;

    @ApiModelProperty(name = "jm", value = "jm", dataType = "String")
    private String jm;

    @ApiModelProperty(name = "hl", value = "hl", dataType = "BigDecimal")
    private BigDecimal hl;
}
