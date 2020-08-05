package com.andawell.common.util;/**
 * @Date： 2020/6/4 11:20
 */

/**
 *@Auther:liuys
 *@Date:2020/6/4 11:20
 *@Description:
 */
public enum TableNameStyle  {
    T_DB_LTSQ("T_DB_LTSQ"),
    T_DB_LTSQ_TEMP("T_DB_LTSQ_TEMP"),
    T_DB_LTSQQD("T_DB_LTSQQD"),
    T_DB_LTSQQD_TEMP("T_DB_LTSQQD_TEMP"),
    T_DB_SJSQ("T_DB_SJSQ"),
    T_DB_SJSQQD("T_DB_SJSQQD"),
    T_CK_CK("T_CK_CK"),
    T_CK_DX("T_CK_DX"),
    T_CK_SX("T_CK_SX"),
    T_WX_NL("T_WX_NL"),
    T_WX_NLQD("T_WX_NLQD"),
    ;

    private TableNameStyle(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
