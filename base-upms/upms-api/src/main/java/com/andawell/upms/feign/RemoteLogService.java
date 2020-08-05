package com.andawell.upms.feign;

import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.upms.entity.LogInfo;
import com.andawell.upms.feign.factory.RemoteLogServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author dcy
 * @date 2019/4/22
 * @FeignClient 在@FeignClient注释中，String值（以上“存储”）是一个任意的客户端名称，用于创建Ribbon负载平衡器
 * name：指定FeignClient的名称
 * url一般用于调试，可以手动指定调用地址
 * decode404:当发生404错误时，该字段为true，调用decoder进行解码否则抛出FeignException异常
 * configuration：feign配置类
 * fallback：定义容错处理类
 * fallbackFactory：工厂类，用于生成fallback示例
 * path:定义当前FeignClient的统一前缀
 */
@Component
@FeignClient(value = "upms-service", fallbackFactory = RemoteLogServiceFallbackFactory.class)
public interface RemoteLogService {
    /**
     * 保存日志
     *
     * @param logInfo 日志实体
     * @return succes、false
     */
    @RequestMapping(value = "inner/sys/log/save", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
    RestResultVo insert(@RequestBody LogInfo logInfo);

}
