package com.andawell.material.vo;

import com.andawell.material.entity.TDbDbqd;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;
import java.util.List;

/***
 * @author hwd
 * @Date: 2020-05-26 09:26
 * @Description:旅团调拨申请
 * @version : V1.0
 */
@Data
@ApiModel("显示旅团调拨申请")
public class TDbLtsqMessageVO {

    /**
     * 申请单号
     */
    private String ltsqdh;

    /**
     * 申请单位
     */
    private String sqdw;

    /**
     * 机型
     */
    private String jx;


    /**
     * 年度
     */
    private Integer nd;

    /**
     * 季度
     */
    private Integer jd;

    /**
     * 日期
     */
    private Date rq;

    /**
     * 申请人
     */
    private String sqr;

    /**
     * 接收人
     */
    private String jsr;

    /**
     * 联系电话
     */
    private String lxdh;


    /**
     * 质量  写死11
     */
    private String zl;



}
