package com.andawell.material.mapper;

import com.andawell.material.entity.TDbJgdbqd;
import com.andawell.material.query.AllotQuery;
import com.andawell.material.query.TDbJgdbqdQuery;
import com.andawell.material.vo.TDbSjsqqdVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TDbJgdbqdMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月29日 上午08:38:39
*/
public interface TDbJgdbqdMapper {



    /**
     *
     * @mbg.generated 2020-05-29
     */
    int deleteByPrimaryKey(@Param("dbdh") String dbdh, @Param("jh") String jh, @Param("zl") String zl, @Param("jx") String jx);

    /**
     *
     * @mbg.generated 2020-05-29
     */
    int insert(TDbJgdbqd record);

    /**
     *
     * @mbg.generated 2020-05-29
     */
    int insertSelective(TDbJgdbqd record);



    /**
     *
     * @mbg.generated 2020-05-29
     */
    TDbJgdbqd selectByPrimaryKey(@Param("dbdh") String dbdh, @Param("jh") String jh, @Param("zl") String zl, @Param("jx") String jx);


    /**
     *
     * @mbg.generated 2020-05-29
     */
    int updateByPrimaryKeySelective(TDbJgdbqd record);

    /**
     *
     * @mbg.generated 2020-05-29
     */
    int updateByPrimaryKey(TDbJgdbqd record);

    List<TDbSjsqqdVO> list(@Param("sqdh")String sqdh);

    Integer getToteDBSL(@Param("query") AllotQuery allotQuery);

    List<TDbJgdbqd> selectByQuery(@Param("query")TDbJgdbqdQuery query);
}