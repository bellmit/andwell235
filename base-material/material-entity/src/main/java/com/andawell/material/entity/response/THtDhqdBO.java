package com.andawell.material.entity.response;

import com.andawell.material.entity.THtDhqd;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 合同清单详细信息
 * @Date： 2020/4/29 11:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class THtDhqdBO extends THtDhqd {

    /**
     * 选择
     */
    private String xz;

    /**
     * 合同编号
     */
    private String htbh;

    /**
     * 件号中文名称
     */
    private String jhmc;

    /**
     * 件号
     */
    private String jh;

    /**
     * 机型中文名称
     */
    private String jxmc;

    /**
     * 航材类别id
     */
    private String hclb;

    /**
     * 航材类别名称
     */
    private String hclbmc;

    /**
     * 单价
     */
    private BigDecimal dj;

    /**
     * 币种
     */
    private String bzmc;

    /**
     * 总价
     */
    private BigDecimal zj;

    /**
     * 总寿命年
     */
    private Integer zsmn;

    /**
     * 总寿命小时
     */
    private Integer zsmxs;

    /**
     * 翻修寿命小时
     */
    private Integer sfxsmxs;

    /**
    /**
     * 首翻期年
     */
    private Integer sfqsm;

    /**
     * 已到数量
     */
    private Long ydsl;

    /**
     * 订货数量
     */
    private Integer dhsl;

    /**
     * 到货日期
     */
    private Date dhrq;

    /**
     * 间修期年
     */
    private Integer jxqn;

    /**
     * 间修期小时
     */
    private Integer jxqxs;

    /**
     * 件号id
     */
    private String jhid;

    /**
     * 件号单位
     */
    private String jldw;

    /**
     * 汇率
     */
    private BigDecimal hl;

    /**
     * 汇率id
     */
    private String bbz;
}
