package com.andawell.common.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("查询列表结果")
public class ListVo<Q, T> {
    @ApiModelProperty(value = "列表", name = "list")
    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public ListVo() {
    }

    public ListVo(List<T> list) {
        this.list = list;
    }
}