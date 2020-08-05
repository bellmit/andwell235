package com.andawell.upms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
* @ClassName: TXtBzlb
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月11日 上午09:35:52
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TXtBzlb {
    /**
     * ID
     */
    private String id;

    /**
     * 名称
     */
    private String mc;

    /**
     * 简码
     */
    private String jm;

    /**
     * null
     */
    private BigDecimal hl;
}