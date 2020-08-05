package com.andawell.material.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/***
 * @author lhb
 * @Date: 2020/7/7 15:23
 * @Description:
 * @version : V1.0
 */
@Data
@ApiModel("统计dome")
public class StatisticsDomeVO {

    private String jx;

    private String jh;

    private String dwid;

    private Integer  sl;

}
