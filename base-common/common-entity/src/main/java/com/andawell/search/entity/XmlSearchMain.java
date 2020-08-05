package com.andawell.search.entity;

import com.andawell.common.entity.dto.CommonEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("xml查询功能主表")
public class XmlSearchMain extends CommonEntityDto {
    @ApiModelProperty(value = "主键", name = "id", dataType = "String")
    private String id;
    @ApiModelProperty(value = "表名", name = "tableName", dataType = "String")
    private String tableName;
    @ApiModelProperty(value = "xml内容", name = "content", dataType = "String")
    private String content;
    @ApiModelProperty(value = "备注", name = "remarks", dataType = "String")
    private String remarks;
}
