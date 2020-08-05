package com.andawell.material.mapper;

import com.andawell.material.entity.PKCX;
import com.andawell.material.query.PKCXQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: yzy
 * @Description:
 * @Date: created in 2020/5/21 13:42
 */
@Mapper
public interface PKCXMapper {

    /**
     *  盘库查询
     * @param pkcxQuery  导出日期
     * @return
     */
    List<PKCX> list(@Param("pkcxQuery") PKCXQuery pkcxQuery);

}
