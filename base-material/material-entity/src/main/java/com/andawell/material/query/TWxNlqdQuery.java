package com.andawell.material.query;/**
 * @Date： 2020/6/10 16:01
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 *@Auther:liuys
 *@Date:2020/6/10 16:01
 *@Description:
 */
@Data
@Accessors(chain = true)
public class TWxNlqdQuery {
    /**
     * 多个id
     */
    @ApiModelProperty(name = "pid",value = "pid",dataType = "Integer")
    private Integer pid;

    @ApiModelProperty(name = "厂商id",value = "厂商id",dataType = "String")
    private String cfid;
}
