package com.andawell.material.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: TCkAqkc
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月02日 下午05:15:18
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkAqkc {
    /**
     * 机型
     */
    private String jx;

    /**
     * 件号
     */
    private String jh;

    /**
     * 安全库存
     */
    private Integer aqkc;

    /**
     * 过剩点
     */
    private Integer gsd;

    /**
     * 低储点
     */
    private Integer dcd;
}