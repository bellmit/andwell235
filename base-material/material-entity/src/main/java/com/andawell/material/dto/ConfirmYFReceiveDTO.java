package com.andawell.material.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author hwd
 * @Date: 2020-05-13 11:02
 * @Description:油封完成接收确认
 * @version : V1.0
 */
@Data
@ApiModel("油封完成接收确认")
public class ConfirmYFReceiveDTO {

    @NotBlank(message = "编号不能为空")
    @ApiModelProperty(name = "bh", value = "编号不能为空",required = true)
    private String bh;

    @NotBlank(message = "单位ID不能为空")
    @ApiModelProperty(name = "dwid", value = "单位ID不能为空",required = true)
    private String dwid;

    @ApiModelProperty(name = "jx", value = "机型不能为空",required = true)
    @NotBlank(message = "机型不能为空")
    private String jx;

    @ApiModelProperty(name = "jh", value = "件号不能为空",required = true)
    @NotBlank(message = "件号不能为空")
    private String jh;

    @ApiModelProperty(name = "xh", value = "序号不能为空",required = true)
    @NotBlank(message = "序号不能为空")
    private String xh;

    @ApiModelProperty(name = "zl", value = "质量不能为空",required = true)
    @NotBlank(message = "质量不能为空")
    private String zl;

    private String xz = "2";

    private Date yfrq;

    private BigDecimal yfqx;
}
