package com.andawell.material.service.impl;


import com.andawell.common.entity.BaseUser;
import com.andawell.common.util.SysUserUtils;
import com.andawell.material.dto.TJhGzDTO;
import com.andawell.material.dto.TJhGzzDTO;
import com.andawell.material.entity.TJhDj;
import com.andawell.material.entity.TJhGz;
import com.andawell.material.entity.TJhJhhh;
import com.andawell.material.mapper.TJhDjMapper;
import com.andawell.material.mapper.TJhGzMapper;
import com.andawell.material.query.TJhGzQuery;
import com.andawell.material.service.ITJhGzService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.vo.TJhGzVO;
import com.andawell.material.vo.TSrJhGzVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/***
 * @author shs
 * @Date: 2020/5/7 15:42
 * @Description:
 * @version : V1.0
 */
@Service
public class TJxGzServiceImpl implements ITJhGzService {
    @Autowired
    private TJhGzMapper tJhGzMapper;
    @Autowired
    private TJhDjMapper tJhDjMapper;

    /***
     * @author shs
     * @Date: 2020/7/2 17:29
     * @Description:
     * 1.获取用户单位
     * 2.用户单位,用户类型默认1
     * 3.公共信息数据和以上数据插入用户关注表
     * 4.公共信息数据和以上数据插入用户关注表
     */
    @Override
    public void insert(TJhGzzDTO tJhGzzDTO) {
        //获取用户单位
        BaseUser user = SysUserUtils.getUser();
        String deptId = user.getDeptId();
        //创建件号关注实体进行数据存储
        TJhGz tJhGz = new TJhGz();
        tJhGz.setJh(tJhGzzDTO.getJh());
        tJhGz.setJx(tJhGzzDTO.getJx());
        tJhGz.setLx(1);
        tJhGz.setYhid(deptId);
        tJhGzMapper.insertSelective(tJhGz);
    }
    /***
     * @author shs
     * @Date: 2020/7/2 17:29
     * @Description:
     * 1.获取到前端传的件号id
     * 2.删除件号关注具体数据
     */
    @Override
    public int delete(String jh) {
        return tJhGzMapper.deleteByPrimaryKey(jh);
    }

    @Override
    public List<TJhGzVO> list(TJhGzQuery tJhGzQuery) {
        Integer lx = tJhGzQuery.getLx();
        if (lx == 1) {
            return tJhGzMapper.Organlist(tJhGzQuery);
        } else if (lx == 2) {
            return tJhGzMapper.teamlist(tJhGzQuery);
        } else {
            return null;
        }
    }

    @Override
    public void insertSy(TJhGzzDTO tJhGzzDTO) {
        //获取用户名称
        BaseUser user = SysUserUtils.getUser();
        String Id = user.getId();
        //创建件号关注实体进行数据存储
        TJhGz tJhGz = new TJhGz();
        tJhGz.setJh(tJhGzzDTO.getJh());
        tJhGz.setJx(tJhGzzDTO.getJx());
        tJhGz.setLx(2);
        tJhGz.setYhid(Id);
        tJhGzMapper.insertSelective(tJhGz);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<TSrJhGzVO> srlist() {
        ArrayList<TSrJhGzVO> list=new ArrayList<>();
        //查询所有私人件号关注信息
        List<TSrJhGzVO> srlist = tJhGzMapper.srlist();
        //过滤私人件号关注信息
        BaseUser user = SysUserUtils.getUser();
        String deptId = user.getName();
        for (int i = 0; i < srlist.size(); i++) {
            if (deptId.equals(srlist.get(i).getYhid())){
                list.add(srlist.get(i));
            }
        }
        return list;
    }
}