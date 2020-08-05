package com.andawell.material.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.experimental.Accessors;

/***
 * @author gzh
 * @Date: 2020/5/11 17:54
 * @Description:
 * @version : V1.0
 */
@Data
@Accessors(chain = true)
@ApiModel("机型类型查询接口")
public class TJhJxlxQuery extends PageDto {
    /**
     * 编码
     */
    @ApiModelProperty(value = "id", name = "id", dataType = "String")
    private String id;

    /**
     * 种类名称
     */
    @ApiModelProperty(value = "mc", name = "mc", dataType = "String")
    private String mc;

    /**
     * 简码
     */
    @ApiModelProperty(value = "jm", name = "jm", dataType = "String")
    private String jm;
}
