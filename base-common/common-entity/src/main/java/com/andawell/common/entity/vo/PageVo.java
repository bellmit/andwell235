package com.andawell.common.entity.vo;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页结果")
public class PageVo {

    @ApiModelProperty(value = "每页记录数", name = "pageSize", dataType = "int", example = "10")
    private int pageSize;

    @ApiModelProperty(value = "页序", name = "pageIndex", dataType = "long", example = "1")
    private int pageIndex;

    @ApiModelProperty(value = "总记录数", name = "recordCount", dataType = "long", example = "0")
    private long recordCount;

    @ApiModelProperty(value = "总页数", name = "pageCount", dataType = "long", example = "0")
    private long pageCount;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public long getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(long recordCount) {
        this.recordCount = recordCount;
    }

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    public PageVo() {
    }

    public PageVo(PageInfo pageInfo) {
        super();
        this.pageIndex = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.pageCount = pageInfo.getPages();
        this.recordCount = pageInfo.getTotal();
    }
}