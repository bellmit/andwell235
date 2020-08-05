package com.andawell.material.service;

import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.material.entity.TCkBfk;
import com.andawell.material.query.TCkBfkQuery;
import com.andawell.material.vo.TCkBfkVO;
import com.andawell.material.vo.TCkDxzbfVO;

import java.util.List;

/**
 * @Date： 2020/5/8 11:01
 */
public interface ITCkBfkService {
    List<TCkBfk> list(TCkBfkQuery tCkBfkQuery);

    ListPageVo<TCkBfkQuery,TCkBfkVO> outnoundList(TCkBfkQuery tCkBfkQuery);

    List<TCkDxzbfVO> warehousingList(TCkBfkQuery tCkBfkQuery);
}
