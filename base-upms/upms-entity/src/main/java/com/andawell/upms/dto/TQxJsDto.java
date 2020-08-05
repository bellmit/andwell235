package com.andawell.upms.dto;


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
public class TQxJsDto {

    /**
     * 角色代码
     */
    private String id;

    /**
     * 角色名称
     */
    @NotBlank(message = "角色名称不能为空")
    @ApiModelProperty(value = "mc", name = "mc", dataType = "String",required = true)
    private String mc;

    /**
     * 父角色
     */
    @NotNull(message = "父角色不能为空")
    @ApiModelProperty(value = "pid", name = "pid", dataType = "String")
    private String pid;

    /**
     * 简码
     */
    @ApiModelProperty(value = "jm", name = "jm", dataType = "String")
    private String jm;

}
