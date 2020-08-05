package com.andawell.material.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
* @ClassName: TCkWjk
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月15日 下午03:44:37
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("外借查询")
public class TCkWjkQuery extends PageDto {
    /**
     * 单位代码
     */
    @ApiModelProperty(value = "单位代码")
    private String dwid;

    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间")
    private String startDate;

    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间")
    private String endDate;

    /**
     * 机型
     */
    @ApiModelProperty(value = "机型")
    private String jx;

    /**
     * 件号
     */
    @ApiModelProperty(value = "件号")
    private String jh;

    /**
     * 序号
     */
    @ApiModelProperty(value = "序号")
    private String xh;

    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private String bh;
}