package com.andawell.material.mapper;

import com.andawell.material.entity.TCkWjk;
import com.andawell.material.query.TCkWjkQuery;
import com.andawell.material.vo.TCkWjkVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TCkWjkMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月15日 下午03:44:37
*/
public interface TCkWjkMapper {
    /**
     *
     * @mbg.generated 2020-05-15
     */
    int deleteByPrimaryKey(@Param("dwid") String dwid, @Param("jx") String jx, @Param("jh") String jh, @Param("xh") String xh, @Param("zl") String zl, @Param("xz") String xz, @Param("bh") String bh);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    int insert(TCkWjk record);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    int insertSelective(TCkWjk record);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    TCkWjk selectByPrimaryKey(@Param("dwid") String dwid,
                              @Param("jx") String jx,
                              @Param("jh") String jh,
                              @Param("xh") String xh,
                              @Param("zl") String zl,
                              @Param("xz") String xz,
                              @Param("bh") String bh);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    int updateByPrimaryKeySelective(TCkWjk record);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    int updateByPrimaryKey(TCkWjk record);

    /**
     * 查询集合
     * @param query
     * @return
     */
    List<TCkWjkVO> getList(TCkWjkQuery query);
}