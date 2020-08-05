package com.andawell.material.dto;

import com.andawell.material.entity.TCkYfk;
import com.andawell.material.utils.ValidableList;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/***
 * @author hwd
 * @Date: 2020-05-08 13:36
 * @Description:外部油封登记入参
 * @version : V1.0
 */
@Data
@ApiModel("外部油封登记")
public class OutYFRegisterDTO
{
    /**
     * 类别简码
     */
    @NotBlank(message = "类别简码不为空")
    @ApiModelProperty(name = "jm;", value = "类别简码不为空",required = true)
    private String jm;

    /**
     * 单位代码
     */
    @NotBlank(message = "单位代码")
    @ApiModelProperty(name = "dwid;", value = "单位代码",required = true)
    private String dwid;

    /**
     * 机型
     */
    @NotBlank(message = "机型")
    @ApiModelProperty(name = "jx;", value = "机型",required = true)
    private String jx;

    /**
     * 件号
     */
    @NotBlank(message = "件号")
    @ApiModelProperty(name = "jh;", value = "件号",required = true)
    private String jh;

    /**
     * 序号
     */
    @NotBlank(message = "序号")
    @ApiModelProperty(name = "xh;", value = "序号",required = true)
    private String xh;

    /**
     * 质量
     */
    @NotBlank(message = "质量")
    @ApiModelProperty(name = "zl;", value = "质量")
    private String zl;


    /**
     * 数量
     */
    @NotBlank(message = "数量")
    @ApiModelProperty(name = "sl;", value = "数量")
    private String sl;


    /**
     * 出厂日期
     */
    @NotNull(message = "出厂日期")
    @ApiModelProperty(name = "ccrq;", value = "出厂日期")
    private Date ccrq;


    /**
     * 油封日期
     */
    @NotNull(message = "油封日期")
    @ApiModelProperty(name = "yfrq;", value = "油封日期")
    private Date yfrq;


    /**
     * 油封期限
     */
    @NotNull(message = "油封期限")
    @ApiModelProperty(name = "yfqx;", value = "油封期限")
    private BigDecimal yfqx;


    /**
     * 备注
     */
    @NotNull(message = "备注")
    @ApiModelProperty(name = "bz;", value = "备注")
    private String bz;



    /**
     * 单位
     */
    @NotNull(message = "单位")
    @ApiModelProperty(name = "dw;", value = "单位")
    private String dw;


    /**
     * 使用油料
     */
    @NotNull(message = "使用油料")
    @ApiModelProperty(name = "syyl;", value = "使用油料")
    private String syyl;

    /**
     * 封存方法
     */
    @NotNull(message = "封存方法")
    @ApiModelProperty(name = "fcff;", value = "封存方法")
    private Integer fcff;



    /**
     * 发付人
     */
    @NotNull(message = "发付人")
    @ApiModelProperty(name = "ffr;", value = "发付人")
    private String ffr;

    /**
     * 接收人
     */
    @NotNull(message = "接收人")
    @ApiModelProperty(name = "jsr;", value = "接收人")
    private String jsr;

    /**
     * 油封单位
     */
    @NotNull(message = "油封单位")
    @ApiModelProperty(name = "yfdw;", value = "油封单位")
    private String yfdw;

    /**
     * 选择(冗余)
     */
    @ApiModelProperty(name = "xz;", value = "选择(冗余)")
    private String xz="0";

    /**
     * 发付单位/来货单位
     */
    @NotNull(message = "发付单位/来货单位")
    @ApiModelProperty(name = "ffdw;", value = "发付单位/来货单位")
    private String ffdw;

}
