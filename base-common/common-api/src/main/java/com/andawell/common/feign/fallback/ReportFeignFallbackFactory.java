package com.andawell.common.feign.fallback;

import com.andawell.common.feign.ReportFeign;
import com.andawell.common.feign.factory.ReportFeignFallback;
import feign.hystrix.FallbackFactory;

/**
 * @Author: yzy
 * @Description:
 * @Date: created in 2020/6/18 16:12
 */
public class ReportFeignFallbackFactory implements FallbackFactory<ReportFeign> {

    @Override
    public ReportFeign create(Throwable throwable) {
        ReportFeignFallback reportFeign = new ReportFeignFallback();
        reportFeign.setCause(throwable);
        return reportFeign;
    }
}
