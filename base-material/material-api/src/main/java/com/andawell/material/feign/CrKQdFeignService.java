package com.andawell.material.feign;

import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.feign.factory.CrkQdListServiceFallbackFactory;
import com.andawell.material.vo.TCkCrkqdVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/***
 * @author lhb
 * @Date: 2020/6/10 9:48
 * @Description:
 * @version : V1.0
 */
@Component
@FeignClient(value = "material-service", fallbackFactory = CrkQdListServiceFallbackFactory.class)
public interface CrKQdFeignService {

    /**获取库存统计数量
     *@Author: liuys
     *@Data: 2020/6/3
     *@Description:
     */
    @RequestMapping(value = "sys/putInStorage/get/tckCrkList")
    RestResultVo<List<TCkCrkqdVO>> getListQdVO(@RequestParam("bh") String bh);

}
