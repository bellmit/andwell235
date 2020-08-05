package com.andawell.material.service;

import com.andawell.material.query.TCfQuery;
import com.andawell.material.vo.TCfVO;

import java.util.List;

/**
 * @author: zje
 * @date: 2020/5/9
 * @description:
 */
public interface ITCfService {

    /**
     *@Auther:zje
     *@Date:2020/5/8
     *@Description:查询厂房列表
     *@Param:
     *@return:
     */
    List<TCfVO> list(TCfQuery query);
}
