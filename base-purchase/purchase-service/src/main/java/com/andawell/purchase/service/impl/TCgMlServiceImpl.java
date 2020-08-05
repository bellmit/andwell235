package com.andawell.purchase.service.impl;

import com.andawell.common.entity.dto.PageDto;
import com.andawell.common.entity.search.ListPageCommon;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.entity.vo.PageVo;
import com.andawell.common.util.BusinessException;
import com.andawell.purchase.constant.NoticeConstant;
import com.andawell.purchase.dto.TCgMlDTO;
import com.andawell.purchase.dto.TCgMlQdDTO;
import com.andawell.purchase.entity.TCgMl;
import com.andawell.purchase.entity.TCgMlQd;
import com.andawell.purchase.enumeration.CategoryEnum;
import com.andawell.purchase.mapper.TCgMlMapper;
import com.andawell.purchase.mapper.TCgMlQdMapper;
import com.andawell.purchase.query.TCgMlQdQuery;
import com.andawell.purchase.service.ITCgMlService;
import com.andawell.purchase.vo.TCgMlQdVO;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author:PCJ
 * @Date:2020/5/29
 * @Version:V1.0.0
 */
@Service
public class TCgMlServiceImpl implements ITCgMlService {

    @Autowired
    private TCgMlMapper tCgMlMapper;

    @Autowired
    private TCgMlQdMapper tCgMlQdMapper;

    /**
     * 发布
     * 将表中发布状态的数据转为失效 status改为2
     * 将要发布的数据根据id主键来修改为发布状态
     * @param id
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void issue(Integer id) {
        //使字段status为1的全部修改为2
        tCgMlMapper.sxStatus();
        //发布  是该数据变为生效状态  发布时间修改
        tCgMlMapper.fbStatusById(id);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map edit(TCgMlDTO tCgMlDTO) {
        Map map = new HashMap<>();


        Short status = tCgMlDTO.getStatus();
        TCgMlQdQuery query=new TCgMlQdQuery();
        List<TCgMlQd> list=null;
        if (status!=CategoryEnum.TAKE_EFFECT.getCode() && status !=CategoryEnum.UNDER_REVISION.getCode()) {
            throw new BusinessException(NoticeConstant.RESPONSE_EDIT_NOT_MESSAGE+":"+tCgMlDTO.getMlbh());
        } else if (status==CategoryEnum.TAKE_EFFECT.getCode()) {
            List<String> bhList=tCgMlMapper.listMlBhByStatus(CategoryEnum.UNDER_REVISION.getCode());
            if (!bhList.isEmpty()) {
                map.put("mlbh",bhList.get(0));
                query=new TCgMlQdQuery().setMlbh(bhList.get(0));
            } else {
                list=tCgMlQdMapper.listByMlBh(new TCgMlQdQuery().setMlbh(tCgMlDTO.getMlbh()));
                if (list.isEmpty()) {
                    return null;
                }
                String mlBh=getMlBh();
                Date cjrq=new Date();
                Date mlXgRq = new Date();
                TCgMl tCgMl = new TCgMl();
                tCgMl.setId(null);
                tCgMl.setMlBh(mlBh);
                tCgMl.setMlBb(tCgMlDTO.getMlBb());
                tCgMl.setCjrq(cjrq);
                tCgMl.setMlBbDw(tCgMlDTO.getMlBbDw());
                tCgMl.setStatus(CategoryEnum.UNDER_REVISION.getCode());
                Integer mlZb=getMlZb(tCgMlDTO.getMlBb());
                tCgMl.setMlZb(mlZb);
                tCgMl.setMlSm(tCgMlDTO.getMlSm());
                tCgMlMapper.insertSelective(tCgMl);
                list.forEach((t)->{
                    t.setCjrq(cjrq);
                    t.setMlbh(mlBh);
                    t.setGxrq(mlXgRq);
                    if(tCgMlQdMapper.insertSelective(t) !=1) {
                    throw new BusinessException(NoticeConstant.RESPONSE_KEY_REPEAT_MESSAGE+":"+t.toString());
                }});
                query=new TCgMlQdQuery().setMlbh(mlBh);
                map.put("mlbh",mlBh);
            }
        } else {
            query=new TCgMlQdQuery().setMlbh(tCgMlDTO.getMlbh());
        }
        map.put("list",listPage(query));
        return  map;
    }

    /**
     * 生效状态是否拥有编辑功能
     */
    @Override
    public Boolean isEdit() {
      if(tCgMlMapper.isEdit()==0){
          return true;
      }else{
          return false;
      }

    }

