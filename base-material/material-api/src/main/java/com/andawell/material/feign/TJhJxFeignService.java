package com.andawell.material.feign;

import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.entity.TJhJx;
import com.andawell.material.feign.factory.TJhJxServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/***
 * @author lhb
 * @Date: 2020/6/15 10:02
 * @Description:
 * @version : V1.0
 */
@Component
@FeignClient(value = "material-service", fallbackFactory = TJhJxServiceFallbackFactory.class)
public interface TJhJxFeignService {

    /**获取库存统计数量
     *@Author: liuys
     *@Data: 2020/6/3
     *@Description:
     */
    @RequestMapping(value = "sys/tjhjx/getTJhJxById")
    RestResultVo<TJhJx> getTJhJxById(@RequestParam("jxId") String jxId);
}
