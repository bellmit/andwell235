package com.andawell.material.mapper;

import com.andawell.material.entity.TCkWsyf;
import com.andawell.material.query.TCkFcsjQuery;
import com.andawell.material.query.TCkWsyfQuery;
import com.andawell.material.vo.TCkFcsjVO;
import com.andawell.material.vo.TCkWsyfVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TCkWsyfMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月08日 下午04:35:57
*/
public interface TCkWsyfMapper {
    /**
     *
     * @mbg.generated 2020-05-08
     */
    int deleteByPrimaryKey(@Param("bh") String bh, @Param("jx") String jx, @Param("jh") String jh, @Param("xh") String xh, @Param("zl") String zl, @Param("xz") Short xz, @Param("dwid") String dwid);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int insert(TCkWsyf record);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int insertSelective(TCkWsyf record);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    TCkWsyf selectByPrimaryKey(@Param("bh") String bh, @Param("jx") String jx, @Param("jh") String jh, @Param("xh") String xh, @Param("zl") String zl, @Param("xz") Short xz, @Param("dwid") String dwid);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int updateByPrimaryKeySelective(TCkWsyf record);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int updateByPrimaryKey(TCkWsyf record);


    /**
     * 获取对应条件的list  对象
     * @param tCkWsyfQuery
     * @return
     */
    List<TCkWsyfVO> list(@Param("query") TCkWsyfQuery tCkWsyfQuery);
}