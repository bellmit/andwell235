package com.andawell.purchase.service.impl;

import com.andawell.common.entity.search.ListPageCommon;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.util.BeanUtils;
import com.andawell.common.util.BusinessException;
import com.andawell.material.feign.CrKQdFeignService;
import com.andawell.material.vo.TCkCrkqdVO;
import com.andawell.purchase.dto.THtFkDTO;
import com.andawell.purchase.entity.HtFk;
import com.andawell.purchase.entity.HtFkQd;
import com.andawell.common.util.BeanUtils;
import com.andawell.purchase.mapper.HtFkMapper;
import com.andawell.purchase.mapper.HtFkQdMapper;

import com.andawell.purchase.mapper.THtQdMapper;
import com.andawell.purchase.query.THtFkQuery;
import com.andawell.purchase.service.ITHtFkService;

import com.andawell.purchase.vo.TDhJhqdVO;
import com.andawell.purchase.vo.THtFkVO;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;


/**
 * @Auther:gzh
 * @Date:2020/6/9 8:52
 */
@Service
public class THtFkServiceImpl implements ITHtFkService {

    @Autowired
    HtFkMapper htFkMapper;

    @Autowired
    HtFkQdMapper htFkQdMapper;

    @Autowired
    THtQdMapper tHtQdMapper;

    @Autowired
    CrKQdFeignService crKQdFeignService;

    /**
     * @param tHtFkDTO
     * @Auther:gzh
     * @Date:2020/6/9 9:16
     * @Description: 合同付款保存
     * 首先查询出最大付款编号，生成付款编号
     * 封装付款model冰箱数据库插入
     * 根据入库单号查询出付款清单向数据库插入
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(THtFkDTO tHtFkDTO) {
        DecimalFormat decimalFormat = new DecimalFormat("000");
        //封装合同付款model
        HtFk htFk = BeanUtils.dtoTODO(tHtFkDTO, HtFk.class);
        //生成合同付款编号
        String fkbh;
        fkbh = htFkMapper.selectMaxFkbh();
        if (fkbh == null) {
            fkbh = "FK-001";
        } else {
            Integer integer = Integer.valueOf(fkbh.substring(fkbh.length() - 3, fkbh.length())) + 1;
            String format = decimalFormat.format(integer);
            fkbh = "FK-" + format;
        }
        //封装合同付款编号
        htFk.setFkbh(fkbh);
        //数据库插入合同付款数据
        htFkMapper.insertSelective(htFk);
        tHtFkDTO.getRkdh().stream().forEach(oneRkdh -> {
            HtFkQd htFkQd = htFkQdMapper.selectHtfkqdByCrkqd(oneRkdh);
            if(htFkQd==null){
                throw new BusinessException("入库单号异常"+oneRkdh);
            }
            //封装入库编号
            htFkQd.setRkb(oneRkdh);
            //封装付款编号
            htFkQd.setFkbh(htFk.getFkbh());
            //封装入库日期
            htFkQd.setFkrq(htFk.getFkrq());
            //封装合同号
            htFkQd.setHth(htFk.getHth());
            //数据库插入合同付款清单数据
            htFkQdMapper.insertSelective(htFkQd);
        });

    }

    @Override
    public List<TCkCrkqdVO> getHtRkDList(String rkbh) {


        RestResultVo<List<TCkCrkqdVO>> restResultVo =
                crKQdFeignService.getListQdVO(rkbh);

        return restResultVo.getResult();
    }

    @Override
    public ListPageVo<THtFkQuery, THtFkVO> listPageHtFk(THtFkQuery query) {
        return new ListPageCommon<THtFkQuery, THtFkVO>(query,q->htFkMapper.listHtFk(q)).getVo();
    }

    /**
     * 合同入库单查看
     *
     * @param query
     * @return
     */
    @Override
    public ListPageVo<THtFkQuery, THtFkVO> listPageHtFkck(THtFkQuery query) {
        DateFormat bf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        List<THtFkVO> tHtFkVOS = htFkMapper.listHtFkck(query);
        tHtFkVOS.stream().forEach(onetHtFkVO->{
            HtFk htFk = htFkMapper.selectByPrimaryKey(onetHtFkVO.getYj(), onetHtFkVO.getFkbh());
            onetHtFkVO.setFkrq(bf.format(htFk.getFkrq()));
            onetHtFkVO.setBz(htFk.getBz());
            onetHtFkVO.setHk(htFk.getHkjg());
        });
       /*  return new ListPageVo<THtFkQuery, THtFkVO>;*/
        return new ListPageCommon<THtFkQuery, THtFkVO>(query,q->tHtFkVOS).getVo();
    }
}
