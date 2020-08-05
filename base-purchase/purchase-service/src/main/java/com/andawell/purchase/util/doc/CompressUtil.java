package com.andawell.purchase.util.doc;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Author: yzy
 * @Description: 生成压缩文件(zip, rar)
 * @Date: created in 2020/6/8 9:49
 */
public class CompressUtil {

    /**
     * @param sourcePath 要压缩的文件路径
     * @param suffix     生成的格式后缀(zip,rar)
     * @throws Exception
     */
    public static void generateFile(String sourcePath, String suffix) throws Exception {
        File file = new File(sourcePath);
        //压缩文件的路径不存在
        if (!file.exists()) {
            throw new Exception("路径" + sourcePath + "不存在文件，无法进行压缩。。");
        }
        //用于存放压缩文件的文件夹
        String generateFle = file.getParent() + File.separator + "CompressFile";

        File compress = new File(generateFle);
        //如果文件夹不存在，进行创建
        if (!compress.exists()) {
            compress.mkdir();
        }
        //目的压缩文件
        String generateFileName = compress.getAbsolutePath() + File.separator + "AAA" + file.getName() + "." + suffix;

        //输入流  表示从一个源读取数据
        //输出流 表示向向下一个写入数据

        //输出流
        FileOutputStream outputStream = new FileOutputStream(generateFileName);

        //压缩输出流
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(outputStream));

        generateFile(zipOutputStream, file, "");


        System.out.println("源文件位置" + file.getAbsolutePath() + ",目标文件生成位置：" + generateFileName);

        //关闭输出流
        zipOutputStream.close();

    }

    /**
     * @param out  输出流
     * @param file 目标文件
     * @param dir  文件夹
     * @throws IOException
     */
    private static void generateFile(ZipOutputStream out, File file, String dir) throws IOException {
        //当前的文件是否为文件夹
        if (file.isDirectory()) {
            //得到文件列表信息
            File[] files = file.listFiles();

            //将文件夹添加到下一级打包，目录
            out.putNextEntry(new ZipEntry(dir + "/"));

            dir = dir.length() == 0 ? "" : dir + "/";

            for (int i = 0; i < files.length; i++) {
                generateFile(out, files[i], dir + files[i].getName());

            }


        } else {  //当前file是文件
            //输入流
            FileInputStream inputStream = new FileInputStream(file);
            //标记要打包条目
            out.putNextEntry(new ZipEntry(dir));
            //进行写操作
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = inputStream.read(bytes)) > 0) {
                out.write(bytes, 0, len);
            }
            //关闭输入流
            inputStream.close();
        }
    }

    /**
     * 递归压缩文件
     *
     * @param output    zipOutPutStream 对象流
     * @param file      压缩的目标文件流
     * @param childPath 条目目录
     */
    private static void zip(ZipOutputStream output, File file, String childPath) {
        FileInputStream input = null;
        try {
            //文件为目录
            if (file.isDirectory()) {
                File[] list = file.listFiles();
                childPath = childPath + (childPath.length() == 0 ? "" : "/") + file.getName();
                //循环递归压缩每个文件
                for (File f : list) {
                    zip(output, f, childPath);
                }

            } else {
                //压缩文件
                childPath = (childPath.length() == 0 ? "" : childPath + "/") + file.getName();

                output.putNextEntry(new ZipEntry(childPath));

                input = new FileInputStream(file);
                int reaLen = 0;
                byte[] buffer = new byte[1024 * 8];
                while ((reaLen = input.read(buffer, 0, 1024 * 8)) != -1) {
                    output.write(buffer, 0, reaLen);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     *
     *  创建压缩流和刷新压缩流
     * @param path   目标文件流
     * @param format zip 格式 | rar 格式
     * @return
     * @throws IOException
     */
    public static String zipFile(File path, String format) throws IOException {
        String generatePath = "";
        if (path.isDirectory()) {
            generatePath = path.getParent().endsWith("/") == false ?
                    path.getParent() + File.separator + path.getName() + "." + format :
                    path.getParent() + path.getName() + "." + format;
        } else {
            generatePath = path.getName().substring(0, path.getName().lastIndexOf(".")) + "." + format;
        }
        //输出流
        FileOutputStream outputStream = new FileOutputStream(generatePath);
        //压缩输出流
        ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(outputStream));
        zip(out, path, "");
        out.flush();
        out.close();

        return generatePath;
    }



    //-------------------------------------------下载--------------------------------------------

    /**
     * 下载doc的压缩包
     * @param rootPath
     * @param response
     * @throws IOException
     */
    public static void download(String rootPath, HttpServletResponse response) throws IOException {
        //压缩
//        String zip = CompressUtil.zipFile(new File(rootPath), "zip");
        System.out.println(rootPath);  //e:\workspace\AW235\base-purchase\purchase-service\target\classes\doc\20200619142412.zip
        String fileName = rootPath.substring(rootPath.length() - 18);
        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition", "attachment;fileName="+fileName);

        try {
            OutputStream outputStream = response.getOutputStream();
            File file = new File(rootPath);
            FileInputStream in = new FileInputStream(file);
            byte[] b = new byte[100];
            int len;
            while ((len = in.read(b)) != -1) {
                outputStream.write(b, 0, len);
            }
            in.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将生成doc的文件夹，递归删除
     * @param dirPath
     */
    public static void deleteDir(String dirPath){
        File file = new File(dirPath);
        if(file.isFile()){
            file.delete();
        }else{
            File[] files = file.listFiles();
            if(files ==null){
                file.delete();
            }else{
                for (int i = 0; i < files.length; i++) {
                    deleteDir(files[i].getAbsolutePath());
                }
                file.delete();
            }
        }
    }

}
