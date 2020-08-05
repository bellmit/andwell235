package com.andawell.material.mapper;

import com.andawell.material.dto.TCkCrksDTO;
import com.andawell.material.entity.TCkCrk;
import com.andawell.material.entity.TSqliteFf;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
* @ClassName: TSqliteFfMapper
* @Description:
* @author: Mybatis Generator
* @date 2020年05月26日 下午01:40:36
*/
public interface TSqliteFfMapper {


    /**
     *
     * @mbg.generated 2020-05-26
     */
    int insertSelective(TSqliteFf tSqliteFf);

    /**
     * 查询列表
     * @param wh
     * @return
     */
    List<TSqliteFf> selectByWh(@Param("wh") String wh);

    /**
     * 删除主表信息 t_sqlite_ff
     * @mbg.generated 2020-05-28
     */
    void deleteFf();
    /**
     * 删除从表信息 t_sqlite_ffqd
     * @mbg.generated 2020-05-28
     */
    void deleteFfqd();

    /**
     *
     * @mbg.generated 2020-06-05
     */
    int deleteByPrimaryKey(String bh);

    int countBh(TSqliteFf tSqliteFf);
}