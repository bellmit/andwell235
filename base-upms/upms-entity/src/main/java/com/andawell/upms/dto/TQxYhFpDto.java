package com.andawell.upms.dto;


import com.andawell.upms.utils.ValidableList;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Date： 2020/5/8 18:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TQxYhFpDto {

    /**
     * 用户身份id
     */
    @NotNull(message = "用户身份id 集合不能为空")
    @ApiModelProperty(name = "id;", value = "用户身份id",required = true)
    List<String> id;
    /**
     * 角色id
     */

    @ApiModelProperty(name = "js;", value = "js")
    String js;

}
