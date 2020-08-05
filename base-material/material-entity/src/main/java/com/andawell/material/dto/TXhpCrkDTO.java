package com.andawell.material.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 *@Auther:gzh
 *@Date:2020/5/18 10:11
 *@Description: 五金入库
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TXhpCrkDTO {

    /**
     * 编号
     */
    private String bh;

    /**
     * 批次号
     */
    private String pch;

    /**
     * 发付单位
     */
    private String ffdw;

    /**
     * 收入单位
     */
    private String srdw;

    /**
     * 出入库类别
     */
    @NotBlank(message = "入库类别不能为空")
    @ApiModelProperty(name = "lb", value = "入库类别",required = true)
    private String lb;

    /**
     * 出入库日期
     */
    @NotNull(message = "入库日期不能为空")
    @ApiModelProperty(name = "rkrq", value = "入库日期",required = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date rq;

    /**
     * 根据文号
     */
    private String gjwh;

    /**
     * 出入库文号
     */
    private String wh;
}
