package com.andawell.upms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: TQxJs
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月13日 下午02:14:26
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TQxJs {
    /**
     * 代码
     */
    private String id;

    /**
     * 角色名称
     */
    private String mc;

    /**
     * 父角色
     */
    private String pid;

    /**
     * 简码
     */
    private String jm;
}