package com.andawell.material.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: yzy
 * @Description:
 * @Date: created in 2020/7/8 14:29
 */
@Data
@ApiModel("修理能力明细查询")
public class TcksxXLNLMXVO {

    @ApiModelProperty(value = "机型名称", name = "jxmc")
    private String jxmc;

    @ApiModelProperty(value = "件号", name = "jh")
    private String jh;

    @ApiModelProperty(value = "件号名称", name = "jhmc")
    private String jhmc;

    @ApiModelProperty(value = "单位名称", name = "dwmc")
    private String dwmc;

    @ApiModelProperty(value = "平均修理时长", name = "avgTime")
    private String avgTime;

    @ApiModelProperty(value = "最长修理时长", name = "maxTime")
    private String maxTime;
}
