package com.andawell.material.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: yzy
 * @Description:
 * @Date: created in 2020/5/21 13:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PKCX {

    /**
     * 机型
     */
    private String jxmc;

    /**
     * 名称
     */
    private String jhmc;
    /**
     * 件号
     */
    private String jh;
    /**
     * 序号
     */
    private String xh;
    /**
     * 单位
     */
    private String dw;
    /**
     * 数量
     */
    private Integer sl;
    /**
     *
     */
    private String PDJG;
}
