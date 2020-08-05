package com.andawell.material.mapper;

import com.andawell.material.entity.TGzDh;
import com.andawell.material.entity.TGzHz;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/***
 * @author shs
 * @Date: 2020/5/7 15:42
 * @Description:
 * @version : V1.0
 */
@Mapper
public interface TGzHzMapper {
    int deleteByPrimaryKey(String id);

    int insert(TGzHz tGzHz);

    int insertSelective(TGzHz tGzHz);

    TGzHz selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TGzHz tGzHz);

    int updateByPrimaryKey(TGzDh tGzHz);

    String maxId();
}