package com.andawell.material.mapper;

import com.andawell.material.dto.TCkPglyqdDTO;
import com.andawell.material.entity.TCkPglyqd;
import com.andawell.material.query.TCkPglyqdQuery;
import com.andawell.material.vo.TCkPglyqdVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TCkPglyqdMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月15日 下午04:48:08
*/
public interface TCkPglyqdMapper {
    /**
     *
     * @mbg.generated 2020-05-15
     */
    int deleteByPrimaryKey(@Param("bh") String bh, @Param("jx") String jx, @Param("jh") String jh, @Param("xh") String xh, @Param("cxsgin") String cxsgin, @Param("dwid") String dwid, @Param("xz") String xz);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    int insert(TCkPglyqd record);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    int insertSelective(TCkPglyqd record);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    TCkPglyqd selectByPrimaryKey(@Param("bh") String bh, @Param("jx") String jx, @Param("jh") String jh, @Param("xh") String xh, @Param("cxsgin") String cxsgin, @Param("dwid") String dwid, @Param("xz") String xz);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    int updateByPrimaryKeySelective(TCkPglyqd record);

    /**
     *
     * @mbg.generated 2020-05-15
     */
    int updateByPrimaryKey(TCkPglyqd record);

    int updateByBhAndJhAndXhAndJx(TCkPglyqdDTO tCkPglyqdDTO);

    TCkPglyqd selectByJxAndJhAndCxsginAndDwidAndXz(@Param("jx") String jx, @Param("jh") String jh, @Param("xh") String xh, @Param("cxsgin") String cxsgin, @Param("dwid") String dwid, @Param("xz") String xz);

    List<TCkPglyqdVO> list(@Param("query")TCkPglyqdQuery tCkPglyqdQuery);

    List<TCkPglyqdVO> timeList(@Param("query")TCkPglyqdQuery tCkPglyqdQuery);
}