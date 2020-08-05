package com.andawell.purchase.enumeration;

import lombok.Getter;

/***
 * @author lhb
 * @Date: 2020/5/6 15:40
 * @Description:
 * @version : V1.0
 */
@Getter
public enum CategoryEnum {

    /**
     * 生效
     */
    TAKE_EFFECT(1,"生效"),
    INVALID(2,"无效"),
    UNDER_REVISION(3,"修订中"),
    DELETE(4,"删除状态");

    private int code;

    private String description;

    CategoryEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }


}
