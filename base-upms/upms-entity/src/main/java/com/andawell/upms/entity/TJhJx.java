package com.andawell.upms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: TJhJx
* @Description: 
* @author: Mybatis Generator
* @date 2020年07月01日 上午11:06:59
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TJhJx {
    /**
     * 编码规则采用PID+2位代码 默认编码从10开始
     */
    private String id;

    /**
     * 机型英文名称
     */
    private String mce;

    /**
     * 机型中文名称
     */
    private String mc;

    /**
     * 机型简码
     */
    private String jm;

    /**
     * 父代码
     */
    private String pid;

    /**
     * 类别
     */
    private String lb;

    /**
     * 数量
     */
    private Integer sl;

    /**
     * 序号指向
     */
    private Integer sgin;

    /**
     * 用于计划生成合同时的合同号组成
     */
    private Short htbz;
}