package com.andawell.material.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: yzy
 * @Description:
 * @Date: created in 2020/7/9 11:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TCkSxXLNLDTO {

    @ApiModelProperty(name = "dwid", value = "单位id")
    private String dwid;

    @ApiModelProperty(name = "dwmc", value = "单位名称")
    private String dwmc;

    @ApiModelProperty(name = "avgTime", value = "平均修理时长")
    private String avgTime;

    @ApiModelProperty(name = "maxTime", value = "最长修理时长")
    private String maxTime;



}
