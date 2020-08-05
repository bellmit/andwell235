package com.andawell.purchase.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: TDhLtxq
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月01日 下午04:31:43
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TDhLtxq {
    /**
     * 计划编号(JH-BH-06011457256)
     */
    private String bh;

    /**
     * 单位Id
     */
    private String dwid;

    /**
     * 机型
     */
    private String jx;

    /**
     * 件号
     */
    private String jh;

    /**
     * 器材类型
     */
    private String qclx;

    /**
     * 器材类型
     */
    private String qclxmc;

    /**
     * 创建日期
     */
    private Date cjrq;

    /**
     * 申请数量
     */
    private Long sqsl;
}