package com.andawell.upms.mapper;

import com.andawell.upms.entity.LogInfo;
import com.andawell.upms.query.LogInfoQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LogInfoMapper {

    /**
     * 条件查询日志信息
     *
     * @param query
     * @return
     * @throws
     * @author dcy
     * @date 2019/1/7 13:56
     */
    public List<LogInfo> list(@Param("query") LogInfoQuery query);

    /**
     * 日志详情
     *
     * @param id
     * @throws
     * @return1
     * @author dcy
     * @date 2019/1/10 9:28
     */
    public LogInfo detail(int id);

    /**
     * 增加日志信息
     *
     * @param LogInfo
     * @return
     * @throws
     * @author dcy
     * @date 2019/1/7 13:56
     */
    public void insert(LogInfo LogInfo);

    /**
     * 修改日志信息
     *
     * @param LogInfo
     * @return
     * @throws
     * @author dcy
     * @date 2019/1/7 13:56
     */
    public void update(LogInfo LogInfo);

    /**
     * 删除日志信息（逻辑删除）
     *
     * @param LogInfo
     * @return
     * @throws
     * @author dcy
     * @date 2019/1/7 13:56
     */
    public void delete(LogInfo LogInfo);

}
