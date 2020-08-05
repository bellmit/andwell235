package com.andawell.material.service;

import com.andawell.material.entity.TCkCrklb;
import com.andawell.material.query.TCkCrklbQuery;
import com.andawell.material.vo.TCkCrklbVO;

import java.util.List;

public interface ITCkCrklbService {

    /***
     * @author gzh
     * @Date: 2020/4/28 14:36
     * @Description: 出入库类别接口
     */
    List<TCkCrklb> rklbList(TCkCrklbQuery query);

    /**
     * 新增本级
     * @param tCkCrklb
     */
    void insertBj(TCkCrklb tCkCrklb);

    /**
     * 编辑出入库类别
     * @param tCkCrklb
     */
    void update(TCkCrklb tCkCrklb);

    /**
     * 新增子级
     * @param tCkCrklb
     */
    void insertZj(TCkCrklb tCkCrklb);

    /**
     * 删除出入库类别
     * @param id
     */
    void delete(String id);

    String getJmById(String id);
    /***
     * @author gzh
     * @Date: 2020/4/28 14:36
     * @Description: 五金出入库类别接口
     */
    List<TCkCrklb> wjcrklbList();
}
