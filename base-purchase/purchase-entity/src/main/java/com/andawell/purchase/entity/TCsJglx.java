package com.andawell.purchase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: TCsJglx
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月06日 上午10:18:19
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCsJglx {
    /**
     * 价格依据ID
     */
    private String id;

    /**
     * 价格依据名称
     */
    private String mc;

    /**
     * 价格依据简码
     */
    private String jm;
}