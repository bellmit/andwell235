package com.andawell.material.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
* @ClassName: TCkBfk
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月08日 上午11:03:26
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "报废出库查询对象")
public class TCkBfkOutLibraryOutVO {

    /**
     * 报废入库编号
     */
    @ApiModelProperty(value = "报废入库编号")
    private String bh;

    /**
     * 件号
     */
    @ApiModelProperty(value = "件号")
    private String jh;

    /**
     * 序号
     */
    private String xh;

    /**
     * 机型
     */
    private String jx;

    /**
     * 单位ID
     */
    private String dwid;

    /**
     * 报废单位
     */
    private String bfdw;

    /**
     * 报废日期
     */
    private Date bfrq;

    /**
     * 报废依据
     */
    private String bfyj;

    /**
     * 报废原因
     */
    private String bfyy;

    /**
     * 备注
     */
    private String bz;

    /**
     * 架位号
     */
    private String jwh;

    /**
     * 入库日期
     */
    private Date rkrq;

    /**
     * 审批人
     */
    private String spr;

    /**
     * 通知数
     */
    private Long tzs;

    /**
     * 仓库代码
     */
    private String ckdm;

    /**
     * 质量
     */
    private String zl;

    /**
     * 待修编号
     */
    private String dxbh;

    /**
     * 报废数量
     */
    private Long sl;

    /**
     * 选择
     */
    private String xz;

    /**
     * HCLB
     */
    private Long hclb;

    /**
     * 批准单位
     */
    private String pzdw;

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
}