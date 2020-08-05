package com.andawell.upms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: TXtCk
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月07日 下午02:34:58
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TXtCk {
    /**
     * 单位代码
     */
    private String dwid;

    /**
     * 仓库代码
     */
    private String ckid;

    /**
     * 仓库名称
     */
    private String mc;

    /**
     * 仓库类型 0普通;1密集
     */
    private Short lx;
}