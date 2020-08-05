package com.andawell.material.service;

import com.andawell.material.dto.TJhGzDTO;
import com.andawell.material.dto.TJhGzzDTO;
import com.andawell.material.entity.THtDh;
import com.andawell.material.entity.TJhGz;
import com.andawell.material.entity.response.THtDhBO;
import com.andawell.material.query.THtDhQuery;
import com.andawell.material.query.TJhGzQuery;
import com.andawell.material.vo.TJhGzVO;
import com.andawell.material.vo.TSrJhGzVO;

import java.util.List;

/**
 * @Date： 2020/4/28 11:36
 */
public interface ITJhGzService {
    /**
     * 公有件号关注添加
     */
    void insert(TJhGzzDTO tJhGzzDTO);
    /**
     * 件号关注删除
     */
    int delete(String jh);
    /**
     * 件号关注删除
     */
    List<TJhGzVO> list(TJhGzQuery tJhGzQuery);
    /**
     * 私有件号关注添加
     */
    void insertSy(TJhGzzDTO tJhGzzDTO);
    /**
     * 私有件号关注查询
     */
    List<TSrJhGzVO> srlist();
}
