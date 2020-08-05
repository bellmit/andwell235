package com.andawell.material.query;


import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class TXtJldwQuery extends PageDto {


    /**
     * ID
     */
    @ApiModelProperty(value = "id", name = "ID", dataType = "String")
    private Short id;

    /**
     * 名称
     */
    @ApiModelProperty(value = "mc", name = "名称", dataType = "String")
    private String mc;

    /**
     * 简码
     */
    @ApiModelProperty(value = "jm", name = "简码", dataType = "String")
    private String jm;
}
