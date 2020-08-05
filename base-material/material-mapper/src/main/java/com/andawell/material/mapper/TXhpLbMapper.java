package com.andawell.material.mapper;

import com.andawell.material.entity.TXhpLb;
import com.andawell.material.query.TXhpLbQuery;
import org.apache.ibatis.annotations.Param;

import javax.management.Query;
import java.util.List;

/**
 * @ClassName: TXhpLbMapper
 * @Description:
 * @author: Mybatis Generator
 * @date 2020年05月08日 下午04:48:24
 */
public interface TXhpLbMapper {

    /**
     * @mbg.generated 2020-05-08
     */
    int deleteByPrimaryKey(Short id);

    /**
     * @mbg.generated 2020-05-08
     */
    int insert(TXhpLb record);

    /**
     * @mbg.generated 2020-05-08
     */
    int insertSelective(TXhpLb record);


    /**
     * @mbg.generated 2020-05-08
     */
    TXhpLb selectByPrimaryKey(Short id);


    /**
     * @mbg.generated 2020-05-08
     */
    int updateByPrimaryKeySelective(TXhpLb record);

    /**
     * @mbg.generated 2020-05-08
     */
    int updateByPrimaryKey(TXhpLb record);

    /**
     * @Auther:gzh
     * @Date:2020/5/15 15:28
     * @Description: 五金类型模糊查询
     * @Param:
     * @return:
     */
    List<TXhpLb> list(@Param("query") Object query);
}