package com.andawell.material.query;/**
 * @Date： 2020/6/10 17:50
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 *@Auther:liuys
 *@Date:2020/6/10 17:50
 *@Description:
 */
@Data
@Accessors(chain = true)
public class TWxNlqdTempQuery {

    @ApiModelProperty(name = "pid",value = "pid",dataType = "Integer")
    private Integer pid;

    @ApiModelProperty(name = "cfid",value = "厂方id",dataType = "String")
    private String cfid;
}
