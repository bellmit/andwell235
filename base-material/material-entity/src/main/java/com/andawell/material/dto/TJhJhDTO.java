package com.andawell.material.dto;

import com.andawell.material.entity.TJhJh;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Date： 2020/4/28 14:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TJhJhDTO{

    @NotBlank(message = "件号id不能为空")
    @ApiModelProperty(value = "件号id",required = true)
    private String id;

    private String zjh;

    @ApiModelProperty(value = "件号名称",required = true)
    @NotBlank(message = "名称不能为空")
    private String mc;

    private String mce;

    private String dw;

    private String zylx;

    private String zyx;

    private String swz;

    private String bpz;

    private String glfs;

    private String jzbz;

    private String wxp;

    private String syfz;

    private String ccfz;

    private BigDecimal yfje;

    private Long djazs;

    /**
     *单位名称
     */

    @NotBlank(message = "件号单位名称不能为空")
    @ApiModelProperty(value = "件号单位名称",required = true)
    private String JhDwMc;



}
