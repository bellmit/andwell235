package com.andawell.material.mapper;

import com.andawell.material.entity.TZclhHbjl;
import java.util.List;

import com.andawell.material.query.RotateQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TZclhHbjlMapper
 * @Description:
 * @author: Mybatis Generator
 * @date 2020年04月29日 上午11:48:51
 */
@Mapper
public interface TZclhHbjlMapper {

    /**
     *
     * @mbg.generated 2020-05-21
     */
    int deleteByPrimaryKey(@Param("bh") String bh, @Param("lhdw") String lhdw, @Param("jx") String jx, @Param("jh") String jh, @Param("xh") String xh, @Param("zl") String zl, @Param("xz") String xz);


    /**
     * @mbg.generated 2020-04-29
     */
    int insert(TZclhHbjl record);

    /**
     * @mbg.generated 2020-04-29
     */
    int insertSelective(TZclhHbjl record);

    /**
     * @mbg.generated 2020-04-29
     */
    List<TZclhHbjl> selectByCondition(RotateQuery query);

    /**
     * @mbg.generated 2020-04-29
     */
    /**
     *
     * @mbg.generated 2020-05-21
     */
    TZclhHbjl selectByPrimaryKey(@Param("bh") String bh,
                                 @Param("lhdw") String lhdw,
                                 @Param("jx") String jx,
                                 @Param("jh") String jh,
                                 @Param("xh") String xh,
                                 @Param("zl") String zl,
                                 @Param("xz") String xz);

    /**
     * 根据轮换入库bh 查询数据
     * @param bh
     * @param lhdw
     * @param jx
     * @param jh
     * @param xh
     * @param zl
     * @param xz
     * @return
     */
    TZclhHbjl selectByPrimaryKeyRkBh(@Param("bh") String bh,
                                 @Param("lhdw") String lhdw,
                                 @Param("jx") String jx,
                                 @Param("jh") String jh,
                                 @Param("xh") String xh,
                                 @Param("zl") String zl,
                                 @Param("xz") String xz);

    /**
     * @mbg.generated 2020-04-29
     */
    int updateByPrimaryKeySelective(TZclhHbjl record);

    /**
     * @mbg.generated 2020-04-29
     */
    int updateByPrimaryKey(TZclhHbjl record);
}