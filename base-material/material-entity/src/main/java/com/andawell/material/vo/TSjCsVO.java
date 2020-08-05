package com.andawell.material.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: TSjCs
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月10日 下午02:11:49
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TSjCsVO {
    /**
     * null
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 数据表名称
     */
    private String tabalName;

    /**
     * 编号
     */
    private String code;

    /**
     * 数据表描述
     */
    private String remark;
}