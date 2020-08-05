package com.andawell.purchase.service.impl;

import com.andawell.common.entity.search.ListPageCommon;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.util.BeanUtils;
import com.andawell.common.util.BusinessException;
import com.andawell.material.feign.BrigadeApplyService;
import com.andawell.material.query.TCkCkQuery;
import com.andawell.material.vo.StockVO;
import com.andawell.purchase.constant.NoticeConstant;
import com.andawell.purchase.dto.LtXqDTO;
import com.andawell.purchase.dto.TDhJhqdDTO;
import com.andawell.purchase.entity.TCgMlQd;
import com.andawell.purchase.entity.TDhJhqd;
import com.andawell.purchase.entity.TDhLtxq;
import com.andawell.purchase.entity.TDhLtxqTemp;
import com.andawell.purchase.enumeration.CategoryEnum;
import com.andawell.purchase.enumeration.DhJhStatusEnum;
import com.andawell.purchase.enumeration.OrderPlanEnum;
import com.andawell.purchase.mapper.*;
import com.andawell.purchase.query.TDhJhqdQuery;
import com.andawell.purchase.query.TDhLtxqQuery;
import com.andawell.purchase.query.TDhLtxqTempQuery;
import com.andawell.purchase.service.ITDhJhQdService;
import com.andawell.purchase.service.ITDhJhService;
import com.andawell.purchase.vo.TDhJhqdVO;
import com.andawell.purchase.vo.TDhLtxqTempVO;
import com.andawell.purchase.vo.TDhLtxqVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author:PCJ
 * @Date:2020/6/2
 * @Version:V1.0.0
 */
@Service
@Slf4j
public class TDhJhQdServiceImpl implements ITDhJhQdService {

    @Autowired
    private TDhJhqdMapper tDhJhqdMapper;

    @Autowired
    private TDhLtxqMapper tDhLtxqMapper;

    @Autowired
    private TDhLtxqTempMapper tDhLtxqTempMapper;

    @Autowired
    TCgMlMapper tCgMlMapper;

    @Autowired
    TCgMlQdMapper tCgMlQdMapper;

    @Autowired
    BrigadeApplyService brigadeApplyService;

    @Autowired
    TXtQclxMapper tXtQclxMapper;



    @Autowired
    ITDhJhService tDhJhService;


    /**
     * 导入旅团需求
     *
     * @param tDhLtxqTemps
     */
    @Override
   // @Transactional(rollbackFor = Exception.class)
    public void leadingIn(List<TDhLtxqTemp> tDhLtxqTemps,String bh) {
        for (TDhLtxqTemp tDhLtxqTemp : tDhLtxqTemps) {
            tDhLtxqTemp.setBh(bh);
            tDhLtxqTempMapper.insertSelective(tDhLtxqTemp);
        }
        // 该需求了

       /* log.info("导入表格");
        // 批量入库
        for (TDhLtxq tDhLtxq : tDhLtxqList) {

            TDhLtxq tDhLtxq1 = tDhLtxqMapper.selectByPrimaryKey(tDhLtxq.getBh(),
                    tDhLtxq.getDwid(),
                    tDhLtxq.getJx(),
                    tDhLtxq.getJh(),
                    tDhLtxq.getQclx());
            if(tDhLtxq1!=null){
                log.error("此数据数据库已存在："+tDhLtxq.toString());
                throw new BusinessException("此数据数据库已存在："+tDhLtxq.toString());
            }
            tDhLtxqMapper.insertSelective(tDhLtxq);
            // 导入需求之后进行汇总

            TDhJhqd tDhJhqd =  tDhJhqdMapper.selectByPrimaryKey(bh,tDhLtxq.getJx(),
                    tDhLtxq.getJh(),
                    tDhLtxq.getQclx());
            if(tDhJhqd == null){
                // 进行初始化数据
                tDhJhqd = new TDhJhqd(
                        bh,tDhLtxq.getJx(),
                        tDhLtxq.getJh(),
                        tDhLtxq.getQclx());
                tDhJhqd.setSqsl(Math.toIntExact(tDhLtxq.getSqsl()));
                tDhJhqd.setStatus((short) OrderPlanEnum.INVALID.getCode());
                tDhJhqd.setCjrq(new Date());
                tDhJhqdMapper.insertSelective(tDhJhqd);
            }
            // 如果已存在 进行 增量数据
            tDhJhqd.setSqsl((int) (tDhJhqd.getSqsl()+tDhLtxq.getSqsl()));
            tDhJhqd.setXgrq(new Date());
            tDhJhqdMapper.updateByPrimaryKeySelective(tDhJhqd);
        }*/
    }

