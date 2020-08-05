package com.andawell.material.mapper;

import com.andawell.material.entity.TJhJxjh;
import com.andawell.material.query.TJhJxJhQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
* @ClassName: TJhJxjhMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月09日 上午11:30:44
*/
public interface TJhJxjhMapper {



    /**
     *根据机型删除件号
     * */
    void delete(String jx);

    /**
     *添加机型件号
     * */
    void insert(TJhJxjh tJhJxjh);

    /**
     * 批量插入
     * @param list
     */
    void insertAll(List<TJhJxjh> list);

    /**
     *根据机型件号删除
     * */
    void deleteByPrimaryKey(@Param("jx") String jx, @Param("jh") String oneJh);

    /**
     *编辑单机件号安装数量
     * */
    void updatedjazs(TJhJxjh tJhJxjh);

    /**
     * 获取单机安装数
     * @param tJhJxJhQuery
     * @return
     */
    Integer selectByCount(TJhJxJhQuery tJhJxJhQuery);
}