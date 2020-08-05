package com.andawell.upms.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 系统中相关字符串处理的工具类
 * @author zoucx
 */
public class SysStringUtils {
    /**
     * 当前日期+UUID
     * @return
     */
    public static String getUUID(){
        Date date =new Date();
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyyMMdd");
        String uuidStr = simpleDateFormat.format(date)+UUID.randomUUID().toString().replace("-","");
        return uuidStr;
    }

}
