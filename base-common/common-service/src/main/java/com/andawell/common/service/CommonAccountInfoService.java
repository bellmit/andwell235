package com.andawell.common.service;

import org.springframework.stereotype.Component;

/**
 * @author DCY
 */
@Component
public interface CommonAccountInfoService {

    public String getAccountInfo(String accountId);
}
