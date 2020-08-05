package com.andawell.material.service.impl;

import com.andawell.common.util.SysUserUtils;
import com.andawell.material.entity.TXtDw;
import com.andawell.material.enumeration.CompanyStyle;
import com.andawell.material.mapper.TXtDwMapper;
import com.andawell.material.mapper.VDwMapper;
import com.andawell.material.query.TXtDwQuery;
import com.andawell.material.query.VDwQuery;
import com.andawell.material.service.ICompanyService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.util.CompanyTreeUtil;
import com.andawell.material.vo.CompanyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date： 2020/4/27 14:30
 */
@Service
public class CompanyServiceImpl implements ICompanyService {

    @Autowired
    private VDwMapper vDwMapper;

    @Autowired
    private TXtDwMapper tXtDwMapper;

    /**
     *@Author: liuys
     *@Data: 2020/7/7
     *@Description: 查询所有系统单位->军方单位
     */
    @Override
    public List<CompanyVO> getList(TXtDwQuery query) {
        //查询系统单位
        List<TXtDw> tXtDws = tXtDwMapper.getList(query);
        //将jc换成jm
        List<CompanyVO> list=new ArrayList<CompanyVO>();
        tXtDws.stream().forEach(tXtDw -> {
            CompanyVO companyVO = BeanUtils.dtoTODO(tXtDw, CompanyVO.class);
            companyVO.setJm(tXtDw.getJc());
            list.add(companyVO);
        });
        return list;
    }

    /**
     * 查询所有单位，并以树结构展示
     * @return
     */
    @Override
    public List<CompanyVO> getTreeList() {
        return CompanyTreeUtil.buildTree(vDwMapper.list(null));
    }

    @Override
    public List<CompanyVO> getPaymentTreeList() {
        VDwQuery query = new VDwQuery();
        //根据类别查询，4是军方单位
        query.setLb(CompanyStyle.MILITARY_UNIT.getCode());
        return CompanyTreeUtil.buildTree(vDwMapper.list(query));
    }

    /**
     *@Author: liuys
     *@Data: 2020/7/7
     *@Description: 查询登录人所在机关下所有的战区
     */
    @Override
    public List<TXtDw> getChildren() {
        TXtDwQuery query =new TXtDwQuery();
        //获取 登录人单位
        String deptId = SysUserUtils.getUser().getDeptId();
        // 机关Id
        String parentId = deptId.substring(0,2);
        query.setRightLikeId(parentId);
        List<TXtDw> list = tXtDwMapper.getList(query);
        return list;
    }


}
