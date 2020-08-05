package com.andawell.common.log.event;

import com.andawell.upms.entity.LogInfo;
import com.andawell.upms.feign.RemoteLogService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

/**
 * @author dcy
 * 异步监听日志事件
 */
@AllArgsConstructor
public class SysLogListener {
    @Autowired
    private RemoteLogService remoteLogService;

    @Async
    @Order
    @EventListener(SysLogEvent.class)
    public void saveSysLog(SysLogEvent event) {
        LogInfo logInfo = event.getLogInfo();
        System.out.println("输出log对象" + logInfo.toString());
        remoteLogService.insert(logInfo);
    }
}
