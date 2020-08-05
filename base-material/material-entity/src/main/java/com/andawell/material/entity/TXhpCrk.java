package com.andawell.material.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: TXhpCrk
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月07日 下午02:08:49
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TXhpCrk {
    /**
     * 编号
     */
    private String bh;

    /**
     * 批次号
     */
    private String pch;

    /**
     * 发付单位
     */
    private String ffdw;

    /**
     * 收入单位
     */
    private String srdw;

    /**
     * 出入库类别
     */
    private String lb;

    /**
     * 出入库日期
     */
    private Date rq;

    /**
     * 根据文号
     */
    private String gjwh;

    /**
     * 出入库文号
     */
    private String wh;
}