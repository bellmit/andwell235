package com.andawell.material.service;

import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.material.dto.LibraryInfoDTO;
import com.andawell.material.dto.OutLibraryInfoDTO;
import com.andawell.material.dto.TroubleShootingDTO;
import com.andawell.material.entity.response.TCkCkBO;
import com.andawell.material.query.TCkPglyQuery;
import com.andawell.material.query.TCkSxLikeQuery;
import com.andawell.material.query.TJhJhQuery;
import com.andawell.material.vo.TCkPglyVo;

import java.util.List;

/**
 * @Date： 2020/5/8 16:47
 */
public interface IOutOfStockService {

    /**
     *@Author: liuys
     *@Data: 2020/5/9 10:44
     *@Description: 全新可用出库/发付出库列表/查询
     */
    List<TCkCkBO> libraryList(TCkSxLikeQuery tCkSxLikeQuery);

    /**
     * 分页
     * @param tCkSxLikeQuery
     * @return
     */
    ListPageVo<TCkSxLikeQuery, TCkCkBO> libraryListPage(TCkSxLikeQuery tCkSxLikeQuery);

    /**
     *@Author: liuys
     *@Data: 2020/5/9 10:45
     *@Description: 全新可用出库/发付出库列表/匹配查询
     */
    List<TCkCkBO> libraryMatchingList(TCkSxLikeQuery tCkSxLikeQuery);


    List<String> getWhlb();
}
