package com.andawell.material.dto;

import com.andawell.material.entity.TXhpCrkqd;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

/**
* @ClassName: TCkCrk
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月06日 下午04:28:25
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkCrksDTO {
    /**
     * 入库编号
     */
    @NotBlank(message = "编号不能为NULL")
    @ApiModelProperty(name = "bh", value = "编号不能为空",required = true)
    private String bh;
}