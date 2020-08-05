package com.andawell.common.entity.vo;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("分页查询结果")
public class ListPageVo<Q extends PageDto, T> {

    @ApiModelProperty(value = "分页信息", name = "page")
    private PageVo page;
    @ApiModelProperty(value = "列表数据", name = "list")
    private List<T> list;


    public PageVo getPage() {
        return page;
    }

    public void setPage(PageVo page) {
        this.page = page;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public ListPageVo() {
    }

    public ListPageVo(Q query, PageVo page, List<T> list) {
        this.page = page;
        this.list = list;
    }
}