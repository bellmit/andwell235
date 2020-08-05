package com.andawell.purchase.mapper;

import com.andawell.purchase.entity.TCgMlQd;
import com.andawell.purchase.query.TCgMlQdQuery;
import com.andawell.purchase.vo.TCgMlQdVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TCgMlQdMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月29日 下午03:43:07
*/
public interface TCgMlQdMapper {
    /**
     *
     * @mbg.generated 2020-05-29
     */
    int deleteByPrimaryKey(Long id);


    /**
     *
     * @mbg.generated 2020-05-29
     */
    int insert(TCgMlQd record);

    /**
     *
     * @mbg.generated 2020-05-29
     */
    int insertSelective(TCgMlQd record);

    /**
     *
     * @mbg.generated 2020-05-29
     */
    TCgMlQd selectByPrimaryKey(Long id);


    /**
     *
     * 唯一索引来查询
     */
    TCgMlQd selectByUnique(@Param("mlbh") String mlbh,
                           @Param("jx") String jx,
                           @Param("jh") String jh );

    /**
     *
     * @mbg.generated 2020-05-29
     */
    int updateByPrimaryKeySelective(TCgMlQd record);

    /**
     *
     * @mbg.generated 2020-05-29
     */
    int updateByPrimaryKey(TCgMlQd record);


    /**
     * 集合查询
     * @param query
     * @return
     */
    List<TCgMlQdVO> list(@Param("query") TCgMlQdQuery query);

    /**
     * 查询目录清单明细
     * @param query
     * @return
     */
    List<TCgMlQd> listByMlBh(@Param("query") TCgMlQdQuery query);

}