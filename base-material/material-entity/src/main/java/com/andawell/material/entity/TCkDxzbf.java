package com.andawell.material.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
* @ClassName: TCkDxzbf
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月14日 下午05:45:46
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkDxzbf {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 单位ID
     */
    private String dwid;

    /**
     * 出入库编号
     */
    private String bh;

    /**
     * 机型
     */
    private String jx;

    /**
     * 件号
     */
    private String jh;

    /**
     * 序号
     */
    private String xh;

    /**
     * 数量
     */
    private Integer sl;

    /**
     * 待报废原因
     */
    private String dbfyy;

    /**
     * 备注
     */
    private String bz;

    /**
     * 发付单位
     */
    private String ffdw;

    /**
     * 航材类别
     */
    private Integer hclb;

    /**
     * 选择
     */
    private String xz;

    /**
     * 日期
     */
    private Date rq;

    /**
     * 间修期年
     */
    private Integer jxqn;

    /**
     * 间修期小时
     */
    private Integer jxqxs;
}