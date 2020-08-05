package com.andawell.purchase.enumeration;/**
 * @Date： 2020/6/4 11:20
 */

import com.andawell.common.entity.annotation.Enum;
import com.andawell.common.entity.template.EnumTemplate;


/**
 *@Auther:liuys
 *@Date:2020/6/4 11:20
 *@Description:
 */

public enum SqlLiteTableNameEnum {
    T_HT("T_HT","合同"),
    T_HT_QD("T_HT_QD","合同清单"),
    T_HT_DH("T_HT_DH","合同订货"),
    T_HT_DHQD("T_HT_DHQD","合同订货清单"),
    T_CK_CRK("T_CK_CRK","合同入库单"),
    T_CK_CRKQD("T_CK_CRKQD","合同入库单明细");;

    SqlLiteTableNameEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    private String code;

    private String name;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
