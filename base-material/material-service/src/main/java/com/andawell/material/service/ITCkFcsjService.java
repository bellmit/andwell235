package com.andawell.material.service;

import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.material.query.TCkFcsjQuery;
import com.andawell.material.vo.TCkFcsjVO;

/***
 * @author lhb
 * @Date: 2020/5/8 18:23
 * @Description:
 * @version : V1.0
 */
public interface ITCkFcsjService {

    ListPageVo<TCkFcsjQuery, TCkFcsjVO> getTCkFcsjList(TCkFcsjQuery tCkFcsjQuery);

}
