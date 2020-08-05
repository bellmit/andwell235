package com.andawell.upms.feign;

import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.upms.dto.LoginAccountInfo;
import com.andawell.upms.entity.SysAccountInfo;
import com.andawell.upms.feign.factory.RemoteAccountServiceFallbackFactory;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author dcy
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
@FeignClient(value = "upms-service", fallbackFactory = RemoteAccountServiceFallbackFactory.class)
public interface RemoteAccountService {
    /**
     * 通过用户名查询用户、角色信息
     *
     * @param username 用户名
     * @return RestResultVo
     */
    @RequestMapping(value = "inner/sys/account/{username}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
    RestResultVo<LoginAccountInfo> findAccountInfo(@PathVariable("username") String username);

    /**
     * 通过用户名查询用户、角色信息
     *
     * @param username 用户名
     * @return SysAccountInfo
     */
    @RequestMapping(value = "inner/sys/account/detail/{username}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.GET)
    public SysAccountInfo findAccountInfoDetail(@PathVariable("username") String username);


    /**
     * 通过id查询用户、角色信息
     *
     * @param id 用户名
     * @return SysAccountInfo
     */
    @RequestMapping(value = "inner/sys/account/detailById/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.GET)
    public SysAccountInfo findAccountInfoDetailById(@PathVariable("id") String id);

    /**
     *@Author: liuys
     *@Data: 2020/7/2
     *@Description: 根据角色查询角色下可查看的机型
     */
    @RequestMapping(value = "sys/jsqx/role/nuder/moder/{js}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.GET)
    RestResultVo<List<String>> getRoleNuderModer(@PathVariable("js") String js);

    /**
     *@Author: liuys
     *@Data: 2020/7/2
     *@Description: 根据角色查询角色下的所有库房
     */
    @RequestMapping(value = "sys/jsqx/role/nuder/warehouse/{js}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.GET)
    RestResultVo<List<String>> getRoleNuderWarehouse(@ApiParam(value = "角色id", name = "js") @PathVariable("js") String js);
}
