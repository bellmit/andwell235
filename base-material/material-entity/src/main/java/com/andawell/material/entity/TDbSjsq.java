package com.andawell.material.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
* @ClassName: TDbSjsq
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月29日 上午11:44:34
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TDbSjsq {
    /**
     * 申请单号
     */
    private String sqdh;

    /**
     * 调拨单号
     */
    private String dbdh;

    /**
     * 机型
     */
    private String jx;

    /**
     * 处理状态0：未处理；1：以处理；
     */
    private String clzt;

    /**
     * 申请人
     */
    private String sqr;

    /**
     * 日期
     */
    private Date rq;

    /**
     * 调拨编号
     */
    private Integer dbbh;

    /**
     * 申请单位
     */
    private String sqdw;

    /**
     * 下发状态0：未下发；1：以下发；
     */
    private String xfzt;

    /**
     * 调拨类型
     */
    private String dblx;

    /**
     * 上传状态
     */
    private String sczt;
}