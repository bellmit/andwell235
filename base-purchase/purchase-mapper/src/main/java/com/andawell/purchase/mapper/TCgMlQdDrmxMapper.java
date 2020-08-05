package com.andawell.purchase.mapper;


import com.andawell.purchase.entity.TCgMlQdDrmx;

import java.math.BigDecimal;

/**
* @ClassName: TCgMlQdDrmxMapper
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月06日 下午04:09:49
*/
public interface TCgMlQdDrmxMapper {

    /**
     *
     * @mbg.generated 2020-06-06
     */
    int insert(TCgMlQdDrmx record);

    /**
     *
     * @mbg.generated 2020-06-06
     */
    int insertSelective(TCgMlQdDrmx record);

    /**
     * 机型名称反查机型id
     */
    String selectIdByMc(String mc);
    /**
     * 器材类型名称反查器材id
     */
    String selectIdByQcmc(String mc);
    /**
     * 价格类型名称反查价格类型id
     */
    String selectJgIdByMc(String mc);
    /**
     * 监管单位名称反查监管单位id
     */
    String selectJgfIdByMc(String jgDw);
    /**
     * 全部删除
     */
    void deleteAll();
    /**
     * 币种名称反查币种汇率
     */
    BigDecimal selectHlByMC(String bzlb);


    String bzlbByMc(String bzlb);
    /**
     * 厂家名称反查厂家id
     */
    String selectCjByMc(String cj);
}