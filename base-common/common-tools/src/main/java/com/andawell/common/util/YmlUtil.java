package com.andawell.common.util;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Yml工具类
 */
public class YmlUtil {
    private static Yaml yaml = new Yaml();

    /**
     * 对象转yml字符串
     *
     * @param object
     * @return
     */
    public static String toYml(Object object) {
        StringWriter writer = new StringWriter();
        yaml.dump(object, writer);
        return writer.toString();
    }

    /**
     * yml文件转对象
     *
     * @param file
     * @param clazz
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> T parse(File file, Class<T> clazz) throws Exception{
        if (!file.exists()) {
            throw new Exception("File Not Found");
        }
        FileInputStream inputStream = new FileInputStream(file);
        return (T) yaml.loadAs(inputStream, clazz);
    }

    /**
     * yaml字符串转对象
     *
     * @param yml
     * @param clazz
     * @return
     */
    public static <T> T stringtoBean(String yml, Class<T> clazz) {
        return (T)yaml.loadAs(yml, clazz);
    }


}
