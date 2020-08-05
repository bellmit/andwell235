package com.andawell.purchase.dto.htprint;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: yzy
 * @Description:
 * @Date: created in 2020/6/9 18:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class THtInfoDTO {

    @ApiModelProperty(value = "总条数")
    private Integer zts;

    @ApiModelProperty(value = "总数量")
    private Integer zsl;

    @ApiModelProperty(value = "总金额")
    private Double zje;
}
