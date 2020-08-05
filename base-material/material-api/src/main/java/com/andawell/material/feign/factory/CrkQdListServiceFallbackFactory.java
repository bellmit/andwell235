package com.andawell.material.feign.factory;/**
 * @Date： 2020/6/3 17:24
 */

import com.andawell.material.feign.BrigadeApplyService;
import com.andawell.material.feign.CrKQdFeignService;
import com.andawell.material.feign.fallback.BrigadeApplyFallbackImpl;
import com.andawell.material.feign.fallback.CrkQdFeignFallbackImpl;
import feign.hystrix.FallbackFactory;

/**
 *@Auther:liuys
 *@Date:2020/6/3 17:24
 *@Description:
 */
public class CrkQdListServiceFallbackFactory implements FallbackFactory<CrKQdFeignService> {


    @Override
    public CrkQdFeignFallbackImpl create(Throwable throwable) {
        CrkQdFeignFallbackImpl brigadeApplyFallback = new CrkQdFeignFallbackImpl();
        brigadeApplyFallback.setCause(throwable);
        return brigadeApplyFallback;
    }
}
