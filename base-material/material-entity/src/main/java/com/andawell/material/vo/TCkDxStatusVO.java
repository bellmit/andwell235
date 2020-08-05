package com.andawell.material.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/***
 * @author hwd
 * @Date: 2020/5/7 14:14
 * @Description: 待修库状态VO
 * @version : V1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkDxStatusVO {

    /**
     * 名称
     */

    @ApiModelProperty(value = "名称", name = "name", dataType = "String")
    private String mc;


    /**
     * 件号
     */
    @ApiModelProperty(value = "件号", name = "JH", dataType = "String")
    private String jh;


    /**
     * 序号
     */
    @ApiModelProperty(value = "序号", name = "XH", dataType = "String")
    private String xh;

    /**
     * 机型
     */
    @ApiModelProperty(value = "机型", name = "JX", dataType = "String")
    private String jx;

    /**
     * 数量
     */
    @ApiModelProperty(value = "数量", name = "SL", dataType = "Long")
    private Long sl;

    /**
     * 单位
     */
    @ApiModelProperty(value = "单位", name = "DW", dataType = "String")
    private String dw;

    /**
     * 单位ID
     */
    @ApiModelProperty(value = "单位ID", name = "dwid", dataType = "String")
    private String dwid;

    /**
     * 选择;0为未送修 1为已送修
     */
    @ApiModelProperty(value = "xz", name = "xz", dataType = "String")
    private String xz;

    /**
     * 入库时间
     */
    @ApiModelProperty(value = "入库时间", name = "RKRQ", dataType = "Date")
    private Date rkrq;

    /**
     * 待修改编号
     */
    @ApiModelProperty(value = "待修改编号", name = "BH", dataType = "String")
    private String bh;

    /**
     * 故障信息
     */
    @ApiModelProperty(value = "故障信息", name = "YJ", dataType = "String")
    private String yj;

    /**
     * 质量 21:待修 24:待报废
     */
    @ApiModelProperty(value = "质量", name = "ZL", dataType = "String")
    private String zl;

    /**
     * 说明
     */
    @ApiModelProperty(value = "说明", name = "sm", dataType = "String")
    private String sm;

    /**
     * 更改日期
     */
    @ApiModelProperty(value = "说明", name = "zhrq", dataType = "String")
    private Date zhrq;
}
