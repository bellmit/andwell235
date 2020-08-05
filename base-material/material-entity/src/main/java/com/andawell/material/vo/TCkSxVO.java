package com.andawell.material.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/***
 * @author lhb
 * @Date: 2020/4/27 10:11
 * @Description:
 * @version : V1.0
 */
@Data
@ApiModel("送修信息")
public class TCkSxVO {

    /**
     * 送修编号
     */
    @ApiModelProperty(value = "送修编号", name = "bh")
    private String bh;

    /**
     * 合同编号
     */
    @ApiModelProperty(value = "合同编号", name = "htbh")
    private String htbh;

    /**
     * 待修编号
     */
    @ApiModelProperty(value = "待修编号", name = "dxbh")
    private String dxbh;

    /**
     * 序号
     */
    @ApiModelProperty(value = "序号", name = "xh")
    private String xh;

    /**
     * 送修数量
     */
    @ApiModelProperty(value = "送修数量", name = "sl")
    private String sl;

    /**
     * 送修日期
     */
    @ApiModelProperty(value = "送修日期", name = "sxrq")
    private String sxrq;

    /**
     * 承修单位
     */
    @ApiModelProperty(value = "承修单位", name = "cxdw")
    private String cxdw;

    /**
     * 间修期年
     */
    @ApiModelProperty(value = "间修期年", name = "jxqn")
    private String jxqn;

    /**
     * 间修期小时
     */
    @ApiModelProperty(value = "间修期小时", name = "jxqxs")
    private String jxqxs;

    /**
     * 单位id
     */
    @ApiModelProperty(value = "单位id", name = "dwid")
    private String dwid;

    /**
     * 单位名称
     */
    @ApiModelProperty(value = "单位名称", name = "cxdwmc")
    private String cxdwmc;

    /**
     * 机型
     */
    @ApiModelProperty(value = "机型id", name = "jx")
    private String jx;

    /**
     * 机型名称
     */
    @ApiModelProperty(value = "机型名称", name = "jxmc")
    private String jxmc;


    /**
     * 件号
     */
    @ApiModelProperty(value = "件号", name = "jh")
    private String jh;

    /**
     * 计量单位
     */
    @ApiModelProperty(value = "计量单位", name = "jh")
    private String dw;

    /**
     * 件号名称
     */
    @ApiModelProperty(value = "件号名称", name = "jhmc")
    private String jhmc;

    /**
     * 出厂日期
     */
    @ApiModelProperty(value = "出厂日期", name = "ccrq")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date ccrq;

    /**
     * 送修类别
     */
    @ApiModelProperty(value = "送修类别", name = "sxlb")
    private String sxlb;

    //统计类别，币种名称，id，币种汇率
    @ApiModelProperty(value = "币种id", name = "bbz")
    private final String bbz="1";

    @ApiModelProperty(value = "币种名称", name = "bbzmc")
    private final String bzmc="人民币";

    @ApiModelProperty(value = "汇率", name = "hl")
    private BigDecimal hl=new BigDecimal(1.000000);


    @ApiModelProperty(value = "航材类别")
    private Integer hclb;

    @ApiModelProperty(value = "质量")
    private String zl;
}
