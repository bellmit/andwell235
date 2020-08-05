package com.andawell.purchase.entity;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
* @ClassName: THtQdTemp
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月11日 下午03:21:02
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class THtQdTemp {
    /**
     * null
     */
    private String hth;

    /**
     * null
     */
    private String jhbh;

    /**
     * null
     */
    private String jx;

    /**
     * null
     */
    private String jh;

    /**
     * null
     */
    private Long mlQdid;

    /**
     * null
     */
    private Integer sl;

    /**
     * null
     */
    private String zj;

    /**
     * null
     */
    private String bz;

    /**
     * null
     */
    private Date cjrq;

    /**
     * null
     */
    private Date xgrq;


    private BigDecimal hl;


    private String bzlb;
}