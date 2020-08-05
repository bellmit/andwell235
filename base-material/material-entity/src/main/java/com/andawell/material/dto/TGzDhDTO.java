package com.andawell.material.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Date： 2020/4/28 14:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TGzDhDTO {

    /**
     * 编号
     */
    @ApiModelProperty(value = "编号",required = true)
    @NotBlank(message = "编号不能为空")
    private String id;
    /**
     * 入库文号
     */
    @ApiModelProperty(value = "入库文号不能为空",required = true)
    @NotBlank(message = "入库文号不能为空")
    private String rkwh;

    /**
     * 入库日期
     */
    @ApiModelProperty(value = "入库日期",required = true)
    private Date rkrq;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态不能为空",required = true)
    @NotNull(message = "状态不能为空")
    private Integer zt;


}
