package com.andawell.material.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: TZyBzmx
 * @Description:
 * @author: Mybatis Generator
 * @date 2020年05月20日 下午05:00:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TZyBzmx {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 件号
     */
    private String jh;

    /**
     * 质量
     */
    private Integer zl;

    /**
     * 数量
     */
    private Integer sl;

    /**
     * 备注
     */
    private String bz;
}
