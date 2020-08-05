package com.andawell.purchase.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
* @ClassName: TDhJhqd
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月02日 上午10:38:57
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TDhJhqdDTO {

    /**
     * 订货计划编号
     */
    @ApiModelProperty(value = "订货计划编号",required = true)
    @NotBlank(message = "订货计划编号不为NULl")
    private String bh;

    /**
     * 机型
     */
    @ApiModelProperty(value = "机型",required = true)
    @NotBlank(message = "机型不为NULl")
    private String jx;

    /**
     * 件号
     */
    @ApiModelProperty(value = "件号",required = true)
    @NotBlank(message = "件号不为NULl")
    private String jh;

    /**
     * 器材类型
     */
    @ApiModelProperty(value = "器材类型")
    private String qclx;

    /**
     * 申请数量
     */
    @ApiModelProperty(value = "申请数量")
    private Integer sqsl;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String bz;


    /**
     * 关联目录清单Id
     */
    @ApiModelProperty(value = "关联目录清单Id")
    private Long mlQdid;

    /**
     * 订货计划数量
     */
    @ApiModelProperty(value = "订货计划数量")
    @NotNull(message = "订货计划数量不为NULL")
    private Integer dhjhsl;


    /**
     * 订货计划数量
     */
    @ApiModelProperty(value = "机型名称")
    private String jxmc;

}