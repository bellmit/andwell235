package com.andawell.material.vo;/**
 * @Date： 2020/5/14 17:47
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 *@Auther:liuys
 *@Date:2020/5/14 17:47
 *@Description:
 */
@Data
public class TCkDxzbfVO {
    /**
     * 编号
     */
    @ApiModelProperty(name = "id", value = "编号", dataType = "Integer")
    private Integer id;

    /**
     * 单位ID
     */
    @ApiModelProperty(name = "dwid", value = "单位ID", dataType = "String")
    private String dwid;

    /**
     * 出入库编号
     */
    @ApiModelProperty(name = "bh", value = "出入库编号", dataType = "String")
    private String bh;

    /**
     * 机型
     */
    @ApiModelProperty(name = "jx", value = "机型", dataType = "String")
    private String jx;

    /**
     * 件号
     */
    @ApiModelProperty(name = "jh", value = "件号", dataType = "String")
    private String jh;

    /**
     * 序号
     */
    @ApiModelProperty(name = "xh", value = "序号", dataType = "String")
    private String xh;

    /**
     * 数量
     */
    @ApiModelProperty(name = "sl", value = "数量", dataType = "Integer")
    private Integer sl;

    /**
     * 待报废原因
     */
    @ApiModelProperty(name = "dbfyy", value = "待报废原因", dataType = "String")
    private String dbfyy;

    /**
     * 备注
     */
    @ApiModelProperty(name = "bz", value = "备注", dataType = "String")
    private String bz;

    /**
     * 发付单位
     */
    @ApiModelProperty(name = "ffdw", value = "发付单位", dataType = "String")
    private String ffdw;

    /**
     * 航材类别
     */
    @ApiModelProperty(name = "hclb", value = "航材类别", dataType = "String")
    private Integer hclb;

    /**
     * 选择
     */
    @ApiModelProperty(name = "xz", value = "选择", dataType = "String")
    private String xz;

    /**
     * 日期
     */
    @ApiModelProperty(name = "rq", value = "日期", dataType = "Date")
    private Date rq;

    /**
     * 间修期年
     */
    @ApiModelProperty(name = "jxqn", value = "间修期年", dataType = "Integer")
    private Integer jxqn;

    /**
     * 间修期小时
     */
    @ApiModelProperty(name = "jxqxs", value = "间修期小时", dataType = "Integer")
    private Integer jxqxs;

    /**
     *@Author: liuys
     *@Data: 2020/5/14
     *@Description:
     */


    @ApiModelProperty(name = "jxqxs", value = "计量单位名称", dataType = "Integer")
    private String jldwmc;

    @ApiModelProperty(name = "jxqxs", value = "计量单位", dataType = "String")
    private String jldw;

    @ApiModelProperty(name = "hclbmc", value = "航材类别名称", dataType = "String")
    private String hclbmc;

    @ApiModelProperty(name = "jhmc", value = "件号名称", dataType = "String")
    private String jhmc;
}
