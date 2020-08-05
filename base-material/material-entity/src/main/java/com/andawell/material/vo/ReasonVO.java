package com.andawell.material.vo;/**
 * @Date： 2020/5/29 14:09
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *@Auther:liuys
 *@Date:2020/5/29 14:09
 *@Description:
 */
@Data
@ApiModel("申请原因")
public class ReasonVO {

    @ApiModelProperty(value = "id", name = "id", dataType = "String")
    private String id;

    @ApiModelProperty(value = "申请原因", name = "reason", dataType = "String")
    private String reason;
}
