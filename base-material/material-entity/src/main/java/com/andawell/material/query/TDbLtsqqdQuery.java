package com.andawell.material.query;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
* @ClassName: TDbLtsqqd
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月13日 上午10:03:54
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TDbLtsqqdQuery {

    /**
     * 申请单号
     */
    @ApiParam(value = "申请单号", name = "ltsqdh")
    private String ltsqdh;

    /**
     * 器材型号
     */
    @ApiParam(value = "器材型号", name = "ID")
    private String id;
    /**
     * 机型
     */
    @ApiParam(value = "机型", name = "JX")
    private String jx;


}