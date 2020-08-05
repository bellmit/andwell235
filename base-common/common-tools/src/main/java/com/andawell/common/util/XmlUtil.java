package com.andawell.common.util;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.Xpp3DomDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * XML工具类
 */
public class XmlUtil {
    //private final static String XML_TAG = "<?xml version='1.0' encoding='UTF-8'?>";


    /**
     * java 转换成xml
     *
     * @param obj 对象实例
     * @return String xml字符串
     * @Title: toXml
     * @Description: TODO
     */
    public static String toXml(Object obj) {
        //      XStream xstream = new XStream();
        //		XStream xstream=new XStream(new DomDriver()); //直接用jaxp dom来解释
        //指定编码解析器,直接用jaxp dom来解释
        XStream xstream = new XStream(new DomDriver("utf-8"));

        ////如果没有这句，xml中的根元素会是<包.类名>；或者说：注解根本就没生效，所以的元素名就是类的属性
        //通过注解方式的，一定要有这句话
        xstream.processAnnotations(obj.getClass());
        return xstream.toXML(obj);
    }

    /**
     * 将传入xml文本转换成Java对象
     *
     * @param xmlStr
     * @param cls    xml对应的class类
     * @return T   xml对应的class类的实例对象
     * <p>
     * 调用的方法实例：PersonBean person=XmlUtil.toBean(xmlStr, PersonBean.class);
     * @Title: toBean
     * @Description: TODO
     */
    public static <T> T COLUMN(String xmlStr, Class<T> cls) {
        //XStream xstream = new XStream();
        XStream xstream = new XStream(new DomDriver("utf-8"));
        //XStream xstream = new XStream(new Xpp3DomDriver());
        xstream.processAnnotations(cls);
        xstream.setClassLoader(cls.getClassLoader());
        xstream.autodetectAnnotations(true);
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypesByWildcard(new String[]{
                "com.**"
        });
        T obj = (T) xstream.fromXML(xmlStr);
        return obj;
    }


    public static <T> T filetoBean(File file, Class<T> cls) {
        //XStream xstream = new XStream();
        XStream xstream = new XStream(new DomDriver("utf-8"));
        //XStream xstream = new XStream(new Xpp3DomDriver());
        xstream.processAnnotations(cls);
        xstream.setClassLoader(cls.getClassLoader());
        xstream.autodetectAnnotations(true);
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypesByWildcard(new String[]{
                "com.**"
        });
        T obj = (T) xstream.fromXML(file,cls);
        return obj;
    }
}