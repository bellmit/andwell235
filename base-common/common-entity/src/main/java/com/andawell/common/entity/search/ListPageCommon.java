package com.andawell.common.entity.search;

import com.andawell.common.entity.dto.PageDto;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.entity.vo.PageVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class ListPageCommon<Q extends PageDto, T> {
    PageHelperSearch<Q, T> pageHelperSearch = null;

    private Q query = null;
    private int pageIndex = 1;
    private int pageSize = 0;

    private ListPageVo<Q, T> vo = null;

    public ListPageCommon(PageHelperSearch<Q, T> pageHelperSearch) {
        this.pageHelperSearch = pageHelperSearch;
        execute();
    }

    public ListPageCommon(Q query, PageHelperSearch<Q, T> pageHelperSearch) {
        this.pageHelperSearch = pageHelperSearch;
        if (query != null) {
            this.query = query;
            this.pageIndex = query.getPageIndex();
            this.pageSize = query.getPageSize();
        }
        execute();
    }

    private void execute() {
        Page<T> pageHelper = PageHelper.startPage(pageIndex, pageSize);
        List<T> list = pageHelperSearch.search(query);
        PageInfo<T> pageInfo = new PageInfo<>(list);
        this.vo = new ListPageVo<>(query, new PageVo(pageInfo), list);
        PageHelper.clearPage();
    }

    public ListPageVo<Q, T> getVo() {
        return vo;
    }

    public List<T> getList() {
        return vo.getList();
    }

    public PageVo getPage() {
        return vo.getPage();
    }
}