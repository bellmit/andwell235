package com.andawell.material.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/***
 * @author hwd
 * @Date: 2020-06-04 12:24
 * @Description:
 * @version : V1.0
 */
@Data
@Accessors(chain = true)
public class TSjSqQuery extends PageDto {

    /**
     * 机型
     */
    @ApiModelProperty(value = "机型", name = "jx", dataType = "String")
    private String jx;
    /**
     * 发付单位
     */
    @ApiModelProperty(value = "发付单位", name = "ffdw", dataType = "String")
    private String ffdw;
}
