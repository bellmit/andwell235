package com.andawell.purchase.mapper;

import com.andawell.purchase.entity.TDhJhqd;
import com.andawell.purchase.query.TDhJhqdQuery;
import com.andawell.purchase.vo.TDhJhqdVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TDhJhqdMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月02日 上午10:38:57
*/
public interface TDhJhqdMapper {
    /**
     *
     * @mbg.generated 2020-06-02
     */
    int deleteByPrimaryKey(@Param("bh") String bh, @Param("jx") String jx, @Param("jh") String jh, @Param("qclx") String qclx);


    /**
     * 物理删除计划编号
     * @param jhBh
     * @return
     */
    int deleteByJhBh(String jhBh);

    /**
     *
     * @mbg.generated 2020-06-02
     */
    int insert(TDhJhqd record);

    /**
     *
     * @mbg.generated 2020-06-02
     */
    int insertSelective(TDhJhqd record);

    /**
     *
     * @mbg.generated 2020-06-02
     */
    TDhJhqd selectByPrimaryKey(@Param("bh") String bh, @Param("jx") String jx, @Param("jh") String jh);

    /**
     *
     * @mbg.generated 2020-06-02
     */
    int updateByPrimaryKeySelective(TDhJhqd record);

    /**
     *
     * @mbg.generated 2020-06-02
     */
    int updateByPrimaryKey(TDhJhqd record);

    /**
     * 查询按照条件对象查询
     * @param query
     * @return
     */
    List<TDhJhqdVO> list(TDhJhqdQuery query);


    /**
     * 只做查询
     * @param bh
     * @return
     */
    List<TDhJhqd> getList(String bh);

    int updateByBh(@Param("bh") String bh, @Param("status") Integer status);

}