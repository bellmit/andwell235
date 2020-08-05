package com.andawell.material.mapper;


import com.andawell.material.entity.TXtCgf;
import org.apache.ibatis.annotations.Param;

/**
* @ClassName: TXtCgfMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月27日 下午01:55:05
*/
public interface TXtCgfMapper {


    /**
     *
     * @mbg.generated 2020-05-27
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated 2020-05-27
     */
    int insert(TXtCgf record);

    /**
     *
     * @mbg.generated 2020-05-27
     */
    int insertSelective(TXtCgf record);



    /**
     *
     * @mbg.generated 2020-05-27
     */
    TXtCgf selectByPrimaryKey(String id);



    /**
     *
     * @mbg.generated 2020-05-27
     */
    int updateByPrimaryKeySelective(TXtCgf record);

    /**
     *
     * @mbg.generated 2020-05-27
     */
    int updateByPrimaryKey(TXtCgf record);
    /**
     *
     * 查询bh
     */
    String Bh();

    /**
     *@Auther:gzh
     *@Date:2020/5/28 10:53
     *@Description: 单位名称判重
     */
    int selectDwmc(@Param("dwmc") String dwmc);
}