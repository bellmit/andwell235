package com.andawell.material.mapper;

import com.andawell.material.dto.TJhJhDTO;
import com.andawell.material.entity.TJhJh;
import com.andawell.material.entity.TJhZl;
import com.andawell.material.entity.TXtJldw;
import com.andawell.material.query.TJhJhQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TJhJhMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年04月27日 下午06:19:17
*/
@Mapper
public interface TJhJhMapper {

    void deleteSqlLiteList();

    List<TJhJh> getSqlLiteList();

    int deleteByPrimaryKey(String id);

    int insert(TJhJh record);

    int insertSelective(TJhJh record);

    TJhJh selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TJhJh record);

    int updateByPrimaryKeyWithBLOBs(TJhJh record);

    int updateByPrimaryKey(TJhJh record);

    /**
     * 查询件号儿
     *
     * @author lhb
     * @Date: 2020/4/26 17:21
     * @Description:
     * @version : V1.0
     * @param query
     */
    List<TJhJhDTO> list(@Param("query") Object query);
}