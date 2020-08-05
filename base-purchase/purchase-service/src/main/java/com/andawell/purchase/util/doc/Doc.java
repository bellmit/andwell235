package com.andawell.purchase.util.doc;

import com.andawell.common.util.SQLiteUtils;
import com.andawell.purchase.util.doc.poi.PoiWordUtil;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: yzy
 * @Description:
 * @Date: created in 2020/6/3 9:29
 */
public class Doc {


    /**
     * 创建目标文件以及目标文件夹
     * 生成目标文件
     * 压缩文件
     * 递归删除目标文件夹
     * 下载压缩文件
     * @param list1
     * @param response
     * @throws IOException
     */
    public static void printHT(List<Map<String,Object>> list1, HttpServletResponse response,String backPath) throws IOException {
        // Doc doc = new Doc();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String docPath1 = backPath;
        String parentPath = docPath1+"/"+format.format(new Date());
        System.out.println(parentPath);
        File file = new File(parentPath);
        //最外层文件夹不存在则创建文件夹
        if(!file.exists()){
            file.mkdir();
        }
        for (Map<String, Object> stringObjectMap : list1) {
            //创建父文件夹下的子文件夹
            File CFJCFilePath = new File(parentPath+"/"+stringObjectMap.get("path"));
            //如果子文件夹不存在则创建文件夹
            if(!CFJCFilePath.exists()){
                CFJCFilePath.mkdir();
            }
            //创建目标文件
            File file2 = new File(CFJCFilePath+"/"+stringObjectMap.get("filePath")+".docx");
            Map<String,String> map = new HashMap<>();
            //生成word
            PoiWordUtil.changWord((String)stringObjectMap.get("tempFilepath"), file2.getPath(),
                    (Map<String, String>)stringObjectMap.get("params"),map,
                    (List<Map<String, String>>)stringObjectMap.get("list"));
        }
        //压缩文件
        String zip = CompressUtil.zipFile(new File(parentPath), "zip");
        //删除文件夹
        CompressUtil.deleteDir(parentPath);
        //下载zip
        CompressUtil.download(zip,response);
    }

    /**
     * 获得doc模板路径
     * @param path
     * @return
     */
    public static String getDocPath(String path){
        String abso = SQLiteUtils.class.getResource("/").getPath();
        String replace = abso.substring(1);
        replace = replace.substring(0, 1).toLowerCase() + replace.substring(1);
        return replace+path;
    }
}