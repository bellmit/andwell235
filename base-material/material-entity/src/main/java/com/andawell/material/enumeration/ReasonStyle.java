package com.andawell.material.enumeration;/**
 * @Date： 2020/5/29 14:13
 */

import lombok.Getter;

/**
 *@Auther:liuys
 *@Date:2020/5/29 14:13
 *@Description:
 */
@Getter
public enum ReasonStyle {
    DEFECT("S1","缺件"),
    REPLACE("S2","定检更换"),
    FAULT("S3","故障更换")
    ;

    private String code;

    private String description;

    ReasonStyle(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
