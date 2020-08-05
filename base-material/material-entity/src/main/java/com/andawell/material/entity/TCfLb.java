package com.andawell.material.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.Transient;

/**
* @ClassName: TCfLb
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月11日 上午09:45:23
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCfLb {
    /**
     * ID
     */
    private String id;

    /**
     * 名称
     */
    private String mc;

    /**
     * 简码
     */
    private String jm;

    /**
     * 父id
     */
    private String pid;
}