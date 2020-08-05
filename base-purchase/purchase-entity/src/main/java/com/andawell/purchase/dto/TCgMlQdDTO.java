package com.andawell.purchase.dto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
* @ClassName: TCgMlQd
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月29日 下午03:43:07
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCgMlQdDTO {
    /**
     * null
     */

    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 目录编号
     */
    @NotBlank(message = "目录编号不为NULL")
    @ApiModelProperty(value = "目录编号",required = true)
    private String mlbh;

    /**
     * 机型Id
     */
    @NotBlank(message = "机型Id不为NULL")
    @ApiModelProperty(value = "目录编号",required = true)
    private String jx;

    /**
     * 机型名称
     */
    @ApiModelProperty(value = "机型名称",required = true)
    private String jxmc;

    /**
     * 件号
     */
    @NotBlank(message = "件号不为NULL")
    @ApiModelProperty(value = "件号",required = true)
    private String jh;

    /**
     * 件号名称
     */
    @ApiModelProperty(value = "件号名称",required = true)
    private String jhmc;

    /**
     * 单价
     */
    @NotBlank(message = "单价不为NULL")
    @ApiModelProperty(value = "单价",required = true)
    private String dj;

    /**
     * 厂家
     */
    @NotBlank(message = "厂家不为NULL")
    @ApiModelProperty(value = "厂家",required = true)
    private String cj;

    /**
     * 价格依据
     */
    @ApiModelProperty(value = "价格依据")
    private String jgyy;

    /**
     * 价格类型
     */
    @ApiModelProperty(value = "价格类型",required = true)
    @NotBlank(message = "价格类型不为NULL")
    private String jglx;

    /**
     * 监管单位
     */
    @ApiModelProperty(value = "监管单位")
    private String jgdw;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String bz;


    /**
     * 器材类别
     */
    @ApiModelProperty(value = "器材类别",required = true)
    @NotBlank(message = "器材类型不为NULL")
    private String qclx;


    /**
     * 汇率
     */
    @ApiModelProperty(value = "币种汇率",required = true)
    @NotNull(message = "币种汇率不为空")
    private BigDecimal hl;

    /**
     * 币种
     */
    @ApiModelProperty(value = "币种",required = true)
    @NotBlank(message = "币种不为空")
    private String bzlb;
}