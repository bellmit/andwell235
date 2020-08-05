package com.andawell.material.service;

import com.andawell.material.dto.TCkSxXLNLDTO;
import com.andawell.material.entity.response.TCkSxBO;
import com.andawell.material.query.TCkSxQuery;
import com.andawell.material.query.TCkSxXLNLQuery;
import com.andawell.material.vo.TCkSxVO;
import com.andawell.material.vo.TcksxXLNLTJVO;

import java.util.List;


/***
 * @author lhb
 * @Date: 2020/4/27 14:40
 * @Description:
 * @version : V1.0
 */
public interface ITCkSxService {
    /**
     * 仓库查询接口
     * @param
     * @return
     */
    List<TCkSxBO> repairReturn(TCkSxQuery tCkSxQuery);

    /**
     * 待修退修入库信息
     * @param tCkSxQuery
     * @return
     */
    List<TCkSxBO> repairRetreat(TCkSxQuery tCkSxQuery);

    /**
     * 查询所有的承修商
     * @return
     */
    List<TCkSxXLNLDTO> getList();
}
