package com.andawell.purchase.service.impl;

import com.andawell.common.entity.search.ListPageCommon;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.entity.TJhJx;
import com.andawell.material.feign.TJhJxFeignService;
import com.andawell.purchase.constant.NoticeConstant;
import com.andawell.purchase.entity.THtQd;
import com.andawell.purchase.enumeration.DhJhStatusEnum;
import com.andawell.purchase.enumeration.OrderPlanEnum;
import com.andawell.purchase.mapper.THtMapper;
import com.andawell.purchase.mapper.THtQdMapper;
import com.andawell.purchase.query.THtQuery;
import com.andawell.common.util.BusinessException;
import com.andawell.purchase.dto.TDhHtDTO;
import com.andawell.purchase.entity.TDhJh;
import com.andawell.purchase.entity.TDhJhqd;
import com.andawell.purchase.entity.THt;
import com.andawell.purchase.mapper.*;
import com.andawell.purchase.service.ITDhHtService;
import com.andawell.purchase.vo.THtVO;
import com.andawell.purchase.util.ToolUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/***
 * @author lhb
 * @Date: 2020/6/4 13:35
 * @Description:
 * @version : V1.0
 */
@Service
@Slf4j
public class TDhHtServiceImpl implements ITDhHtService {

    @Autowired
    private THtMapper tHtMapper;

    @Autowired
    private THtQdMapper tHtQdMapper;

    @Autowired
    private TDhJhqdMapper tDhJhqdMapper;

    @Autowired
    private TDhJhMapper tDhJhMapper;

