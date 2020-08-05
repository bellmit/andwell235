package com.andawell.upms.mapper;

import com.andawell.upms.entity.TQxJs;

import java.util.List;

/**
* @ClassName: TQxJsMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月13日 下午02:14:26
*/
public interface TQxJsMapper {

    /**
     *
     * @mbg.generated 2020-05-13
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2020-05-13
     */
    int insert(TQxJs record);

    /**
     *
     * @mbg.generated 2020-05-13
     */
    int insertSelective(TQxJs record);

    /**
     *
     * @mbg.generated 2020-05-13
     */
    TQxJs selectByPrimaryKey(String id);


    /**
     *
     * @mbg.generated 2020-05-13
     */
    int updateByPrimaryKeySelective(TQxJs record);

    /**
     *
     * @mbg.generated 2020-05-13
     */
    int updateByPrimaryKey(TQxJs record);

    /**
     *新增角色id判重
     */
    int selectById(String id);
    /**
     *获取最大的父级id
     */
    Integer maxFid();
    /**
     *获取最大的子级id
     */
    Integer selectIdByPid(String pid);

    List<TQxJs> selectByPidId(String id);
}