package com.andawell.material.vo;/**
 * @Date： 2020/6/9 17:31
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *@Auther:liuys
 *@Date:2020/6/9 17:31
 *@Description:
 */
@Data
@NoArgsConstructor
public class TWxNlTempVO {
    /**
     * ID
     */
    @ApiModelProperty(name = "id", value = "ID", dataType = "Integer")
    private Integer id;

    /**
     * 机型
     */
    @ApiModelProperty(name = "jx", value = "机型", dataType = "String")
    private String jx;

    /**
     * 件号
     */
    @ApiModelProperty(name = "jh", value = "件号", dataType = "String")
    private String jh;

}
