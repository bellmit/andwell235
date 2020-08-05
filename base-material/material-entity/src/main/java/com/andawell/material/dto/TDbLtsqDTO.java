package com.andawell.material.dto;

import com.andawell.material.utils.ValidableList;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
* @ClassName: TDbLtsq
* @Description: 
* @author: shs
* @date 2020年05月13日 上午10:02:57
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TDbLtsqDTO {
    /**
     * 申请单号
     */
    @ApiModelProperty(value = "申请单号",name = "ltsqdh")
    private String ltsqdh;

    /**
     * 机型
     */
    @NotBlank(message = "机型不能为空")
    @ApiModelProperty(value = "机型",required = true)
    private String jx;

    /**
     * 申请类别
     */
    @NotNull(message = "申请类别不能为空")
    @ApiModelProperty(value = "申请类别",required = true)
    private Integer sqlb;


    /**
     * 年度
     */
    @NotNull(message = "年度不能为空")
    @ApiModelProperty(value = "年度",required = true)
    private Integer  nd;

    /**
     * 季度
     */
    @NotNull(message = "季度不能为空")
    @ApiModelProperty(value = "季度",required = true)
    private Integer jd;
    /**
     * 日期
     */
    @ApiModelProperty(value = "日期",name = "rq")
    private Date rq;

    /**
     * 申请人
     */
    @ApiModelProperty(value = "申请人",name = "sqr")
    private String sqr;


    /**
     * 接收单位
     */
    @NotBlank(message = "接收单位不能为空")
    @ApiModelProperty(name = "jsdw", value = "接收单位",required = true)
    private String jsdw;

    /**
     * 接收人
     */
    @ApiModelProperty(value = "接收人",name = "jsr")
    private String jsr;

    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话",name = "lxdh")
    private String lxdh;

    /**
     * 用户单位
     */
    @ApiModelProperty(value = "用户单位",name = "dw")
    private String dw;

    /**
     * 批量调拨明细信息
     */
    @Valid
    private ValidableList<TDbLtsqqdDTO> tDbLtsqqds;

}