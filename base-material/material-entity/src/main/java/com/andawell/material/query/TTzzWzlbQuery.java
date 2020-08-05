package com.andawell.material.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author:PCJ
 * @Date:2020/5/15
 * @Version:V1.0.0
 */
@Data
@Accessors(chain = true)
@ApiModel("通专装物资类别查询")
public class TTzzWzlbQuery extends PageDto {
    /**
     * null
     */
    @ApiModelProperty(name = "id", value = "id", dataType = "String")
    private String id;

    /**
     * 父ID
     */
    @ApiModelProperty(name = "pid", value = "pid", dataType = "String")
    private String pid;

    /**
     * 名称
     */
    @ApiModelProperty(name = "mc", value = "mc", dataType = "String")
    private String mc;

    /**
     * null
     */
    @ApiModelProperty(name = "jm", value = "jm", dataType = "String")
    private String jm;
}
