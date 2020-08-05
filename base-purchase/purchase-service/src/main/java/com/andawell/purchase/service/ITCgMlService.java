package com.andawell.purchase.service;

import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.purchase.dto.TCgMlDTO;
import com.andawell.purchase.entity.TCgMlQd;
import com.andawell.purchase.query.TCgMlQdQuery;
import com.andawell.purchase.vo.TCgMlQdVO;

import java.util.List;
import java.util.Map;

public interface ITCgMlService {


    /**
     * 跟新数据
     * @param tCgMlDTO
     * @return
     */
    void updateTCgMl(TCgMlDTO tCgMlDTO);

    /**
     * 增加目录
     * @param tCgMlDTO
     */
    void saveCgml(TCgMlDTO tCgMlDTO);


    /**
     * 逻辑删除 状态改为 4
     * @param id
     */
    void deleteTCMl(Long id);

    /**
     * 发布
     * @param id
     */
    void issue(Integer id);
    /**
     * 判断id数据库是否存在
     * @param id
     */
    int selectId(Integer id);
    /**
     * 根据id查询数据状态
     * @param id
     */
    int selectStatusById(Integer id);

    /**
     * 编辑目录
     * @param tCgMlDTO
     * @return
     */
    Map edit(TCgMlDTO tCgMlDTO);
    /**
     * 生效状态是否拥有编辑功能
     */
    Boolean isEdit();
}
