package com.andawell.upms.enumeration;


import com.andawell.common.entity.annotation.Enum;
import com.andawell.common.entity.template.EnumTemplate;


/**
 * 账户状态
 */
@Enum("accountStatus")
public enum AccountStatus implements EnumTemplate<AccountStatus> {
    usable("正常"),
    unusable("停用");

    private AccountStatus(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String getName() {
        return name;
    }
}
