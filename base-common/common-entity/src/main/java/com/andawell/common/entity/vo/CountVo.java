package com.andawell.common.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("查询数量结果")
public class CountVo<Q, T> {
    @ApiModelProperty(value = "数量", name = "count",example = "0")
    private long count;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public CountVo() {
    }

    public CountVo(long count) {
        this.count = count;
    }
}