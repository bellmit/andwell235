package com.andawell.material.mapper;

import com.andawell.material.entity.TCkYfk;
import com.andawell.material.query.OutYFQuery;
import com.andawell.material.vo.TCkYfkVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
* @ClassName: TCkYfkMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月08日 下午04:56:49
*/
@Mapper
public interface TCkYfkMapper {



    /**
     *
     * @mbg.generated 2020-05-08
     */
    int deleteByPrimaryKey(@Param("bh") String bh, @Param("dwid") String dwid, @Param("jx") String jx, @Param("jh") String jh, @Param("xh") String xh, @Param("zl") String zl, @Param("xz") String xz);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int insert(TCkYfk record);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int insertSelective(TCkYfk record);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    TCkYfk selectByPrimaryKey(@Param("bh") String bh, @Param("dwid") String dwid, @Param("jx") String jx, @Param("jh") String jh, @Param("xh") String xh, @Param("zl") String zl, @Param("xz") String xz);





    List<TCkYfkVO> getOutYFList( OutYFQuery outYFQuery);


    /**
     *
     * @mbg.generated 2020-05-08
     */
    int updateByPrimaryKeySelective(TCkYfk record);

    /**
     *
     * @mbg.generated 2020-05-08
     */
    int updateByPrimaryKey(TCkYfk record);
}