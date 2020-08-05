package com.andawell.material.enumeration;

import lombok.Getter;

/***
 * @author lhb
 * @Date: 2020/5/4 13:43
 * @Description:
 * @version : V1.0
 */
@Getter
public enum MaterialCategory {

    TURNOVER(1,"周转器材"),
    WAR_PREPAREDNESS(2,"战备器材");

    private int code;

    private String description;

    MaterialCategory(int code, String description) {
        this.code = code;
        this.description = description;
    }
}
