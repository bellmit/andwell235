package com.andawell.upms.dto;


import com.andawell.upms.utils.ValidableList;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/***
 * @author gzh
 * @Date: 2020/5/13 14:36
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TQxJsqxDto {

    /**
     * 角色代码
     */
    @NotBlank(message = "角色代码不能为空")
    @ApiModelProperty(value = "js", name = "js", dataType = "String",required = true)
    private String js;

    /**
     * 资源代码
     */
    @NotNull(message = "资源代码不能为空")
    @ApiModelProperty(value = "zy", name = "zy", dataType = "String",required = true)
    private List<String> zy;

    /**
     * 有权限
     */
    @ApiModelProperty(value = "qx", name = "qx", dataType = "String")
    private String qx;

}
