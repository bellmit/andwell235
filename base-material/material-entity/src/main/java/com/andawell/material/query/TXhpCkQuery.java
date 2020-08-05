package com.andawell.material.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TXhpCkQuery {
    @ApiModelProperty(name = "mc",value = "名称",dataType = "String")
    private String mc;
    @ApiModelProperty(name = "gg",value = "规格",dataType = "String")
    private String gg;
}
