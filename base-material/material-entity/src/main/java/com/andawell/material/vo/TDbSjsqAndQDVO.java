package com.andawell.material.vo;

import com.andawell.material.entity.TDbSjsqqd;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;
import java.util.List;

/***
 * @author hwd
 * @Date: 2020-06-18 09:36
 * @Description:
 * @version : V1.0
 */
@Data
@ApiModel("上级申请清单")
public class TDbSjsqAndQDVO {

    /**
     * 申请单号
     */
    private String sqdh;

    /**
     * 调拨单号
     */
    private String dbdh;

    /**
     * 机型
     */
    private String jx;

    /**
     * 处理状态0：未处理；1：以处理；
     */
    private String clzt;

    /**
     * 申请人
     */
    private String sqr;

    /**
     * 日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date rq;

    /**
     * 调拨编号
     */
    private Integer dbbh;

    /**
     * 申请单位
     */
    private String sqdw;

    /**
     * 下发状态0：未下发；1：以下发；
     */
    private String xfzt;

    /**
     * 调拨类型
     */
    private String dblx;

    /**
     * 上传状态
     */
    private String sczt;


    List<TDbSjsqqd> tDbSjsqqds;

}
