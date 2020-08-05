package com.andawell.upms.mapper;

import com.andawell.upms.entity.TXtJgf;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
* @ClassName: TXtJgfMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月27日 下午01:34:03
*/
public interface TXtJgfMapper {

    /**
     *
     * @mbg.generated 2020-05-27
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2020-05-27
     */
    int insert(TXtJgf record);

    /**
     *
     * @mbg.generated 2020-05-27
     */
    int insertSelective(TXtJgf record);

    /**
     *
     * @mbg.generated 2020-05-27
     */
    TXtJgf selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2020-05-27
     */
    int updateByPrimaryKeySelective(TXtJgf record);

    /**
     *
     * @mbg.generated 2020-05-27
     */
    int updateByPrimaryKey(TXtJgf record);

    String getMaxId();

    List<String> listMc(String mc);

    List<TXtJgf> list();

}