    /**
     * 生成当前版本的子版本号
     * @param mlBb
     * @return
     */
    private Integer getMlZb(String mlBb) {
        String maxMlZb=tCgMlMapper.getMaxMlZb(mlBb);
        if (StringUtils.isEmpty(maxMlZb)) {
            return 1;
        }
        return Integer.valueOf(maxMlZb)+1;
    }

    /**
     * 目录编号生成
     * @param
     * @return
     */
    private String getMlBh() {
        String maxMlBh=tCgMlMapper.getMaxMlBh();
        String mlBh="BH-"+String.valueOf(Integer.valueOf(maxMlBh)+1000+1).substring(1);
        return mlBh;
    }

    /**
     * 判断id数据库是否存在
     *
     * @param id
     */
    @Override
    public int selectId(Integer id) {
        return tCgMlMapper.selectId(id);
    }

    /**
     * 根据id查询数据状态
     *
     * @param id
     */
    @Override
    public int selectStatusById(Integer id) {
        return tCgMlMapper.selectStatusById(id);
    }

    /**
     * 跟新数据
     *
     * @param tCgMlDTO
     * @return
     */
    @Override
    public void updateTCgMl(TCgMlDTO tCgMlDTO) {

        TCgMl tCgMl = new TCgMl();

        BeanUtils.copyProperties(tCgMlDTO,tCgMl);

        int n = tCgMlMapper.updateByPrimaryKeySelective(tCgMl);

        if(n<=0){
            throw new BusinessException("数据不存在："+tCgMlDTO.toString());
        }
    }

    /**
     * 增加目录
     *
     * @param tCgMlDTO
     */
    @Override
    public void saveCgml(TCgMlDTO tCgMlDTO) {

        TCgMl tCgMl = new TCgMl();
        // 子版本号是 1
        tCgMl.setMlZb(1);
        BeanUtils.copyProperties(tCgMlDTO,tCgMl);
        tCgMl.setMlFbRq(new Date());
        tCgMl.setMlBh(getMlBh());
        tCgMl.setCjrq(new Date());
        tCgMl.setStatus(CategoryEnum.UNDER_REVISION.getCode());
        tCgMlMapper.insertSelective(tCgMl);

    }

    /**
     * 逻辑删除 状态改为 4
     *
     * @param id
     */
    @Override
    public void deleteTCMl(Long id) {

        TCgMl tCgMl = tCgMlMapper.selectByPrimaryKey(id);

        if(tCgMl == null){
            throw new BusinessException("数据不存在id="+id);
        }
        if(tCgMl.getStatus()!= CategoryEnum.UNDER_REVISION.getCode()){
            throw new BusinessException("状态必须为修订中");
        }
        tCgMl.setStatus(CategoryEnum.DELETE.getCode());
        tCgMlMapper.updateByPrimaryKeySelective(tCgMl);
    }

    /**
     * 批量查询
     * @param query
     * @return
     */
    public ListPageVo<TCgMlQdQuery, TCgMlQdVO> listPage(TCgMlQdQuery query) {
        return new ListPageCommon<TCgMlQdQuery, TCgMlQdVO>(query,(q)->tCgMlQdMapper.list(q)).getVo();
    }
}
