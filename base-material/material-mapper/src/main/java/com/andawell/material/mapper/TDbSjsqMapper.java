package com.andawell.material.mapper;

import com.andawell.material.entity.TDbDb;
import com.andawell.material.entity.TDbSjsq;
import com.andawell.material.query.TDbJgdbQuery;
import com.andawell.material.query.TDbSjsqQuery;
import com.andawell.material.vo.TDbSjsqVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TDbSjsqMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月29日 上午11:44:34
*/
public interface TDbSjsqMapper {

    List<TDbSjsq> list();

    TDbSjsq selectByNew(@Param("number") String number,@Param("type") String type);


    /**
     *
     * @mbg.generated 2020-05-29
     */
    int deleteByPrimaryKey(String sqdh);

    /**
     *
     * @mbg.generated 2020-05-29
     */
    int insert(TDbSjsq record);

    /**
     *
     * @mbg.generated 2020-05-29
     */
    int insertSelective(TDbSjsq record);



    /**
     *
     * @mbg.generated 2020-05-29
     */
    TDbSjsq selectByPrimaryKey(String sqdh);


    /**
     *
     * @mbg.generated 2020-05-29
     */
    int updateByPrimaryKeySelective(TDbSjsq record);

    /**
     *
     * @mbg.generated 2020-05-29
     */
    int updateByPrimaryKey(TDbSjsq record);

    List<TDbSjsq> selectByQuery(@Param("query") TDbSjsqQuery query);

}