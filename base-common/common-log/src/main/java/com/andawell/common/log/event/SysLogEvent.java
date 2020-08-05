package com.andawell.common.log.event;

import com.andawell.upms.entity.LogInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 系统日志事件
 */
@Getter
@AllArgsConstructor
public class SysLogEvent {
	private LogInfo logInfo;
}
