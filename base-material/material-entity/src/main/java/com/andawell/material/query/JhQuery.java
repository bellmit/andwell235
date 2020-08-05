package com.andawell.material.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/***
 * @author hwd
 * @Date: 2020-05-27 10:41
 * @Description:
 * @version : V1.0
 */
@Data
@Accessors(chain = true)
@ApiModel("件号儿查询")
public class JhQuery extends PageDto {
    @ApiModelProperty(name = "jx", value = "jx", dataType = "String")
    private String jx;
}
