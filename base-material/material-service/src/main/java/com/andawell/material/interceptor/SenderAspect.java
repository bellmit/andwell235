package com.andawell.material.interceptor;

import com.andawell.common.util.BusinessException;
import com.andawell.material.config.UdpConfig;
import com.andawell.material.util.UpSender;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.SocketException;
import java.net.UnknownHostException;

/***
 * @author lhb
 * @Date: 2020/6/23 10:16
 * @Description:
 * @version : V1.0
 */
@Aspect
@Component
@Slf4j
public class SenderAspect {

    @Resource
    UdpConfig udpConfig;

    //     @Pointcut("execution(public com.andawell.common.entity.vo.RestResultVo com.andawell..*.controller.*Controller.*(." +
    //            ".))")

   // private final String controllerPoint = "execution(public * com.andawell.material.controller.*.*(..))";

    @Pointcut("execution(public * com.andawell.material.controller.BaseLibraryController.*(..)) || execution(public * com.andawell.material.controller.OutOfStockController.*(..)) ")
    public void controllerMethodPointCut(){

    }

    /**
     * 切点
     */
    @After("controllerMethodPointCut()")
    public void doAfter(JoinPoint joinPoint) throws UnknownHostException, SocketException {
        //只操作 post 请求
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        if(!"POST".equals(request.getMethod())){
            return;
        }
        // 发送密集柜消息
        log.info("发送UDP 密集柜消息");
        try {
            UpSender.sender(udpConfig.getIpAddress(),udpConfig.getPort(),udpConfig.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            log.error("发送UDP 密集柜消息");
        }

    }
}
