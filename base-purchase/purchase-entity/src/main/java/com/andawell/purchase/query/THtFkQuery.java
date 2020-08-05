package com.andawell.purchase.query;

import com.andawell.common.entity.dto.PageDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:PCJ
 * @Date:2020/6/9
 * @Version:V1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class THtFkQuery extends PageDto {

    /**
     * 入库依据即合同号(2019LHZ9WA-158厂-1)  年度+LH + 机型名称+ 厂家 ，价格类型为暂定价是拼接-1
     */
    private String yj;

    /**
     * 计划编号
     */
    private String jhbh;

    /**
     * 厂家id
     */
    private String cjid;

    /**
     * 厂家名称
     */
    private String cjmc;

    /**
     * 状态
     */
    private Integer status;
}
