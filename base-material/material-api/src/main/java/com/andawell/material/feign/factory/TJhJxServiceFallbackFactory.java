package com.andawell.material.feign.factory;/**
 * @Date： 2020/6/3 17:24
 */

import com.andawell.material.feign.CrKQdFeignService;
import com.andawell.material.feign.TJhJxFeignService;
import com.andawell.material.feign.fallback.CrkQdFeignFallbackImpl;
import com.andawell.material.feign.fallback.TJhJXFeignFallbackImpl;
import feign.hystrix.FallbackFactory;

/**
 *@Auther:liuys
 *@Date:2020/6/3 17:24
 *@Description:
 */
public class TJhJxServiceFallbackFactory implements FallbackFactory<TJhJxFeignService> {


    @Override
    public TJhJXFeignFallbackImpl create(Throwable throwable) {
        TJhJXFeignFallbackImpl brigadeApplyFallback = new TJhJXFeignFallbackImpl();
        brigadeApplyFallback.setCause(throwable);
        return brigadeApplyFallback;
    }
}
