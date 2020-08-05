package com.andawell.material.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/***
 * @author hwd
 * @Date: 2020-05-29 09:45
 * @Description:
 * @version : V1.0
 */
@Data
@ApiModel("机关调拨清单")
public class TDbSjsqQdDTO {


    @ApiModelProperty(value = "调拨单号", name = "dbdh", dataType = "String")
    private String dbdh;

    @NotNull(message = "机型不能为空")
    @ApiModelProperty(value = "机型", name = "jx", dataType = "String")
    private String jx;

    @NotNull(message = "接受单位不能为空")
    @ApiModelProperty(value = "接收单位", name = "jsdw", dataType = "String")
    private String jsdw;

    @NotNull(message = "申请原因不能为空")
    @ApiModelProperty(value = "申请原因", name = "sqyy", dataType = "String")
    private String sqyy;
    @NotNull(message = "质量不能为空")
    @ApiModelProperty(value = "质量", name = "zl", dataType = "String")
    private String zl;
    @NotNull(message = "件号不能为空")
    @ApiModelProperty(value = "件号", name = "jh", dataType = "String")
    private String jh;
    @NotNull(message = "数量不能为空")
    @ApiModelProperty(value = "数量", name = "sl", dataType = "Integer")
    private Integer sl;

    @NotNull(message = "平均单价不能为空")
    @ApiModelProperty(value = "平均单价", name = "dj", dataType = "BigDecimal")
    private BigDecimal dj;
}
