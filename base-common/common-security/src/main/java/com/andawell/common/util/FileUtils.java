package com.andawell.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.util.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/***
 * @author hwd
 * @Date: 2020-06-03 09:05
 * @Description:
 * @version : V1.0
 */
@Slf4j
public class FileUtils {

    private static String path;

    private static String upload;

    public static void setPath(String path) {
        FileUtils.path = path;
    }

    public static void setUpload(String upload) {
        FileUtils.upload = upload;
    }

    /**
     * 获取今天的文件
     * @param filepath
     * @return
     */
    public static String getNewFile(String filepath) {
        String format = new SimpleDateFormat("yyy-MM-dd").format(new Date());
        File path = new File(filepath+format);
        if(path!=null) {
            //列出该目录下所有文件夹
            File[] files = path.listFiles();
            List<File> collect = Arrays.stream(files).filter((q) -> {
                return q.getName().equals(SysUserUtils.getUser().getDeptId() + ".db");
            }).collect(Collectors.toList());
            return files.length>0?collect.get(0).getAbsolutePath():null;
        }
        return null;
    }


    public static Boolean copy(InputStream is,String newPath){
        try {
            File newFile = new File(newPath);
            // 如果文件夹上级目录不存在创建
            File parentFile = newFile.getParentFile();
            if(!parentFile.exists())
            {
                parentFile.mkdirs();
            }
            // 如果文件不存在创建
            if(!newFile.exists())
                newFile.createNewFile();
            if(!newFile.exists())
                newFile.mkdirs();
            //  BufferedInputStream is = new BufferedInputStream(new FileInputStream(new File(dbPath)));
            BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(newFile));
            IOUtils.copy(is,os);
            IOUtils.closeQuietly(os);
            IOUtils.closeQuietly(is);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            throw new BusinessException("复制异常");
        }
    }

    public static String getHistoryNewFile(String filepath)
    {
        File file = new File(filepath);
        File[] files = file.listFiles();
        Arrays.sort(files,(f1,f2)->{
            return (int)(convertDate(f2.getName())-convertDate(f1.getName()));
        });
        if(files.length>0)
        {
            File[] files1 = new File(filepath + files[0].getName()).listFiles();
            return files1.length>0?files1[0].getAbsolutePath():null;
        }else
        {
            return null;
        }
    }


    /**
     * 转换日期
     * @param date
     * @return
     */
    public static Long convertDate(String date) {
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            return parse.getTime();

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static File getNewSqlist() {
        String abso=FileUtils.class.getResource("/").getPath();
        String replace = abso.substring(1);
        replace=replace.substring(0,1).toLowerCase()+replace.substring(1);
        File file = new File(replace + path);
        return file!=null?file:null;
    }

    /**
     * sqlite 下载
     * @param response
     * @return
     * @throws Exception
     */
    public static Boolean download(HttpServletResponse response){
        try {
            //获取文件路径
//            File newFile = FileUtils.getNewSqlist();
//            if(newFile!=null) {
                //完成文件下载
                File file = new File(upload);
                BufferedInputStream is = new BufferedInputStream(new FileInputStream(file));
                //下载
                response.reset();
                String finalFileName = URLEncoder.encode(file.getName(), "UTF-8");
                response.setContentType("application/octet-stream");
                response.addHeader("Content-Disposition","attachment;filename=\""+finalFileName+"\"");
                BufferedOutputStream os = new BufferedOutputStream(response.getOutputStream());
                IOUtils.copy(is,os);
                IOUtils.closeQuietly(os);
                IOUtils.closeQuietly(is);
                return true;
//            }
        }catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("下载失败");
        }
    }


    /**
     * EXCEL 下载
     * @param response
     * @return
     * @throws Exception
     */
    public static Boolean download(HttpServletResponse response,InputStream is,String fileName) throws IOException {
        BufferedOutputStream os = null;
        try {
            //获取文件路径
//            File newFile = FileUtils.getNewSqlist();
//            if(newFile!=null) {
            //完成文件下载
            //下载
            //response.reset();
            String finalFileName = URLEncoder.encode(fileName, "UTF-8");
           // response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition","attachment;filename=\""+finalFileName+"\"");
            os = new BufferedOutputStream(response.getOutputStream());
            IOUtils.copy(is,os);
            IOUtils.closeQuietly(os);
            IOUtils.closeQuietly(is);
            return true;
//            }
        }catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("下载失败");
        }finally {
            is.close();
            os.close();
        }
    }

    /**
     * sqlite 下载
     * @param response
     * @return
     * @throws Exception
     */
    public static Boolean downloadByLocalPath(HttpServletResponse response,String path){
        try {
            //获取文件路径
            File newFile = new File(path);
            if(newFile!=null) {
                //完成文件下载
                BufferedInputStream is = new BufferedInputStream(new FileInputStream(newFile));
                //下载
                response.reset();
                String finalFileName = URLEncoder.encode(newFile.getName(), "UTF-8");
                response.setContentType("application/octet-stream");
                response.addHeader("Content-Disposition","attachment;filename=\""+finalFileName+"\"");
                BufferedOutputStream os = new BufferedOutputStream(response.getOutputStream());
                IOUtils.copy(is,os);
                IOUtils.closeQuietly(os);
                IOUtils.closeQuietly(is);
                return true;
            }
        }catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("下载失败");
        }
        return false;
    }

    /**
     * sqlite 上传
     */
    public static String upload(MultipartFile multipartFile,String filepath)
    {
        Boolean stat = false;
        File file1 = null;
        try {
            //获取文件后缀名
            String extension ="."+ FilenameUtils.getExtension(multipartFile.getOriginalFilename());
            //生成新的文件名字
            String newFilename = SysUserUtils.getUser().getDeptId()+extension;

            //根据日期生成文件夹
            String format = new SimpleDateFormat("yyy-MM-dd").format(new Date());
            String dateDirPath = filepath+format;

            File file = new File(dateDirPath);
            if(!file.exists())
                file.mkdirs();
            file1 = new File(file, newFilename);
            multipartFile.transferTo(file1);
            stat=true;
        }catch (Exception e) {
            e.printStackTrace();
            stat=false;
        }
        String absolutePath = file1.getAbsolutePath();
        String replace = absolutePath.replace("\\", "//");
        return replace;
    }

    /**
     * 对对象的空值赋值
     * @param dataclass
     * @param <T>
     * @return
     */
    public static  <T> T convertData(T dataclass)
    {
        Class<?> aClass = dataclass.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            String name = field.getName();
            Class<?> type = field.getType();
            String property = name.substring(0, 1).toUpperCase() + name.substring(1);
            Method method = null;
            try {
                method = aClass.getMethod("get" + property);
                Object invoke = method.invoke(dataclass);
                if( null==invoke)
                {
                    //判断类型
                    Object conversion = conversion(type);
                    method = aClass.getMethod("set" + property, type);
                    method.invoke(dataclass, conversion);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return dataclass;
    }

    public static Object conversion(Class<?> type) throws ParseException, NumberFormatException {
        String types = type.toString();
        int one = types.lastIndexOf(".");
        String attr = types.substring(one + 1, types.length());
        if (attr.equals("String")) {
            return "";
        }
        if (attr.equals("Date")) {
            //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            //Date date = dateFormat.parse(value);
            return new Date();
        }
        if (attr.equals("Long")) {
            return 0L;
        }
        if (attr.equals("BigDecimal")) {
            return new BigDecimal(0);
        }
        if (attr.equals("Integer")) {
            return 0;
        }
        return null;
    }

    /**
     *@Author: liuys
     *@Data: 2020/6/15
     *@Description: 删除文件
     */

    public static Boolean deleteFile(){
        boolean result =false;
        File file = new File(upload);
        if (file.exists()){
            file.delete();
            result=true;
        }
        return result;
    }

    public static Boolean deleteFile(String pathFile){
        boolean result =false;
        File file = new File(pathFile);
        if (file.exists()){
            file.delete();
            result=true;
        }
        return result;
    }
    /**
     *@Author: liuys
     *@Data: 2020/6/15
     *@Description: 将db文件复制生成新的db
     */
    public static Boolean copy(String dbPath, String newPath) {
        try {
            File newFile = new File(newPath);
            // 如果文件夹上级目录不存在创建
            File parentFile = newFile.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            // 如果文件不存在创建
            if (!newFile.exists())
                newFile.createNewFile();
            if (!newFile.exists())
                newFile.mkdirs();
            //BufferedInputStream is = new BufferedInputStream(new FileInputStream(new File(dbPath)));
            ClassPathResource cpr = new ClassPathResource(dbPath);
            InputStream is = cpr.getInputStream();
            BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(newFile));
            IOUtils.copy(is, os);
            IOUtils.closeQuietly(os);
            IOUtils.closeQuietly(is);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Boolean copy() {
        try {
            File newFile = new File(upload);
            File parentFile = newFile.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (!newFile.exists())
                newFile.createNewFile();
//            FileChannel input = new FileInputStream(new File(upload)).getChannel();
//            FileChannel output = new FileInputStream(newFile).getChannel();
//            output.transferFrom(input,0,input.size());
            //BufferedInputStream is = new BufferedInputStream(new FileInputStream(new File(path)));
            ClassPathResource classPath = new ClassPathResource("db/sqlist.db");
            InputStream is = classPath.getInputStream();
            BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(newFile));
            IOUtils.copy(is, os);
            IOUtils.closeQuietly(os);
            IOUtils.closeQuietly(is);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
