package com.andawell.purchase.service;

import com.andawell.purchase.query.HTPrintQuery;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @Author: yzy
 * @Description:
 * @Date: created in 2020/6/9 14:50
 */
public interface ITHtPrintService {

    /**
     * 查询标签的集合
     * @param hth
     * @param jhbh
     * @return
     */
    Map<String, String> bookmarkMap(String hth, String jhbh);

    /**
     * 查询合同清单列表
     * @param hth
     * @param jhbh
     * @return
     */
    List<Map<String, String>> list(String hth, String jhbh);


    /**
     * 1.先查询出替换标签的map和替换列表的list
     * 2.文档中替换标签的map
     * 3.文档中的列表
     * 4.合同号和厂方简称的路径
     * 5.厂方简称的路径
     * 6.模板文件路径
     * 7.批量生成并下载和同zip
     * @param htPrintQuery
     */
    void printHT(List<HTPrintQuery> htPrintQuery, HttpServletResponse response);
}
