package com.andawell.purchase.mapper;

import com.andawell.purchase.entity.TDhLtxqTemp;
import com.andawell.purchase.query.TDhLtxqTempQuery;
import com.andawell.purchase.vo.TDhLtxqTempVO;

import java.util.List;

/**
* @ClassName: TDhLtxqTempMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月03日 下午02:33:10
*/
public interface TDhLtxqTempMapper {
    /**
     *
     * @mbg.generated 2020-06-03
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 根据编号删除Excel
     * @param bh
     * @return
     */
    int deleteBybh(String bh);

    /**
     *
     * @mbg.generated 2020-06-03
     */
    int insert(TDhLtxqTemp record);

    /**
     *
     * @mbg.generated 2020-06-03
     */
    int insertSelective(TDhLtxqTemp record);

    /**
     *
     * @mbg.generated 2020-06-03
     */
    TDhLtxqTemp selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2020-06-03
     */
    int updateByPrimaryKeySelective(TDhLtxqTemp record);

    /**
     *
     * @mbg.generated 2020-06-03
     */
    int updateByPrimaryKey(TDhLtxqTemp record);


    /**
     * 获取批量
     * @return
     */
    List<TDhLtxqTempVO> getList(TDhLtxqTempQuery tDhLtxqTempQuery);
}