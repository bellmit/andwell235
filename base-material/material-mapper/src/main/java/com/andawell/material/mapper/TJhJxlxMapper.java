package com.andawell.material.mapper;


import com.andawell.material.entity.TJhJxlx;
import com.andawell.material.entity.TXtJldw;
import com.andawell.material.query.TJhJxlxQuery;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
* @ClassName: TJhJxlxMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月11日 下午05:55:59
*/
public interface TJhJxlxMapper {


    void deleteSqlLiteList();

    List<TJhJxlx> getSqlLiteList();
    /**
     *
     * @mbg.generated 2020-05-11
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2020-05-11
     */
    int insert(TJhJxlx record);

    /**
     *
     * @mbg.generated 2020-05-11
     */
    int insertSelective(TJhJxlx record);



    /**
     *
     * @mbg.generated 2020-05-11
     */
    TJhJxlx selectByPrimaryKey(String id);





    /**
     *
     * @mbg.generated 2020-05-11
     */
    int updateByPrimaryKeySelective(TJhJxlx record);

    /**
     *
     * @mbg.generated 2020-05-11
     */
    int updateByPrimaryKey(TJhJxlx record);

    /**
     *机型类型查询
     * @mbg.generated 2020-05-11
     */
    List<TJhJxlx> list(@Param("query") TJhJxlxQuery query);

    String getMaxId();

    TJhJxlx getByMc(String mc);

}