    @Autowired
    private TJhJxFeignService tJhJxFeignService;
    @Override
    public ListPageVo<THtQuery, THtVO> listPageBefore(THtQuery query) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR,1);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        Date time = calendar.getTime();
        query.setStartTime(time);
        return new ListPageCommon<THtQuery, THtVO>(query,q->tHtMapper.listBefore(q)).getVo();
    }

    @Override
    public ListPageVo<THtQuery, THtVO> listPageAfter(THtQuery query) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR,1);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        Date startTime = calendar.getTime();
        query.setStartTime(startTime);
        calendar.set(Calendar.YEAR,calendar.get(Calendar.YEAR)+1);
        Date endTime =calendar.getTime();
        query.setEndTime(endTime);
        return new ListPageCommon<THtQuery, THtVO>(query,q->tHtMapper.listAfter(q)).getVo();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String jhbh) {
        int i = tHtMapper.deleteByJhbh(jhbh);
        if (i < 1) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_ERROR_MESSAGE);
        }
        tHtQdMapper.deleteByJhbh(jhbh);
        // 更新订货计划清单
        TDhJh tDhJh =  tDhJhMapper.selectByPrimaryKey(jhbh);
        tDhJh.setStatus((short) DhJhStatusEnum.INVALID.getCode());
        tDhJhMapper.updateByPrimaryKeySelective(tDhJh);
    }


    /**
     * 生成合同
     *
     * @param tDhHtDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveHtAndQdList(TDhHtDTO tDhHtDTO) {

        // 根据编号查出，订货计划
        TDhJh tDhJh =
                tDhJhMapper.selectByPrimaryKey(tDhHtDTO.getJhbh());
        if(tDhJh == null){
            throw new BusinessException("订货计划不存在请核实数据");
        }
        tDhJh.setStatus((short) DhJhStatusEnum.HANDLED.getCode());
        tDhJhMapper.updateByPrimaryKeySelective(tDhJh);

        // 根据订货计划，查询出订货计划清单生成 合同清单
        List<TDhJhqd> list = tDhJhqdMapper.getList(tDhHtDTO.getJhbh());


        // 组装数据 ，机型 和 厂家一致 进行数据分组
        List<List<TDhJhqd>> groupList = new ArrayList<>();

        list.stream().collect(Collectors.groupingBy(
                d ->cjAndJxCondition(d),Collectors.toList()))
                // TODO: 2020/6/4 待核实方法
                .forEach((jx,fooListByCondition)->{
                    groupList.add(fooListByCondition);
         });

        // 分组成功之后生成 合同 以及 合同清单

        for (List<TDhJhqd> tDhJhqdVOS : groupList) {

            // 创建合同
            THt tHt = new THt();
            BeanUtils.copyProperties(tDhHtDTO,tHt);
            TDhJhqd tDhJhqdVO =  tDhJhqdVOS.get(0);
            tHt.setCjrq(new Date());
            // 机型
            tHt.setJx(tDhJhqdVO.getHtjx());
            // 厂家
            tHt.setCjid(tDhJhqdVO.getCj());
            // 监管方
            tHt.setJgfid(tDhJhqdVO.getJgdw());
            // 设置合同编号
            String bh = ToolUtil.getHtBh(tDhJhqdVO);

            BigDecimal totalPrice = new BigDecimal("0");
            Integer js = 0;
            tHt.setHth(bh);
            tHt.setXs(tDhJhqdVOS.size());
            tHt.setJglx(tDhJhqdVO.getJglx());
            // 保存明细
            for (TDhJhqd dhJhqd : tDhJhqdVOS) {

                THtQd tHtQd1 =
                        tHtQdMapper.selectByPrimaryKey
                                (bh,tDhHtDTO.getJhbh(),
                        dhJhqd.getJx(),dhJhqd.getJh());
                if(tHtQd1!=null){
                    throw new BusinessException("合同清单已存在");
                }

                THtQd tHtQd = new THtQd();
                tHtQd.setHth(bh);
                tHtQd.setJfjd(tHt.getJfjd());
                tHtQd.setJhbh(tDhHtDTO.getJhbh());
                tHtQd.setMlQdid(dhJhqd.getMlQdid());
                tHtQd.setBzlb(dhJhqd.getBzlb());
                tHtQd.setHl(dhJhqd.getHl());
                // 单价乘以数量
                tHtQd.setSl(dhJhqd.getSqsl());
                BigDecimal bigDecimal = new BigDecimal(dhJhqd.getDj());

                BigDecimal subTotalPrice = bigDecimal.multiply(
                        new BigDecimal(dhJhqd.getDhJhsl().toString()));
                js = js + dhJhqd.getDhJhsl();
                totalPrice = totalPrice.add(subTotalPrice);
                tHtQd.setZj(subTotalPrice.toString());
                tHtQd.setJh(dhJhqd.getJh());
                tHtQd.setJx(dhJhqd.getJx());
                tHtQd.setCjrq(new Date());
                tHtQdMapper.insertSelective(tHtQd);
            }
            tHt.setJs(js);
            tHt.setZj(totalPrice.toString());
           if(tHtMapper.selectByPrimaryKey(bh,tDhHtDTO.getJhbh()) !=null){
               throw new BusinessException("该合同已存在，请核实数据");
           }
           tHt.setCjrq(new Date());
           tHtMapper.insertSelective(tHt);
        }
    }

    /**
     * 分组代码
     * @param tDhJhqdVO
     * @return
     */
    private String cjAndJxCondition(TDhJhqd tDhJhqdVO){
        RestResultVo<TJhJx> resultVo =
                tJhJxFeignService.getTJhJxById(tDhJhqdVO.getJx());

        TJhJx tJhJx = resultVo.getResult();
        if(tJhJx.getHtbz() != 0){
             resultVo =
                    tJhJxFeignService.getTJhJxById(tJhJx.getPid());
             if(resultVo.getResult() != null){
                 tJhJx = resultVo.getResult();
             }
        }
        tDhJhqdVO.setHtjxjm(tJhJx.getJm());
        tDhJhqdVO.setHtjx(tJhJx.getId());
        return tDhJhqdVO.getCj()+tJhJx.getId()+tDhJhqdVO.getJglxmc();
    }
}
