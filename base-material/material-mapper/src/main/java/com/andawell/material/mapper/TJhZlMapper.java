package com.andawell.material.mapper;

import com.andawell.material.entity.TJhZl;
import com.andawell.material.entity.TXtCk;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TJhZlMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年04月27日 下午03:31:13
*/
@Mapper
public interface TJhZlMapper {
    int deleteByPrimaryKey(String id);

    int insert(TJhZl record);

    int insertSelective(TJhZl record);

    TJhZl selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TJhZl record);

    int updateByPrimaryKey(TJhZl record);
    /**
     * 条件查询质量等级
     *
     * @author lhb
     * @Date: 2020/4/26 17:21
     * @Description:
     * @version : V1.0
     * @param query
     */
    List<TJhZl> list(@Param("query") Object query);

}