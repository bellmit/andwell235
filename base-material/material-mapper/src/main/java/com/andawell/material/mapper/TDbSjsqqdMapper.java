package com.andawell.material.mapper;

import com.andawell.material.entity.TDbJgdbqd;
import com.andawell.material.entity.TDbSjsqqd;
import com.andawell.material.query.TDbSjsqQuery;
import com.andawell.material.query.TDbSjsqqdQuery;
import com.andawell.material.vo.TDbSjsqqdVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TDbSjsqqdMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月29日 上午11:45:03
*/
public interface TDbSjsqqdMapper {


    List<TDbSjsqqd> list();

    /**
     *
     * @mbg.generated 2020-05-29
     */
    int deleteByPrimaryKey(@Param("sqdh") String sqdh, @Param("jx") String jx, @Param("jh") String jh, @Param("zl") String zl);

    /**
     *
     * @mbg.generated 2020-05-29
     */
    int insert(TDbSjsqqd record);

    /**
     *
     * @mbg.generated 2020-05-29
     */
    int insertSelective(TDbSjsqqd record);


    /**
     *
     * @mbg.generated 2020-05-29
     */
    TDbSjsqqd selectByPrimaryKey(@Param("sqdh") String sqdh, @Param("jx") String jx, @Param("jh") String jh, @Param("zl") String zl);


    /**
     *
     * @mbg.generated 2020-05-29
     */
    int updateByPrimaryKeySelective(TDbSjsqqd record);

    /**
     *
     * @mbg.generated 2020-05-29
     */
    int updateByPrimaryKey(TDbSjsqqd record);



    Integer getKC(@Param("jx") String jx, @Param("jh") String jh);

    List<TDbSjsqqd> selectByQuery(@Param("query") TDbSjsqqdQuery query);

}