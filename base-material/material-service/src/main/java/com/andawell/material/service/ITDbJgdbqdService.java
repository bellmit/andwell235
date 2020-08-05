package com.andawell.material.service;

import com.andawell.material.dto.TDbJgdbDTO;
import com.andawell.material.dto.TDbJgdbqdDTO;
import com.andawell.material.entity.TDbJgdbqd;
import com.andawell.material.vo.TDbSjsqqdVO;

import java.util.List;

/**
 * @author: zje
 * @date: 2020/5/28
 * @description:
 */
public interface ITDbJgdbqdService {

    List<TDbSjsqqdVO> list(String sqdh);

    void insert(TDbJgdbDTO dbJgdbDTO);

    List<TDbJgdbqd> getJgdbqd(TDbJgdbDTO dbJgdbDTO);
}
