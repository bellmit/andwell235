package com.andawell.material.mapper;

import com.andawell.material.entity.TTzzCk;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TTzzCkMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月15日 上午10:11:18
*/
public interface TTzzCkMapper {

    /**
     *
     * @mbg.generated 2020-05-15
     */
    int deleteByPrimaryKey(@Param("jh") String jh, @Param("xh") String xh);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    int insert(TTzzCk record);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    int insertSelective(TTzzCk record);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    TTzzCk selectByPrimaryKey(@Param("jh") String jh, @Param("xh") String xh);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    int updateByPrimaryKeySelective(TTzzCk record);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    int updateByPrimaryKey(TTzzCk record);

    List<String> listJhAndXh();

    String getSl(String jh, String xh);

    void insertAll(List<TTzzCk> tTzzCkList);


}