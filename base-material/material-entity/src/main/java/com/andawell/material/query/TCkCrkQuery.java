package com.andawell.material.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
* @ClassName: TCkCrk
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月06日 下午04:28:25
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkCrkQuery extends PageDto {

    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private String bh;

    /**
     * 单位ID
     */
    @ApiModelProperty(value = "单位ID")
    private String dwid;

    /**
     * 文号
     */
    @ApiModelProperty(value = "文号")
    private String wh;

    /**
     * 机型
     */
    @ApiModelProperty(value = "jx")
    private String jx;

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



}