package com.andawell.material.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.swing.*;
import javax.validation.constraints.NotBlank;

/***
 * @author lhb
 * @Date: 2020/4/26 17:26
 * @Description:
 * @version : V1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkSxQuery {

    /**
     * 送修单位Id
     */
    @NotBlank(message = "送修单位Id不能为空")
    @ApiModelProperty(name = "dwid", value = "送修单位Id")
    private String dwid;

    /**
     * 机型Id
     */
    @NotBlank(message = "机型Id不能为空")
    @ApiModelProperty(name = "jx", value = "机型Id")
    private String jx;

    /**
     * 件号
     */
    @ApiModelProperty(name = "jh", value = "件号")
    private String jh;

    /**
     * 选择
     */
    @ApiModelProperty(name = "xz", value = "选择")
    private String xz;

    /**
     * 质量
     */
    @ApiModelProperty(name = "zl", value = "质量")
    private String zl;

}
