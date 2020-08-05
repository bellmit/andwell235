package com.andawell.upms.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel("中队查询")
public class TXtZdQuery extends PageDto {

    @ApiModelProperty(name = "dwid", value = "单位id", dataType = "String")
    private String dwid;

    @ApiModelProperty(name = "mc", value = "名称", dataType = "String")
    private String mc;

    @ApiModelProperty(name = "yx", value = "是否有效，0有效，1无效", dataType = "String")
    private String yx;

    @ApiModelProperty(name = "zdid", value = "中队id", dataType = "String")
    private String zdid;
}
