package com.andawell.purchase.query;

import com.andawell.common.entity.dto.PageDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author:PCJ
 * @Date:2020/6/4
 * @Version:V1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class THtQuery extends PageDto {
    /**
     * 合同号(2019LHZ9WA-158厂-1)  年度+LH + 机型名称+ 厂家 ，价格类型为暂定价是拼接-1
     */
    private String hth;

    /**
     * 计划编号
     */
    private String jhbh;

    /**
     * 机型
     */
    private String jx;

    /**
     * 价格类型
     */
    private String jglx;

    /**
     * 签订地点
     */
    private String qddd;

    /**
     * 签订日期
     */
    private Date qdrq;

    /**
     * 采购方Id
     */
    private String cgfid;

    /**
     * 厂家ID
     */
    private String cjid;

    /**
     * 监管方ID
     */
    private String jgfid;

    /**
     * 定价依据
     */
    private String dlyj;

    /**
     * 运输方式
     */
    private String ysfs;

    /**
     * 总价
     */
    private String zj;

    /**
     * 创建日期
     */
    private Date cjrq;

    /**
     * 修改日期
     */
    private Date xgrq;

    /**
     * 当年年度开始时间
     */
    private Date startTime;

    /**
     * 次年年度开始时间
     */
    private Date endTime;
}
