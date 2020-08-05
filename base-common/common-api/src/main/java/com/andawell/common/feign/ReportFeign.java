package com.andawell.common.feign;

import com.andawell.common.feign.fallback.ReportFeignFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: yzy
 * @Description:
 * @Date: created in 2020/6/18 15:57
 */
@FeignClient(name = "report-service", fallbackFactory = ReportFeignFallbackFactory.class)
@Component
public interface ReportFeign {

//    @GetMapping("/sys/report/showReport")
//    String report(@RequestParam("filePath") String filePath,
//                  @RequestParam("paramName") String paramName,
//                  @RequestParam("paramValue") String paramValue);

    @RequestMapping("report/inner/forward")
    public void index(@RequestParam("filePath") String filePath,
                      @RequestParam("paramName") String paramName,
                      @RequestParam("paramValue")String paramValue) ;
}
