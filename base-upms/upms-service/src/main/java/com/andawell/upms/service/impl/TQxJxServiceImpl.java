package com.andawell.upms.service.impl;


import com.andawell.upms.dto.TQxJxDto;
import com.andawell.upms.entity.TJhJx;
import com.andawell.upms.entity.TQxJx;
import com.andawell.upms.mapper.TJhJxMapper;
import com.andawell.upms.mapper.TQxJxMapper;
import com.andawell.upms.query.TQxJxQuery;
import com.andawell.upms.service.TQxJxService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


/**
 *
 *角色仓库
 * @Date： 2020/5/13 14:12
 */
@Service

public class TQxJxServiceImpl implements TQxJxService {

    @Autowired
    private TQxJxMapper tQxJxMapper;

    @Autowired
    private TJhJxMapper tJhJxMapper;


/**
 *@Auther:gzh
 *@Date:2020/7/6 9:19
 *@Description:新增角色权限机型
 * 首先判断是全增还是丹增
 * 全增的话先做一个全删
 * 丹增的话直接增加
 *@Param:
 *@return:
 */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(TQxJxDto tQxJxDto) {

      if( tQxJxDto.getTQxJxs().size()>1){
          //全增  先做全删根据js进行全删
          tQxJxMapper.deleteAllByJs(tQxJxDto.getTQxJxs().get(0).getJs());
          tQxJxDto.getTQxJxs().stream().forEach(oneTQxJx->{
              tQxJxMapper.insert(oneTQxJx);
          });
      }else{
          //单增
          TQxJx tQxJx = tQxJxDto.getTQxJxs().get(0);
          tQxJxMapper.insert(tQxJx);
          //查询出本级机型对象
          TJhJx tJhJx = tJhJxMapper.selectByPrimaryKey(tQxJx.getJx());
          if(StringUtils.isEmpty(tJhJx.getPid())){
              inserttQxJxdgP(tJhJx, tQxJx);
          }else {
              inserttQxJxdg(tJhJx, tQxJx);
          }

      }

    }
    //单增父级从上往下
    private void inserttQxJxdgP(TJhJx tJhJx, TQxJx tQxJx) {
        //如果不是子级菜单一直往下添加
        List<TJhJx> list = tJhJxMapper.selectByPid(tJhJx.getId());
        if(list.size()>0){
         list.stream().forEach(onetjhjx->{
             //封装父级对象
             tQxJx.setJx(onetjhjx.getId());
             //查询该条数据数据库是否存在
             TQxJx tQxJxPc = tQxJxMapper.selectByPrimaryKey(tQxJx.getJs(),tQxJx.getJx());
             if(tQxJxPc==null){
                 //向数据库插入
                 tQxJxMapper.insert(tQxJx);
             }
             inserttQxJxdgP(onetjhjx,tQxJx);
         });
        }


    }

    //单增子级从下往上
    public void inserttQxJxdg(TJhJx tJhJx,TQxJx tQxJx ) {
        //如果不是顶级菜单就一直往上查并添加
        if(StringUtils.isNotEmpty(tJhJx.getPid())){
            //查询出父级对象
            TJhJx tJhJxP = tJhJxMapper.selectByPrimaryKey(tJhJx.getPid());
            //封装父级对象
            tQxJx.setJx(tJhJxP.getId());
            //查询该条数据数据库是否存在
            TQxJx tQxJxPc = tQxJxMapper.selectByPrimaryKey(tQxJx.getJs(),tQxJx.getJx());
            if(tQxJxPc==null){
                //向数据库插入
                tQxJxMapper.insert(tQxJx);
            }
            //重新调用该方法
            inserttQxJxdg(tJhJxP,tQxJx);
                }
    }

/**
 *@Auther:gzh
 *@Date:2020/7/6 9:31
 *@Description:角色删除机型权限
 * 根据表中主键来进行删除
 *@Param:
 *@return:
 */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(TQxJxDto tQxJxDto) {
        tQxJxDto.getTQxJxs().stream().forEach(oneTQxJx->{
            tQxJxMapper.deleteByPrimaryKey(oneTQxJx.getJs(),oneTQxJx.getJx());
        });
    }


    @Override
    public List<String> getRoleNuderModer(String js) {
        TQxJxQuery tQxJxQuery = new  TQxJxQuery();
        tQxJxQuery.setJs(js);
        return tQxJxMapper.selectByQuery(tQxJxQuery).stream().map(tQxJx -> tQxJx.getJx()).collect(Collectors.toList());
    }

}
