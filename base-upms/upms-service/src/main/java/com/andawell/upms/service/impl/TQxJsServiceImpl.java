package com.andawell.upms.service.impl;


import com.andawell.common.entity.search.ListCommon;
import com.andawell.upms.dto.TQxJsDto;
import com.andawell.upms.dto.TQxJsqxDto;
import com.andawell.upms.entity.TQxJs;
import com.andawell.upms.entity.TQxJsqx;
import com.andawell.upms.entity.TQxYh;
import com.andawell.upms.mapper.TQxJsMapper;
import com.andawell.upms.mapper.TQxJsqxMapper;
import com.andawell.upms.query.TQxJsqxQuery;
import com.andawell.upms.service.TQxJsService;
import com.andawell.upms.service.TQxJsqxService;
import com.andawell.upms.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author GZH
 * 角色管理接口
 */
@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class TQxJsServiceImpl implements TQxJsService {


    @Autowired
    private TQxJsMapper tQxJsMapper;


    /**
     *@Auther:gzh
     *@Date:2020/5/30 13:37
     *@Description: 新增角色权限
     * 首先通过pid判断是新增父级还是新增子级
     * 父级的话去数据库查询出来最大的id然后+1并封装
     * 子级的话根据pid来查询最大的id然后+1并封装
     * 最后插入到数据库当中
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(TQxJsDto tQxJsDto) {
        //判断是新增子级还是新增父级
        if(tQxJsDto.getPid().equals("")){
            //新增父级   获取最大的父级id
          Integer fid =  tQxJsMapper.maxFid();
          //封装新增的父级id
            tQxJsDto.setId(String.valueOf(fid+1));
        }else{
            //新增子级  根据pid查询出最大的子级id
            Integer zid  =  tQxJsMapper.selectIdByPid(tQxJsDto.getPid());
            if(zid==null){
                tQxJsDto.setId(tQxJsDto.getPid()+"01");
            }else{
                tQxJsDto.setId(String.valueOf(zid+1));
            }
        }
        //插入一行数据到T_QX_JS
        tQxJsMapper.insert( BeanUtils.dtoTODO(tQxJsDto, TQxJs.class));
    }
/**
 *@Auther:gzh
 *@Date:2020/7/6 8:56
 *@Description: 编辑角色
 * 转换对象
 * 数据库插入
 *@Param:
 *@return:
 */
    @Override
    public void update(TQxJsDto tQxJsDto) {
        tQxJsMapper.updateByPrimaryKey( BeanUtils.dtoTODO(tQxJsDto, TQxJs.class));
    }

    /**
     *@Auther:gzh
     *@Date:2020/7/6 8:59
     *@Description:删除角色
     * 根据主键id进行删除
     *@Param:
     *@return:
     */
    @Override
    public void delete(String id) {
        tQxJsMapper.deleteByPrimaryKey(id);
    }

    /**
     *@Auther:gzh
     *@Date:2020/5/20 14:16
     *@Description: 新增角色id判重
     */
    @Override
    public int selectById(String id) {
        return tQxJsMapper.selectById(id);
    }

    @Override
    public List<TQxJs> selectByPidId(String id) {
        return tQxJsMapper.selectByPidId(id);
    }
}
