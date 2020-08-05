package com.andawell.purchase.dto.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/***
 * @author lhb
 * @Date: 2020/6/2 13:19
 * @Description:
 * @version : V1.0
 */
@Data
public class LtXqExcelDTO  {

    /**
     * 申请单位
     */
    @ExcelProperty(index = 1)
    private String bm;

    /**
     * 机型
     */
    @ExcelProperty(index = 2)
    private String jxmc;

    /**
     * 器材名称
     */
    @ExcelProperty(index = 3)
    private String qcmc;

    
    /**
     * 件号
     */
    @ExcelProperty(index = 4)
    private String qcxh;

    /**
     * 器材类型
     */
    @ExcelProperty(index = 5)
    private String qclxmc;

    /**
     * 单位
     */
    @ExcelProperty(index = 6)
    private String dw;


    /**
     * 申请数量
     */
    @ExcelProperty(index = 7)
    private Integer sqsl;

}
