package com.andawell.purchase.mapper;

import com.andawell.purchase.entity.TCgMl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: TCgMlMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月29日 下午03:37:01
*/
public interface TCgMlMapper {
    /**
     *
     * @mbg.generated 2020-05-29
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2020-05-29
     */
    int insert(TCgMl record);

    /**
     *
     * @mbg.generated 2020-05-29
     */
    int insertSelective(TCgMl record);

    /**
     *
     * @mbg.generated 2020-05-29
     */
    TCgMl selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2020-05-29
     */
    int updateByPrimaryKeySelective(TCgMl record);

    /**
     *
     * @mbg.generated 2020-05-29
     */
    int updateByPrimaryKey(TCgMl record);

    /**
     *修改生效状态1为失效状态2
     * @mbg.generated 2020-05-29
     */
    void sxStatus();
    /**
     *发布生效，生效状态修改为1
     * @mbg.generated 2020-05-29
     */
    void fbStatusById(Integer id);

    /**
     *判断id数据库是否存在
     * @mbg.generated 2020-05-29
     */
    int selectId(Integer id);

    /**
     * 获取目录编号
     * @param status
     * @return
     */
    List<String> listMlBhByStatus(@Param("status") int status);

    /**
     *根据id查询数据状态
     * @mbg.generated 2020-05-29
     */
    int selectStatusById(Integer id);
    String getMaxMlBh();

    /**
     * 获取最大 目录子版本
     * @param mlBb
     * @return
     */
    String getMaxMlZb(String mlBb);
    /**
     * 查询有几个状态为xiudingzhongd
     *
     */
    int isEdit();

    void updateXgrqByMlbh(String mlbh);
}