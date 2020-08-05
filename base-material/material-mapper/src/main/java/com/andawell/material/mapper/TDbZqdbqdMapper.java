package com.andawell.material.mapper;

import com.andawell.material.entity.TDbZqdbqd;
import com.andawell.material.query.AllotQuery;
import com.andawell.material.query.TSjSqQuery;
import com.andawell.material.vo.TDbJgdbVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TDbZqdbqdMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月30日 上午10:46:40
*/
public interface TDbZqdbqdMapper {



    List<TDbJgdbVO> getUpAskList(@Param("query") TSjSqQuery tSjSqQuery);

    Integer getToteDBSL(@Param("query")AllotQuery allotQuery);

    Integer getDBSummber(@Param("query")AllotQuery allotQuery);



    /**
     *
     * @mbg.generated 2020-05-30
     */
    int deleteByPrimaryKey(@Param("dbdh") String dbdh, @Param("jh") String jh, @Param("zl") String zl, @Param("jx") String jx);

    /**
     *
     * @mbg.generated 2020-05-30
     */
    int insert(TDbZqdbqd record);

    /**
     *
     * @mbg.generated 2020-05-30
     */
    int insertSelective(TDbZqdbqd record);


    /**
     *
     * @mbg.generated 2020-05-30
     */
    TDbZqdbqd selectByPrimaryKey(@Param("dbdh") String dbdh, @Param("jh") String jh, @Param("zl") String zl, @Param("jx") String jx);



    /**
     *
     * @mbg.generated 2020-05-30
     */
    int updateByPrimaryKeySelective(TDbZqdbqd record);

    /**
     *
     * @mbg.generated 2020-05-30
     */
    int updateByPrimaryKey(TDbZqdbqd record);

    Integer getIsExistByPrimaryKey(@Param("query")AllotQuery allotQuery);

}