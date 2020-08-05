package com.andawell.material.service;

import com.andawell.material.entity.TCkCrklx;
import com.andawell.material.query.TCkCrklxQuery;
import com.andawell.material.vo.TCkCrklxVO;

import java.util.List;

/**
 * @Date： 2020/5/11 15:02
 */
public interface ITCkCrklxService {
    List<TCkCrklxVO> treelist(TCkCrklxQuery query);

    List<TCkCrklx> list(TCkCrklxQuery query);
}
