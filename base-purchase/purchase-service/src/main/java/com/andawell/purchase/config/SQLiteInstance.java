package com.andawell.purchase.config;

import com.andawell.common.util.FileUtils;
import com.andawell.common.util.SQLiteUtils;
import com.andawell.common.util.SysUserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * @author lhb
 * @Date: 2020/6/10 15:55
 * @Description:
 * @version : V1.0
 */
@Component
public class SQLiteInstance {


    @Autowired
    SQLLIteConfig sqllIteConfig;

    public static SQLiteUtils sqLiteUtils;


    public static String tempDbFilePath;

    public static SQLiteUtils getInstance(){
        return sqLiteUtils;
    }

    @PostConstruct
    public void setSqLiteUtils() {
        SQLiteUtils.setPath(sqllIteConfig.getPath());
        SQLiteUtils.setClassName(sqllIteConfig.getClassName());
        SQLiteUtils.setJdbcDriver(sqllIteConfig.getJdbcDriver());
        // 初始化绝对路径 db 模板

        // 复制db 用户备份路径
        this.tempDbFilePath = sqllIteConfig.getTempDbFilePath();
        FileUtils.setUpload(sqllIteConfig.getPath());
    }



    // 备份的文件地址，然后拼接商 时间YYYY-MM-DD
    public static String getUserTempPath(String path){
        String userId = SysUserUtils.getUserId();
        String replace =path+ new SimpleDateFormat("yyy-MM-dd").
                format(new Date())
                +"//"+userId+".db";
        return replace;
    }
}
