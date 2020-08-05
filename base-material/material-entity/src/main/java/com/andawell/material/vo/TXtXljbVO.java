package com.andawell.material.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date： 2020/5/3 15:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TXtXljbVO {
    /**
     * null
     */

    @ApiModelProperty(value = "id", name = "id")
    private Integer id;

    /**
     * null
     */
    @ApiModelProperty(value = "mc", name = "维修类别名称")
    private String mc;
}
