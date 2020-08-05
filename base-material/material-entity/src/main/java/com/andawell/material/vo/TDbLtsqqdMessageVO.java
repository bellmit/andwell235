package com.andawell.material.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/***
 * @author hwd
 * @Date: 2020-05-26 09:35
 * @Description: 申请清单信息
 * @version : V1.0
 */
@Data
@ApiModel("显示旅团调拨申请")
public class TDbLtsqqdMessageVO {

    /**
     * 单价
     */
    private BigDecimal dj;


    /**
     * 件号
     */
    private String jh;

    /**
     * 件号名称
     */
    private String jhmc;

    /**
     * 申请数量
     */
    private Integer sqsl;

    /**
     * 更换原因名称
     */
    private String ghyymc;


    /**
     * 更换原因代码
     */
    private String ghyy;

    /**
     * 计量单位
     */
    private String jldwmc;

    /**
     * 机型
     */
    private String jx;

    /**
     * 机型名称
     */
    private String jxmc;




    /**
     * 库存信息
     */
    private List<BursaryVO> bursaryVOs;

}
