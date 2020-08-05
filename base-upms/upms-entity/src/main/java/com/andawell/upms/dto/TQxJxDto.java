package com.andawell.upms.dto;


import com.andawell.upms.entity.TQxCk;
import com.andawell.upms.entity.TQxJx;
import com.andawell.upms.utils.ValidableList;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

/**
 * @Date： 2020/5/8 18:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TQxJxDto {

    /**
     * 权限机型
     */
    @Valid
    @ApiModelProperty(name = "tQxCks;", value = "权限机型",required = true)
    private ValidableList<TQxJx> tQxJxs;



}
