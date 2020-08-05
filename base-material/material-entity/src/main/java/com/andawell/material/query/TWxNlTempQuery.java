package com.andawell.material.query;/**
 * @Date： 2020/6/10 15:10
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 *@Auther:liuys
 *@Date:2020/6/10 15:10
 *@Description:
 */
@Data
@Accessors(chain = true)
public class TWxNlTempQuery {

    @ApiModelProperty(name = "id",value = "id",dataType = "Integer")
    private Integer id;
}
