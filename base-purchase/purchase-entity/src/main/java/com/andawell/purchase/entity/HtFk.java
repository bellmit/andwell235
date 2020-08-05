package com.andawell.purchase.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: HtFk
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月08日 下午04:37:24
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HtFk {
    /**
     * 合同号
     */
    private String hth;

    /**
     * 付款编号
     */
    private String fkbh;

    /**
     * 货款价格
     */
    private String hkjg;

    /**
     * 付款日期
     */
    private Date fkrq;

    /**
     * 运保单位
     */
    private String ybdl;

    /**
     * 备注
     */
    private String bz;
}