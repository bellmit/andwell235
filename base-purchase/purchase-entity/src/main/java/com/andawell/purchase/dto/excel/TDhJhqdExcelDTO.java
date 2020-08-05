package com.andawell.purchase.dto.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
* @ClassName: TDhJhqd
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月02日 上午10:38:57
*/
@Data
@AllArgsConstructor
public class TDhJhqdExcelDTO {


    /**
     * 机型
     */
    @ExcelProperty(value = {"机型"})
    private String jx;

    /**
     * 件号
     */
    @ExcelProperty(value = {"件号"})
    private String jh;

    /**
     * 器材类型
     */
    @ExcelProperty(value = {"器材类型"})
    private String qclx;

    /**
     * 申请数量
     */
    @ExcelProperty(value = {"申请数量"})
    private Integer sqsl;

    /**
     * 订货计划数量
     */
    @ExcelProperty(value = {"订货计划数量"})
    private Integer dhJhsl;

    /**
     * 备注
     */
    @ExcelProperty(value = {"备注"})
    private String bz;

}