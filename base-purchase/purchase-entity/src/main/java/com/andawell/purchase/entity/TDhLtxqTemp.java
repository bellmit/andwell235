package com.andawell.purchase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: TDhLtxqTemp
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月03日 下午02:33:10
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TDhLtxqTemp {
    /**
     * 自增Id
     */
    private Long id;

    /**
     * 部门
     */
    private String bm;

    /**
     * 机型名称
     */
    private String jxmc;

    /**
     * 器材名称
     */
    private String qcmc;

    /**
     * 器材型号
     */
    private String qcxh;

    /**
     * 器材类型名称
     */
    private String qclxmc;

    /**
     * 单位
     */
    private String dw;

    /**
     * 申请数量
     */
    private Integer sqsl;

    /**
     * 计划编号
     */
    private String bh;
}