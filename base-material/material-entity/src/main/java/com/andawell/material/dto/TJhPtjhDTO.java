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
public class TJhPtjhDTO {

    /**
     * 主件号
     */
    @NotBlank(message = "主件号不能为空")
    @ApiModelProperty(name = "jh", value = "主件号",required = true)
    private String jh;

    /**
     * 配套件号
     */
    @NotBlank(message = "配套件号不能为空")
    @ApiModelProperty(name = "ptjh", value = "配套件号",required = true)
    private String ptjh;

    /**
     * 机型
     */
    @NotBlank(message = "机型不能为空")
    @ApiModelProperty(name = "jx", value = "机型",required = true)
    private String jx;

    /**
     * 配套数量
     */
    @NotNull(message = "配套数量不能为空")
    @ApiModelProperty(name = "sl", value = "配套数量",required = true)
    private Integer sl;

    /**
     * 日期
     */
    private Date rq;

    /**
     * 备注
     */
    private String bz;

}