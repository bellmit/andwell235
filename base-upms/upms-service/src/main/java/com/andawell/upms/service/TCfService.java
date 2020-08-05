package com.andawell.upms.service;

import com.andawell.upms.entity.TCf;
import com.andawell.upms.query.TCfQuery;

import java.util.List;

public interface TCfService {

    /**
     * 删除
     * @param id
     */
    void delete(String id);

    /**
     * 新增承修方
     * @param tCf
     */
    void insertCx(TCf tCf);


    /**
     * 厂方编辑
     * @param tCf
     */
    void update(TCf tCf);

    /**
     * 承修方查询
     * @param query
     * @return
     */
    List<TCf> listCx(TCfQuery query);


    /**
     * 承制方查询
     * @param query
     * @return
     */
    List<TCf> listCz(TCfQuery query);

    /**
     * 承制方新增
     * @param tCf
     */
    void insertCz(TCf tCf);

    /**
     * 承制方导入
     * @param list
     */
    void upload(List<String[]> list);

}
