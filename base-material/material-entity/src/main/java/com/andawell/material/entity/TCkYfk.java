package com.andawell.material.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
* @ClassName: TCkYfk
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月08日 下午04:56:48
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkYfk {
    /**
     * 编号
     */
    private String bh;

    /**
     * 单位代码
     */
    private String dwid;

    /**
     * 机型
     */
    private String jx;

    /**
     * 件号
     */
    private String jh;

    /**
     * 序号
     */
    private String xh;

    /**
     * 质量
     */
    private String zl;

    /**
     * 选择(冗余)
     */
    private String xz;

    /**
     * 数量
     */
    private Long sl;

    /**
     * 单价
     */
    private BigDecimal dj;

    /**
     * 总价
     */
    private BigDecimal zj;

    /**
     * 出厂日期
     */
    private Date ccrq;

    /**
     * 验收日期
     */
    private Date ysrq;

    /**
     * 寿命状态(保留)
     */
    private String smzt;

    /**
     * 入库日期
     */
    private Date rkrq;

    /**
     * 总寿命：年
     */
    private Integer zsmn;

    /**
     * 总寿命 ： 小时
     */
    private Integer zsmxs;

    /**
     * 总寿命 ： 循环
     */
    private Integer zsmxh;

    /**
     * 总寿命 ： 起落
     */
    private Integer zsmql;

    /**
     * 总飞行次数
     */
    private Integer zfxcs;

    /**
     * 油封日期
     */
    private Date yfrq;

    /**
     * 油封期限
     */
    private BigDecimal yfqx;

    /**
     * 总油封次数
     */
    private Integer zyfcs;

    /**
     * 油封次数
     */
    private Integer yfcs;

    /**
     * 飞行日期
     */
    private Date fxrq;

    /**
     * 飞行寿命：年
     */
    private Integer fxsmn;

    /**
     * 飞行寿命：小时
     */
    private Integer fxsmxs;

    /**
     * 飞行次数
     */
    private Integer fxcs;

    /**
     * 商保期限 ： 年
     */
    private Integer sbqxn;

    /**
     * 商保期限 ： 小时
     */
    private Integer sbqxxs;

    /**
     * 备注
     */
    private String bz;

    /**
     * 总飞行小时
     */
    private Integer zfxxs;

    /**
     * 本次总飞行小时
     */
    private Integer bczfxxs;

    /**
     * 本次飞行小时
     */
    private Integer bcfxxs;

    /**
     * 总循环次数
     */
    private Integer zxhcs;

    /**
     * 本次总循环次数
     */
    private Integer bczxhcs;

    /**
     * 本次循环次数
     */
    private Integer bcxhcs;

    /**
     * 总起落次数
     */
    private Integer zqlcs;

    /**
     * 本次总起落次数
     */
    private Integer bczqlcs;

    /**
     * 本次起落次数
     */
    private Integer bcqlcs;

    /**
     * 单位
     */
    private String dw;

    /**
     * 架位信息
     */
    private String jwh;

    /**
     * 1为序号管理;2为批次号管理
     */
    private Long glfs;

    /**
     * 仓库代码
     */
    private String ckdm;

    /**
     * 汇率
     */
    private BigDecimal hl;

    /**
     * 币种
     */
    private Integer bbz;

    /**
     * null
     */
    private String fjh;

    /**
     * 首翻日历期
     */
    private Integer sfrlq;

    /**
     * 总日历期
     */
    private Integer zrlq;

    /**
     * 总翻修次数
     */
    private Integer zfanxcs;

    /**
     * 翻修次数
     */
    private Integer fanxcs;

    /**
     * 修复日期
     */
    private Date xfrq;

    /**
     * 首翻期寿命
     */
    private Integer sfqsm;

    /**
     * 首翻期剩余寿命
     */
    private Integer sfqsysm;

    /**
     * 油封单位
     */
    private String yfdw;

    /**
     * 使用油料
     */
    private String syyl;

    /**
     * 封存方法
     */
    private Integer fcff;

    /**
     * 出库日期
     */
    private Date ckrq;

    /**
     * 发付人
     */
    private String ffr;

    /**
     * 接收人
     */
    private String jsr;

    /**
     * null
     */
    private BigDecimal yfje;

    private String ffdw;

    /**
     * 备用xz
     */
    private String xzs;
}