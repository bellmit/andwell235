package com.andawell.material.dto;

import com.andawell.material.utils.ValidableList;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/***
 * @author hwd
 * @Date: 2020-05-29 09:43
 * @Description:
 * @version : V1.0
 */
@Data
@ApiModel("向上申请")
public class TDbsjSqDTO {

    @NotNull(message = "机型不能为空")
    @ApiModelProperty(value = "机型",required = true)
    private String jx;


    @Valid
    private ValidableList<TDbSjsqQdDTO> tDbSjsqQdDTOS;


}
