package com.andawell.upms.service.impl;


import com.andawell.common.entity.search.DetailCommon;
import com.andawell.common.entity.search.ListCommon;
import com.andawell.upms.dto.TQxYhDto;
import com.andawell.upms.dto.TQxYhFpDto;
import com.andawell.upms.entity.TQxYh;
import com.andawell.upms.mapper.TQxYhMapper;
import com.andawell.upms.query.TQxYhQuery;
import com.andawell.upms.service.TQxYhService;
import com.andawell.upms.util.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 用户管理的增删改查 职务下拉列表查询
 *
 * @Date： 2020/5/8 14:12
 */
@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class TQxYhServiceImpl implements TQxYhService {

    @Autowired
    private TQxYhMapper tQxYhMapper;

    /**
     * 用户删除接口
     */
    @Override
    public void delete(String id) {
        tQxYhMapper.deleteByPrimaryKey(id);
    }

    /**
     * 用户新增接口
     * 获取用户的最大身份id+1
     * 封装最后插入数据库
     */
    @Override
    public void insert(TQxYhDto tQxYhDTO) {
        /**
         * 获取最大的用户id来生成身份id
         * */
        String maxid = tQxYhMapper.maxId(tQxYhDTO.getDw());
        Integer id;
        if (StringUtils.isEmpty(maxid)) {
            id = 1;
        } else {
            id = Integer.parseInt(maxid.substring(maxid.length() - 3, maxid.length())) + 1;
        }
        maxid = tQxYhDTO.getDw() + String.format("%03d",id);
        TQxYh tQxYh = BeanUtils.dtoTODO(tQxYhDTO, TQxYh.class);
        tQxYh.setId(maxid);
        tQxYhMapper.insert(tQxYh);
    }

    /**
     * 用户登录名称判重接口
     */
    @Override
    public int DlmPc(String dlm) {
        return tQxYhMapper.DlmPc(dlm);
    }

    /**
     * 用户编辑接口
     */
    @Override
    public void update(TQxYhDto tQxYhDTO) {
        tQxYhMapper.updateByPrimaryKeySelective(BeanUtils.dtoTODO(tQxYhDTO, TQxYh.class));
    }

    /**
     * 用户角色分配接口
     * 修改T_QX_YH，将JS字段修改为对应角色ID 添加
     * 修改T_QX_YH，将JS字段修改为空值  删除
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateyhfp(TQxYhFpDto tQxYhFpDto) {
        TQxYh tQxYh = new TQxYh();
        tQxYh.setJs(tQxYhFpDto.getJs());
        tQxYhFpDto.getId().stream().forEach(oneid -> {
            tQxYh.setId(oneid);
        tQxYhMapper.updateByPrimaryKeySelective(tQxYh);
        });
    }

    /**
     * @param query
     * @return 人员信息查询(集合)
     * @Author 董重阳
     */
    @Override
    public List<TQxYh> list(TQxYhQuery query) {
        return new ListCommon<TQxYhQuery, TQxYh>(query, (q) -> tQxYhMapper.list(q)).get();
    }

    /**
     * @param id
     * @return 人员详细信息查询
     * @Author 董重阳
     */
    @Override
    public TQxYh detail(String id) {
        return new DetailCommon<TQxYhQuery, TQxYh>(new TQxYhQuery().setId(id), (q) -> tQxYhMapper.list(q)).get();
    }

    @Override
    public TQxYh selectDlmById(String id) {
        return tQxYhMapper.selectByPrimaryKey(id);
    }
}
