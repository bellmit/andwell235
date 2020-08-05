package com.andawell.material.feign.fallback;/**
 * @Date： 2020/6/3 17:18
 */

import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.feign.CrKQdFeignService;
import com.andawell.material.vo.StockVO;
import com.andawell.material.vo.TCkCrkqdVO;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *@Auther:liuys
 *@Date:2020/6/3 17:18
 *@Description:
 */
@Component
@Slf4j
public class CrkQdFeignFallbackImpl implements CrKQdFeignService {

    @Setter
    private Throwable cause;



    /**
     * 获取库存统计数量
     *
     * @param bh
     * @Author: liuys
     * @Data: 2020/6/3
     * @Description:
     */
    @Override
    public RestResultVo<List<TCkCrkqdVO>> getListQdVO(String bh) {
        log.error("feign 查询清单失败", cause);
        return null;
    }
}
