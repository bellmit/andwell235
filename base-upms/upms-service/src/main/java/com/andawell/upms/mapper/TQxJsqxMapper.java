package com.andawell.upms.mapper;



import com.andawell.upms.entity.TQxJsqx;
import com.andawell.upms.query.TQxJsqxQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: TQxJsqxMapper
 * @Description:
 * @author: Mybatis Generator
 * @date 2020年05月13日 上午09:38:54
 */
public interface TQxJsqxMapper {

    /**
     * @mbg.generated 2020-05-13
     */
    int deleteByPrimaryKey(@Param("js") String js, @Param("zy") String zy);

    /**
     * @mbg.generated 2020-05-13
     */
    int insert(TQxJsqx record);

    /**
     * @mbg.generated 2020-05-13
     */
    int insertSelective(TQxJsqx record);

    /**
     * @mbg.generated 2020-05-13
     */
    TQxJsqx selectByPrimaryKey(@Param("js") String js, @Param("zy") String zy);


    /**
     * @mbg.generated 2020-05-13
     */
    int updateByPrimaryKeySelective(TQxJsqx record);

    /**
     * @mbg.generated 2020-05-13
     */
    int updateByPrimaryKey(TQxJsqx record);


    /***
     * @author gzh
     * @Date: 2020/4/28 14:36
     * @Description: 角色权限查询接口
     */
    String[] list(@Param("query") TQxJsqxQuery query);

    /***
     * @author gzh
     * @Date: 2020/4/28 14:36
     * @Description: 根据角色删除
     */
    void deleteByJs(String js);
}