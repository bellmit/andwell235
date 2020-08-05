package com.andawell.common.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;

@Builder
@ApiModel("返回结果")
public class RestResultVo<R> {
    @ApiModelProperty(value = "状态码",name = "statusCode")
    private int statusCode;
    @ApiModelProperty(value = "信息",name = "message")
    private String message;
    @ApiModelProperty(value = "返回值",name = "result")
    private R result;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public R getResult() {
        return result;
    }

    public void setResult(R result) {
        this.result = result;
    }

    public RestResultVo() {
    }

    public RestResultVo(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public RestResultVo(int statusCode, String message, R result) {
        this.statusCode = statusCode;
        this.message = message;
        this.result = result;
    }
}