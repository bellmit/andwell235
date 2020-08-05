package com.andawell.common.entity.search;

import com.andawell.common.entity.vo.CountVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.function.BiPredicate;

public class CountCommon<Q, T> {
    PageHelperSearch<Q, T> pageHelperSearch = null;

    private Q query = null;
    private int pageIndex = 1;
    private int pageSize = -1;

    private CountVo<Q, T> vo = null;

    public CountCommon(PageHelperSearch<Q, T> pageHelperSearch) {
        this.pageHelperSearch = pageHelperSearch;
        execute();
    }

    public CountCommon(Q query, PageHelperSearch<Q, T> pageHelperSearch) {
        this.pageHelperSearch = pageHelperSearch;
        this.query = query;
        execute();
    }

    private void execute() {
        Page<T> pageHelper = PageHelper.startPage(pageIndex, pageSize);
        List<T> list = pageHelperSearch.search(query);
        PageInfo<T> pageInfo = new PageInfo<>(list);
        this.vo = new CountVo<>(pageInfo.getTotal());
        PageHelper.clearPage();
    }

    public long get() {
        return vo.getCount();
    }
}