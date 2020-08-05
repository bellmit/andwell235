package com.andawell.purchase.entity;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
* @ClassName: THt
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月04日 下午01:26:31
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class THt {
    /**
     * 合同号(2019LHZ9WA-158厂-1)  年度+LH + 机型名称+ 厂家 ，价格类型为暂定价是拼接-1
     */
    private String hth;

    /**
     * 计划编号
     */
    private String jhbh;

    /**
     * 机型
     */
    private String jx;

    /**
     * 价格类型
     */
    private String jglx;

    /**
     * 签订地点
     */
    private String qddd;

    /**
     * 签订日期
     */
    private Date qdrq;

    /**
     * 采购方Id
     */
    private String cgfid;

    /**
     * 厂家ID
     */
    private String cjid;

    /**
     * 监管方ID
     */
    private String jgfid;

    /**
     * 定价依据
     */
    private String dlyj;

    /**
     * 运输方式
     */
    private String ysfs;

    /**
     * 总价
     */
    private String zj;

    /**
     * 创建日期
     */
    private Date cjrq;

    /**
     * 修改日期
     */
    private Date xgrq;

    /**
     * 交付年度
     */
    private Integer nd;

    /**
     * 交付进度
     */
    private String jfjd;

    /**
     * 订货项数
     */
    private Integer xs;

    /**
     * 订货件数
     */
    private Integer js;



}