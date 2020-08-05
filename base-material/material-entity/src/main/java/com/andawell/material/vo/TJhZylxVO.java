package com.andawell.material.vo;/**
 * @Date： 2020/5/11 15:16
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *@Auther:liuys
 *@Date:2020/5/11 15:16
 *@Description:
 */
@Data
@NoArgsConstructor
public class TJhZylxVO {
    /**
     * ID
     */
    @ApiModelProperty(value = "ID", name = "id", dataType = "String")
    private String id;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称", name = "mc", dataType = "String")
    private String mc;

    /**
     * 简码
     */
    @ApiModelProperty(value = "简码", name = "jm", dataType = "String")
    private String jm;
}
