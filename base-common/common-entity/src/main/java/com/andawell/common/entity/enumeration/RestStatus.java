package com.andawell.common.entity.enumeration;

public class RestStatus {
    public static final int SUCCESS = 200;
    public static final int BAD_REQUEST = 400;
    public static final int BE_REJECTED = 403;
    public static final int NOT_FOUND = 404;
    public static final int UNAUTHORIZED = 401;
    public static final int PROXY_AUTHENTICATION_REQUIRED = 407;
    public static final int ERROR = 500;
    /**
     * 等待客户端确认
     */
    public static final int WAIT_VERIFY = 600;
    /*BAD_REQUEST(400),
    BE_REJECTED(403),
    NOT_FOUND(404),
    UNAUTHORIZED(401),
    PROXY_AUTHENTICATION_REQUIRED(407),
    ERROR(500);

    public int code;

    @JsonValue
    public int getCode() {
        return code;
    }

    @JsonCreator
    public RestStatus(int code) {
        this.code = code;
    }*/
}
