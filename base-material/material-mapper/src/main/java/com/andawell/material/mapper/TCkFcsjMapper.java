package com.andawell.material.mapper;

import com.andawell.material.entity.TCkFcsj;
import com.andawell.material.query.TCkFcsjQuery;
import com.andawell.material.vo.TCkFcsjVO;
import org.apache.ibatis.annotations.Param;

import javax.management.Query;
import java.util.List;

/**
* @ClassName: TCkFcsjMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月08日 上午09:12:14
*/
public interface TCkFcsjMapper {
    /**
     *
     * @mbg.generated 2020-05-08
     */
    int deleteByPrimaryKey(@Param("bh") String bh, @Param("dwid") String dwid, @Param("jx") String jx, @Param("jh") String jh, @Param("xh") String xh, @Param("zl") String zl, @Param("xz") String xz);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int insert(TCkFcsj record);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int insertSelective(TCkFcsj record);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    TCkFcsj selectByPrimaryKey(@Param("bh") String bh, @Param("dwid") String dwid, @Param("jx") String jx, @Param("jh") String jh, @Param("xh") String xh, @Param("zl") String zl, @Param("xz") String xz);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int updateByPrimaryKeySelective(TCkFcsj record);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int updateByPrimaryKey(TCkFcsj record);

    /**
     * 获取对应条件的list  对象
     * @param tCkFcsjQuery
     * @return
     */
    List<TCkFcsjVO> list(@Param("query") TCkFcsjQuery tCkFcsjQuery);
}