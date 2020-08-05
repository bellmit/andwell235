package com.andawell.material.vo;/**
 * @Date： 2020/7/1 10:40
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *@Auther:liuys
 *@Date:2020/7/1 10:40
 *@Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TJhJxVO {
    /**
     * 编码规则采用PID+2位代码 默认编码从10开始
     */
    @ApiModelProperty(name = "id", value = "id", dataType = "String")
    private String id;

    /**
     * 机型英文名称
     */
    private String mce;

    /**
     * 机型中文名称
     */
    private String mc;

    /**
     * 机型简码
     */
    private String jm;

    /**
     * 父代码
     */
    private String pid;

    /**
     * 类别
     */
    private String lb;

    /**
     * 数量
     */
    private Integer sl;

    /**
     * 序号指向
     */
    private Integer sgin;

    /**
     * 用于计划生成合同时的合同号组成
     */
    private Integer htbz;
}
