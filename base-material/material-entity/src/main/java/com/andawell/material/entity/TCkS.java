package com.andawell.material.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
* @ClassName: TCkSx
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月06日 下午04:28:25
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkS {
    /**
     * 编号
     */
    private String bh;

    /**
     * 件号
     */
    private String jh;

    /**
     * 序号
     */
    private String xh;

    /**
     * 单位ID
     */
    private String dwid;

    /**
     * 机型
     */
    private String jx;

    /**
     * 选择 (0:送修未返回 1：送修已返回)
     */
    private String xz = "0";
    

    /**
     * 飞机号
     */
    private String fjh;

    /**
     * 备注
     */
    private String bz;

    /**
     * 质量 22:在修
     */
    private String zl;

    /**
     * 仓库代码
     */
    private String ckdm;

    /**
     * 返回地
     */
    private String fhd;

    /**
     * 承修单位
     */
    private String cxdw;

    /**
     * 送修日期
     */
    private Date sxrq;

    /**
     * 送修类别
     */
    private String sxlb;

    /**
     * 合同编号
     */
    private String htbh;

    /**
     * 数量
     */
    private Long sl;

    /**
     * 待修编号
     */
    private String dxbh;

    /**
     * 执行数量
     */
    private Integer zxsl;

    /**
     * null
     */
    private String pszt;

    /**
     * 航材类别
     */
    private Integer hclb;

    /**
     * 专业类别
     */
    private Integer zylb;

    /**
     * 故障原因
     */
    private String gzyy;

    /**
     * 间修期年
     */
    private Integer jxqn;

    /**
     * 间修期小时
     */
    private Integer jxqxs;

    /**
     * null
     */
    private String rfid;

    /**
     * null
     */
    private String ysid;

    /**
     * 上报编号
     */
    private String sbbh;

    /**
     * 上报日期
     */
    private Date sbrq;

    /**
     * 上报截止日期
     */
    private Date jzrq;

    /**
     * 批复状态
     */
    private String pfzt;

    /**
     * 生产厂家
     */
    private String sccj;

    /**
     * 使用时间
     */
    private String sysj;

    /**
     * 修复、退修
     */
    private String cljg;

    /**
     * 处理时间，即出入库时间
     */
    private Date clsj;

    /**
     * 处理编号，即对应的出入库编号
     */
    private String clbh;
}