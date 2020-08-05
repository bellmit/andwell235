package com.andawell.purchase.enumeration;

import lombok.Getter;

/***
 * @author lhb
 * @Date: 2020/6/2 9:33
 * @Description:
 * @version : V1.0
 */
@Getter
public enum OrderPlanEnum {

    INVALID(1,"草稿"),
    TAKE_EFFECT(2,"生效"),
    DELETE(3,"删除状态");

    private int code;

    private String description;

    OrderPlanEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

}
