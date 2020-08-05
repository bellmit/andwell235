package com.andawell.material.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/***
 * @author hwd
 * @Date: 2020-05-25 10:33
 * @Description: 旅团调拨申请明细
 * @version : V1.0
 */
@Data
@ApiModel("旅团调拨申请明细")
public class AllotAskDetailVO {

    /**
     * 件号
     */
    private String jh;

    /**
     * 加号名称
     */
    private String jhmc;

    /**
     * 申请数量
     */
    private Integer sqsl;

    /**
     * 机型
     */
    private String jx;

    /**
     * 机型名称
     */
    private String jxmc;

    /**
     * 申请原因
     */
    private String ghyy;

    /**
     * 计量单位
     */
    private String jldwmc;



    /**
     * 库房信息
     */
    private List<BursaryVO> bursaryVOS;
}
