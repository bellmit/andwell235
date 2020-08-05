package com.andawell.material.enumeration;

import com.andawell.common.entity.annotation.Enum;
import com.andawell.common.entity.template.EnumTemplate;
import lombok.*;

/**
 * @Date： 2020/5/6 18:29
 */
@Getter
//@Enum("companyStyle")
public enum CompanyStyle{
    MILITARY_UNIT(4,"军方单位");

    private int code;

    private String description;

    CompanyStyle(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
}
