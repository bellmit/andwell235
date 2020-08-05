package com.andawell.upms.mapper;

import com.andawell.upms.entity.SysAccountInfo;
import com.andawell.upms.query.SysAccountInfoQuery;
import com.andawell.upms.vo.SysAccountInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author DCY
 * 账户信息管理DAO层接口
 */
@Mapper
public interface SysAccountInfoMapper {
    /**
     * 账户列表信息查询Mapper
     *
     * @param query
     * @return
     */
    public List<SysAccountInfo> list(@Param("query") SysAccountInfoQuery query);

}