package com.andawell.purchase.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author:PCJ
 * @Date:2020/6/2
 * @Version:V1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TDhJhqdVO {


    /**
     * 订货计划编号
     */
    //@ExcelProperty(value = "编号",index = 0)
    @ExcelIgnore
    @ApiModelProperty(value = "订货计划编号")
    private String bh;

    /**
     * 机型
     */
    @ApiModelProperty(value = "机型")
    @ExcelProperty(value = "机型Id",index = 0)
    private String jx;

    /**
     * 机型名称
     */
    @ApiModelProperty(value = "机型名称")
    @ExcelProperty(value = "机型名称",index = 1)
    private String jxmc;


    /**
     * 机型
     */
    @ApiModelProperty(value = "器材型号")
    @ExcelProperty(value = "器材型号",index = 2)
    private String jh;

    /**
     * 件号名称
     */
    @ApiModelProperty(value = "器材名称")
    @ExcelProperty(value = "器材名称",index = 3)
    private String jhmc;

    /**
     * 器材类型名称
     */
    @ApiModelProperty(value = "器材类型名称")
    @ExcelProperty(value = "器材类型名称",index = 4)
    private String qclxmc;

    /**
     * 计量单位名称
     */
    @ExcelProperty(value = "计量单位",index = 5)
    private String jldwmc;

    /**
     * 厂家名称
     */
    @ExcelProperty(value = "厂家名称",index = 6)
    @ApiModelProperty(value = "厂家名称")
    private String cjmc;


    /**
     * 厂家名称
     */
    @ExcelIgnore
    @ApiModelProperty(value = "厂家id")
    private String cj;

    /**
     * 单价
     */
    @ApiModelProperty(value = "单价")
    @ExcelProperty(value = "单价",index = 7)
    private String dj;


    /**
     * 目录id
     */
    @ExcelIgnore
    @ApiModelProperty(value = "目录id")
    private String mlid;

    /**
     * 价格依据
     */
    @ApiModelProperty(value = "价格依据")
    @ExcelProperty(value = "价格依据",index = 9)
    private String jgYy;

    /**
     * 价格类型
     */
    @ExcelProperty(value = "价格类型",index = 8)
    @ApiModelProperty(value = "价格类型")
    private String jgLx;

    /**
     * 价格类型名称
     */
    @ApiModelProperty(value = "价格类型名称")
    private String jgLxMc;

    /**
     * 申请数量
     */
    @ApiModelProperty(value = "申请数量")
    @ExcelProperty(value = "申请数量",index = 10)
    private Integer sqsl;

    /**
     * 单机安装数
     */
    @ExcelProperty(value = "单机安装数",index = 11)
    private Integer djazsl;

    /**
     * 库存数量
     */
    @ExcelProperty(value = "库存数量",index = 12)
    private Integer kcsl;


    /**
     * 库存数量
     */
    @ExcelProperty(value = "在修数量",index = 13)
    private Integer zxsl;

    /**
     * 库存数量
     */
    @ExcelProperty(value = "待修数量",index = 14)
    private Integer dxsl;

    /**
     * 库存数量
     */
    @ExcelProperty(value = "订货未到数量",index = 15)
    private Integer dhwdsl;


    /**
     * 订货计划数量
     */
    @ExcelProperty(value = "订货计划数量",index = 16)
    private Integer dhjhsl;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注",index = 17)
    private String bz;


    /**
     * 关联目录清单Id
     */
    @ExcelIgnore
    @ApiModelProperty(value = "关联目录清单Id")
    private Long mlQdid;

    /**
     * 监管单位
     */
    @ExcelIgnore
    @ApiModelProperty(value = "监管单位")
    private String jgdw;

    /**
     * 监管单位
     */
    @ExcelIgnore
    @ApiModelProperty(value = "总价")
    private String zj;
}
