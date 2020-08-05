package com.andawell.upms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: TXtDw
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月11日 上午10:39:26
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TXtDw {
    /**
     * 单位ID
     */
    private String id;

    /**
     * 单位名称
     */
    private String mc;

    /**
     * 单位简称
     */
    private String jc;

    /**
     * 番号
     */
    private String fh;

    /**
     * 联系地址
     */
    private String lxdz;

    /**
     * null
     */
    private String dsn;

    /**
     * null
     */
    private String username;

    /**
     * null
     */
    private String password;

    /**
     * null
     */
    private String ip;

    /**
     * null
     */
    private Integer istrans;

    /**
     * 单位类型
     */
    private String lx;

    /**
     * 单位简码
     */
    private String ejm;

    /**
     * 父ID
     */
    private String pid;
}