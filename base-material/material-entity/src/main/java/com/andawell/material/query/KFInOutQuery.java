package com.andawell.material.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/***
 * @author hwd
 * @Date: 2020-05-26 14:25
 * @Description:
 * @version : V1.0
 */
@Data
@ApiModel("库房出入库")
public class KFInOutQuery {
    /**
     * 查询日期
     */
    @ApiModelProperty(value = "查询日期 yyyy-mm")
    private String queryDate;

    /**
     * 季度
     */
    @ApiModelProperty(value = "季度")
    private String jd;

    /**
     * 开始日期
     */
    @ApiModelProperty(value = "开始日期 yyyy-mm-dd")
    private String startDate;

    /**
     * 结束日期
     */
    @ApiModelProperty(value = "结束日期 yyyy-mm-dd")
    private String endDate;

    /**
     * 出入库类别
     */
    @ApiModelProperty(value = "出入库类别")
    private String crklb;

}
