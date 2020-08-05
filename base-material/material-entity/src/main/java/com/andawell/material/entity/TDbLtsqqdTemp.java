package com.andawell.material.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @ClassName: TDbLtsqqdTemp
 * @Description:
 * @author: Mybatis Generator
 * @date 2020年06月09日 下午02:46:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TDbLtsqqdTemp {
    /**
     * 申请单号
     */
    private String ltsqdh;

    /**
     * 项次
     */
    private Integer xc;

    /**
     * 件号
     */
    private String jh;

    /**
     * 单价安装数
     */
    private Integer azsl;

    /**
     * 全新数量
     */
    private Integer qxsl;

    /**
     * 可用数量
     */
    private Integer kysl;

    /**
     * 待修数量
     */
    private Integer dxsl;

    /**
     * 送修数量
     */
    private Integer sxsl;

    /**
     * 需求数量
     */
    private Integer xqsl;

    /**
     * 申请数量
     */
    private Integer sqsl;

    /**
     * 厂家
     */
    private String cj;

    /**
     * 飞机号
     */
    private String fjh;

    /**
     * 更换原因
     */
    private String ghyy;

    /**
     * 单价
     */
    private BigDecimal dj;

    /**
     * 总价
     */
    private BigDecimal zj;

    /**
     * 备注
     */
    private String bz;

    /**
     * 到货标志，0：没有到；1：已收到
     */
    private String dhbz;

    /**
     * null
     */
    private String jx;

    /**
     * 计量单位
     */
    private String jldw;
}
