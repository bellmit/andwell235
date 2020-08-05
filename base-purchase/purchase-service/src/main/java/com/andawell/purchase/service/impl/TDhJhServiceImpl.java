package com.andawell.purchase.service.impl;

import com.andawell.common.util.BeanUtils;
import com.andawell.common.util.BusinessException;
import com.andawell.common.util.SysUserUtils;
import com.andawell.purchase.dto.TDhJhDTO;
import com.andawell.purchase.entity.TDhJh;
import com.andawell.purchase.entity.TDhJhqd;
import com.andawell.purchase.entity.TDhLtxq;
import com.andawell.purchase.enumeration.OrderPlanEnum;
import com.andawell.purchase.mapper.*;
import com.andawell.purchase.query.TDhJhQuery;
import com.andawell.purchase.service.ITDhJhQdService;
import com.andawell.purchase.service.ITDhJhService;
import com.andawell.purchase.util.ToolUtil;
import com.andawell.purchase.vo.TDhJhVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/***
 * @author gzh
 * @Date: 2020/6/2 9:03
 * @Description:
 * @version : V1.0
 */
@Service
@Slf4j
public class TDhJhServiceImpl implements ITDhJhService {

    @Autowired
    TDhJhMapper tDhJhMapper;


    /**
     * 新增订货计划
     *
     * @param tDhJhDTO
     */
    @Override
    public void insert(TDhJhDTO tDhJhDTO) {
        //获取当前时间戳


        TDhJh tDhJh =  tDhJhMapper.selectByBusinessNew("LH"+tDhJhDTO.getJhnf());
        //封装编号
        tDhJhDTO.setBh(ToolUtil.getJhBh(tDhJh,tDhJhDTO.getJhnf()));

        //tDhJhDTO.setStatus(OrderPlanEnum.TAKE_EFFECT.getCode());

        TDhJhQuery tDhJhQuery = new TDhJhQuery();
        tDhJhQuery.setStatus((short) OrderPlanEnum.INVALID.getCode());

        List<TDhJhVO> tDhJhVOList =
                tDhJhMapper.listJhbh(tDhJhQuery);
        if(tDhJhVOList!=null && tDhJhVOList.size()>0){
            throw new BusinessException("已存在草稿，请刷新页面");
        }

        //添加数据
        tDhJhDTO.setCjrq(new Date());
        tDhJhDTO.setStatus((short) OrderPlanEnum.INVALID.getCode());
        tDhJhMapper.insertSelective(BeanUtils.dtoTODO(tDhJhDTO, TDhJh.class));
    }

    /**
     * 查询订货计划
     *
     * @param bh
     */
    @Override
    public void updateStatus(String bh) {
        TDhJh tDhJh = tDhJhMapper.selectByPrimaryKey(bh);
        if(tDhJh == null){
            throw new BusinessException("订货计划不存在");
        }
        tDhJh.setStatus((short) OrderPlanEnum.TAKE_EFFECT.getCode());
        tDhJhMapper.updateByPrimaryKeySelective(tDhJh);
    }

    /**
     * 获取草稿状态
     *
     * @return
     */
    @Override
    public TDhJhVO getInvalid() {
        TDhJhQuery query = new TDhJhQuery();
        query.setStatus((short) OrderPlanEnum.INVALID.getCode());
        List<TDhJhVO> list = tDhJhMapper.listJhbh(query);
        if( list != null && list.size()>0 ){
           return list.get(0);
        }
        return null;
    }

    /**
     * 修改订货计划
     *
     * @param tDhJhDTO
     */
    @Override
    public void update(TDhJhDTO tDhJhDTO) {
        tDhJhMapper.updateByPrimaryKeySelective(BeanUtils.dtoTODO(tDhJhDTO, TDhJh.class));
    }


    @Override
    public List<TDhJhVO> listJhbh(TDhJhQuery query) {
        return tDhJhMapper.listJhbh(query);
    }
}
