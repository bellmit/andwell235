package com.andawell.material.mapper;

import com.andawell.material.entity.TCfLb;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
* @ClassName: TCfLbMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月11日 上午09:45:23
*/
public interface TCfLbMapper {

    /**
     *
     * @mbg.generated 2020-05-11
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2020-05-11
     */
    int insert(TCfLb record);

    /**
     *
     * @mbg.generated 2020-05-11
     */
    int insertSelective(TCfLb record);

    /**
     *
     * @mbg.generated 2020-05-11
     */
    TCfLb selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2020-05-11
     */
    int updateByPrimaryKeySelective(TCfLb record);

    /**
     *
     * @mbg.generated 2020-05-11
     */
    int updateByPrimaryKey(TCfLb record);

    List<String> get2LengthId();

    String getMaxID(@Param("id") String id);

    List<TCfLb> getSqlLiteList();

    void deleteSqlLiteList();


    List<TCfLb> list();

    TCfLb getByMc(@Param("mc") String mc);
}