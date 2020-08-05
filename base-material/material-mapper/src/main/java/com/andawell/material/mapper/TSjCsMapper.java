package com.andawell.material.mapper;

import com.andawell.material.entity.TSjCs;
import com.andawell.material.entity.TSjCs;
import com.andawell.material.vo.TSjCsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TSjCsMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月10日 下午02:11:50
*/
public interface TSjCsMapper {
    /**
     *
     * @mbg.generated 2020-06-10
     */
    long countByExample(TSjCs example);

    /**
     *
     * @mbg.generated 2020-06-10
     */
    int deleteByExample(TSjCs example);

    /**
     *
     * @mbg.generated 2020-06-10
     */
    int insert(TSjCs record);

    /**
     *
     * @mbg.generated 2020-06-10
     */
    int insertSelective(TSjCs record);

    /**
     *
     * @mbg.generated 2020-06-10
     */
    List<TSjCs> selectByExample(TSjCs example);

    /**
     *
     * @mbg.generated 2020-06-10
     */
    int updateByExampleSelective(@Param("record") TSjCs record, @Param("example") TSjCs example);

    /**
     *
     * @mbg.generated 2020-06-10
     */
    int updateByExample(@Param("record") TSjCs record, @Param("example") TSjCs example);

    List<TSjCsVO> cslist();

    List<TSjCs> list();


}