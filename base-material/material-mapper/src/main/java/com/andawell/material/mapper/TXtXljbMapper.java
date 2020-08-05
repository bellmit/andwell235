package com.andawell.material.mapper;

import com.andawell.material.entity.TXtXljb;
import com.andawell.material.entity.TXtZd;
import com.andawell.material.query.TXtXljbQuery;
import com.andawell.material.query.TXtZdQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: TXtXljbMapper
 * @Description:
 * @author: Mybatis Generator
 * @date 2020年05月03日 上午10:00:28
 */
public interface TXtXljbMapper {

    /**
     * @mbg.generated 2020-05-03
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @mbg.generated 2020-05-03
     */
    int insert(TXtXljb record);

    /**
     * @mbg.generated 2020-05-03
     */
    int insertSelective(TXtXljb record);

    /**
     * @mbg.generated 2020-05-03
     */
    TXtXljb selectByPrimaryKey(Integer id);

    /**
     * @mbg.generated 2020-05-03
     */
    int updateByPrimaryKeySelective(TXtXljb record);

    /**
     * @mbg.generated 2020-05-03
     */
    int updateByPrimaryKey(TXtXljb record);


    List<TXtXljb> list(@Param("query")TXtXljbQuery query);
}