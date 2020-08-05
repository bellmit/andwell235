package com.andawell.material.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
* @ClassName: TJhPtjh
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月20日 下午02:32:20
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TJhPtjh {
    /**
     * 主件号
     */
    private String jh;

    /**
     * 配套件号
     */
    private String ptjh;

    /**
     * 机型
     */
    private String jx;

    /**
     * 配套数量
     */
    private Integer sl;

    /**
     * 日期
     */
    private Date rq;

    /**
     * 备注
     */
    private String bz;
}