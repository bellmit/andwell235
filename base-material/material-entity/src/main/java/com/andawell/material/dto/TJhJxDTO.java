package com.andawell.material.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Date： 2020/5/6 18:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TJhJxDTO {
    /**
     * 编码规则采用PID+2位代码 默认编码从10开始
     */
    @ApiModelProperty(name = "id", value = "机型代码")
    private String id;

    /**
     * 机型英文名称
     */
    private String mce;

    /**
     * 机型中文名称
     */
    @NotBlank(message = "名称不能为空")
    @ApiModelProperty(name = "mc", value = "名称",required = true)
    private String mc;

    /**
     * 机型简码
     */
    @NotBlank(message = "简码不能为空")
    @ApiModelProperty(name = "jm", value = "简码",required = true)
    private String jm;

    /**
     * 父代码
     */
    private String pid;

    /**
     * 类别
     */
    private String lb;

    /**
     * 数量
     */
    private Integer sl;

    /**
     * 序号指向
     */
    private Integer sgin;

}
