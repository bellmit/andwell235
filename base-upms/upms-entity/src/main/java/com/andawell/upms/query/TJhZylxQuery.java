package com.andawell.upms.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author:PCJ
 * @Date:2020/5/11
 * @Version:V1.0.0
 */
@Data
@Accessors(chain = true)
@ApiModel("专业类型查询")
public class TJhZylxQuery {

    @ApiModelProperty(name = "id", value = "id", dataType = "String")
    private String id;

    @ApiModelProperty(name = "mc", value = "mc", dataType = "String")
    private String mc;

    @ApiModelProperty(name = "jm", value = "jm", dataType = "String")
    private String jm;
}
