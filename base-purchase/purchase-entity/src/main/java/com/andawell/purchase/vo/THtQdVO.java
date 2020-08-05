package com.andawell.purchase.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
* @ClassName: THtQd
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月04日 下午05:58:22
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class THtQdVO {

    /**
     * 合同编号
     */
    @ApiModelProperty("合同编号")
    private String hth;

    /**
     * 计划编号
     */
    @ApiModelProperty("计划编号")
    private String jhbh;

    /**
     * 机型
     */
    @ApiModelProperty("机型")
    private String jx;

    /**
     * 件号
     */
    @ApiModelProperty("件号")
    private String jh;

    /**
     * 采购目录清单Id
     */
    @ApiModelProperty("采购目录清单Id")
    private Long mlQdid;

    /**
     * 数量
     */
    @ApiModelProperty("采购目录清单Id")
    private Integer sl;

    /**
     * 总价
     */
    @ApiModelProperty("zj")
    private String zj;

    /**
     * 备注
     */
    private String bz;


}