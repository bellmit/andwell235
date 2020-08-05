package com.andawell.material.query;/**
 * @Date： 2020/6/4 9:14
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 *@Auther:liuys
 *@Date:2020/6/4 09:14
 *@Description:
 */
@Data
@Accessors(chain = true)
@ApiModel("")
public class TJhJxJhQuery {
    /**
     * 机型 必须匹配
     */
    @NotBlank(message = "机型不能为空")
    @ApiModelProperty(name = "jx", value = "机型", dataType = "String")
    private String jx;

    /**
     * 件号 必须匹配
     */
    @NotBlank(message = "件号不能为空")
    @ApiModelProperty(name = "jh", value = "件号", dataType = "String")
    private String jh;
}
