package com.andawell.common.util;

import java.util.*;
import java.util.Map.Entry;

/**
 * <p>客户端基类:Map集合工具类</p>
 * <p>Map集合处理工具类</p>
 * @author liqs
 * @createDate 2016-8-9 15:26:47
 * 用到的可能性不大 常用方法apache maputil有封装
 */
public class MapUtil {





    /**
     * 遍历Map集合,替换单个Key值
 
     * @param1 Map<String , Object> 待替换的Map
     * @param keyName  Key值
     * @param renameKeyName 替换key值
     * @return Map<String , Object>
     */
    public static  Map<String , Object> getMapChangeKey(Map<String , Object> map,String keyName,String renameKeyName) {

        Map<String , Object> newMap =  new HashMap<String, Object>();
        Set set = map.keySet();

        for (Iterator it = set.iterator(); it.hasNext();) {
            String key = (String) it.next();
            Object value = map.get(key);
            if (keyName.trim().equals(key)) {
                key=renameKeyName;
            }
            newMap.put(key.toLowerCase(), value);
        }


        return newMap;
    }


    /**
     * 遍历Map集合,替换单个Key值
     * @param1 Map<String , Object> 待替换的Map
     * @param keyName  Key值
     * @param renameKeyName 替换key值
     * @return Map<String , Object>  key没有转换小写
     */
    public static  Map<String , Object> getMapChangeKeyNoLowerCase(Map<String , Object> map,String keyName,String renameKeyName) {

        Map<String , Object> newMap =  new HashMap<String, Object>();
        Set set = map.keySet();

        for (Iterator it = set.iterator(); it.hasNext();) {
            String key = (String) it.next();
            Object value = map.get(key);
            if (keyName.trim().equals(key)) {
                key=renameKeyName;
            }
            newMap.put(key, value);
        }


        return newMap;
    }

    /**
     * 遍历Map集合,替换单个Key值
 
     * @param1 Map<String , Object> 待替换的Map
     * @param2 Map<key值 , 替换Key值 > reMap
     * @return Map<String , Object>
     */
    public static  Map<String , Object> getMapChangeKey(Map<String , Object> map,Map<String , String > reMap) {

        Map<String , Object> newMap =  new HashMap<String, Object>();
        Set set = map.keySet();

        for (Iterator it = set.iterator(); it.hasNext();) {
            String key = (String) it.next();
            Object value = map.get(key);
            String reName=reMap.get(key)+"".trim();
            if (!"null".equals(reName)) {
                key=reName;
            }
            newMap.put(key.toLowerCase(), value);
        }


        return newMap;
    }


    /**
     * 获取Map中的List
     * @param1 Map<String, Object>
     * @return  List
     */
    public static List getList (Map<String, Object> map) {

        List list = new ArrayList();
        Iterator<Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, Object> entry = it.next();
            Object type = (Object) entry.getValue();
            list.add(type);
        }
        return list;
    }

    /**
     * 获取Map中指定的Map
     * @param map
     * @param key K值
     * @return value值转Map
     */
    public static Map<String, Object> getKeyMap (Map<String, Object> map,String key){

        Map<String, Object> newMap = new HashMap<String, Object>();


        List list = new ArrayList();
        Iterator<Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, Object> entry = it.next();
            if (key.equals(entry.getKey().toString())) {

                Object object =entry.getValue();
                if(object instanceof List || object instanceof ArrayList ){
                    while (object instanceof List || object instanceof ArrayList ){
                        list=(List) object;
                        object=list.get(0);
                    }
                    list.add(object);
                }else {
                    list.add(entry.getValue());
                }

            }

        }
        if (list.size()>0) {
            newMap=(Map<String, Object>) list.get(0);
        }else {
            newMap=null;
        }


        return newMap;
    }

    /**
     * 获取Map中指定的Map
     * @param map
     * @param key K值
     * @return value值转Map
     */
    public static List  getListKeyList (Map<String, Object> map,String key){

        List list = new ArrayList();
        Iterator<Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, Object> entry = it.next();
            if (key.equals(entry.getKey().toString())) {

                Object object =entry.getValue();
                if(object instanceof List || object instanceof ArrayList ){
                    while (object instanceof List || object instanceof ArrayList ){
                        list=(List) object;
                        object=list.get(0);
                    }
                    //    list.add(object);
                }else {
                    list.add(entry.getValue());
                }

            }

        }



        return list;
    }


    /**
     * 获取Map中指定的List
     * @param map
     * @param key K值
     * @return value值转List
     */
    public static List getMapList (Map<String, Object> map,String key){

        List list = new ArrayList();
        Iterator<Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, Object> entry = it.next();
            if (key.equals(entry.getKey().toString())) {
                Object object=entry.getValue();
                if(object instanceof HashMap ){
                    list.add((Map<String, Object>)entry.getValue());
                }else if(object instanceof List){
                    list=(List) entry.getValue();
                }

            }

        }
        if (list.size()==0) {
            list=null;
        }


        return list;
    }
    /**
     * 获取Map中指定的List
     * @param map
     * @param key K值
     * @return value值转List
     */
    public static String getKeyString (Map<String, Object> map,String key){

        String value = null;
        Iterator<Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, Object> entry = it.next();
            if (key.equals(entry.getKey().toString())) {
                value = (String) entry.getValue();

            }

        }


        return value;
    }
    /**
     * 查找map中指定的
     * @param map
     * @param key K值
     * @return value值转Map
     */



}

