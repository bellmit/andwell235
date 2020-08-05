package com.andawell.material.vo;/**
 * @Date： 2020/5/11 15:16
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *@Auther:liuys
 *@Date:2020/5/11 15:16
 *@Description: 出库类别参数
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkCrklxVO {
    /**
     * 出入库类型代码
     */
    @ApiModelProperty(value = "出入库类型代码", name = "id", dataType = "String")
    private String id;

    /**
     * 出入库名称
     */
    @ApiModelProperty(value = "出入库名称", name = "mc", dataType = "String")
    private String mc;

    /**
     * 出入库简码
     */
    @ApiModelProperty(value = "出入库简码", name = "jm", dataType = "String")
    private String jm;

    /**
     * 出入库简码
     */
    @ApiModelProperty(value = "出库类型子级", name = "list", dataType = "list")
    private List<TCkCrklxVO> list;
}