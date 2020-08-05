package com.andawell.material.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: TTzzWz
 * @Description:
 * @author: Mybatis Generator
 * @date 2020年05月13日 上午11:13:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TTzzWzVO {

    /**
     * 件号
     */
    private String jh;

    /**
     * 名称
     */
    private String mc;

    /**
     * 单位id
     */
    private String dw;

    /**
     * 单位名称
     */
    private String dwmc;

    /**
     * 类别  车辆物资、其他物资
     */
    private String lb;

    /**
     * 类别名称  车辆物资、其他物资
     */
    private String lbmc;
}