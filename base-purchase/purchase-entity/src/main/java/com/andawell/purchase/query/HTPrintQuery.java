package com.andawell.purchase.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: yzy
 * @Description:
 * @Date: created in 2020/6/16 10:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HTPrintQuery {
    /**
     * 合同号
     */
    private String hth;
    /**
     * 计划编号
     */
    private String jhbh;
}
