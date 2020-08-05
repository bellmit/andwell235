package com.andawell.material.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
* @ClassName: TTzzCrk
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月15日 上午10:53:28
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TTzzCrk {
    /**
     * 编号
     */
    private String bh;

    /**
     * 发付单位
     */
    private String ffdw;

    /**
     * 接收单位
     */
    private String jsdw;

    /**
     * 日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date rq;

    /**
     * 文号
     */
    private String wh;

    /**
     * 依据
     */
    private String yj;

    /**
     * 发付人
     */
    private String ffr;

    /**
     * 接收人
     */
    private String jsr;

    /**
     * 运输方式
     */
    private String ysfs;

    /**
     * 出入库类别
     */
    private String crklb;
}