package com.andawell.upms.mapper;

import com.andawell.upms.entity.TXtDw;
import com.andawell.upms.entity.TXtZd;
import com.andawell.upms.query.TXtDwQuery;
import com.andawell.upms.query.TXtZdQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TXtZdMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月08日 下午05:09:02
*/

public interface TXtZdMapper {


    /**
     *
     * @mbg.generated 2020-05-08
     */
    int deleteByPrimaryKey(@Param("dwid") String dwid, @Param("zdid") String zdid);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int insert(TXtZd record);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int insertSelective(TXtZd record);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int updateByPrimaryKeySelective(TXtZd record);


    List<TXtZd> list(@Param("query") TXtZdQuery query);

    String getMaxZdid(String dwid);
}