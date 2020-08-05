package com.andawell.material.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TFfsjDcVO {

    /**
     * 编号
     */
    private String bh;

    /**
     * 机型
     */
    private String jx;
    /**
     * 机型名称
     */
    private String jxmc;
    /**
     * 文号
     */
    private String wh;
    /**
     * 运输方式
     */
    private String ysfs;
    /**
     * 运输方式名称
     */
    private String ysfsmc;
    /**
     * 日期
     */
    private String ckrq;
    /**
     * 发货单位
     */
    private String ffdw;
    /**
     * 接收单位
     */
    private String jsdw;
    /**
     * 发付单位名称
     */
    private String ffdwmc;
    /**
     * 接收单位名称
     */
    private String jsdwmc;



}
