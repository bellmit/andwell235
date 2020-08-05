package com.andawell.upms.feign.fallback;

import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.upms.dto.LoginAccountInfo;
import com.andawell.upms.entity.SysAccountInfo;
import com.andawell.upms.feign.RemoteAccountService;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author dcy
 * @date 2019/4/22
 */
@Component
public class RemoteAccountServiceFallbackImpl implements RemoteAccountService {
    private final static Logger logger = LoggerFactory.getLogger(RemoteAccountServiceFallbackImpl.class);
    @Setter
    private Throwable cause;

    /**
     * 通过用户名查询用户、角色信息
     *
     * @param username 用户名
     * @return R
     */
    @Override
    public RestResultVo<LoginAccountInfo> findAccountInfo(String username) {
        logger.error("feign 查询用户信息失败:{}", username, cause);
        return null;
    }

    @Override
    public SysAccountInfo findAccountInfoDetail(String username) {
        logger.error("feign 查询账户详细信息失败:{}", username, cause);
        return null;
    }

    @Override
    public SysAccountInfo findAccountInfoDetailById(String id) {
        logger.error("feign 查询账户详细信息失败:{}", id, cause);
        return null;
    }

    @Override
    public RestResultVo<List<String>> getRoleNuderModer(String js) {
        logger.error("feign 查询机型失败:{}", js, cause);
        return null;
    }

    @Override
    public RestResultVo<List<String>> getRoleNuderWarehouse(String js) {
        logger.error("feign 查询仓库失败:{}", js, cause);
        return null;
    }

}
