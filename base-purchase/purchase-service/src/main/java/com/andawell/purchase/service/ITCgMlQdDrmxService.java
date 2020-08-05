package com.andawell.purchase.service;


import com.andawell.purchase.entity.TCgMlQdDrmx;

import java.util.List;

/***
 * @author gzh
 * @Date: 2020/6/2 8:59
 * @Description:
 * @version : V1.0
 */
public interface ITCgMlQdDrmxService {

    /**
     * 导入明细
     */
    void leadingInDrmx(List<TCgMlQdDrmx> list, String mlbh);
    /**
     * 导入明细全部删除
     */
    void deleteCgmlmxAll();
}
