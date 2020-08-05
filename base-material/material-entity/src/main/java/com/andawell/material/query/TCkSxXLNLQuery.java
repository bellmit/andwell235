package com.andawell.material.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/***
 * @author yzy
 * @Description:
 * @version : V1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkSxXLNLQuery extends PageDto {

    /**
     * 机型Id
     */
    @ApiModelProperty(name = "jx", value = "机型Id")
    private String jx;

    /**
     * 件号
     */
    @ApiModelProperty(name = "jh", value = "件号")
    private String jh;


}
