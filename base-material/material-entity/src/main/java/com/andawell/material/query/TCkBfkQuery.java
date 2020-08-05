package com.andawell.material.query;/**
 * @Date： 2020/5/13 13:39
 */

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 *@Auther:liuys
 *@Date:2020/5/13 13:39
 *@Description:
 */
@Data
@Accessors(chain = true)
public class TCkBfkQuery extends PageDto {

    /**
     * 机型 必须匹配
     */
    @NotBlank(message = "机型不能为空")
    @ApiModelProperty(name = "jx", value = "机型", dataType = "String")
    private String jx;

    @ApiModelProperty(name = "startTime", value = "开始时间", dataType = "Data")
    private Data startTime;

    @ApiModelProperty(name = "endTime", value = "结束时间", dataType = "Data")
    private Data endTime;
}
