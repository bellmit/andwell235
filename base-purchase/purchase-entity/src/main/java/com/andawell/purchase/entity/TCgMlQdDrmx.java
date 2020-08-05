package com.andawell.purchase.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
* @ClassName: TCgMlQdDrmx
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月06日 下午04:09:49
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCgMlQdDrmx {
    /**
     * 器材类别Id
     */
    @ExcelProperty(value = "器材类别",index = 0)
    private String qcLx;

    /**
     * 机型Id
     */
    @ExcelProperty(value = "机型",index = 1)
    private String jx;

    /**
     * 件号名称
     */
    @ExcelProperty(value = "件号名称",index = 2)
    private String jhmc;

    /**
     * 件号ID
     */
    @ExcelProperty(value = "件号ID",index = 3)
    private String jh;

    /**
     * 计量单位
     */
    @ExcelProperty(value = "计量单位",index = 4)
    private String jldwmc;

    /**
     * 单价
     */
    @ExcelProperty(value = "单价",index = 5)
    private String dj;

    /**
     * 厂家
     */
    @ExcelProperty(value = "厂家",index = 6)
    private String cj;

    /**
     * 价格依据
     */
    @ExcelProperty(value = "价格依据",index = 7)
    private String jgYy;

    /**
     * 价格类型
     */
    @ExcelProperty(value = "价格类型",index = 8)
    private String jgLx;

    /**
     * 监管单位
     */
    @ExcelProperty(value = "监管单位",index = 9)
    private String jgDw;

    /**
     * 币种类别
     */
    @ExcelProperty(value = "币种类别",index = 10)
    private String bzlb;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注",index = 11)
    private String bz;

    /**
     * 汇率
     */
    private BigDecimal hl;

    /**
     * 从属目录编号
     */
    private String mlBh;
}