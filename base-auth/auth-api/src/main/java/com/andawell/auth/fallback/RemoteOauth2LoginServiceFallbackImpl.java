package com.andawell.auth.fallback;

import com.andawell.auth.RemoteOauth2LoginService;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author dcy
 * @date 2019/4/22
 */
@Component
public class RemoteOauth2LoginServiceFallbackImpl implements RemoteOauth2LoginService {
    private final static Logger logger = LoggerFactory.getLogger(RemoteOauth2LoginServiceFallbackImpl.class);
    @Setter
    private Throwable cause;

    @Override
    public ResponseEntity<?> postAccessToken(Map<String, String> parameters) {
        return null;
    }
}
