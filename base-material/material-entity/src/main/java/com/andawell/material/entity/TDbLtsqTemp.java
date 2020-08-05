package com.andawell.material.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName: TDbLtsqTemp
 * @Description:
 * @author: Mybatis Generator
 * @date 2020年06月09日 下午02:39:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TDbLtsqTemp {
    /**
     * 申请单号
     */
    private String ltsqdh;

    /**
     * 申请单位
     */
    private String sqdw;

    /**
     * 机型
     */
    private String jx;

    /**
     * 申请类别
     */
    private Short sqlb;

    /**
     * 项数
     */
    private Integer xs;

    /**
     * 年度
     */
    private Short nd;

    /**
     * 季度
     */
    private Short jd;

    /**
     * 日期
     */
    private Date rq;

    /**
     * 申请人
     */
    private String sqr;

    /**
     * 数据处理
     */
    private Short datacl;

    /**
     * 接收单位
     */
    private String jsdw;

    /**
     * 接收人
     */
    private String jsr;

    /**
     * 联系电话
     */
    private String lxdh;

    /**
     * 上传状态1：未上传；2：以上传
     */
    private String sczt;

    /**
     * 处理状态1：未处理；2：已处理
     */
    private String clzt;
}
