package com.andawell.purchase.enumeration;

import lombok.Getter;

/**
 * @Author:PCJ
 * @Date:2020/6/2
 * @Version:V1.0.0
 */
@Getter
public enum  DhJhStatusEnum {

    /**
     * 生效
     */
    TAKE_EFFECT(0,"草稿"),
    INVALID(1,"生效"),
    DELETE(3,"删除状态"),
    HANDLED(4,"已处理生成合同");

    private int code;

    private String description;

    DhJhStatusEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }
}
