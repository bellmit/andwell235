package com.andawell.purchase.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: HtFkQd
 * @Description:
 * @author: Mybatis Generator
 * @date 2020年06月08日 下午04:37:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HtFkQd {
    /**
     * 入库编号
     */
    private String rkb;

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
     * 合同号
     */
    private String hth;

    /**
     * 付款编号  fk-三位流水号
     */
    private String fkbh;

    /**
     * 付款日期
     */
    private Date fkrq;

}