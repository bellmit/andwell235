package com.andawell.material.mapper;

import com.andawell.material.entity.TDbLtsq;
import com.andawell.material.entity.TGzFh;
import com.andawell.material.entity.TRyZw;
import com.andawell.material.query.AllotQuery;
import com.andawell.material.query.TDbLtsqQuery;
import com.andawell.material.vo.AllotAskDetailVO;
import com.andawell.material.vo.BursaryVO;
import com.andawell.material.vo.TDbLtsqVO;
import com.andawell.material.vo.TDbLtsqqdMessageVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TDbLtsqMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月13日 上午10:02:57
*/
public interface TDbLtsqMapper {

    List<TDbLtsq> list(@Param("query") AllotQuery allotQuery);

    List<BursaryVO> getBursary(@Param("dwid") String dwid,@Param("jx") String jx,@Param("jh") String jh);


    int insertSelective(TDbLtsq tDbLtsq);

    List<String> maxId();

    Integer XcMax();

    List<TDbLtsq> listjd(@Param("query") Object query);

    /**
     * 12
     * @param query
     * @return
     */
    Integer ky(@Param("query") Object query);

    /**
     * 21
     * @param query
     * @return
     */
    Integer dx(@Param("query") Object query);

    /**
     *  11
     * @param query
     * @return
     */
    Integer qx(@Param("query") Object query);

    /**
     * 0
     * @param query
     * @return
     */
    Integer zx(@Param("query") Object query);

    /**
     *@Author: liuys
     *@Data: 2020/5/26
     *@Description: 查询战区下旅团下的申请
     */
    List<TDbLtsqVO> getAllocationList(@Param("query") TDbLtsqQuery tDbLtsqQuery);

    /**
     *模糊查询最新的申请编号
     */
    TDbLtsq selectByLatest(@Param("query")TDbLtsqQuery query);

    int updateByPrimaryKeySelective(TDbLtsq record);

    List<TDbLtsq> selectByQuery(@Param("query")TDbLtsqQuery query);

}