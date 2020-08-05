package com.andawell.purchase.mapper;

import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.purchase.entity.TCf;
import java.util.List;

import com.andawell.purchase.query.TCfQuery;
import com.andawell.purchase.vo.TCfVO;
import org.apache.ibatis.annotations.Param;

/**
* @ClassName: TCfMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月05日 下午05:56:11
*/
public interface TCfMapper {

    List<TCfVO> list(@Param("query") TCfQuery query);

}