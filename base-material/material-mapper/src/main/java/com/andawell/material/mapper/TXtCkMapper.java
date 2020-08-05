package com.andawell.material.mapper;

import com.andawell.material.entity.CurrencyInfo;
import com.andawell.material.entity.TXtCk;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TXtCkMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年04月27日 下午02:20:15
*/
@Mapper
public interface TXtCkMapper {
    int deleteByPrimaryKey(@Param("dwid") String dwid, @Param("ckid") String ckid);

    int insert(TXtCk record);

    int insertSelective(TXtCk record);

    TXtCk selectByPrimaryKey(@Param("dwid") String dwid, @Param("ckid") String ckid);

    int updateByPrimaryKeySelective(TXtCk record);

    int updateByPrimaryKey(TXtCk record);

    /**
     * 条件查询仓库类别列表
     *
     * @author lhb
     * @Date: 2020/4/26 17:21
     * @Description:
     * @version : V1.0
     * @param query
     */
    List<TXtCk> list(@Param("query") Object query);
}