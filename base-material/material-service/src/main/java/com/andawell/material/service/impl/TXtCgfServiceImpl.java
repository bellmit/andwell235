package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListPageCommon;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.material.dto.TXtCgfDTO;
import com.andawell.material.entity.TXtCgf;
import com.andawell.material.mapper.TCkWsyfMapper;
import com.andawell.material.mapper.TXtCgfMapper;
import com.andawell.material.query.TCkWsyfQuery;
import com.andawell.material.service.ITCkWsYfService;
import com.andawell.material.service.ITXtCgfService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.vo.TCkWsyfVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

/**
 *@Auther:gzh
 *@Date:2020/5/28 10:18
 *@Description: 采购方管理
 */
@Service
@Slf4j
public class TXtCgfServiceImpl implements ITXtCgfService {


    @Autowired
   private  TXtCgfMapper tXtCgfMapper;

    /**
     *@Auther:gzh
     *@Date:2020/5/28 10:25
     *@Description: 编号生成接口
     */
    @Override
    public TXtCgf bh() {
        DecimalFormat decimalFormat = new DecimalFormat("000");
        TXtCgf tXtCgf = new TXtCgf();
       String bh =  tXtCgfMapper.Bh();
       if(bh.isEmpty()){
           tXtCgf.setId("CG001");
       }else{
        int bhh = Integer.parseInt(bh.substring(bh.length() - 3, bh.length()))+1;
           String format = decimalFormat.format(bhh);
           String id = "CG"+format;
        tXtCgf.setId(id);
       }
        return tXtCgf;
    }

    @Override
    public int dwmc(String dwmc) {
        return tXtCgfMapper.selectDwmc(dwmc);
    }

    /**
     *@Auther:gzh
     *@Date:2020/7/6 10:30
     *@Description新增采购方
     *@Param:
     *@return:
     */
    @Override
    public void insert(TXtCgfDTO tXtCgfDTO) {
        tXtCgfMapper.insertSelective(BeanUtils.dtoTODO(tXtCgfDTO,TXtCgf.class));
    }

    /**
     *@Auther:gzh
     *@Date:2020/5/28 11:01
     *@Description: 采购方删除
     */
    @Override
    public void delete(String id) {
        tXtCgfMapper.deleteByPrimaryKey(id);
    }
    /**
     *@Auther:gzh
     *@Date:2020/5/28 11:01
     *@Description: 采购方编辑
     */
    @Override
    public void updateById(TXtCgfDTO tXtCgfDTO) {
        tXtCgfMapper.updateByPrimaryKeySelective(BeanUtils.dtoTODO(tXtCgfDTO,TXtCgf.class));
    }
}
