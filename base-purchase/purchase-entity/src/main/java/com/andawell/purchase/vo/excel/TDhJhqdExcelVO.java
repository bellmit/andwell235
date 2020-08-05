package com.andawell.purchase.vo.excel;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
* @ClassName: TDhJhqd
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月02日 上午10:38:57
*/
@Data
@AllArgsConstructor
public class TDhJhqdExcelVO {
    /**
     * 订货计划编号
     */
    private String bh;

    /**
     * 机型
     */
    private String jx;

    /**
     * 件号
     */
    private String jh;

    /**
     * 器材类型
     */
    private String qclx;

    /**
     * 申请数量
     */
    private Integer sqsl;

    /**
     * 备注
     */
    private String bz;

    /**
     * 创建时间
     */
    private Date cjrq;

    /**
     * 修改时间
     */
    private Date xgrq;

    /**
     * 0.草稿 1,生效 3，删除
     */
    private Short status;

    /**
     * 关联目录清单Id
     */
    private Long mlQdid;

    /**
     * 订货计划数量
     */
    private Integer dhJhsl;

}