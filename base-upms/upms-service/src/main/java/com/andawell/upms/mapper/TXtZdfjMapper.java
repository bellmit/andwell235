package com.andawell.upms.mapper;

import com.andawell.upms.entity.TXtZd;
import com.andawell.upms.entity.TXtZdfj;
import com.andawell.upms.entity.ZdfjDTO;
import com.andawell.upms.query.TXtZdQuery;
import com.andawell.upms.query.TXtZdfjQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TXtZdfjMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月08日 下午06:02:29
*/

public interface TXtZdfjMapper {


    /**
     *
     * @mbg.generated 2020-05-08
     */
    int insert(TXtZdfj record);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int insertSelective(TXtZdfj record);


    int delete(String mc);

    List<TXtZdfj> list(@Param("query") TXtZdfjQuery q);

    String getMaxMc();

    int update(@Param("zdfjDTO") ZdfjDTO zdfjDTO);
}