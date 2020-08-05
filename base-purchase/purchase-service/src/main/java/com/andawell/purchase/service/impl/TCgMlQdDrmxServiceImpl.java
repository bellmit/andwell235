package com.andawell.purchase.service.impl;

import com.andawell.common.util.BusinessException;
import com.andawell.purchase.entity.TCgMlQdDrmx;
import com.andawell.purchase.mapper.TCgMlQdDrmxMapper;
import com.andawell.purchase.service.ITCgMlQdDrmxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;


/**
 * @Author:gzh
 * @Date:2020/5/29
 * @Version:V1.0.0
 */
@Service
public class TCgMlQdDrmxServiceImpl implements ITCgMlQdDrmxService {


    @Autowired
    TCgMlQdDrmxMapper tCgMlQdDrmxMapper;



    /**
     * 导入明细
     *根据id反查出来部分数据
     * 封装目录编号
     * 插入数据库
     * @param tempList
     * @param mlbh
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void leadingInDrmx(List<TCgMlQdDrmx> tempList, String mlbh) {
        tempList.stream().forEach(oneTCgMlQdDrmx->{
            //反查  器材类型名称反查器材id
            String qcLxid = tCgMlQdDrmxMapper.selectIdByQcmc(oneTCgMlQdDrmx.getQcLx());
            if( qcLxid == null){
                throw new BusinessException("器材类型不存在："+oneTCgMlQdDrmx.toString());
            }
            oneTCgMlQdDrmx.setQcLx(qcLxid);
            //反查  机型名称反查机型id
            String jxid = tCgMlQdDrmxMapper.selectIdByMc(oneTCgMlQdDrmx.getJx());
            if( jxid == null){
                throw new BusinessException("机型不存在："+oneTCgMlQdDrmx.toString());
            }
            oneTCgMlQdDrmx.setJx(jxid);
            //反查  价格类型名称反查价格类型id
            String jglxid = tCgMlQdDrmxMapper.selectJgIdByMc(oneTCgMlQdDrmx.getJgLx());
            if( jglxid == null){
                throw new BusinessException("价格类型不存在："+oneTCgMlQdDrmx.toString());
            }
            oneTCgMlQdDrmx.setJgLx(jglxid);
            //反查  监管单位名称反查监管单位id
            String jgdwid = tCgMlQdDrmxMapper.selectJgfIdByMc(oneTCgMlQdDrmx.getJgDw());
            if( jgdwid == null){
                throw new BusinessException("监管单位不存在："+oneTCgMlQdDrmx.toString());
            }
            oneTCgMlQdDrmx.setJgDw(jgdwid);
            //反查  币种名称查汇率
            BigDecimal hl  =  tCgMlQdDrmxMapper.selectHlByMC(oneTCgMlQdDrmx.getBzlb());
            if(hl==null){
                throw new BusinessException("币种汇率为空："+oneTCgMlQdDrmx.toString());
            }
            oneTCgMlQdDrmx.setHl(hl);
            //反查  厂家名称查厂家id
           String cjid =  tCgMlQdDrmxMapper.selectCjByMc(oneTCgMlQdDrmx.getCj());
           if(cjid==null){
               throw new BusinessException("厂家不存在："+oneTCgMlQdDrmx.toString());
           }
            oneTCgMlQdDrmx.setCj(cjid);
            //反查  币种名称查id
            String bzlb  =  tCgMlQdDrmxMapper.bzlbByMc(oneTCgMlQdDrmx.getBzlb());
            if(bzlb==null){
                throw new BusinessException("币种不存在："+oneTCgMlQdDrmx.toString());
            }
            oneTCgMlQdDrmx.setBzlb(bzlb);
            //封装目录编号
            oneTCgMlQdDrmx.setMlBh(mlbh);
            tCgMlQdDrmxMapper.insertSelective(oneTCgMlQdDrmx);
        });
    }

    /**
     * 导入明细全部删除
     */
    @Override
    public void deleteCgmlmxAll() {
        tCgMlQdDrmxMapper.deleteAll();
    }


}
