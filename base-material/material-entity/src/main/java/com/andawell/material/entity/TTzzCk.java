package com.andawell.material.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
* @ClassName: TTzzCk
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月15日 上午10:11:18
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TTzzCk {
    /**
     * 件号
     */
    private String jh;

    /**
     * 序号
     */
    private String xh;

    /**
     * 数量
     */
    private Integer sl;

    /**
     * 单价
     */
    private BigDecimal dj;

    /**
     * 总价
     */
    private BigDecimal zj;

    /**
     * 出厂日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date ccrq;

    /**
     * 入库日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date rkrq;

    /**
     * 车架号
     */
    private String cjh;

    /**
     * 发动机号
     */
    private String fdjh;

    /**
     * 仓库号
     */
    private String ckdm;

    /**
     * 架位号
     */
    private String jwh;

    /**
     * 备注
     */
    private String bz;

    /**
     * 单位代码
     */
    private String dwid;
}