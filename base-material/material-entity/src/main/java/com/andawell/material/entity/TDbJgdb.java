package com.andawell.material.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
* @ClassName: TDbJgdb
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月28日 下午04:58:42
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TDbJgdb {
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
     * 处理状态：默认是0，处理后是1
     */
    private String clzt;

    /**
     * 打印标识
     */
    private Short print;

    /**
     * 编写日期
     */
    private Date rq;

    /**
     * 调拨编号
     */
    private String dbbh;

    /**
     * 下发状态0：未下发；1：以下发；
     */
    private String xfzt;

    /**
     * 上传状态0：未长传；1：未长传
     */
    private String cszt;

    /**
     * 调拨类型
     */
    private Integer dblx;

    /**
     * 申请编号
     */
    private String sqdh;

    /**
     * 申请单位(用户单位id)
     */
    private Integer sqdw;

    /**
     * 申请人
     */
    private String sqr;

    /**
     * 发付单位
     */
    private String ffdw;

    /**
     * 接收单位
     */
    private String jsdw;

    /**
     * dbdh
     */
    private String dbdh;

}