package com.andawell.material.entity;


import lombok.Data;

import java.math.BigDecimal;


/***
 * @author lhb
 * @Date: 16:59
 * @Description:
 * @version : V1.0
 */
@Data
public class CurrencyInfo {

    private String id;

    private String name;

    private String code;

    private BigDecimal hl;
}
