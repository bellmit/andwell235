package com.andawell.material.mapper;

import com.andawell.material.entity.TDbLtsq;
import com.andawell.material.entity.TDbLtsqqd;
import com.andawell.material.query.TDbLtsqQuery;
import com.andawell.material.query.TDbLtsqqdQuery;
import com.andawell.material.vo.TDbLtsqqdMessageVO;
import com.andawell.material.vo.TDbLtsqqdVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: TDbLtsqqdMapper
 * @Description:
 * @author: Mybatis Generator
 * @date 2020年05月13日 上午10:03:54
 */
public interface TDbLtsqqdMapper {


    List<TDbLtsqqd> list(@Param("query") TDbLtsqQuery tDbLtsqQuery);

    /**
     * 战区调拨明细查询
     * @param bh
     * @return
     */
    List<TDbLtsqqdMessageVO> getlist(@Param("bh") String bh);

    void insertSelective(TDbLtsqqd tDbLtsqqd);

    List<TDbLtsqqd> getGrundist(@Param("query") Object query);

    int updateByPrimaryKeySelective(TDbLtsqqd record);

    List<TDbLtsqqd> BoxList(@Param("query") Object query);

    List<TDbLtsqqdVO> smList(TDbLtsqqdQuery q);

    Integer qx();

    List<TDbLtsqqd> selectByQuery(@Param("query") TDbLtsqqdQuery query);
}