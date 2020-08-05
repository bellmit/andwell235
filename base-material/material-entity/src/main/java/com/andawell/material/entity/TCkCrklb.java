package com.andawell.material.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: TCkCrklb
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月06日 下午04:28:25
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkCrklb {
    /**
     * 出入库类别代码
     */
    private String id;

    /**
     * 出入库名称
     */
    private String mc;

    /**
     * 出入库简码
     */
    private String jm;

    /**
     * 对于入库  1表示新增一条记录，0表示更新原有记录 对于出库  1表示减少一条记录，0表示更新原有记录
     */
    private String xz;

    /**
     * 上级代码
     */
    private String pid;
}