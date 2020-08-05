package com.andawell.upms.entity;

import lombok.Data;


@Data
public class LoginInfo {
    private String username;
    private String password;
    private String grantType;
    private String loginSign;
}
