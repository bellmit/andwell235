package com.andawell.material.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * @Date： 2020/5/6 17:11
 */
@Data
@Accessors(chain = true)
@ApiModel("交旧单位")
public class TXtZdQuery extends PageDto {
    @NotBlank(message = "单位id不能为空")
    @ApiParam(value = "单位id", name = "dwid")
    private Integer dwid;
}
