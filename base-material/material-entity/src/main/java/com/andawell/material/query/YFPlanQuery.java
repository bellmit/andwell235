package com.andawell.material.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.util.Date;

/***
 * @author hwd
 * @Date: 2020-05-09 17:23
 * @Description:油封计划查询
 * @version : V1.0
 */
@Data
@ApiModel("油封计划查询")
public class YFPlanQuery {
    @ApiParam(value = "质量,全新/可用传入1，待修传入2", name = "zl")
    private String zl;
    @ApiParam(value = "机型", name = "jx")
    private String jx;
    @ApiParam(value = "件号", name = "jh")
    private String jh;
    @ApiParam(value = "开始日期(yyyy-MM-dd)", name = "startDate")
    private String startDate;
    @ApiParam(value = "结束日期(yyyy-MM-dd)", name = "endDate")
    private String endDate;
    @ApiParam(value = "季度", name = "jd")
    private String jd;



























}
