package com.andawell.material.mapper;

import com.andawell.material.entity.TDbDbqd;
import com.andawell.material.vo.TDbJgdbVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TDbDbqdMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月21日 下午05:27:34
*/
public interface TDbDbqdMapper {


    List<TDbJgdbVO> getUpAskList(@Param("jsdw") String jsdw, @Param("jx")String jx);

    Integer getToteDBSL(@Param("ffdw") String ffdw,@Param("jx")String jx,@Param("jh") String jh);

    Integer getDBSummber(@Param("sqdh")String sqdh,@Param("jx")String jx,@Param("jh")String jh,@Param("ffdw")String ffdw,@Param("jsdw")String jsdw);

    /**
     *
     * @mbg.generated 2020-05-21
     */
    int deleteByPrimaryKey(@Param("dbdh") String dbdh, @Param("jh") String jh, @Param("zl") String zl, @Param("jx") String jx);

    /**
     *
     * @mbg.generated 2020-05-21
     */
    int insert(TDbDbqd record);

    /**
     *
     * @mbg.generated 2020-05-21
     */
    int insertSelective(TDbDbqd record);



    /**
     *
     * @mbg.generated 2020-05-21
     */
    TDbDbqd selectByPrimaryKey(@Param("dbdh") String dbdh, @Param("jh") String jh, @Param("zl") String zl, @Param("jx") String jx);



    /**
     *
     * @mbg.generated 2020-05-21
     */
    int updateByPrimaryKeySelective(TDbDbqd record);

    /**
     *
     * @mbg.generated 2020-05-21
     */
    int updateByPrimaryKey(TDbDbqd record);
}