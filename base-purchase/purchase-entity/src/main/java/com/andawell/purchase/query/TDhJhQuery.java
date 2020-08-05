package com.andawell.purchase.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author:PCJ
 * @Date:2020/6/6
 * @Version:V1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TDhJhQuery {

    /**
     * 计划编号(JH-BH-时间戳)
     */
    private String bh;

    /**
     * 计划名称
     */
    private String jhmc;

    /**
     * 计划年份
     */
    private String jhnf;

    /**
     * 计划说明
     */
    private String jhsm;

    /**
     * 创建日期
     */
    private Date cjrq;

    /**
     * 修改日期
     */
    private Date xgrq;

    /**
     * 1.草稿(暂留字段）2.发布  3. 删除
     */
    private Short status;
}
