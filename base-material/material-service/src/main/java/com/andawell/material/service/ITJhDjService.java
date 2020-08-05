package com.andawell.material.service;

import com.andawell.material.dto.TJhDjDTO;
import com.andawell.material.query.TJhDjQuery;
import com.andawell.material.vo.TJhDjVO;

import java.util.List;

/***
 * @author shs
 * @Date: 2020/5/7 15:40
 * @Description:
 * @version : V1.0
 */
public interface ITJhDjService {
    /**
     * 大件信息添加
     * @param
     * @return
     */
     void insert(TJhDjDTO tJhDjDTO);
    /**
     * 大件信息查询
     * @param
     * @return
     */
    List<TJhDjVO> list(TJhDjQuery tJhDjQuery);
    /**
     * 大件信息删除
     * @param
     * @return
     */
    void delete(List<String> list);


}
