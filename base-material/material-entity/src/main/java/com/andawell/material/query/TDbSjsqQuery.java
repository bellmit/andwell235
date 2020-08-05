package com.andawell.material.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: zje
 * @date: 2020/6/4
 * @description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TDbSjsqQuery {
    /**
     * 申请单号
     */
    private String sqdh;
}
