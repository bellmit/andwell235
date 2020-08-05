package com.andawell.purchase.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:PCJ
 * @Date:2020/6/5
 * @Version:V1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCfVO {

    /**
     * 编码规则： 承制方M+4位代码 维修方R+4位代码 油封方O+4为代码 军代表A+4位代码 军代表小组 军代表+2位代码
     */
    private String id;

    /**
     * 名称
     */
    private String mc;

    /**
     * 简称
     */
    private String jm;

    /**
     * 监管单位
     */
    private String jgdw;

    /**
     * 监管单位名称
     */
    private String jgdwmc;
}
