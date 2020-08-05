package com.andawell.material.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author hwd
 * @Date: 2020-05-12 18:02
 * @Description:数据提交DTO
 * @version : V1.0
 */
@Data
@ApiModel("油封完成数据提交")
public class PutYFDataDTO {
    @ApiModelProperty(value = "编号不能为空",required = true)
    @NotBlank(message = "编号不能为空")
    private String bh;
    @ApiModelProperty(value = "单位ID不能为空",required = true)
    @NotBlank(message = "单位ID不能为空")
    private String dwid;
    @ApiModelProperty(value = "机型不能为空",required = true)
    @NotBlank(message = "机型不能为空")
    private String jx;
    @ApiModelProperty(value = "件号不能为空",required = true)
    @NotBlank(message = "件号不能为空")
    private String jh;
    @ApiModelProperty(value = "序号不能为空",required = true)
    @NotBlank(message = "序号不能为空")
    private String xh;
    @ApiModelProperty(value = "质量不能为空",required = true)
    @NotBlank(message = "质量不能为空")
    private String zl;
    @ApiModelProperty(value = "选择不能为空",required = true)
    @NotBlank(message = "选择不能为空")
    private String xz;

    @ApiModelProperty(value = "油封日期",required = true)
    @NotNull(message = "油封日期不能为空")
    private Date yfrq;
    @ApiModelProperty(value = "油封期限",required = true)
    @NotNull(message = "油封期限不能为空")
    private BigDecimal yfqx;
    @ApiModelProperty(value = "油封方法",required = true)
    @NotNull(message = "油封方法不能为空")
    private Integer fcff;

    private String bz;

    /**
     * 使用油料
     */
    @NotBlank(message = "使用油料不能为空")
    private String syyl;

    
    private String xzs;
















}
