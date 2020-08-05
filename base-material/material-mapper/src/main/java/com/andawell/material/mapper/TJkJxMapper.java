package com.andawell.material.mapper;

import com.andawell.material.entity.TJkJx;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
* @ClassName: TJkJxMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月22日 上午09:27:18
*/
public interface TJkJxMapper {

    /**
     *
     * @mbg.generated 2020-05-22
     */
    int deleteByPrimaryKey(String xbdh);

    /**
     *
     * @mbg.generated 2020-05-22
     */
    int insert(TJkJx record);

    /**
     *
     * @mbg.generated 2020-05-22
     */
    int insertSelective(TJkJx record);

    /**
     *
     * @mbg.generated 2020-05-22
     */
    TJkJx selectByPrimaryKey(String xbdh);

    /**
     *
     * @mbg.generated 2020-05-22
     */
    int updateByPrimaryKeySelective(TJkJx record);

    /**
     *
     * @mbg.generated 2020-05-22
     */
    int updateByPrimaryKey(TJkJx record);
}