package com.andawell.material.service;

import com.andawell.material.entity.TXtDw;
import com.andawell.material.entity.VDw;
import com.andawell.material.query.TXtDwQuery;
import com.andawell.material.vo.CompanyVO;

import java.util.List;

/**
 * @Date： 2020/4/27 14:30
 */
public interface ICompanyService {

    /**
     *@Author: liuys
     *@Data: 2020/7/7
     *@Description: 查询所有系统单位->军方单位
     */
    List<CompanyVO> getList(TXtDwQuery query);
    /**
     * 查询所有单位，并以树结构展示
     * @return
     */
    List<CompanyVO> getTreeList();

    List<CompanyVO> getPaymentTreeList();

    /**
     *@Author: liuys
     *@Data: 2020/7/7
     *@Description: 查询登录人所在机关下所有的战区
     */
    List<TXtDw> getChildren();

}
