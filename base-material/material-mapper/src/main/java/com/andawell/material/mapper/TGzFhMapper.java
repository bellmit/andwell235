package com.andawell.material.mapper;

import com.andawell.material.dto.TGzFhDTO;
import com.andawell.material.entity.TGzDh;
import com.andawell.material.entity.TGzFh;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/***
 * @author shs
 * @Date: 2020/5/7 15:42
 * @Description:
 * @version : V1.0
 */
@Mapper
public interface TGzFhMapper {


    int insertSelective(TGzFh tGzFh);


    String maxId();

    void update(@Param("id") String id);
}