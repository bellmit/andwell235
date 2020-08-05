package com.andawell.material.mapper;

import com.andawell.material.dto.TGzDhDTO;
import com.andawell.material.dto.TJhJhDTO;
import com.andawell.material.entity.TGzDh;
import com.andawell.material.entity.TJhJh;
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
public interface TGzDhMapper {

    void insert(TGzDh tGzDh);


    void updateByPrimaryKeySelective(TGzDh tGzDh);


    String maxId();
}