package com.andawell.upms.service.impl;


import com.andawell.common.entity.search.ListCommon;
import com.andawell.upms.dto.TQxJsqxDto;
import com.andawell.upms.entity.TQxJsqx;
import com.andawell.upms.mapper.TQxJsqxMapper;
import com.andawell.upms.query.TQxJsqxQuery;
import com.andawell.upms.service.TQxJsqxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author GZH
 * 角色权限管理接口
 */
@Service
public class TQxJsqxServiceImpl implements TQxJsqxService {


    @Autowired
    private TQxJsqxMapper tQxJsqxMapper;

    /**
     * @Auther:gzh
     * @Date:2020/5/15 14:53
     * @Description: 角色权限查询
     * @Param:
     * @return:
     */
    @Override
    public String[] list(TQxJsqxQuery query) {
        return  tQxJsqxMapper.list(query);
    }

    /**
     * @param tQxJsqxDto
     * @Auther:gzh
     * @Date:2020/5/15 14:53
     * @Description: 角色权限添加
     * @Param:
     * @return:
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void Insert(TQxJsqxDto tQxJsqxDto) {
        tQxJsqxDto.getZy().stream().forEach(oneZy -> {
            tQxJsqxMapper.insertSelective(new TQxJsqx(tQxJsqxDto.getJs(), oneZy, tQxJsqxDto.getQx()));
        });
    }

    /**
     * @param tQxJsqxDto
     * @Auther:gzh
     * @Date:2020/5/15 14:53
     * @Description: 角色权限删除
     * @Param:
     * @return:
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(TQxJsqxDto tQxJsqxDto) {
        tQxJsqxDto.getZy().stream().forEach(oneZy -> {
            tQxJsqxMapper.deleteByPrimaryKey(tQxJsqxDto.getJs(),oneZy);
        });
    }


}
