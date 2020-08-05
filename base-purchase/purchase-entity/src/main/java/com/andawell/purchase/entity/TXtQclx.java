package com.andawell.purchase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: TXtQclx
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月29日 下午02:51:25
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TXtQclx {
    /**
     * 主键Id
     */
    private String id;

    /**
     * 名称
     */
    private String qcMc;

    /**
     * 状态主键（预留字段） 
     */
    private Integer status;
}