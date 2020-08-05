package com.andawell.material.mapper;

import com.andawell.material.entity.TDbSjsqqdTemp;
import com.andawell.material.query.TDbLtsqQuery;
import com.andawell.material.query.TDbSjsqqdTempQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TDbSjsqqdTempMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月09日 下午04:51:19
*/
public interface TDbSjsqqdTempMapper {

    /**
     *
     * @mbg.generated 2020-06-09
     */
    int deleteByPrimaryKey(@Param("sqdh") String sqdh, @Param("jx") String jx, @Param("jh") String jh, @Param("zl") String zl, @Param("jsdw") String jsdw);

    int deleteBySQDH(@Param("sqdh") String sqdh);

    /**
     *
     * @mbg.generated 2020-06-09
     */
    int insert(TDbSjsqqdTemp record);

    /**
     *
     * @mbg.generated 2020-06-09
     */
    int insertSelective(TDbSjsqqdTemp record);

    /**
     *
     * @mbg.generated 2020-06-09
     */
    TDbSjsqqdTemp selectByPrimaryKey(@Param("sqdh") String sqdh, @Param("jx") String jx, @Param("jh") String jh, @Param("zl") String zl, @Param("jsdw") String jsdw);


    /**
     *
     * @mbg.generated 2020-06-09
     */
    int updateByPrimaryKeySelective(TDbSjsqqdTemp record);

    /**
     *
     * @mbg.generated 2020-06-09
     */
    int updateByPrimaryKey(TDbSjsqqdTemp record);

    List<TDbSjsqqdTemp> selectByQuery(@Param("query") TDbSjsqqdTempQuery query);

    void deleteAll();

    List<TDbSjsqqdTemp> getList(@Param("query") TDbLtsqQuery tDbLtsqQuery);
}