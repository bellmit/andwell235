package com.andawell.upms.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
* @ClassName: TXtCk
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月07日 下午02:34:58
*/
@Data

public class TXtCkDto {
    /**
     * 单位代码
     */
    @NotBlank(message = "单位id不能为空")
    @ApiModelProperty(name = "dwid;", value = "单位id",required = true)
    private String dwid;

    /**
     * 仓库代码
     */
    private String ckid;

    /**
     * 仓库名称
     */
    private String mc;

    /**
     * 仓库类型 0普通;1密集
     */
    private Short lx;
}