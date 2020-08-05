package com.andawell.purchase.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
* @ClassName: THt
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月04日 下午01:26:31
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class THtDTO {
    /**
     * 合同号(2019LHZ9WA-158厂-1)  年度+LH + 机型名称+ 厂家 ，价格类型为暂定价是拼接-1
     */
    @ApiModelProperty(value = "合同号",required = true)
    @NotBlank(message = "合同号不为NULL")
    private String hth;

    /**
     * 计划编号
     */
    @ApiModelProperty(value = "计划编号",required = true)
    @NotBlank(message = "计划编号不为NULL")
    private String jhbh;

    /**
     * 机型
     */
    @ApiModelProperty(value = "机型",required = true)
    @NotBlank(message = "机型不为NULL")
    private String jx;



    /**
     * 签订地点
     */
    @NotBlank(message = "签订地点不为NULL")
    @ApiModelProperty(value = "签订地点",required = true)
    private String qddd;

    /**
     * 签订日期
     */
    @NotNull(message = "签订日期不为NULL")
    @ApiModelProperty(value = "签订日期",required = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date qdrq;


    /**
     * 定价依据
     */
    @NotBlank(message = "定价依据不为NULL")
    @ApiModelProperty(value = "定价依据",required = true)
    private String dlyj;

    /**
     * 运输方式
     */
    @NotBlank(message = "运输方式不为NULL")
    @ApiModelProperty(value = "运输方式",required = true)
    private String ysfs;

    /**
     * 总价
     */
    @NotBlank(message = "总价不为NULL")
    @ApiModelProperty(value = "总价",required = true)
    private String zj;

    /**
     * 总价
     */
    @NotBlank(message = "厂家不为NULL")
    @ApiModelProperty(value = "厂家",required = true)
    private String cjid;

}