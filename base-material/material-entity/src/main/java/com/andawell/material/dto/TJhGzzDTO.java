package com.andawell.material.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TJhGzzDTO {
    /**
     * 件号ID
     */
    @NotBlank(message = "件号不能为空")
    @ApiModelProperty(name = "jh", value = "件号",required = true)
    private String jh;

    /**
     * 机型ID
     */
    @NotBlank(message = "机型不能为空")
    @ApiModelProperty(name = "jx", value = "机型",required = true)
    private String jx;

    /**
     * 用户编号
     */
    private String yhid;

    /**
     * 关注类型  1：机关；2：旅团
     */
    private Short lx;
    /**
     * 单位
     */
    private String dw;

    /**
     * 名称
     */
    private String mc;

    /**
     * 资源名称
     */
    private String zylx;
}
