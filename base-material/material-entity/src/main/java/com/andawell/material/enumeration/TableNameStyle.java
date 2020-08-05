package com.andawell.material.enumeration;/**
 * @Date： 2020/6/4 11:20
 */

import com.andawell.common.entity.annotation.Enum;
import com.andawell.common.entity.template.EnumTemplate;

/**
 *@Auther:liuys
 *@Date:2020/6/4 11:20
 *@Description:
 */
@Enum("tableNameStyle")
public enum TableNameStyle implements EnumTemplate<WhleStyle> {
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
    T_SQLite_FFQD("T_SQLite_FFQD"),
    T_SQLite_FF("T_SQLite_FF"),
    T_CF_LB("T_CF_LB"),
    T_CK_CRKLB ("T_CK_CRKLB"),
    T_ZY_DY("T_ZY_DY"),
    T_DB_DBLX("T_DB_DBLX"),
    T_DBZT("T_DBZT"),
    T_CK_FYFS("T_CK_FYFS"),
    T_JH_JXLX("T_JH_JXLX"),
    T_ZY_FJS("T_ZY_FJS"),
    T_CF("T_CF"),
    T_XT_BZLB("T_XT_BZLB"),
    T_JH_JX("T_JH_JX"),
    T_XT_JLDW("T_XT_JLDW"),
    T_JH_JH("T_JH_JH"),
    T_XT_DW("T_XT_DW"),
    T_RY_ZW("T_RY_ZW"),
    T_ZY_RWSC("T_ZY_RWSC"),
    T_ZY_RWXZ("T_ZY_RWXZ"),
    T_JH_WXLX("T_JH_WXLX"),
    T_QX_ZYLB("T_QX_ZYLB"),
    T_SJ_CS("T_SJ_CS")
    ;

    private TableNameStyle(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String getName() {
        return name;
    }
}
