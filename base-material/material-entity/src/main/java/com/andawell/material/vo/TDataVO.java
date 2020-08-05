package com.andawell.material.vo;/**
 * @Date： 2020/5/13 13:59
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Auther:shs
 * @Date:2020/5/13 13:59
 * @Description:
 */
@Data
@ApiModel("报废信息")
public class TDataVO {

    /**
     * 单位id
     */
    @ApiModelProperty(value = "单位id", name = "dwid", dataType = "String")
    private List<TDataStateVO> dwmc;

    /**
     * 库存信息状态
     */
    @ApiModelProperty(value = "库存信息状态", name = "ckck", dataType = "String")
    private Boolean T_CK_CK;

    /**
     * 库存送修状态
     */
    @ApiModelProperty(value = "库存送修状态", name = "cksx", dataType = "String")
    private Boolean T_CK_SX;

    /**
     * 库存待修状态
     */
    @ApiModelProperty(value = "库存待修状态", name = "ckdx", dataType = "String")
    private Boolean T_CK_DX;


}

