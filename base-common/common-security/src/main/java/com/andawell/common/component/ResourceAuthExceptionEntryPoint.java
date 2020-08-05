package com.andawell.common.component;

import cn.hutool.http.HttpStatus;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 资源验证异常处理的返回值
 * 可以根据 AuthenticationException 不同细化异常处理
 */
@Slf4j
@Component
@AllArgsConstructor
public class ResourceAuthExceptionEntryPoint implements AuthenticationEntryPoint {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        RestResultVo<String> result = new RestResultVo<>();
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

        result.setStatusCode(RestStatus.UNAUTHORIZED);
        if (authException != null) {
            if ("Full authentication is required to access this resource".equals(authException.getMessage())) {
                result.setMessage("请求Token值不存在");
                //result.setResult(authException.getMessage());
            } else {
                result.setMessage("Token失效");
                //result.setResult(authException.getMessage());
            }
        }
        response.setStatus(HttpStatus.HTTP_OK);

        PrintWriter printWriter = response.getWriter();
        printWriter.append(objectMapper.writeValueAsString(result));


    }
}
