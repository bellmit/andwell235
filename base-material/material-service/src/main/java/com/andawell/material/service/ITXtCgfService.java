package com.andawell.material.service;

import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.material.dto.TXtCgfDTO;
import com.andawell.material.entity.PKCX;
import com.andawell.material.entity.TXtCgf;
import com.andawell.material.query.PKCXQuery;

import java.util.List;

/**
 *@Auther:gzh
 *@Date:2020/5/28 10:15
 *@Description: 采购方管理
 */
public interface ITXtCgfService {

    /**
     *@Auther:gzh
     *@Date:2020/5/28 10:25
     *@Description: 编号生成接口
     */
    TXtCgf bh();
    /**
     *@Auther:gzh
     *@Date:2020/5/28 10:52
     *@Description: 单位名称判重
     */
    int dwmc(String dwmc);

    /**
     *@Auther:gzh
     *@Date:2020/5/28 11:01
     *@Description: 采购方新增
     */
    void insert(TXtCgfDTO tXtCgfDTO);
    /**
     *@Auther:gzh
     *@Date:2020/5/28 11:01
     *@Description: 采购方删除
     */
    void delete(String id);
    /**
     *@Auther:gzh
     *@Date:2020/5/28 11:01
     *@Description: 采购方编辑
     */
    void updateById(TXtCgfDTO tXtCgfDTO);
}
