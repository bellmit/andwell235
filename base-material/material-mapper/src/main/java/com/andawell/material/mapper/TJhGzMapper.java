package com.andawell.material.mapper;


import com.andawell.material.entity.TJhGz;
import com.andawell.material.query.TJhGzQuery;
import com.andawell.material.vo.TJhGzVO;
import com.andawell.material.vo.TSrJhGzVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TJhGzMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月18日 下午04:47:53
*/
public interface TJhGzMapper {
    /**
     *  关注信息插入
     * */
    int insertSelective(TJhGz tJhGz);
    /**
     *  关注信息删除
     * */
    int deleteByPrimaryKey(@Param ("jh") String jh);
    /**
     *  机关相关关注查询
     * */
    List<TJhGzVO> Organlist(@Param("query") Object query);
    /**
     *  旅团相关关注查询
     * */
    List<TJhGzVO> teamlist(@Param("query") Object query);
    /**
     *  私人件号关注
     * */
    List<TSrJhGzVO> srlist();
}