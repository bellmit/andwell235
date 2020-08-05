package com.andawell.common.entity.search;

import com.andawell.common.entity.vo.DetailVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class DetailCommon<Q, T> {
    PageHelperSearch<Q, T> pageHelperSearch = null;

    private Q query = null;
    private int pageIndex = 1;
    private int pageSize = 1;

    private DetailVo<Q, T> vo = null;

    public DetailCommon(PageHelperSearch<Q, T> pageHelperSearch) {
        this.pageHelperSearch = pageHelperSearch;
        execute();
    }

    public DetailCommon(Q query, PageHelperSearch<Q, T> pageHelperSearch) {
        this.pageHelperSearch = pageHelperSearch;
        this.query = query;
        execute();
    }

    private void execute() {
        Page<T> pageHelper = PageHelper.startPage(pageIndex, pageSize);
        List<T> list = pageHelperSearch.search(query);
        PageInfo<T> pageInfo = new PageInfo<>(list);
        if (pageInfo.getTotal() <= 0) {
            this.vo = new DetailVo<>();
        } else {
            this.vo = new DetailVo<>(list.get(0));
        }
        PageHelper.clearPage();
    }

    public T get() {
        return vo.getDetail();
    }
}