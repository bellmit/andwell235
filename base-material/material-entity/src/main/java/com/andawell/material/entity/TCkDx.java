package com.andawell.material.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: TCkDx
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月06日 下午04:28:25
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkDx {
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
     * 选择;0为未送修 1为已送修
     */
    private String xz;

    /**
     * 机型
     */
    private String jx;

    /**
     * 单位编号
     */
    private String dwid;

    /**
     * 仓库代码
     */
    private String ckdm;

    /**
     * 飞机号
     */
    private String fjh;

    /**
     * 质量 21:待修 24:待报废
     */
    private String zl;

    /**
     * 入库日期
     */
    private Date rkrq;

    /**
     * 使用单位
     */
    private String sydw;

    /**
     * 专业
     */
    private String zy;

    /**
     * 故障日期
     */
    private Date gzrq;

    /**
     * 发现人
     */
    private String fxr;

    /**
     * 排故人
     */
    private String pgr;

    /**
     * 故障现象
     */
    private String gzxx;

    /**
     * 装机时间
     */
    private Date zjsj;

    /**
     * 装机单位
     */
    private String zjdw;

    /**
     * 装机人
     */
    private String zjr;

    /**
     * 拆机单位
     */
    private String cjdw;

    /**
     * 拆机时间
     */
    private Date cjsj;

    /**
     * 拆机人
     */
    private String cjr;

    /**
     * 备注
     */
    private String bz;

    /**
     * 本次循环次数
     */
    private Integer bcxhcs;

    /**
     * 本次起落次数
     */
    private Integer bcqlcs;

    /**
     * 本次飞行次数
     */
    private Integer bcfxxs;

    /**
     * 数量
     */
    private Long sl;

    /**
     * 承修单位
     */
    private String cxdw;

    /**
     * 故障信息卡
     */
    private String yj;

    /**
     * 用于保存送修表中的合同编号 （返修时使用）
     */
    private String htbh;

    /**
     * 送修数量
     */
    private Integer zxsl;

    /**
     * 出厂日期
     */
    private Date ccrq;

    /**
     * 验收日期
     */
    private Date ysrq;

    /**
     * 寿命状态(保留)暂无意义
     */
    private String smzt;

    /**
     * 总寿命:年
     */
    private String zsmn;

    /**
     * 总寿命:小时
     */
    private String zsmxs;

    /**
     * 总寿命:循环
     */
    private String zsmxh;

    /**
     * 总寿命:起落
     */
    private String zsmql;

    /**
     * 总飞行次数
     */
    private String zfxcs;

    /**
     * 油封日期
     */
    private Date yfrq;

    /**
     * 油封权限
     */
    private Integer yfqx;

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
     * 飞行寿命:年
     */
    private Integer fxsmn;

    /**
     * 飞行寿命:小时
     */
    private Integer fxsmxs;

    /**
     * 飞行次数
     */
    private Integer fxcs;

    /**
     * 总飞行小时
     */
    private Integer zfxxs;

    /**
     * 本次总飞行小时
     */
    private Integer bczfxxs;

    /**
     * 总循环次数
     */
    private Integer zxhcs;

    /**
     * 本次总循环次数
     */
    private Integer bczxhcs;

    /**
     * 总起落次数
     */
    private Integer zqlcs;

    /**
     * 本次总起落次数
     */
    private Integer bczqlcs;

    /**
     * null
     */
    private String zt;

    /**
     * 航材类别
     */
    private Integer hclb;

    /**
     * 修理级别
     */
    private Integer xljb;

    /**
     * 专业类别
     */
    private Integer zylb;

    /**
     * 架位号
     */
    private String jwh;

    /**
     * null
     */
    private String zddm;

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
     * 上报开始日期
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
     * 报废、送修
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

    /**
     * 状态互转说明
     */
    private String zhsm;

    /**
     * 状态转换日期
     */
    private Date zhrq;

    /**
     * 新选择
     */
    private String xxz;
}