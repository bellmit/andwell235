package com.andawell.material.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TJhGzVO {
    /**
     * 件号
     */
    private String jh;

    /**
     * 机型
     */
    private String jx;

    /**
     * 单位
     */
    private String dw;

    /**
     * 名称
     */
    private String mc;

    /**
     * 资源名称
     */
    private String zylx;
    /**
     * 用户编号
     */
    private String yhid;

    /**
     * 关注类型  1：机关；2：旅团
     */
    private Integer lx;
}
