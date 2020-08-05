package com.andawell.material.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.math.BigDecimal;

/***
 * @author hwd
 * @Date: 2020-05-26 13:27
 * @Description:
 * @version : V1.0
 */
@Data
@ApiModel("库房出入库信息")
public class KFInOutMessageVO {
    /**
     * 流水号
     */
    private String lsh;

    /**
     * 根据文号
     */
    private String gjwh;

    /**
     * 出库文号
     */
    private String wh;

    /**
     * 件号名称
     */
    private String jhmc;

    /**
     * 件号
     */
    private String jh;

    /**
     * 机型
     */
    private String jx;


    /**
     * 机型
     */
    private String mc;


    /**
     * 合同号
     */
    private String hth;

    /**
     * 发票号
     */
    private String fph;

    /**
     * 单价
     */
    private BigDecimal dj;

    /**
     * 总价
     */
    private BigDecimal zj;

    /**
     * 币种
     */
    private String bzmc;

    /**
     * 汇率
     */
    private BigDecimal hl;

    /**
     * 发付单位
     */
    private String fhdw;

    /**
     * 接收单位
     */
    private String srdw;
}
