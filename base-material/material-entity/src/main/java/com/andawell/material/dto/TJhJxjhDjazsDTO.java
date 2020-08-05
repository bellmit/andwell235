package com.andawell.material.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * @Date： 2020/5/21 15:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TJhJxjhDjazsDTO {
    /**
     * 机型
     */
    @NotBlank(message = "机型代码不能为空")
    @ApiModelProperty(name = "jx;", value = "机型代码",required = true)
    private String jx;

    /**
     * 件号
     */
    @NotNull(message = "件号代码不能为空")
    @ApiModelProperty(name = "jh;", value = "机型代码",required = true)
    private String jh;

    /**
     * 单机安装数
     **/
    @NotNull(message = "单机安装数不能为空")
    @ApiModelProperty(name = "djazs;", value = "单机安装数",required = true)
    private  Integer djazs;

}
