package com.andawell.material.service;

import com.andawell.material.dto.SystemNoDetailDTO;
import com.andawell.material.dto.TCkJsdBcDTO;
import com.andawell.material.entity.response.TCkSxBO;
import com.andawell.material.query.TCkSxQuery;

import java.util.List;


/***
 * @author gzh
 * @Date: 2020/6/02  14:40
 * @Description:
 * @version : V1.0
 */
public interface ITCkJsdService {
    /**
     *结算单打印保存接口
     */
    void insert(TCkJsdBcDTO tCkJsdBcDTO);
    /**
     * 结算单编号查询接口
     */
    String getSystemNumber();
}
