package com.andawell.auth.fallback;

import com.andawell.auth.RemoteLoginTokenService;
import com.andawell.common.entity.vo.RestResultVo;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author dcy
 * @date 2019/4/22
 */
@Component
public class RemoteLoginTokenServiceFallbackImpl implements RemoteLoginTokenService {
    private final static Logger logger = LoggerFactory.getLogger(RemoteLoginTokenServiceFallbackImpl.class);
    @Setter
    private Throwable cause;

    @Override
    public RestResultVo<Boolean> loginLimit(String username) {
        return null;
    }

    @Override
    public RestResultVo<Boolean> loginRemoveTokenByUsername(String nameCode) {
        return null;
    }
}
