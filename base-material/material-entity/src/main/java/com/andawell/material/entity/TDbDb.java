package com.andawell.material.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName: TDbDb
 * @Description:
 * @author: Mybatis Generator
 * @date 2020年05月21日 下午03:34:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TDbDb {
    /**
     * 调拨单号
     */
    private String dbdh;

    /**
     * 申请单号
     */
    private String sqdh;

    /**
     * 文号
     */
    private String wh;

    /**
     * 运输方式
     */
    private Integer ysfs;

    /**
     * 机型
     */
    private String jx;

    /**
     * 发付单位
     */
    private Integer ffdw;

    /**
     * 接收单位
     */
    private Integer jsdw;

    /**
     * 状态
     */
    private Integer zt;

    /**
     * 编写日期
     */
    private Date rq;

    /**
     * 备注
     */
    private String bz;

    /**
     * null
     */
    private Short bzw;

    /**
     * 调拨类型
     */
    private Integer dblx;

    /**
     * 打印标识
     */
    private Short print;

    /**
     * null
     */
    private Integer dblb;

    /**
     * 调拨编号
     */
    private String dbbh;

    /**
     * 下发状态0：未下发；1：以下发；
     */
    private String xfzt;

    /**
     * 处理状态0：未处理；1：以处理；
     */
    private String clzt;

    /**
     * 上传状态0：未长传；1：未长传
     */
    private String cszt;

    /**
     * 上级申请0：不需要上级申请；1：需要上级申请；
     */
    private String sjsq;

    /**
     * 上级申请时间
     */
    private Date sjrq;
}
