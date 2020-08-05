package com.andawell.material.dto;

import com.andawell.material.vo.TDbLtsqqdVO;
import io.swagger.annotations.ApiModelProperty;
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
public class TDbLtsqqdDTO extends TDbLtsqqdVO {

    /**
     * 申请单号
     */
    @ApiModelProperty(value = "申请单号",name = "ltsqdh")
    private String ltsqdh;

    /**
     * 项次
     */
    @ApiModelProperty(value = "项次",name = "xc")
    private Integer xc;

    /**
     * 件号
     */
    @NotBlank(message = "件号不能为空")
    @ApiModelProperty(value = "件号",name = "jh")
    private String jh;

    /**
     * 单价安装数
     */
    @ApiModelProperty(value = "单价安装数",name = "azsl")
    private Integer azsl;

    /**
     * 全新数量
     */
    @ApiModelProperty(value = "全新数量",name = "qxsl")
    private Integer qxsl;

    /**
     * 可用数量
     */
    @ApiModelProperty(value = "可用数量",name = "kysl")
    private Integer kysl;

    /**
     * 待修数量
     */
    @ApiModelProperty(value = "待修数量",name = "dxsl")
    private Integer dxsl;

    /**
     * 送修数量
     */
    @ApiModelProperty(value = "送修数量",name = "sxsl")
    private Integer sxsl;

    /**
     * 需求数量
     */
    @NotNull(message = "需求数量不能为空")
    @ApiModelProperty(value = "需求数量",required = true)
    private Integer xqsl;

    /**
     * 申请数量
     */
    @NotNull(message = "申请数量不能为空")
    @ApiModelProperty(value = "申请数量",required = true)
    private Integer sqsl;

    /**
     * 厂家
     */
    @ApiModelProperty(value = "厂家",name = "cj")
    private String cj;

    /**
     * 飞机号
     */
    @ApiModelProperty(value = "飞机号",name = "fjh")
    private String fjh;

    /**
     * 更换原因
     */
    @NotBlank(message = "申请原因不能为空")
    @ApiModelProperty(value = "申请原因",name = "ghyy")
    private String ghyy;

    /**
     * 单价
     */
    @ApiModelProperty(value = "单价",name = "dj")
    private BigDecimal dj;


    /**
     * 备注
     */
    @ApiModelProperty(value = "备注",name = "bz")
    private String bz;

    /**
     * 计量单位
     */
    @ApiModelProperty(value = "计量单位",name = "jldw")
    private String jldw;

}