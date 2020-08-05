package com.andawell.material.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Date： 2020/4/30 15:22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TJhVO {
    /**
     * 机型
     */
    @ApiModelProperty(value = "jx", name = "机型", dataType = "String")
    private String jx;


    /**
     * 件号
     */
    @ApiModelProperty(value = "id", name = "件号id", dataType = "String")
    private String id;


    /**
     * 器材名称
     */
    @ApiModelProperty(value = "mc", name = "器材名称", dataType = "String")
    private String mc;

    /**
     * 资源名称
     */
    @ApiModelProperty(value = "jldw", name = "计量单位", dataType = "String")
    private String jldw;


}
