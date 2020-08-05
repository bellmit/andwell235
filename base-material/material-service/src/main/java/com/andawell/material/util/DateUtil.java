package com.andawell.material.util;/**
 * @Date： 2020/5/20 9:18
 */

import lombok.extern.slf4j.Slf4j;
import org.apache.tools.ant.util.DateUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *@Auther:liuys
 *@Date:2020/5/20 09:18
 *@Description: 获取当前时间
 */
@Slf4j
public class DateUtil {
//    public static Date currentTime() {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        String newDate = format.format(new Date());
//        try {
//            Date parse = format.parse(newDate);
//            return parse;
//        } catch (ParseException e) {
//            e.printStackTrace();
//            log.error(e.getMessage());
//            return null;
//        }
//    }
    public static String currentTime() {
        String format = new SimpleDateFormat("yyy-MM-dd").format(new Date());
        return format;
    }

    public static Date transition(String rq) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            if (rq != null) {
                Date date = simpleDateFormat.parse(rq);
                return date;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return null;
    }
    public static String date2String(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (date!=null){
            return simpleDateFormat.format(date);
        }else{
            return null;
        }
    }

    public static Date switchingTime(Date date)throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        Locale locale=Locale.CHINA;
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, locale);
        return dateFormat.parse(format);
    }
}
