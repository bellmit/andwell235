package com.andawell.material.query;/**
 * @Date： 2020/5/11 15:14
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 *@Auther:liuys
 *@Date:2020/5/11 15:14
 *@Description: 出库类型
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
public class TCkCrklxQuery {
    @ApiModelProperty(value = "id数组，进行多个id查询",name = "ids")
    List<String> ids;
}
