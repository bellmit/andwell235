package com.andawell.material.util;

import com.github.pagehelper.util.StringUtil;
import com.sun.corba.se.spi.ior.IdentifiableFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.jsoup.select.Evaluator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Slf4j
public class NullUtil {
    public static Integer nulland0(Integer cs) {
        try {
            if (cs != null) {
                return cs;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return 0;
    }

    public static Integer lingandnull(Integer cs) {
        try {
            if (cs == 0) {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return cs;
    }

    public static Long longnull(Long cs) {
        try {
            if (cs != null) {
                return cs;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return Long.valueOf(0);
    }

    public static java.sql.Date dateandnull(java.sql.Date sj) {
        try {
            String s = sj.toString();
            if (StringUtils.isEmpty(s)) {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return sj;
    }

    public static String BigDecimalandInteger(BigDecimal cs) {

        if (cs == null) {
            return "0";
        }
        String str = cs.toString();
        return str;
    }

    public static BigDecimal Stirng2BigDecimal(String cs) {

        if (cs.equals(null)) {
            return null;
        }
        BigDecimal str=new BigDecimal(cs);
        return str;
    }


    public static java.sql.Date date(Date date) {
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
    }

    public static String datetoString(Date date) {
        if (date == null) {
            return null;
        } else {
            return date.toString();
        }
    }
}