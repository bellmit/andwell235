package com.andawell.purchase.service;

import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.util.ValidableList;
import com.andawell.purchase.dto.TCgMlQdDTO;
import com.andawell.purchase.entity.TCgMlQd;
import com.andawell.purchase.query.TCgMlQdQuery;
import com.andawell.purchase.vo.TCgMlQdVO;

import java.util.List;

public interface ITCgMlQdService {

    void insertAll(ValidableList<TCgMlQdDTO> tCgMlQdList);

    /**
     * 跟新目录清单
     */
    void updateTCgMlQd(TCgMlQdDTO tCgMlQdDTO);

    /**
     * 删除清单
     */
    void deleteTCgMlQd(Long Id);

    /**
     * 插入目录清单
     * @param tCgMlQdDTO
     */
    void insertTCgMlQd(TCgMlQdDTO tCgMlQdDTO);

    /**
     * 目录清单分页查询
     * @param query
     * @return
     */
    ListPageVo<TCgMlQdQuery, TCgMlQdVO> listPage(TCgMlQdQuery query);

}
