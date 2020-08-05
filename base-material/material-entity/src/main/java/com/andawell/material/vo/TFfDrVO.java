package com.andawell.material.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
* @ClassName: TCkCrkqd
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月06日 下午04:28:25
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TFfDrVO {
    /**
     * 编号
     */
    private String bh;

    /**
     * 备用编号，涉及修改编号操作
     */
    private String bhs;

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
     * 红冲标示  默认是0
     */
    private String cxsgin = "0";

    /**
     * 单位ID
     */
    private String dwid;

    /** 默认是0
     * 选择
     */
    private String xz = "0";

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
    private Integer tzs;

    /**
     * 数量(入库 实收数;出库 实发数)  
     */
    private Integer sl;

    /**
     * 质量
     */
    private String zl;

    /**
     * 单价
     */
    private Integer dj;

    /**
     * 总价
     */
    private Integer zj;

    /**
     * 出厂日期
     */
    private String ccrq;

    /**
     * 验收日期
     */
    private String ysrq;

    /**
     * 寿命状态
     */
    private String smzt;

    /**
     * 入库日期
     */
    private String rkrq;

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
    private String yfrq;

    /**
     * 翻修日期
     */
    private String fxrq;

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
    private String cjrq;

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
    private Integer hl;

    /**
     * 出入库类别
     */
    private String lb;

    /**
     * 出入库日期
     */
    private String rq;

    /**
     * 计价
     */
    private Integer jj;

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
    private Integer yfqx;

    /**
     * 付款类别
     */
    private Integer fklb;

    /**
     * 缴旧数
     */
    private Integer jjs;

    /**
     * 中队代码
     */
    private String zddm;

    /**
     * 收旧数
     */
    private Integer sjs;

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
    private String xfrq;

    /**
     * 修复日期
     */
    private String xcxsgin;


}