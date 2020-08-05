package com.andawell.purchase.service.impl;

import com.andawell.common.entity.search.ListPageCommon;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.util.BusinessException;
import com.andawell.common.util.ValidableList;
import com.andawell.purchase.dto.TCgMlQdDTO;
import com.andawell.common.util.ValidableList;
import com.andawell.purchase.entity.TCgMl;
import com.andawell.purchase.entity.TCgMlQd;
import com.andawell.purchase.mapper.TCgMlMapper;
import com.andawell.purchase.mapper.TCgMlQdDrmxMapper;
import com.andawell.purchase.mapper.TCgMlQdMapper;
import com.andawell.purchase.query.TCgMlQdQuery;
import com.andawell.purchase.service.ITCgMlQdService;
import com.andawell.purchase.vo.TCgMlQdVO;
import org.springframework.beans.BeanUtils;
import com.andawell.purchase.service.ITCgMlQdService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.Date;
import java.util.List;

/**
 * @Author:PCJ
 * @Date:2020/5/29
 * @Version:V1.0.0
 */
@Service
public class TCgMlQdServiceImpl implements ITCgMlQdService {

    @Autowired
    private TCgMlMapper tCgMlMapper;

    @Autowired
    private TCgMlQdMapper tCgMlQdMapper;




    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertAll(ValidableList<TCgMlQdDTO> tCgMlQdList) {

        Date date = new Date();
        if(tCgMlQdList!=null && tCgMlQdList.size()>0){

            List<TCgMlQd> list =
                    com.andawell.common.util.BeanUtils.copyList(tCgMlQdList,TCgMlQd.class);

            for (TCgMlQd tCgMlQd : list) {
                try {
                    tCgMlQd.setCjrq(date);
                    tCgMlQdMapper.insertSelective(tCgMlQd);
                }catch (Exception e){
                    e.printStackTrace();
                    throw new BusinessException("数据重复:"+",机型："+tCgMlQd.getJxmc()+",件号："+tCgMlQd.getJhmc());
                }
            }

            tCgMlMapper.updateXgrqByMlbh(list.get(0).getMlbh());
        }

    }

    /**
     * 跟新目录清单
     *
     * @param tCgMlQdDTO
     */
    @Override
    public void updateTCgMlQd(TCgMlQdDTO tCgMlQdDTO) {
        TCgMlQd tCgMlQd =
                tCgMlQdMapper.selectByPrimaryKey(tCgMlQdDTO.getId());

        if(tCgMlQd == null){
            throw new BusinessException("数据不存在："+tCgMlQdDTO.toString());
        }
        BeanUtils.copyProperties(tCgMlQdDTO,tCgMlQd);
        tCgMlQd.setGxrq(new Date());
        tCgMlQdMapper.updateByPrimaryKey(tCgMlQd);
    }

    /**
     * 删除清单
     *
     * @param id
     */
    @Override
    public void deleteTCgMlQd(Long id) {
        int n = tCgMlQdMapper.deleteByPrimaryKey(id);
        if(n<=0){
            throw new BusinessException("数据不存在id："+id);
        }
    }

    /**
     * 插入目录清单
     *
     * @param tCgMlQdDTO
     */
    @Override
    public void insertTCgMlQd(TCgMlQdDTO tCgMlQdDTO) {
        TCgMlQd tCgMlQd = new TCgMlQd();
        BeanUtils.copyProperties(tCgMlQdDTO,tCgMlQd);
        tCgMlQd.setCjrq(new Date());
        tCgMlQdMapper.insert(tCgMlQd);
    }

    /**
     * 分页查询
     * @param query
     * @return
     */
    @Override
    public ListPageVo<TCgMlQdQuery, TCgMlQdVO> listPage(TCgMlQdQuery query) {
        return new ListPageCommon<TCgMlQdQuery, TCgMlQdVO>
                (query,(q)->tCgMlQdMapper.list(q))
                .getVo();
    }
}
