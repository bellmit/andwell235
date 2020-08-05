package com.andawell.material.mapper;

import com.andawell.material.entity.CurrencyInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * @author lhb
 * @Date: 2020/4/26 17:21
 * @Description:
 * @version : V1.0
 */
@Mapper
public interface CurrencyInfoMapper {
    /**
     * 条件查询账户权限信息
     *
     * @author lhb
     * @Date: 2020/4/26 17:21
     * @Description:
     * @version : V1.0
     * @param query
     */
    List<CurrencyInfo> list(@Param("query") Object query);
}
