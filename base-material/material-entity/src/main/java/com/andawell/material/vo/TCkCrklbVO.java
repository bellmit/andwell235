package com.andawell.material.vo;/**
 * @Date： 2020/5/27 16:44
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *@Auther:liuys
 *@Date:2020/5/27 16:44
 *@Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkCrklbVO {
    /**
     * 出入库类别代码
     */
    @ApiModelProperty(value = "出入库类别代码")
    private String id;

    /**
     * 出入库名称
     */
    @ApiModelProperty(value = "出入库名称")
    private String mc;

    /**
     * 出入库简码
     */
    @ApiModelProperty(value = "出入库简码")
    private String jm;

    /**
     * 对于入库  1表示新增一条记录，0表示更新原有记录 对于出库  1表示减少一条记录，0表示更新原有记录
     */
    @ApiModelProperty(value = "对于入库  1表示新增一条记录，0表示更新原有记录 对于出库  1表示减少一条记录，0表示更新原有记录")
    private String xz;
}
