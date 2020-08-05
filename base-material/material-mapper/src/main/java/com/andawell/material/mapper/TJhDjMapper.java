package com.andawell.material.mapper;

import com.andawell.material.entity.TJhDj;
import com.andawell.material.vo.TJhDjVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: TJhDjMapper
 * @Description:
 * @author: Mybatis Generator
 * @date 2020年05月15日 上午11:51:58
 */
public interface TJhDjMapper {

    int deleteByPrimaryKey(@Param("jh") String jh, @Param("jx") String jx);


    int insertSelective(TJhDj tJhDj);


    List<TJhDjVO> list(@Param("query") Object query);

    int deleteByPrimaryKey(@Param("jh") String jh);
}