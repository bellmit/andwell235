package com.andawell.upms.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel("仓库查询")
public class TXtCkQuery extends PageDto {

    @ApiModelProperty(name = "dwid", value = "dwid", dataType = "String")
    private String dwid;

    @ApiModelProperty(name = "ckid", value = "ckid", dataType = "String")
    private String ckid;

    @ApiModelProperty(name = "mc", value = "mc", dataType = "String")
    private String mc;

    @ApiModelProperty(name = "lx", value = "lx", dataType = "short")
    private short lx;
}
