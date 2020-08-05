package com.andawell.common.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页条件")
public class PageDto {
    private final static int DEFAULT_SIZE = 10;

    @ApiModelProperty(value = "每页记录数", name = "pageSize", dataType = "int", example = "10")
    private int pageSize = DEFAULT_SIZE;

    @ApiModelProperty(value = "页序", name = "pageIndex", dataType = "int", example = "1")
    private int pageIndex = 1;

    @ApiModelProperty(value = "排序字段", name = "sortField", dataType = "String")
    private String sortField;

    @ApiModelProperty(value = "排序方式", name = "sortOrder", dataType = "String")
    private String sortOrder;

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

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public PageDto() {

    }

    public PageDto(int pageSize, int pageIndex) {
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
    }
}