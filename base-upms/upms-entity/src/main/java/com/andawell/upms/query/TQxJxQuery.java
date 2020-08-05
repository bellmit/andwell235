package com.andawell.upms.query;/**
 * @Date： 2020/7/1 13:30
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 *@Auther:liuys
 *@Date:2020/7/1 13:30
 *@Description:
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class TQxJxQuery {
    /**
     * 角色id
     */
    @ApiModelProperty( value = "角色id",required = true)
    private String js;

    /**
     * 机型id
     */
    @ApiModelProperty( value = "机型id",required = true)
    private String jx;
}
