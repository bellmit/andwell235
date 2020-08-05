package com.andawell.material.mapper;

import com.andawell.material.entity.TWxNl;
import com.andawell.material.query.TWxNlQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TWxNlMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月09日 下午01:36:42
*/
public interface TWxNlMapper {


    /**
     *
     * @mbg.generated 2020-05-09
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2020-05-09
     */
    int insert(TWxNl record);

    /**
     *
     * @mbg.generated 2020-05-09
     */
    int insertSelective(TWxNl record);



    /**
     *
     * @mbg.generated 2020-05-09
     */
    TWxNl selectByPrimaryKey(Integer id);


    /**
     *
     * @mbg.generated 2020-05-09
     */
    int updateByPrimaryKeySelective(TWxNl record);

    /**
     *
     * @mbg.generated 2020-05-09
     */
    int updateByPrimaryKey(TWxNl record);

    int selectMaxId();

    TWxNl selectWxNl(@Param("jxId") String jxId,@Param("jhId")String jhId);

    /**
     *@Author: liuys
     *@Data: 2020/6/9
     *@Description: 根据条件查询信息
     */
    List<TWxNl> selectByQuery(@Param("query") TWxNlQuery tWxNlQuery);
}