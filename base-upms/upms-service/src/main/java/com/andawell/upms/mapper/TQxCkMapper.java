package com.andawell.upms.mapper;


import com.andawell.upms.entity.TQxCk;
import org.apache.ibatis.annotations.Param;
import com.andawell.upms.query.TQxCkQuery;
import java.util.List;

/**
* @ClassName: TQxCkMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月14日 上午11:10:44
*/
public interface TQxCkMapper {

    /**
     *
     * @mbg.generated 2020-05-14
     */
    int deleteByPrimaryKey(@Param("js") String js, @Param("dwid") String dwid, @Param("ckid") String ckid);

    /**
     *
     * @mbg.generated 2020-05-14
     */
    int insert(TQxCk record);

    /**
     *
     * @mbg.generated 2020-05-14
     */
    int insertSelective(TQxCk record);

    /***
     * @author gzh
     * @Date: 2020/4/28 14:36
     * @Description:根据角色全部删除
     */
    void deleteByJs(String js);

    /**
     * 批量插入
     * @param list
     */
    void insertAll(List<TQxCk> list);


    /**
     *@Author: liuys
     *@Data: 2020/7/3
     *@Description:
     */
    List<TQxCk> list(@Param("query")TQxCkQuery tQxCkQuery);
}