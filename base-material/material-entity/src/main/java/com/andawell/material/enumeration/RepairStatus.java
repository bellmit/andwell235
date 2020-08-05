package com.andawell.material.enumeration;

import lombok.Getter;

/***
 * @author lhb
 * @Date: 2020/5/6 15:40
 * @Description:
 * @version : V1.0
 */
@Getter
public enum RepairStatus {
    //维修类型  1.送修 2.报废 3.退修 4.修复
    TO_BE_REPAIR("0","待修"),
    REPAIR("1","送修"),
    SCRAP("2","报废"),
    RETREAT("3","退修"),
    REPAIRED("4","修复");

    private String code;

    private String description;

    RepairStatus(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
