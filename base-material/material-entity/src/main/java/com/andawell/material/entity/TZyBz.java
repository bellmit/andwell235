package com.andawell.material.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: TZyBz
 * @Description:
 * @author: Mybatis Generator
 * @date 2020年05月20日 下午04:51:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TZyBz {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 机型
     */
    private String jx;

    /**
     * 地域
     */
    private Integer dy;

    /**
     * 任务性质
     */
    private Integer rwxz;

    /**
     * 飞机数
     */
    private Integer fjs;

    /**
     * 任务时长
     */
    private Integer rwsc;

    /**
     * 备注
     */
    private String bz;
}
