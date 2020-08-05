package com.andawell.common.entity.search;

import com.andawell.common.entity.vo.ListVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class ListCommon<Q, T> {
    PageHelperSearch<Q, T> pageHelperSearch = null;

    private Q query = null;
    private int pageIndex = 1;
    private int pageSize = 0;

    private ListVo<Q, T> vo = null;

    public ListCommon(PageHelperSearch<Q, T> pageHelperSearch) {
        this.pageHelperSearch = pageHelperSearch;
        execute();
    }

    public ListCommon(Q query, PageHelperSearch<Q, T> pageHelperSearch) {
        this.pageHelperSearch = pageHelperSearch;
        this.query = query;
        execute();
    }

    private void execute() {
        Page<T> pageHelper = PageHelper.startPage(pageIndex, pageSize);
        List<T> list = pageHelperSearch.search(query);
        PageInfo<T> pageInfo = new PageInfo<>(list);
        this.vo = new ListVo<>(list);
        PageHelper.clearPage();
    }

    public List<T> get() {
        return vo.getList();
    }
}