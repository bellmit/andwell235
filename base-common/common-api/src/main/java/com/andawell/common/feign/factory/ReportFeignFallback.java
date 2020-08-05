package com.andawell.common.feign.factory;

import com.andawell.common.feign.ReportFeign;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author: yzy
 * @Description:
 * @Date: created in 2020/6/18 16:09
 */
@Component
@Slf4j
public class ReportFeignFallback implements ReportFeign {

    @Setter
    private Throwable cause;

    //    @Override
//    public String report(String filePath, String paramName,String paramValue) {
//        log.error("feign 调用showReport失败",cause);
//        return null;
//    }
    @Override
    public void index(String filePath, String paramName, String paramValue) {
        log.error("feign 调用showReport失败", cause);
    }
}