    /**
     * 导入订货计划
     *
     * @param tempList
     * @param bh
     */
    @Override
    public void leadingInDhJh(List<TDhJhqdVO> tempList, String bh) {

        for (TDhJhqdVO tDhJhqdVO : tempList) {
            TDhJhqd tDhJhqd1 =  tDhJhqdMapper.selectByPrimaryKey(
                    bh,
                    tDhJhqdVO.getJx(),
                    tDhJhqdVO.getJh());
            if(tDhJhqd1 == null){
                throw new BusinessException("数据不存在："+tDhJhqdVO.toString());
            }
            tDhJhqd1.setBz(tDhJhqdVO.getBz());
            tDhJhqd1.setDhJhsl(tDhJhqdVO.getDhjhsl());
            tDhJhqdMapper.updateByPrimaryKeySelective(tDhJhqd1);
        }
    }

    /**
     * 保存接口
     *
     * @param tDhJhqdList
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveList(List<TDhJhqdDTO> tDhJhqdList) {

        String jhbh = "";

        if(tDhJhqdList ==null || tDhJhqdList.size()<=0){
            throw new BusinessException("计划数据为空，请添加有效数据");
        }
        for (TDhJhqdDTO tDhJhqd : tDhJhqdList) {

            if(tDhJhqd.getMlQdid() == null){
                throw new BusinessException("机型："+tDhJhqd.getJxmc()+"，件号："+tDhJhqd.getJh()+",无采购清单，请完善有效采购目录");
            }

            jhbh = tDhJhqd.getBh();

            TDhJhqd tDhJhqd1 =  tDhJhqdMapper.selectByPrimaryKey(
                    jhbh,
                    tDhJhqd.getJx(),
                    tDhJhqd.getJh());
            if(tDhJhqd1 == null){
                throw new BusinessException("数据不存在："+tDhJhqd.toString());
            }
            // 保存计划清单=
            // 关联采购目录
            List<String> list =
                    tCgMlMapper.listMlBhByStatus(CategoryEnum.TAKE_EFFECT.getCode());

            if(list==null || list.size() ==0){
                throw new BusinessException("请添加采购目录再申请订货计划");
            }
            // 只有一个生效版本
            TCgMlQd tCgMlQd = tCgMlQdMapper.selectByUnique(list.get(0),
                    tDhJhqd.getJx(),
                    tDhJhqd.getJh());

            if(tCgMlQd == null){
                throw new BusinessException("请绑定采购目录再进行订货:"+tDhJhqd.toString());
            }
             // 关联完成进行绑定
            tDhJhqd1.setMlQdid(tCgMlQd.getId());
            tDhJhqd1.setBz(tDhJhqd.getBz());
            tDhJhqd1.setStatus((short) DhJhStatusEnum.INVALID.getCode());
            tDhJhqd1.setDhJhsl(tDhJhqd.getDhjhsl());
            tDhJhqd1.setMlQdid(tDhJhqd.getMlQdid());
            tDhJhqdMapper.updateByPrimaryKeySelective(tDhJhqd1);
        }
        tDhJhService.updateStatus(jhbh);
    }

    /**
     * 保存接口 旅团需求
     *
     * @param ltXqDTOList
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveLtXQList(List<LtXqDTO> ltXqDTOList) {
        List<TDhLtxq> list = BeanUtils.copyList(ltXqDTOList,TDhLtxq.class);
        for (TDhLtxq ltxq : list) {
            ltxq.setCjrq(new Date());
            try {
                TDhLtxq  tDhLtxq =  tDhLtxqMapper.selectByPrimaryKey(ltxq.getBh(),
                        ltxq.getDwid(),
                        ltxq.getJx(),
                        ltxq.getJh());

                if(tDhLtxq == null){
                    tDhLtxqMapper.insertSelective(ltxq);
                }else {
                    tDhLtxqMapper.updateByPrimaryKeySelective(tDhLtxq);
                }
            }catch (Exception e){
                e.printStackTrace();
                throw new BusinessException("数据错误请核实："+ltxq.toString());
            }
            // 导入需求之后进行汇总
            TDhJhqd tDhJhqd =  tDhJhqdMapper.selectByPrimaryKey(ltxq.getBh(),ltxq.getJx(),
                    ltxq.getJh());

            if(tDhJhqd != null){
                // 如果已存在 进行 增量数据
                tDhJhqd.setSqsl((int) (tDhJhqd.getSqsl()+ltxq.getSqsl()));
            }
            if(tDhJhqd == null){
                // 进行初始化数据
                tDhJhqd = new TDhJhqd(
                        ltxq.getBh(),ltxq.getJx(),
                        ltxq.getJh());
                tDhJhqd.setSqsl(Math.toIntExact(ltxq.getSqsl()));

                if(StringUtils.isNotBlank(ltxq.getQclxmc())){
                    tDhJhqd.setQclx(tXtQclxMapper.selectIdByQcMc(ltxq.getQclxmc()));
                }
                tDhJhqd.setStatus((short) OrderPlanEnum.INVALID.getCode());
                tDhJhqd.setCjrq(new Date());
                tDhJhqdMapper.insertSelective(tDhJhqd);
            }
            if(StringUtils.isNotBlank(ltxq.getQclxmc())){
                tDhJhqd.setQclx(tXtQclxMapper.selectIdByQcMc(ltxq.getQclxmc()));
            }
            tDhJhqd.setXgrq(new Date());
            tDhJhqdMapper.updateByPrimaryKeySelective(tDhJhqd);
        }

        this.deleteLtXQExcelList(ltXqDTOList.get(0).getBh());
    }

    /**
     * 根据编号删除excel
     *
     * @param bh
     */
    @Override
    public void deleteLtXQExcelList(String bh) {
        tDhLtxqTempMapper.deleteBybh(bh);
    }

