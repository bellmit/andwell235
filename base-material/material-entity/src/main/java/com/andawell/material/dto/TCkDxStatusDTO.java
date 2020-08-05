package com.andawell.material.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/***
 * @author hwd
 * @Date: 2020-05-26 16:59
 * @Description:
 * @version : V1.0
 */
@Data
@ApiModel("待修状态")
public class TCkDxStatusDTO {

    /**
     * 名称
     */

    @ApiModelProperty(value = "名称", name = "name", dataType = "String")
    private String mc;


    /**
     * 件号
     */
    @NotBlank(message = "件号不能为空")
    @ApiModelProperty(value = "件号", name = "JH", dataType = "String")
    private String jh;


    /**
     * 序号
     */
    @NotBlank(message = "机型不能为空")
    @ApiModelProperty(value = "序号", name = "XH", dataType = "String")
    private String xh;

    /**
     * 机型
     */
    @NotBlank(message = "机型不能为空")
    @ApiModelProperty(value = "机型", name = "JX", dataType = "String")
    private String jx;

    /**
     * 数量
     */
    @NotNull(message = "数量不能为空")
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
    @NotBlank(message = "单位id不能为空")
    @ApiModelProperty(value = "单位ID", name = "dwid", dataType = "String")
    private String dwid;

    /**
     * 选择;0为未送修 1为已送修
     */
    @NotBlank(message = "选择不能为空")
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
    @NotBlank(message = "编号不能为空")
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
    @NotBlank(message = "质量不能为空")
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
