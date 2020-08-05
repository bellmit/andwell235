package com.andawell.material.vo;/**
 * @Date： 2020/5/9 11:19
 */

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 *@Auther:liuys
 *@Date:2020/5/9 11:19
 *@Description:
 */
@Data
@ApiModel("出库详细信息")
public class TCkCkVO {
    /**
     * 单位ID
     */
    private String dwid;

    /**
     * 单位名称
     */
    private String dwmc;

    /**
     * 机型
     */
    private String jx;

    /**
     * 机型名称
     */
    private String jxmc;

    /**
     * 件号
     */
    private String jh;

    /**
     * 件号名称
     */
    private String jhmc;

    /**
     * 序号
     */
    private String xh;

    /**
     * 质量
     */
    private String zl;

    /**
     * 质量名称
     */
    private String zlmc;

    /**
     * 选择标志位
     */
    private String xz = "0";

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
     * 寿命状态
     */
    private String smzt;

    /**
     * 入库日期
     */
    private Date rkrq;

    /**
     * 总寿命年
     */
    private Integer zsmn;

    /**
     * 总寿命小时
     */
    private Integer zsmxs;

    /**
     * 总寿命循环
     */
    private Integer zsmxh;

    /**
     * 总寿命起落
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
     * 总油封次数
     */
    private Integer zyfcs;

    /**
     * 油封次数
     */
    private Integer yfcs;

    /**
     * 翻修日期
     */
    private Date fxrq;

    /**
     * 翻修寿命年
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
     * 商保期限年
     */
    private Integer sbqxn;

    /**
     * 商保期限小时
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
     * 架位号
     */
    private String jwh;

    /**
     * 管理方式
     */
    private Integer glfs;

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
     * 飞机号
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
     * 航材类别
     */
    private Integer hclb;

    /**
     * 计价
     */
    private BigDecimal jj;

    /**
     * 资源类别
     */
    private Integer zylb;

    /**
     * 总供气次数
     */
    private Integer zgqcs;

    /**
     * 供气次数
     */
    private Integer gqcs;

    /**
     * 首翻期小时
     */
    private Integer sfqxs;

    /**
     * 油封期限
     */
    private BigDecimal yfqx;

    /**
     * 间修期年
     */
    private Integer jxqn;

    /**
     * 间修期小时
     */
    private Integer jxqxs;

    /**
     * rfid卡号
     */
    private String rfid;

    /**
     * 验收id包装号
     */
    private String ysid;

    /**
     * 器材类别 1：周转器材；2：战备器材
     */
    private String qclb;

    /**
     * 备用xz
     */
    private String xzs;
}
