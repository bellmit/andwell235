package com.andawell.purchase.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author:PCJ
 * @Date:2020/6/4
 * @Version:V1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class THtVO {

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
     * 机型名称
     */
    private String jxmc;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date qdrq;

    /**
     * 采购方Id
     */
    private String cgfid;

    /**
     * 采购方名称
     */
    private String cgfmc;

    /**
     * 厂家ID
     */
    private String cjid;

    /**
     * 厂家名称
     */
    private String cjmc;

    /**
     * 监管方ID
     */
    private String jgfid;

    /**
     * 监管方名称
     */
    private String jgfmc;

    /**
     * 定价依据
     */
    private String dlyj;

    /**
     * 运输方式
     */
    private String ysfs;

    /**
     * 运输方式名称
     */
    private String ysfsmc;

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
     * 订货项数
     */
    private Integer xs;

    /**
     * 订货件数
     */
    private Integer js;

    /**
     * 交付年度
     */
    private Integer nd;
}
