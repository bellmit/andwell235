package com.andawell.material.vo;/**
 * @Date： 2020/5/9 11:19
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 *@Auther:shs
 *@Date:2020/7/6 17:19
 *@Description:
 */
@Data
@ApiModel("全新，待修，在修，报废信息")
public class TCkSyVO {
    /**
     *
     *名称
     */
    @ApiModelProperty(name = "mc", value = "名称", dataType = "String")
    private String mc;
    /**
     * 项数
     */
    @ApiModelProperty(name = "xs", value = "项数", dataType = "Integer")
    private Integer xs;
    /**
     * 件数
     */
    @ApiModelProperty(name = "js", value = "件数", dataType = "Integer")
    private Integer js;
    /**
     * 项数
     */
    @ApiModelProperty(name = "dbfxs", value = "项数", dataType = "Integer")
    private Integer dbfxs;
    /**
     * 件数
     */
    @ApiModelProperty(name = "dbfjs", value = "件数", dataType = "Integer")
    private Integer dbfjs;


}

