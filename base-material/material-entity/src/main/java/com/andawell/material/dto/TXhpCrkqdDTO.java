package com.andawell.material.dto;

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
 *@Auther:gzh
 *@Date:2020/5/18 10:11
 *@Description: 五金入库
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TXhpCrkqdDTO {

    /**
     * null
     */
    private String bh;

    /**
     * 批次号
     */
    private String pch;

    /**
     * 件号名称
     */
    @NotNull(message = "件号名称不能为空")
    @ApiModelProperty(name = "mc", value = "件号名称",required = true)
    private String mc;

    /**
     * 规格
     */
    @NotNull(message = "规格不能为空")
    @ApiModelProperty(name = "gg", value = "规格",required = true)
    private String gg;

    /**
     * 日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date rq;

    /**
     * 单位
     */
    private String dw;

    /**
     * 单价
     */
    private BigDecimal dj;

    /**
     * 数量
     */
    private BigDecimal sl;

    /**
     * 五金类别
     */
    @NotNull(message = "五金类别不能为空")
    @ApiModelProperty(name = "lb", value = "五金类别",required = true)
    private String lb;

    /**
     * 检验人
     */
    private String jyr;

    /**
     * 交货人
     */
    private String jhr;

    /**
     * 接收人
     */
    private String jsr;

    /**
     * 库管员
     */
    private String kgy;

    /**
     * 领用人，分发出库时共用
     */
    private String lyr;

    /**
     * 备注
     */
    private String bz;

    /**
     * 仓库号
     */
    private String ckdm;

    /**
     * 架位号
     */
    private String jwh;

    /**
     * 有效期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date yxq;

    /**
     * 器材类别
     */
    private String hclb;

    /**
     * dwid
     */
    private String dwid;

    /**
     * 通知数
     */
    private BigDecimal tzs;

    /**
     * 使用单位，分发出库时用
     */
    private String sydw;

    /**
     * 入库来源类别
     */
    private String lylb;
}
