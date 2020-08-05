package com.andawell.material.service;

import com.andawell.material.dto.TJhJhDTO;

import com.andawell.material.dto.TJhJhjxDTO;
import com.andawell.material.query.TJhJhQuery;
import com.andawell.material.query.TJhZlQuery;

import java.util.List;

/***
 * @author lhb
 * @Date: 2020/4/27 14:40
 * @Description:
 * @version : V1.0
 */
public interface ITJhJhService {
    /**
     * 件号查询接口
     * @param
     * @return
     */
    List<TJhJhDTO> list(TJhJhQuery tJhJhQuery);

    /**
     * 件号新增接口
     *
     */
    void insert(TJhJhDTO tJhJhDTO);

    /**
     * 件号修改接口
     *
     */
    void update(TJhJhDTO jhJhDTO);

    /**
     * 件号删除接口
     *
     */
    void delete(String id);

    /**
     * 新增件号机型
     *
     */
    void insertjhjx(TJhJhjxDTO tJhJhjxDTO);
    /**
     * 删除件号机型
     *
     */
    void deletejhjx(TJhJhjxDTO tJhJhjxDTO);
}
