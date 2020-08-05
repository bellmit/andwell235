package com.andawell.material.mapper;

import com.andawell.material.entity.TCkCrk;

import java.util.List;

import com.andawell.material.query.TCkCrkQuery;
import com.andawell.material.vo.TCkCrkVO;
import com.andawell.material.vo.TFfsjDcVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @ClassName: TCkCrkMapper
* @Description:
* @author: Mybatis Generator
* @date 2020年04月28日 上午09:36:47
*/
@Mapper
public interface TCkCrkMapper {


    /**
     *
     * @mbg.generated 2020-04-28
     */
    int deleteByPrimaryKey(@Param("bh") String bh, @Param("dwid") String dwid);

    /**
     *
     * @mbg.generated 2020-04-28
     */
    int insert(TCkCrk record);

    /**
     *
     * @mbg.generated 2020-04-28
     */
    int insertSelective(TCkCrk record);

    /**
     *
     * @mbg.generated 2020-04-28
     */
    TCkCrk selectByPrimaryKey(@Param("bh") String bh,
                              @Param("dwid") String dwid);


    /**
     * 查询列表
     * @param wh
     * @return
     */
    List<TCkCrk> selectByWh(@Param("wh") String wh);

    /**
     * 获取最新数据
     * @return
     */
    TCkCrk selectByNew(@Param("number") String number,@Param("wh") String wh);


    /**
     * 回执跟踪-出库回执跟踪
     * @shs 2020-05-09
     */
    int updateByPrimaryKeySelective(TCkCrk record);

    /**
     * 回执跟踪-出库回执跟踪
     * @shs 2020-05-09
     */
    int updateSelective(TCkCrk record);

    /**
     *
     * @mbg.generated 2020-04-28
     */
    int updateByPrimaryKey(TCkCrk record);

    /**
     * 根据条件查询
     * @param tCkCrkQuery
     * @return
     */
    List<TCkCrkVO> getList(TCkCrkQuery tCkCrkQuery);

    TCkCrk selectByYjrqOne();
    /**
     * 根据编号查询发付主信息
     * @param bh
     * @return
     */
    TFfsjDcVO select(@Param("bh") String bh);

    List<String> selectCkWh();

    List<String> selectRkWh();
}