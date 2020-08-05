package com.andawell.material.service;

import com.andawell.material.query.JhQuery;
import com.andawell.material.vo.TJhJhVO;
import com.andawell.material.vo.TJhVO;

import java.util.List;

/***
 * @author hwd
 * @Date: 2020-05-27 10:06
 * @Description:
 * @version : V1.0
 */
public interface TJhService
{
    public List<TJhVO> getlist(JhQuery jhQuery);
}
