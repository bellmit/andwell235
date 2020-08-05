package com.andawell.purchase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
* @ClassName: TCkCrkqd
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月12日 上午10:10:37
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkCrkqd {
    /**
     * 编号
     */
    private String bh;

    /**
     * 机型
     */
    private String jx;

    /**
     * 件号
     */
    private String jh;

    /**
     * 序号(批次号)
     */
    private String xh;

    /**
     * 红冲标示
     */
    private String cxsgin;

    /**
     * 单位ID
     */
    private String dwid;

    /**
     * 选择
     */
    private String xz;

    /**
     * 仓库代码
     */
    private String ckdm;

    /**
     * 架位号
     */
    private String jwh;

    /**
     * 飞机号
     */
    private String fjh;

    /**
     * 通知数
     */
    private Long tzs;

    /**
     * 数量(入库 实收数;出库 实发数)  
     */
    private Long sl;

    /**
     * 质量
     */
    private String zl;

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
     * 寿命状态
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
     * 总寿命：小时
     */
    private Integer zsmxs;

    /**
     * 总寿命：循环次数
     */
    private Integer zsmxh;

    /**
     * 总寿命 ：起落次数
     */
    private Integer zsmql;

    /**
     * 总翻修次数
     */
    private Integer zfxcs;

    /**
     * 油封日期
     */
    private Date yfrq;

    /**
     * 翻修日期
     */
    private Date fxrq;

    /**
     * 翻修年限
     */
    private Integer fxsmn;

    /**
     * 翻修寿命小时
     */
    private Integer fxsmxs;

    /**
     * 翻修次数
     */
    private Integer fxcs;

    /**
     * 商保期年
     */
    private Integer sbqxn;

    /**
     * 商保期飞行小时
     */
    private Integer sbqxxs;

    /**
     * 备注
     */
    private String bz;

    /**
     * 总飞行小时(总使用时间)
     */
    private Integer zfxxs;

    /**
     * 本次总飞行小时(使用时间)
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
     * 循环次数
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
     * 起落次数
     */
    private Integer bcqlcs;

    /**
     * 调拨选择标志 外借选择标志
     */
    private String dbbz;

    /**
     * 创建日期
     */
    private Date cjrq;

    /**
     * 油封次数
     */
    private Integer yfcs;

    /**
     * 总油封次数
     */
    private Integer zyfcs;

    /**
     * 新品是否选择标志
     */
    private String xsbz;

    /**
     * 汇率
     */
    private BigDecimal hl;

    /**
     * 出入库类别
     */
    private String lb;

    /**
     * 出入库日期
     */
    private Date rq;

    /**
     * 计价
     */
    private BigDecimal jj;

    /**
     * 航材类别
     */
    private Integer hclb;

    /**
     * 币种
     */
    private Integer bbz;

    /**
     * 专业类别
     */
    private Integer zylb;

    /**
     * 原序号(原批次号)
     */
    private String yxh;

    /**
     * 总供气次数
     */
    private Integer zgqcs;

    /**
     * 供气次数
     */
    private Integer gqcs;

    /**
     * 油封期限
     */
    private BigDecimal yfqx;

    /**
     * 付款类别
     */
    private Short fklb;

    /**
     * 缴旧数
     */
    private Long jjs;

    /**
     * 中队代码
     */
    private String zddm;

    /**
     * 收旧数
     */
    private Long sjs;

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
     * 原件号
     */
    private String yjh;

    /**
     * 修复日期
     */
    private Date xfrq;
}