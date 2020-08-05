package com.andawell.material.mapper;


import com.andawell.material.entity.THtDh;
import com.andawell.material.entity.THtDhqd;
import com.andawell.material.entity.response.THtDhqdBO;
import com.andawell.material.query.THtDhqdQuery;
import com.andawell.material.vo.THtDhqdVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: THtDhqdMapper
 * @Description:
 * @author: Mybatis Generator
 * @date 2020年04月28日 下午04:11:10
 */
@Mapper
public interface THtDhqdMapper {


    /**
     * @mbg.generated 2020-04-28
     */
    int insert(THtDhqd record);

    /**
     * 查询主键位置
     * @param htbh
     * @param jx
     * @param jh
     * @return
     */
    THtDhqd selectByPrimaryKey(@Param("htbh") String htbh,
                                 @Param("jx") String jx,
                                 @Param("jh") String jh);

    /**
     *
     * @mbg.generated 2020-04-28
     */
    int updateByPrimaryKeySelective(THtDhqd record);

    /**
     * @mbg.generated 2020-04-28
     */
    int insertSelective(THtDhqd record);


    /**
     * 根据合同id查询合同的详细信息
     *
     * @param tHtDhqdQuery
     * @return
     */
    List<THtDhqdVO> findDetailListByHtbh(@Param("query") THtDhqdQuery tHtDhqdQuery);

    int updeteSlByHtbhAndJxAndJh(@Param("addSl") Long addSl, @Param("htbh") String htbh, @Param("jx") String jx, @Param("jh") String jh);

    Integer selectByCount(@Param("jx") String jx, @Param("jh") String jh);
}