package com.andawell.material.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Date： 2020/4/28 14:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TGzDhVO {

    /**
     * 编号
     */
    private String id;

    /**
     * 机型
     */
    private String jx;

    /**
     * 运单号
     */
    private String ydh;

    /**
     * 箱数
     */
    private Integer xs;

    /**
     * 到货日期
     */
    private Date dhrq;

    /**
     * 收货人
     */
    private String sshr;

    /**
     * 接收人
     */
    private String jsr;

    /**
     * 送货人
     */
    private String shr;

    /**
     * 联系方式
     */
    private String lxfs;

    /**
     * 备注
     */
    private String bz;

    /**
     * 入库文号
     */
    private String rkwh;

    /**
     * 入库日期
     */
    private Date rkrq;

    /**
     * 状态
     */
    private Integer zt;

    /**
     * 发货单位
     */
    private String fhdw;

    /**
     * 入库箱数
     */
    private Integer rkxs;

    /**
     * 航材类别
     */
    private Integer hclb;

    /**
     * 承运单位
     */
    private String cydw;
}
