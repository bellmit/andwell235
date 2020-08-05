package com.andawell.material.entity;

import com.andawell.material.utils.CustomDateDeserialize;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.TypeCache;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
* @ClassName: TDbLtsq
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月13日 上午10:02:57
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TDbLtsq implements Serializable {
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
     * 申请类别
     */
    private Integer sqlb;

    /**
     * 项数
     */
    private Integer xs;

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
     * 数据处理
     */
    private Integer datacl;

    /**
     * 接收单位
     */
    private String jsdw;

    /**
     * 接收人
     */
    private String jsr;

    /**
     * 联系电话
     */
    private String lxdh;

    /**
     * 上传状态
     */
    private String sczt ;

    /**
     * 处理状态
     */
    private String clzt;
}