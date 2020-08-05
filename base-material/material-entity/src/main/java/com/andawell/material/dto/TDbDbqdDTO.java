package com.andawell.material.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author hwd
 * @Date: 2020-05-22 09:56
 * @Description:
 * @version : V1.0
 */
@Data
@ApiModel("战区和机关调拨清单")
public class TDbDbqdDTO
{
    /**
     * 调拨单号
     */
    @ApiModelProperty(name = "dbdh", value = "调拨单号")
    private String dbdh;

    /**
     * 件号
     */
    @NotNull(message = "件号不能位空")
    private String jh;

    /**
     * 质量
     */

    private String zl;

    /**
     * 机型
     */
    @NotNull(message = "机型不能位空")
    private String jx;

    /**
     * 调拨数量
     */
    private Integer dcsl;

    /**
     * 上级申请数量
     */
    private Integer sjsq;

    /**
     * 备注
     */
    private String bz;

    /**
     * null
     */
    private Short bzw;

    /**
     * 最迟发付日期
     */

    private Date zcffrq;

    /**
     * 平均单价
     */
    //@NotNull(message = "平均单价不能位空")
    private BigDecimal dj;

    /**
     * 发付单位
     */
    private String dwid;

    /**
     * 接受单位（申请单位）
     */
    private String sqdw;

    /**
     * 申请数量
     */
    private String sqsl;


    /**
     * 申请原因
     */
    private String ghyy;


}
