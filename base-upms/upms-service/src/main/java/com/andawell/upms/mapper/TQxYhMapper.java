package com.andawell.upms.mapper;


import com.andawell.upms.entity.TQxYh;
import com.andawell.upms.query.TQxYhQuery;
import org.apache.ibatis.annotations.Param;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @ClassName: TQxYhMapper
 * @Description:
 * @author: Mybatis Generator
 * @date 2020年05月08日 下午01:32:17
 */
public interface TQxYhMapper {

    /**
     * @mbg.generated 2020-05-08
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated 2020-05-08
     */
    int insert(TQxYh record);

    /**
     * @mbg.generated 2020-05-08
     */
    int insertSelective(TQxYh record);


    /**
     * @mbg.generated 2020-05-08
     */
    TQxYh selectByPrimaryKey(String id);

    /**
     * @Author 董重阳
     * 用户信息查询
     */
    public List<TQxYh> list(@Param("query") TQxYhQuery query);

    /**
     * @mbg.generated 2020-05-08
     */
    int updateByPrimaryKeySelective(TQxYh record);

    /**
     * @mbg.generated 2020-05-08
     */
    int updateByPrimaryKey(TQxYh record);

    /**
     * 登录名称判重接口
     */
    int DlmPc(String dlm);

    /**
     * 获取最大的用户id来生成身份id
     *
     * @param dw
     */
    String maxId(@Param("dw") String dw);
}