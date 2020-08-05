package com.andawell.material.mapper;

import com.andawell.material.entity.TXhpCrkqd;

import org.apache.ibatis.annotations.Param;

/**
* @ClassName: TXhpCrkqdMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月07日 下午02:08:49
*/
public interface TXhpCrkqdMapper {

    /**
     *
     * @mbg.generated 2020-05-07
     */
    int deleteByPrimaryKey(@Param("bh") String bh, @Param("pch") String pch, @Param("mc") String mc, @Param("gg") String gg);

    /**
     *
     * @mbg.generated 2020-05-07
     */
    int insert(TXhpCrkqd record);

    /**
     *
     * @mbg.generated 2020-05-07
     */
    int insertSelective(TXhpCrkqd record);

    /**
     *
     * @mbg.generated 2020-05-07
     */
    TXhpCrkqd selectByPrimaryKey(@Param("bh") String bh, @Param("pch") String pch, @Param("mc") String mc, @Param("gg") String gg);

    /**
     *
     * @mbg.generated 2020-05-07
     */
    int updateByPrimaryKeySelective(TXhpCrkqd record);

    /**
     *
     * @mbg.generated 2020-05-07
     */
    int updateByPrimaryKey(TXhpCrkqd record);
    /**
     *@Auther:gzh
     *@Date:2020/5/18 14:54
     *@Description: 获取最大文号
     *@return: String
     * @param jm
     */
    String maxWh(@Param("jm")String jm);
    /**
     *@Auther:gzh
     *@Date:2020/5/18 15:10
     *@Description: 获取最大编号
     *@return: String
     * @param jm
     */
    String maxBh(@Param("jm") String jm);
}