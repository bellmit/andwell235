package com.andawell.material.mapper;

import com.andawell.material.entity.TCkD;
import com.andawell.material.entity.TCkDx;
import com.andawell.material.query.NewPrpertoryCountQuery;
import com.andawell.material.query.SummaryQuery;
import com.andawell.material.query.TCkDxQuery;
import com.andawell.material.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TCkDxMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月06日 上午10:49:43
*/
@Mapper
public interface TCkDxMapper {


    /**
     *
     * @mbg.generated 2020-05-06
     */
    int deleteByPrimaryKey(@Param("bh") String bh, @Param("jh") String jh, @Param("xh") String xh, @Param("xz") String xz, @Param("jx") String jx, @Param("dwid") String dwid);

    /**
     *
     * @mbg.generated 2020-05-06
     */
    int insert(TCkDx record);

    /**
     *
     * 数据导入
     */
    void insertckdx(TCkD record);

    int insertSelective(TCkDx record);


    /**
     *
     * @mbg.generated 2020-05-06
     */
    TCkDx selectByPrimaryKey(@Param("bh") String bh,
                             @Param("jh") String jh,
                             @Param("xh") String xh,
                             @Param("xz") String xz,
                             @Param("jx") String jx,
                             @Param("dwid") String dwid);


    /**
     *
     * @mbg.generated 2020-05-06
     */
    int updateByPrimaryKeySelective(TCkDx record);

    /**
     *
     * @mbg.generated 2020-05-06
     */
    int updateByPrimaryKey(TCkDx record);

    /**
     * 条件查询待修改库中的数据
     */
    List<TCkDxStatusVO> list(@Param("query") TCkDxQuery tCkDxQuery);

    /**
     * 待修出库-待修库查询
     * @param tCkDxQuery
     * @return
     */
    List<TCkDxOutLibraryVO> outLibraryList(TCkDxQuery tCkDxQuery);


    List<TCkDxSendForRepairVO> getSendRepairList(TCkDxQuery tCkDxQuery);


    Integer selectByCount(TCkDxQuery tCkDxQuery);


    List<TCkD> select();

    void deleteCkdx(String dwid);


    int updateByStatusKey(TCkDx tCkDx);

    List<RepairKcMxVO> listMx(@Param("query") NewPrpertoryCountQuery query);

    SummaryVO getRepairedCount(@Param("query") SummaryQuery query);

    List<TCkDxVO> getStatistics(@Param("query") SummaryQuery query);

    Integer getRepairedStatistics(@Param("query")SummaryQuery query);
    /**
     *@Auther:gzh
     *@Date:2020/7/13 16:03
     *@Description: 库存查询-待修库存统计
     *@Param:
     *@return:
     */
    List<NewRepertoryCountVO> listTJ(@Param("query")NewPrpertoryCountQuery query);
    /**
     *@Auther:gzh
     *@Date:2020/7/13 16:03
     *@Description: 库存查询-待修库存统计总数
     *@Param:
     *@return:
     */
    String selectBySumZs(@Param("query")NewPrpertoryCountQuery query);
}