package com.andawell.common.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("查询结果")
public class DetailVo<Q, T> {
    @ApiModelProperty(value = "详细信息", name = "detail")
    private T detail;

    public T getDetail() {
        return detail;
    }

    public void setDetail(T detail) {
        this.detail = detail;
    }

    public DetailVo() {
    }

    public DetailVo(T detail) {
        this.detail = detail;
    }
}