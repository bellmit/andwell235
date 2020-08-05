package com.andawell.upms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: TXtJgf
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月27日 下午01:34:03
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TXtJgf {
    /**
     * 流水号，规则：JG+3为流水号
     */
    private String id;

    /**
     * 名称
     */
    private String mc;

    /**
     * 地址
     */
    private String dz;

    /**
     * 邮编
     */
    private String yb;

    /**
     * 电话
     */
    private String dh;
}