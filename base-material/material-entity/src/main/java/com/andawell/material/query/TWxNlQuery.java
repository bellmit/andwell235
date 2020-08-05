package com.andawell.material.query;/**
 * @Date： 2020/6/9 15:49
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 *@Auther:liuys
 *@Date:2020/6/9 15:49
 *@Description:
 */
@Data
@Accessors(chain = true)
public class TWxNlQuery {
    /**
     * 多个id
     */
    @ApiModelProperty(name = "ids",value = "多个id",dataType = "List")
    private List<Integer> ids;
}
