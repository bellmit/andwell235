package com.andawell.common.util;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;

public class ZipUtil {
    private static List list = new ArrayList();

    /**
     * 遍历文件夹下所有文件
     * @param1  path文件夹路径
     * @return  文件夹下所有文件
     */
    private static List listFile(String path) {
        File file = new File(path);
        String[] array = null;
        String sTemp = "";
        if (!file.isDirectory()) {
            return null;
        }
        array = file.list();
        if (array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                sTemp = path + array[i];
                file = new File(sTemp);
                if (file.isDirectory()) {
                    listFile(sTemp + "/");
                } else {
                    list.add(sTemp);
                }
            }
        } else {
            return null;
        }
        return list;
    }
    /**
     * 遍历文件夹下所有文件
     * @param1  需要打包文件路径
     * @param2  文件打包路径
     */
    public static void zip(String needtozipfilepath, String zipfilepath) {
        try {
            byte[] b = new byte[512];
            File needtozipfile = new File(needtozipfilepath);
            if (!needtozipfile.exists()) {
                System.err.println("指定的要压缩的文件或目录不存在.");
                return;
            }
            String zipFile = zipfilepath;
            File targetFile = new File(zipFile.substring(0, zipFile.indexOf("\\") + 1));
            if (!targetFile.exists()) {
                System.out.println("指定的目标文件或目录不存在.");
                return;
            }
            String filepath = needtozipfilepath;
            List fileList = listFile(filepath);
            FileOutputStream fileOutputStream = new FileOutputStream(zipFile);
            CheckedOutputStream cs = new CheckedOutputStream(fileOutputStream, new CRC32());
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(cs));
            for (int i = 0; i < fileList.size(); i++) {
                InputStream in = new FileInputStream((String) fileList.get(i));
                String fileName = ((String) fileList.get(i)).replace(File.separatorChar, '/');
                fileName = fileName.substring(fileName.indexOf("/") + 1);
                ZipEntry e = new ZipEntry(fileName);
                out.putNextEntry(e);
                int len = 0;
                while ((len = in.read(b)) != -1) {
                    out.write(b, 0, len);
                }
                out.closeEntry();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 压缩文件 或者 文件夹
     */
    public static boolean zip(String baseDirName, String[] fileNames,
                              String targetFileName, String encoding) {
        boolean flag = false;
        try {
            File baseDir = new File(baseDirName);
            if (!baseDir.exists() || (!baseDir.isDirectory())) {
                System.err.println("压缩失败! 根目录不存在: " + baseDirName);
                return false;
            }
            String baseDirPath = baseDir.getAbsolutePath();
            File targetFile = new File(targetFileName);
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
                    targetFile));
            out.setEncoding(encoding);
            if ("*".equals(fileNames)) {
                dirToZip(baseDirPath, baseDir, out);
            } else {
                File[] files = new File[fileNames.length];
                for (int i = 0; i < files.length; i++) {
                    files[i] = new File(baseDir, fileNames[i]);
                }
                if (files[0].isFile()) {
                    filesToZip(baseDirPath, files, out);
                }

            }
            out.close();
            flag = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 将文件压缩到Zip 输出流
     */
    private static void fileToZip(String baseDirPath, File file,
                                  ZipOutputStream out) throws IOException {
        FileInputStream in = null;
        org.apache.tools.zip.ZipEntry entry = null;
        byte[] buffer = new byte[1024 * 4];
        int bytes_read = 0;
        if (file.isFile()) {
            in = new FileInputStream(file);
            String zipFileName = getEntryName(baseDirPath, file);
            entry = new org.apache.tools.zip.ZipEntry(zipFileName);
            out.putNextEntry(entry);
            while ((bytes_read = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytes_read);
            }
            out.closeEntry();
            in.close();
        }
    }

    /**
     * 多个文件目录压缩到Zip 输出流
     */
    private static void filesToZip(String baseDirPath, File[] files,
                                   ZipOutputStream out) throws IOException {
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            if (file.isFile()) {
                // 调用本类的一个静态方法 压缩一个文件
                fileToZip(baseDirPath, file, out);
            } else {
                dirToZip(baseDirPath, file, out);
            }
        }
    }

    /**
     * 将文件目录压缩到Zip 输出流
     */
    private static void dirToZip(String baseDirPath, File dir,
                                 ZipOutputStream out) throws IOException {
        File[] files = dir.listFiles();
        if (files.length == 0) {
            String zipFileName = getEntryName(baseDirPath, dir);
            org.apache.tools.zip.ZipEntry entry = new org.apache.tools.zip.ZipEntry(
                    zipFileName);
            out.putNextEntry(entry);
            out.closeEntry();
        } else {
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                if (file.isFile()) {
                    // 调用本类的一个静态方法 压缩一个文件
                    fileToZip(baseDirPath, file, out);
                } else {
                    dirToZip(baseDirPath, file, out);
                }
            }
        }
    }

    /**
     * 获取 待压缩文件在 ZIP 文件中的 entry的名字，即相对于根目录的相对路径名
     */
    private static String getEntryName(String baseDirPath, File file) {
        if (!baseDirPath.endsWith(File.separator)) {
            baseDirPath += File.separator;
        }
        String filePath = file.getAbsolutePath();
        if (file.isDirectory()) {
            filePath += "/";
        }
        int index = filePath.indexOf(baseDirPath);
        return filePath.substring(index + baseDirPath.length());
    }

}