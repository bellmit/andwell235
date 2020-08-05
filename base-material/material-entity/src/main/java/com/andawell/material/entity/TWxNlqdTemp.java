package com.andawell.material.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
* @ClassName: TWxNlqdTemp
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月09日 下午03:43:10
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TWxNlqdTemp {
    /**
     * PID
     */
    private Integer pid;

    /**
     * 厂方ID
     */
    private String cfid;

    /**
     * 维修类别
     */
    private String wxlb;

    /**
     * 设备名称
     */
    private String sbmc;

    /**
     * 设备型号
     */
    private String sbxh;

    /**
     * 设备状况
     */
    private String sbzk;

    /**
     * 制造厂家
     */
    private String zccj;

    /**
     * 计量单位
     */
    private String jlzq;

    /**
     * 资料名称
     */
    private String zlmc;

    /**
     * 资料版次
     */
    private String zlbc;

    /**
     * 章节号
     */
    private String zjh;

    /**
     * 内部编号
     */
    private String nbbh;

    /**
     * 资料来源
     */
    private String zlly;

    /**
     * 受控状态
     */
    private String skzt;

    /**
     * 工作环境
     */
    private String gzhj;

    /**
     * 备件来源
     */
    private String bjly;

    /**
     * 备注
     */
    private String bz;

    /**
     * 内部编号
     */
    private BigDecimal sxbl;
}