    @Override
    public ListPageVo<TDhJhqdQuery, TDhJhqdVO> listPage(TDhJhqdQuery query) {
        ListPageVo pageVo = new ListPageCommon<TDhJhqdQuery, TDhJhqdVO>(query,q->
                tDhJhqdMapper.list(q)
        ).getVo();

       List<TDhJhqdVO> list = pageVo.getList();

       // 进行统计
        for (TDhJhqdVO tDhJhqdVO : list) {
      /*      TCkCkQuery tCkCkQuery = new TCkCkQuery();
            tCkCkQuery.setJh();
            tCkCkQuery.setJx();
*/
            RestResultVo<StockVO> restResultVo =
                    brigadeApplyService.getStatistics(tDhJhqdVO.getJx(),tDhJhqdVO.getJh());
            if(restResultVo.getResult() != null){
                StockVO stockVO = restResultVo.getResult();
                if(stockVO.getQxsl()!= null){
                    tDhJhqdVO.setKcsl(stockVO.getQxsl());
                }
                if(stockVO.getKysl()!= null){
                    tDhJhqdVO.setKcsl(tDhJhqdVO.getKcsl()+stockVO.getKysl());
                }
                if(stockVO.getDxsl()!=null){
                    tDhJhqdVO.setDxsl(stockVO.getDxsl());
                }
                if(stockVO.getZxsl()!=null){
                    tDhJhqdVO.setDxsl(stockVO.getZxsl());
                }
                if(stockVO.getDhwdsl()!=null){
                    tDhJhqdVO.setDxsl(stockVO.getDhwdsl());
                }
                if(stockVO.getDjazsl()!=null){
                    tDhJhqdVO.setDxsl(stockVO.getDjazsl());
                }
            }

        }
        return pageVo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String bh) {

        int i=tDhJhqdMapper.deleteByJhBh(bh);
        if (i < 1) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_ERROR_MESSAGE);
        }
        tDhLtxqMapper.deleteByBh(bh);
        // 删除excel
        tDhLtxqTempMapper.deleteBybh(bh);
        /*
        if (n < 1) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_ERROR_MESSAGE);
        }
         */
    }

    /**
     * 获取旅团需求
     *
     * @param tDhLtxqQuery
     */
    @Override
    public List<TDhLtxqVO> getLtXqList(TDhLtxqQuery tDhLtxqQuery) {

        // 获取采购有效编号
        List<String> list =
                tCgMlMapper.listMlBhByStatus(CategoryEnum.TAKE_EFFECT.getCode());
        if(list.isEmpty()){
            throw new BusinessException("请添加采购目录列表");
        }
        String mlbh = list.get(0);
        tDhLtxqQuery.setMlbh(mlbh);
        List<TDhLtxqVO> tDhLtxqs =
                tDhLtxqMapper.getList(tDhLtxqQuery);
        return tDhLtxqs;
    }

    /**
     * 获取旅团需求
     *
     * @param tDhLtxqTempQuery
     */
    @Override
    public List<TDhLtxqTempVO> getLtXqExcelList(TDhLtxqTempQuery tDhLtxqTempQuery) {
        return tDhLtxqTempMapper.getList(tDhLtxqTempQuery);
    }
}
