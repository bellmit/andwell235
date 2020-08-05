package com.andawell.purchase.util.doc.poi.bean.table;

import java.io.Serializable;

/**
 * Apache Poi 动态表格 通用接口
 *
 * @author yzy
 * Create on 2018/12/1 11:27
 */
public interface IPoiWordTable extends Serializable {

    /**
     * 设置表格内容
     */
    void setCell(int row, int col, String text);

    /**
     * 读取表格内容
     */
    String getCell(int row, int col);

    /** 读取表格行数 */
    int getRows();

    /** 读取表格列数 */
    int getCols();
}
