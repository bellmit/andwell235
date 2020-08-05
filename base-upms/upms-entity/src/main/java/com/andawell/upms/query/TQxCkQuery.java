package com.andawell.upms.query;/**
 * @Date： 2020/7/2 17:39
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 *@Auther:liuys
 *@Date:2020/7/2 17:39
 *@Description:
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class TQxCkQuery {
    /**
     * null
     */
    @ApiModelProperty( value = "角色id",required = true)
    private String js;

    /**
     * null
     */
    @ApiModelProperty(value = "单位id",required = true)
    private String dwid;

    /**
     * null
     */
    @ApiModelProperty(value = "仓库id",required = true)
    private String ckid;
}
