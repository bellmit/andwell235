package com.andawell.material.util;

import com.andawell.material.utils.ValidableList;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.List;

/***
 * @author lhb
 * @Date: 2020/4/27 10:18
 * @Description:
 * @version : V1.0
 */
public class BeanUtils {

    /**
     * do 转 VO
     *
     * @param doList
     * @param voClass
     * @param <T>
     * @return
     */
    public static <T> List<T> copyList(List<?> doList, Class<T> voClass) {
        List<T> voList = new ArrayList<>();
        if (doList!=null && !doList.isEmpty()) {
            try {
                T voObj = null;
                for (Object doObj : doList) {
                    voObj = voClass.newInstance();
                    org.springframework.beans.BeanUtils.copyProperties(doObj, voObj);
                    voList.add(voObj);
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return voList;
    }

    /**
     * 单个实体类的转换
     *
     * @param dotEntity
     * @param voClass
     * @return
     */
    public static <T> T dtoTODO(Object dotEntity, Class<T> voClass) {
        if (dotEntity == null) {
            return null;
        }
        T t = null;
        try {
            t = voClass.newInstance();
            org.springframework.beans.BeanUtils.copyProperties(dotEntity, t);
            return t;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * ValidableList(重写的List转换)
     * @param doList
     * @param voClass
     * @param <T>
     * @return
     */
    public static <T> ValidableList<T> copyValidableList(ValidableList<?> doList, Class<T> voClass) {
        ValidableList<T> voList = new ValidableList<>();
        try {
            T voObj = null;
            for (Object doObj : doList) {
                voObj = voClass.newInstance();
                org.springframework.beans.BeanUtils.copyProperties(doObj, voObj);
                voList.add(voObj);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return voList;
    }

}

