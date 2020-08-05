package com.andawell.material.mapper;

import com.andawell.material.dto.TCkSxXLNLDTO;
import com.andawell.material.entity.TCkS;
import com.andawell.material.entity.TCkSx;
import com.andawell.material.entity.response.TCkSxBO;
import com.andawell.material.query.SummaryQuery;
import com.andawell.material.query.TCkSxQuery;
import com.andawell.material.vo.TcksxXLNLTJVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
* @ClassName: TCkSxMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月03日 上午09:54:53
*/
@Mapper
public interface TCkSxMapper {

    /**
     *
     * @mbg.generated 2020-05-03
     */
    int deleteByPrimaryKey(@Param("bh") String bh,
                           @Param("jh") String jh,
                           @Param("xh") String xh,
                           @Param("dwid") String dwid,
                           @Param("jx") String jx,
                           @Param("xz") String xz);

    /**
     * 送修数据统计
     * @return
     */
     List<Map> getStatisticsUnderRepairList(SummaryQuery summaryQuery);

    /**
     *
     * @mbg.generated 2020-05-03
     */
    int insert(TCkSx record);

    /**
     *
     * @mbg.generated 2020-05-03
     */
    void insertcksx(TCkS record);

    /**
     *
     * @mbg.generated 2020-05-03
     */
    int insertSelective(TCkSx record);


    /**
     *
     * @mbg.generated 2020-05-03
     */
    TCkSx selectByPrimaryKey(@Param("bh") String bh,
                             @Param("jh") String jh,
                             @Param("xh") String xh,
                             @Param("dwid") String dwid,
                             @Param("jx") String jx,
                             @Param("xz") String xz);

    /**
     *
     * @mbg.generated 通过处理编号查询
     */
    TCkSx selectByPrimaryClBh(@Param("bh") String bh,
                             @Param("jh") String jh,
                             @Param("xh") String xh,
                             @Param("dwid") String dwid,
                             @Param("jx") String jx,
                             @Param("xz") String xz);



    /**
     *
     * @mbg.generated 2020-05-03
     */
    int updateByPrimaryKeySelective(TCkSx record);

    /**
     *
     * @mbg.generated 2020-05-03
     */
    int updateByPrimaryKey(TCkSx record);

    /**
     * 根据条件查询送修记录列表
     * @param tCkSxQuery
     * @return
     */
    List<TCkSxBO> repairReturn(TCkSxQuery tCkSxQuery);

    /**
     *
     * @param tCkSxQuery
     * @return
     */
    List<TCkSxBO> repairRetreat(TCkSxQuery tCkSxQuery);


    TCkSx selectQueryOne(TCkSx record);


    Integer selectByCount(TCkSxQuery tCkSxQuery);
    /**
     *
     * @param 数据全查，用于数据导出使用
     * @return
     */
    List<TCkS> select();


    void deleteCksx(String dwid);

    List<TCkSx> getSqlLiteList();

    /**
     * 查询修理能力明细
     * @param tCkSxXLNLQuery
     * @return
     */
//    List<TcksxXLNLMXVO> selectXLNLMX(TCkSxXLNLQuery tCkSxXLNLQuery);

    /**
     * 查询所有的承修商
     * @return
     */
    List<TCkSxXLNLDTO> getList();

    /**
     * 查询修理能力数据
     * @return
     */
    List<TcksxXLNLTJVO> getXLNLListData(@Param("jx") String jx,@Param("jh") String jh);

}