package com.andawell.material.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
* @ClassName: TJhJx
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月06日 下午04:28:25
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TJhJhhhDTO {

    /**
     * 件号
     */
    @NotBlank(message = "件号不能为空")
    @ApiModelProperty(name = "jh", value = "件号",required = true)
    private String jh;

    /**
     * 互换件号
     */
    @NotBlank(message = "互换件号")
    @ApiModelProperty(name = "thjh", value = "互换件号",required = true)
    private String thjh;

    /**
     * 备注
     */
    private String memo;

    /**
     * 机型
     */
    @NotNull(message = "机型不能为空")
    @ApiModelProperty(name = "jx", value = "机型",required = true)
    private String jx;

}