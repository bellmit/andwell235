package com.andawell.material.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @Date： 2020/4/28 16:59
 */
@Data
@Accessors(chain = true)
@ApiModel("合同详细列表")
public class THtDhQuery extends PageDto {

    /**
     * 机型
     */
    @NotBlank(message = "机型不能为空")
    @NonNull
    @ApiModelProperty(name = "jx", value = "机型", dataType = "String")
    private String jx;
}
