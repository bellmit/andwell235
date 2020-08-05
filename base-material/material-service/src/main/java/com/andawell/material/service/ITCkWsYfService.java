package com.andawell.material.service;

import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.material.query.TCkFcsjQuery;
import com.andawell.material.query.TCkWsyfQuery;
import com.andawell.material.vo.TCkFcsjVO;
import com.andawell.material.vo.TCkWsyfVO;

/***
 * @author lhb
 * @Date: 2020/5/8 18:23
 * @Description:
 * @version : V1.0
 */
public interface ITCkWsYfService {

    ListPageVo<TCkWsyfQuery, TCkWsyfVO> getTCkWsYfList(TCkWsyfQuery tCkWsyfQuery);

}
