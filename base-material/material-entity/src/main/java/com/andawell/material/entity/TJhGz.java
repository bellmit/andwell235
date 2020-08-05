package com.andawell.material.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: TJhGz
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月18日 下午04:47:53
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TJhGz {
    /**
     * 件号ID
     */
    private String jh;

    /**
     * 机型ID
     */
    private String jx;

    /**
     * 用户编号
     */
    private String yhid;

    /**
     * 关注类型  1：机关；2：旅团
     */
    private Integer lx;
}