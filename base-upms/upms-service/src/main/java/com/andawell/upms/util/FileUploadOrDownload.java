package com.andawell.upms.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;


/**
 * 文件上传或下载工具类
 * @author  zoucx
 */
@Slf4j
public class FileUploadOrDownload {

    public  String uploadFile(HttpServletRequest request,@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return "文件为空";
            }
            //获取项目的根路径
            String routerPath=request.getContextPath();
            //获取文件路径
            String filePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+routerPath;
            log.info("项目的文件路径:{}", filePath);
            // 获取文件名
            String fileName = file.getOriginalFilename();
            log.info("上传的文件名为：", fileName);
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            log.info("文件的后缀名为：",suffixName);
            // 设置文件存储路径,将上传的文件存放到项目的WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
            String savePath=request.getServletContext().getRealPath("/WEB-INF/upload");
            log.info("文件的保存位置:{}",savePath);
            String path = savePath + fileName;
            File dest = new File(path);
            // 检测是否存在目录
            if (!dest.getParentFile().exists() && !dest.isDirectory()) {
                //递归新建文件夹
                dest.getParentFile().mkdirs();
            }
            // 文件写入
            file.transferTo(dest);
            return filePath+"/static/file/"+fileName;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }
}
