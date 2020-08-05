package com.andawell.upms.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


/***
 * @author gzh
 * @Date: 2020/5/13 9:54
 * @Description:
 * @version : V1.0
 */
@Data
@Accessors(chain = true)
public class TQxJsqxQuery extends PageDto {
    /**
     * 角色代码
     */
    @ApiModelProperty(value = "js", name = "js", dataType = "String")
    private String js;

    /**
     * 资源代码
     */
    @ApiModelProperty(value = "zy", name = "zy", dataType = "String")
    private String zy;

    /**
     * 有权限
     */
    @ApiModelProperty(value = "qx", name = "qx", dataType = "String")
    private String qx;


}
