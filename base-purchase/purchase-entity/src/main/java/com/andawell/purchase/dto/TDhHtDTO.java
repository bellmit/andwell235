package com.andawell.purchase.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

/***
 * @author lhb
 * @Date: 2020/6/4 13:42
 * @Description:
 * @version : V1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("订货合同")
public class TDhHtDTO {


    /**
     * 计划编号
     */
    @ApiModelProperty(value = "计划编号")
    @NotBlank(message = "计划编号不为NUll")
    private String jhbh;


    /**
     * 签订地点
     */
    @ApiModelProperty(value = "签订地点")
    @NotBlank(message = "签订地点不为NUll")
    private String qddd;

    /**
     * 签订日期
     */
    @ApiModelProperty(value = "签订日期")
    @NotNull(message = "签订日期不为NUll")
    private Date qdrq;

    /**
     * 定价依据
     */
    @ApiModelProperty(value = "定价依据")
    @NotBlank(message = "定价依据不为NUll")
    private String dlyj;

    /**
     * 运输方式
     */
    @ApiModelProperty(value = "运输方式")
    @NotBlank(message = "运输方式不为NUll")
    private String ysfs;


    /**
     * 采购方Id
     */
    @ApiModelProperty(value = "采购方Id")
    @NotBlank(message = "采购方Id不为NUll")
    private String cgfid;

    /**
     * 交付年度
     */
    @ApiModelProperty(value = "交付年度")
    @NotNull(message = "交付年度不为NUll")
    private Integer nd;

    /**
     * 交付进度
     */
    @ApiModelProperty(value = "交付进度")
    @NotBlank(message = "交付进度不为NUll")
    private String jfjd;

}
