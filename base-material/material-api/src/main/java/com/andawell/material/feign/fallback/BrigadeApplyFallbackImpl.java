package com.andawell.material.feign.fallback;/**
 * @Date： 2020/6/3 17:18
 */

import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.feign.BrigadeApplyService;
import com.andawell.material.vo.StockVO;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 *@Auther:liuys
 *@Date:2020/6/3 17:18
 *@Description:
 */
@Component
@Slf4j
public class BrigadeApplyFallbackImpl implements BrigadeApplyService {

    @Setter
    private Throwable cause;


    /**
     * 获取库存统计数量
     *
     * @param jx
     * @param jh
     * @Author: liuys
     * @Data: 2020/6/3
     * @Description:
     */
    @Override
    public RestResultVo<StockVO> getStatistics(String jx, String jh) {
        log.error("feign 查询统计失败", cause);
        return null;
    }
}
