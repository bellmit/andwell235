package com.andawell.upms.mapper;


import com.andawell.upms.entity.TQxJx;
import com.andawell.upms.query.TQxJxQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TQxJxMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月14日 下午03:09:14
*/
public interface TQxJxMapper {


    /**
     *
     * @mbg.generated 2020-05-14
     */
    int deleteByPrimaryKey(@Param("js") String js, @Param("jx") String jx);

    /**
     *
     * @mbg.generated 2020-05-14
     */
    int insert(TQxJx record);

    /**
     *
     * @mbg.generated 2020-05-14
     */
    int insertSelective(TQxJx record);

    /**
     *根据js进行全部删除
     * @mbg.generated 2020-05-14
     */
    void deleteAllByJs(@Param("js") String js);


    /**
     *@Author: liuys
     *@Data: 2020/7/1
     *@Description: 根据条件
     */
    List<TQxJx> selectByQuery(@Param("query")TQxJxQuery tQxJxQuery);


    TQxJx selectByPrimaryKey(@Param("js")String js,@Param("jx")String jx);
}