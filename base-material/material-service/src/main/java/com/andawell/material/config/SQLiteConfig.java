package com.andawell.material.config;

import com.andawell.common.util.FileUtils;
import com.andawell.common.util.SQLiteUtils;
import com.andawell.common.util.SysUserUtils;
import com.andawell.material.util.DateUtil;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/***
 * @author lhb
 * @Date: 2020/6/10 15:55
 * @Description:
 * @version : V1.0
 */
@Data
@Component
public class SQLiteConfig {

    private static String className;
    private static String jdbcDriver;
    private static String path;
    private static String upload;

    static {
        ClassLoader classLoader = SQLiteUtils.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("sqlite.properties");
        Properties props = new Properties();
        try {
            props.load(in);
            className = props.getProperty("className");
            jdbcDriver = props.getProperty("jdbcDriver");
            path = props.getProperty("path");
            upload = props.getProperty("upload");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static SQLiteUtils sqLiteUtils;


    public static SQLiteUtils getInstance(){
        return sqLiteUtils;
    }

    @PostConstruct
    public void setSqLiteUtils() {
        SQLiteConfig.sqLiteUtils = new SQLiteUtils(
                className,
                jdbcDriver);
    }


    /**
     *@Author: liuys
     *@Data: 2020/6/15
     *@Description: 获取用db的路径
     */
    public static String getPath(){
        String userId = SysUserUtils.getUserId();
        String replace =upload+ DateUtil.currentTime()+"//"+userId+".db";
        return replace;
    }

    /**
     *@Author: liuys
     *@Data: 2020/6/15
     *@Description: 获取项目中的db文件路径
     */
    public static String getDbPath(){
        String abso = SQLiteUtils.class.getResource("/").getPath();
        String replace = abso.substring(1);
        replace = replace.substring(0, 1).toLowerCase() + replace.substring(1);
        // 目标DB
        File file = new File(replace + path);
        return file!=null?file.getAbsolutePath():null;
    }

    /**
     *@Author: liuys
     *@Data: 2020/6/16
     *@Description: 初始化参数
     */
    public static void initial(){
        //目中的db文件路径
        FileUtils.setPath(getDbPath());
        //上传文件的路径
        FileUtils.setUpload(getPath());
        //db连接的路劲
        SQLiteUtils.setPath(getPath());
    }


}
