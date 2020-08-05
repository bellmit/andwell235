package com.andawell.material.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/***
 * @author hwd
 * @Date: 2020-05-13 13:21
 * @Description:
 * @version : V1.0
 */
@Data
@ApiModel("油封完成上架")
public class YFCompletedShelvesDTO
{
    @NotBlank(message = "编号不能为空")
    private String bh;

    @NotBlank(message = "单位id不能为空")
    private String dwid;

    @NotBlank(message = "机型不能为空")
    private String jx;

    @NotBlank(message = "机号不能为空")
    private String jh;

    @NotBlank(message = "序号不能为空")
    private String xh;

    @NotBlank(message = "质量不能为空")
    private String zl;

    private String bz;

    private String jwh;

    private String xz="3";
}
