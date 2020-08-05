package com.andawell.upms.dto;


import com.andawell.upms.entity.TQxCk;
import com.andawell.upms.utils.ValidableList;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Date： 2020/5/8 18:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TQxCkDto {

  /*  *//**
     * 权限仓库
     *//*
    @Valid
    @ApiModelProperty(name = "tQxCks;", value = "权限仓库",required = true)
    private ValidableList<TQxCk> tQxCks;*/
    /**
     * null
     */
    @NotBlank(message = "角色id不能为空")
    @ApiModelProperty( value = "角色id",required = true)
    private String js;

    /**
     * null
     */
   /* @NotBlank(message = "单位id不能为空")*/
    @ApiModelProperty(value = "单位id",required = true)
    private String dwid;

    /**
     * null
     */
   /* @NotBlank(message = "仓库id不能为空")*/
    @ApiModelProperty(value = "仓库id",required = true)
    private String ckid;

    @ApiModelProperty(name = "isAll;", value = "是否全部增",required = true)
    private boolean isAll=false;



}
