package com.andawell.material.service;

import com.andawell.material.dto.TXhpRkBcDTO;
import com.andawell.material.entity.TXhpCk;
import com.andawell.material.entity.TXhpCkCx;
import com.andawell.material.query.TXhpCkHjQuery;
import com.andawell.material.query.TXhpCkQuery;
import com.andawell.material.query.XhpCkQuery;
import com.andawell.material.query.XhpRkQuery;

import java.util.List;

public interface ITXhpCkService {
    List<TXhpCk> list();

    int txhpCkUpdateByMcGgPch(TXhpCkHjQuery query);

    /**
     *@Auther:gzh
     *@Date:2020/5/18 13:33
     *@Description:  五金入库保存
     *@Param: TXhpRkBcDTO
     */
    void rkbc(TXhpRkBcDTO tXhpRkBcDTO);

    /**
     *@Auther:gzh
     *@Date:2020/5/19 10:32
     *@Description: 五金出库保存
     *@Param: tXhpRkBcDTO
     */
    void ckbc(TXhpRkBcDTO tXhpRkBcDTO);

}
