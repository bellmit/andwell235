package com.andawell.material.mapper;

import com.andawell.material.entity.TSqliteFfqd;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
* @ClassName: TSqliteFfqdMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月26日 下午01:41:16
*/
public interface TSqliteFfqdMapper {
    /**
     *
     * @mbg.generated 2020-05-26
     */
    long countByExample(TSqliteFfqd example);

    /**
     *
     * @mbg.generated 2020-05-26
     */
    int deleteByExample(TSqliteFfqd example);

    /**
     *
     * @mbg.generated 2020-05-26
     */
    int deleteByPrimaryKey(@Param("bh") String bh);

    /**
     *
     * @mbg.generated 2020-05-26
     */
    int insert(TSqliteFfqd record);

    /**
     *
     * @mbg.generated 2020-05-26
     */
    int insertSelective(TSqliteFfqd record);

    /**
     *
     * @mbg.generated 2020-05-26
     */
    List<TSqliteFfqd> selectByExample(TSqliteFfqd example);

    /**
     *
     * @mbg.generated 2020-05-26
     */
    TSqliteFfqd selectByPrimaryKey(@Param("bh") String bh, @Param("jx") String jx, @Param("jh") String jh, @Param("xh") String xh, @Param("zl") String zl);

    /**
     *
     * @mbg.generated 2020-05-26
     */
    int updateByExampleSelective(@Param("record") TSqliteFfqd record, @Param("example") TSqliteFfqd example);

    /**
     *
     * @mbg.generated 2020-05-26
     */
    int updateByExample(@Param("record") TSqliteFfqd record, @Param("example") TSqliteFfqd example);

    /**
     *
     * @mbg.generated 2020-05-26
     */
    int updateByPrimaryKeySelective(TSqliteFfqd record);

    /**
     *
     * @mbg.generated 2020-05-26
     */
    int updateByPrimaryKey(TSqliteFfqd record);
}