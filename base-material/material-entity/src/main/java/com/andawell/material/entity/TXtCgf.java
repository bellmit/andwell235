package com.andawell.material.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: TXtCgf
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月27日 下午01:55:05
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TXtCgf {
    /**
     * 流水号,编码规则：CG+3位流水号
     */
    private String id;

    /**
     * 单位名称
     */
    private String dwmc;

    /**
     * 地址
     */
    private String dz;

    /**
     * 电话
     */
    private String dh;

    /**
     * 开户名称
     */
    private String khmc;

    /**
     * 开户银行
     */
    private String khyh;

    /**
     * 银行账户
     */
    private String yhzh;
}