package com.andawell.material.mapper;

import com.andawell.material.dto.TCkCrkqdsDTO;
import com.andawell.material.entity.TCkCrkqd;
import com.andawell.material.entity.TSqliteFfqd;
import com.andawell.material.query.TCkCrkqdIndexQuery;
import com.andawell.material.query.TCkCrkqdQuery;
import com.andawell.material.vo.IndexEcharsVO;
import com.andawell.material.vo.TCkCrkqdVO;
import com.andawell.material.vo.ZbKcVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TCkCrkqdMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月06日 下午04:28:25
*/
@Mapper
public interface TCkCrkqdMapper {
    /**
     *
     * @mbg.generated 2020-05-06
     */
    int deleteByPrimaryKey(@Param("bh") String bh, @Param("jx") String jx, @Param("jh") String jh, @Param("xh") String xh, @Param("cxsgin") String cxsgin, @Param("dwid") String dwid, @Param("xz") String xz);

    /**
     *
     * @mbg.generated 2020-05-06
     */
    int insert(TCkCrkqd record);

    /**
     *
     * @mbg.generated 2020-05-06
     */
    int insertSelective(TCkCrkqd record);

    /**
     *
     * @mbg.generated 2020-05-06
     */
    TCkCrkqd selectByPrimaryKey(@Param("bh") String bh,
                                @Param("jx") String jx,
                                @Param("jh") String jh,
                                @Param("xh") String xh,
                                @Param("cxsgin") String cxsgin,
                                @Param("dwid") String dwid,
                                @Param("xz") String xz);

    /**
     *
     * @mbg.generated 2020-05-06
     */
    int updateByPrimaryKeySelective(TCkCrkqd record);

    /**
     *
     * @mbg.generated 2020-05-06
     */
    int updateByPrimaryKey(TCkCrkqd record);

    /**
     * 根据条件查询清单
     * @param q
     * @return
     */
    List<TCkCrkqdVO> getList(TCkCrkqdQuery q);


    Integer selectByCount(TCkCrkqdQuery tCkCrkqdQuery);

    List<ZbKcVO> list(@Param("jh") String jh);

    /**
     * 发付导出明细查询
     * @mbg.generated 2020-05-06
     */
    List<TSqliteFfqd> select(@Param("bh") String bh);

    /**
     * 首页echars查询
     * @param tCkCrkqdIndexQuery
     * @return
     */
    List<IndexEcharsVO> selectCkEcharts(TCkCrkqdIndexQuery tCkCrkqdIndexQuery);
}