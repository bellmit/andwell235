package com.andawell.material.service;

import com.andawell.material.dto.TCkCrkDTO;
import com.andawell.material.dto.TCkCrksDTO;
import com.andawell.material.vo.TSqliteFfVO;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface ITCkCrkService {

    /**
     * 向sqlite插入数据
     *
     * @return
     */
    void insert(HttpServletResponse response,List<TCkCrksDTO> tCkCrks) throws Exception;

    /**
     * 向oracle插入数据
     *
     * @return
     */
    int insertOracle(List<TCkCrksDTO> tCkCrks) throws Exception;

    /**
     * 查询sqlite主表信息
     *
     * @return
     */
    List<TSqliteFfVO> CrCrklist(String result) throws Exception;
    /**
     * 删除Oracle主表信息
     *
     * @return
     */
    void delete(TCkCrksDTO tCkCrks);

    /**
     * 修改出库回执查询
     *
     * @return
     */
    void updateTCkCrk(TCkCrkDTO tCkCrkDTO);
}
