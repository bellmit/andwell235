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
public class TXhpCkDTO {

    /**
     * 批次号
     */
    @NotNull(message = "批次号不能为空")
    @ApiModelProperty(name = "pch", value = "批次号",required = true)
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
     * 计量单位
     */
    private String dw;

    /**
     * 单价
     */
    private BigDecimal dj;

    /**
     * 数量
     */
    @NotNull(message = "入/出库数不能为空")
    @ApiModelProperty(name = "sl", value = "入/出库数",required = true)
    private BigDecimal sl;

    /**
     * 五金类别
     */
    @NotNull(message = "五金类别不能为空")
    @ApiModelProperty(name = "lb", value = "五金类别",required = true)
    private String lb;

    /**
     * 架位号
     */
    private String jwh;

    /**
     * 仓库号
     */
    private String ckdm;

    /**
     * 单位ID
     */
    private String dwid;

    /**
     * 入库日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date rkrq;

    /**
     * 有效期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date yxq;

    /**
     * 来源单位
     */
    private String lydw;

    /**
     * null
     */
    private String bz;

    /**
     * 入库来源类别
     */
    private String lylb;
}
