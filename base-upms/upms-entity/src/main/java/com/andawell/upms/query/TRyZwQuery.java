package com.andawell.upms.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


/***
 * @author gzh
 * @Date: 2020/5/8 15:54
 * @Description:
 * @version : V1.0
 */
@Data
@Accessors(chain = true)
public class TRyZwQuery extends PageDto {
    /**
     * ID
     */
    @ApiModelProperty(value = "ID", name = "id", dataType = "String")
    private String id;

    /**
     * 名称
     */
    @ApiModelProperty(value = "按名称模糊查询", name = "mc", dataType = "String")
    private String mc;

    /**
     * 简码
     */
    @ApiModelProperty(value = "按简码模糊查询", name = "jm", dataType = "String")
    private String jm;


}
