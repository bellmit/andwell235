package com.andawell.upms.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel("单位类型查询")
public class TQxDwlxQuery {

    @ApiModelProperty(name = "id", value = "id", dataType = "String")
    private String id;

    @ApiModelProperty(name = "mc", value = "mc", dataType = "String")
    private String mc;

    @ApiModelProperty(name = "jm", value = "jm", dataType = "String")
    private String jm;


}
