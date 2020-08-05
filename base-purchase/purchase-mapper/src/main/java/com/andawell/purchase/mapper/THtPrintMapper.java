package com.andawell.purchase.mapper;

import com.andawell.purchase.dto.htprint.THtInfoDTO;
import com.andawell.purchase.dto.htprint.THtPrintDTO;
import com.andawell.purchase.dto.htprint.THtqdDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author: yzy
 * @Description:
 * @Date: created in 2020/6/9 13:35
 */
public interface THtPrintMapper {

    /**
     * 查询总体
     * @param hth
     * @param jhbh
     * @return
     */
    THtPrintDTO select(@Param("hth") String hth, @Param("jhbh") String jhbh);

    /**
     * 清单列表
     * @param hth
     * @param jhbh
     * @return
     */
    List<Map<String,String>> qdList(@Param("hth") String hth, @Param("jhbh") String jhbh);

    /**
     * 统计信息 查询总数量，总金额，清单列表数量
     * @param hth
     * @param jhbh
     * @return
     */
    THtInfoDTO info(@Param("hth") String hth, @Param("jhbh") String jhbh);
}
