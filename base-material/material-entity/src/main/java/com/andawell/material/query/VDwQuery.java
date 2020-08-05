package com.andawell.material.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * @Date： 2020/5/6 18:22
 */
@Data
@Accessors(chain = true)
@ApiModel("单位视图")
@NoArgsConstructor
@AllArgsConstructor
public class VDwQuery extends PageDto {
    @NotBlank(message = "类别不能为空")
    @ApiParam(value = "类别", name = "lb")
    private Integer lb;

    private String rightLikeId;
}
