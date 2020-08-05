package com.andawell.upms.enumeration;

import com.andawell.common.entity.annotation.Enum;
import com.andawell.common.entity.template.EnumTemplate;

/**
 * 系统公告状态枚举类
 * notRelease:未发布
 * release:发布
 *
 * @author zoucx
 */
@Enum("sysNoticeStatus")
public enum SysNoticeStatus implements EnumTemplate<SysNoticeStatus> {
    notRelease("未发布"),
    release("发布");

    private SysNoticeStatus(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String getName() {
        return name;
    }
}
