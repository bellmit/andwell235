package com.andawell.upms.feign.fallback;

import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.upms.entity.LogInfo;
import com.andawell.upms.feign.RemoteLogService;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author dcy
 * @date 2019/4/22
 */
@Component
public class RemoteLogServiceFallbackImpl implements RemoteLogService {

    private final static Logger logger = LoggerFactory.getLogger(RemoteLogServiceFallbackImpl.class);
    @Setter
    private Throwable cause;

    /**
     * 保存日志
     *
     * @param logInfo 日志实体
     * @return success、false
     */
    @Override
    public RestResultVo insert(LogInfo logInfo) {
        logger.error("feign 插入日志失败", cause);
        return null;
    }

}
