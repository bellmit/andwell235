package com.andawell.material.service;


import com.andawell.material.dto.TJhJhDTO;
import com.andawell.material.dto.TJhJxDTO;
import com.andawell.material.dto.TJhJxjhDTO;
import com.andawell.material.dto.TJhJxjhDjazsDTO;
import com.andawell.material.entity.TJhJx;

import com.andawell.material.entity.TJhJxlx;
import com.andawell.material.query.TJhJxQuery;
import com.andawell.material.query.TJhJxlxQuery;

import com.andawell.material.vo.AircaftModelTreelVO;
import com.andawell.material.vo.TJhJxVO;


import java.util.List;

/**
 * 机型（飞机的型号）信息处理接口
 */
public interface ITJhJxService {

    //机型信息列表查询
    List<AircaftModelTreelVO> getTreeList();

    /**\
     * 根据Id 获取数据，如果
     */
    TJhJx getTJhJxById(String jxId);
    /**\
     * 机型新增
     */
    void insert(TJhJxDTO tJhJxDTO);

    /**\
     * 机型编辑
     */
    void updateByPrimaryKey(TJhJxDTO tJhJxDTO);

    /**\
     * 机型删除
     */
    void delete(String id);


    /**\
     * 机型的删除增加
     */
   /* void deleteAndInsertjxjh(TJhJxjhDTO tJhJxjhDTO);*/


    /**\
     * 机型类型查询
     */
    List<TJhJxlx> listlx(TJhJxlxQuery query);

    /**\
     * 机型件号增加
     */
    void insertjxjh(TJhJxjhDTO tJhJxjhDTO);
    /**\
     * 机型件号删除
     */
    void deletejxjh(TJhJxjhDTO tJhJxjhDTO);

    /**\
     * 编辑单机安装数
     */
    void updatedjazs(TJhJxjhDjazsDTO tJhJxjhDjazsDTO);

    List<TJhJx> selectById(String id);

    //机型信息列表查询
    List<TJhJx> getList(TJhJxQuery query);
}
