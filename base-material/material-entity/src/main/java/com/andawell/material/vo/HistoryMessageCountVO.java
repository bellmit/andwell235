package com.andawell.material.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.math.BigDecimal;

/***
 * @author hwd
 * @Date: 2020-05-21 09:36
 * @Description:
 * @version : V1.0
 */
@Data
@ApiModel("历史信息统计")
public class HistoryMessageCountVO
{
    private String jx;

    private String jxmc;

    private String jh;

    private String jhmc;

    private String jldw;

    private Long zsl;

    private String zl;

    private String zlmc;

    private String hclb;

    private BigDecimal zj;

    private BigDecimal pjj;


}
