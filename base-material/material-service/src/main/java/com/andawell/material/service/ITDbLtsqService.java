package com.andawell.material.service;

import com.andawell.material.dto.TDbDbAndQdDTO;
import com.andawell.material.dto.TDbLtsqDTO;
import com.andawell.material.entity.TDbLtsq;
import com.andawell.material.entity.TDbLtsqqd;
import com.andawell.material.query.TDbLtsqQuery;
import com.andawell.material.query.TDbLtsqqdQuery;
import com.andawell.material.vo.TDbLtsqqdVO;

import java.util.List;

/***
 * @author shs
 * @Date: 2020/5/14 15:40
 * @Description:
 * @version : V1.0
 */
public interface ITDbLtsqService {

    /**
     * 调拨管理接口
     */
    int insert(TDbLtsqDTO tDbLtsqDTO);
    /**
     * 季度查询
     */
    List<TDbLtsq> listjd(TDbLtsqQuery query);
    /**
     * 申请原因下拉
     */
    List<TDbLtsqqd> getGrundist(TDbLtsqQuery query);
    /**
     * 各种数目回显
     */
    TDbLtsqqdVO smList(TDbLtsqqdQuery query);

    String getAllotBh(String type);

    Boolean saveAllot(TDbDbAndQdDTO tDbDbAndQdDTO);

    String getNumber();
}
