package com.andawell.material.feign.factory;/**
 * @Date： 2020/6/3 17:24
 */

import com.andawell.material.feign.BrigadeApplyService;
import com.andawell.material.feign.fallback.BrigadeApplyFallbackImpl;
import feign.hystrix.FallbackFactory;

/**
 *@Auther:liuys
 *@Date:2020/6/3 17:24
 *@Description:
 */
public class BrigadeApplyServiceFallbackFactory implements FallbackFactory<BrigadeApplyService> {


    @Override
    public BrigadeApplyService create(Throwable throwable) {
        BrigadeApplyFallbackImpl brigadeApplyFallback = new BrigadeApplyFallbackImpl();
        brigadeApplyFallback.setCause(throwable);
        return brigadeApplyFallback;
    }
}
