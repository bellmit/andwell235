package com.andawell.material.feign;

import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.feign.factory.BrigadeApplyServiceFallbackFactory;
import com.andawell.material.vo.StockVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Date： 2020/6/3 16:38
 */
@Component
@FeignClient(value = "material-service", fallbackFactory = BrigadeApplyServiceFallbackFactory.class)
public interface BrigadeApplyService {

    /**获取库存统计数量
     *@Author: liuys
     *@Data: 2020/6/3
     *@Description:
     */
    @RequestMapping(value = "sys/brigade/apply/get/statistics")
    RestResultVo<StockVO> getStatistics(@RequestParam("jx") String jx, @RequestParam("jh") String jh);
}
