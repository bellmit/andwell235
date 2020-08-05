package com.andawell.material.service.impl;


import com.andawell.common.entity.search.ListCommon;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.util.SysUserUtils;
import com.andawell.material.dto.TJhJhDTO;
import com.andawell.material.dto.TJhJxDTO;
import com.andawell.material.dto.TJhJxjhDTO;
import com.andawell.material.dto.TJhJxjhDjazsDTO;
import com.andawell.material.entity.TJhJx;
import com.andawell.material.entity.TJhJxjh;
import com.andawell.material.entity.TJhJxlx;
import com.andawell.material.mapper.TJhJhMapper;
import com.andawell.material.mapper.TJhJxMapper;
import com.andawell.material.mapper.TJhJxjhMapper;
import com.andawell.material.mapper.TJhJxlxMapper;
import com.andawell.material.query.TJhJhQuery;
import com.andawell.material.query.TJhJxQuery;
import com.andawell.material.query.TJhJxlxQuery;
import com.andawell.material.service.ITJhJxService;
import com.andawell.material.util.AircaftModelTreeUtil;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.vo.AircaftModelTreelVO;
import com.andawell.upms.feign.RemoteAccountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 机型（飞机的型号）的增删改查  机型件号
 *
 * @Date： 2020/4/26 17:45
 */
@Service
public class TJhJxServiceImpl implements ITJhJxService {

    @Autowired
    TJhJxMapper tJhJxMapper;


    /**
     * 机型件号中间表mapper
     */
    @Autowired
    TJhJxjhMapper tJhJxjhMapper;

    @Autowired
    TJhJxlxMapper tJhJxlxMapper;

    @Autowired
    TJhJhMapper tJhJhMapper;

    @Autowired
    RemoteAccountService remoteAccountService;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<AircaftModelTreelVO> getTreeList() {
        TJhJxQuery query = new TJhJxQuery();
        //查询所有父节点
        query.setSgin(0);
        List<TJhJx> tJhJxeList = tJhJxMapper.list(query);
        //查询所有字节点
        query.setSgin(1);
        List<TJhJx> tJhJxes = tJhJxMapper.list(query);
        //做成树结构数据
        List<AircaftModelTreelVO> aircaftModeTreelVos = AircaftModelTreeUtil.buildTree(tJhJxeList, tJhJxes);
        return aircaftModeTreelVos;
    }


    @Override
    public TJhJx getTJhJxById(String jxId) {
        return tJhJxMapper.selectByPrimaryKey(jxId);
    }

    /**
     *
     * 机型新增
     * 根据sgin字段判断是子级新增还是父级新增
     * 父级新增首先查询出最大的父级id然后进行累加
     * 子级新增查询出在该父级下的最大id进行累加
     * 最后进行插入
     */
    @Override
    public void insert(TJhJxDTO tJhJxDTO) {
        //判断是新增子级还是新增父级
        if (StringUtils.isEmpty(tJhJxDTO.getPid())) {
            //新增父级   查询最大父级id+1
            tJhJxDTO.setId(tJhJxMapper.selectMaxPid());
        } else {
            //新增子级   查询最大的子级id+1
            String id = tJhJxMapper.selectZid(tJhJxDTO.getPid());
            if (id == null) {
                tJhJxDTO.setId(tJhJxDTO.getPid() + "01");
            } else {
                tJhJxDTO.setId(tJhJxMapper.selectZid(tJhJxDTO.getPid()));
            }
        }
        tJhJxMapper.insert(BeanUtils.dtoTODO(tJhJxDTO, TJhJx.class));
    }

    /**
     * *
     * 机型修改
     * 转换类型根据机型id进行修改
     */
    @Override
    public void updateByPrimaryKey(TJhJxDTO tJhJxDTO) {
        tJhJxMapper.updateByPrimaryKeySelective(BeanUtils.dtoTODO(tJhJxDTO, TJhJx.class));
    }

    /**
     * *
     * 机型删除
     *根据机型id删除
     */
    @Override
    public void delete(String id) {
        tJhJxMapper.deleteByPrimaryKey(id);
    }


/*    @Override
    public void deleteAndInsertjxjh(TJhJxjhDTO tJhJxjhDTO) {
        tJhJxjhMapper.delete(tJhJxjhDTO.getJx());
        tJhJxjhDTO.getJh().stream().forEach(oneJh -> {
            tJhJxjhMapper.insert(new TJhJxjh(tJhJxjhDTO.getJx(), oneJh));
        });
    }*/


    /**
     * 机型类型查询
     */
    @Override
    public List<TJhJxlx> listlx(TJhJxlxQuery query) {
        return new ListCommon<TJhJxlxQuery, TJhJxlx>(query,
                (q) -> tJhJxlxMapper.list(q)).get();
    }


    /**
     * 机型件号增加
     * 首先判断是一条增加还是全部增加
     * 如果是单条增加直接插入到中间表当中
     * 如果是全部增加
     * 首先把全量的件号查询出来
     * 然后在中间表把该机型的件号全量删除
     * 最后把机型跟全量件号插入到中间表当中
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertjxjh(TJhJxjhDTO tJhJxjhDTO) {


        List<TJhJxjh> tJhJxjhList = new ArrayList<>();
        //全部增加
        if (tJhJxjhDTO.isAll()) {
            TJhJhQuery query = new TJhJhQuery();
            // query.setPageSize(100);
            // 全部查询出件号
            List<TJhJhDTO> list = tJhJhMapper.list(query);
            // 机型中间表 全部删除
            tJhJxjhMapper.delete(tJhJxjhDTO.getJx());
            list.stream().forEach(oneTjhjhDto -> {
                TJhJxjh tJhJxjh = new TJhJxjh();
                tJhJxjh.setJx(tJhJxjhDTO.getJx());
                tJhJxjh.setJh(oneTjhjhDto.getId());
                tJhJxjhList.add(tJhJxjh);
            });


            ExecutorService newFiexedThreadPool = new ThreadPoolExecutor
                    (7,
                            10,
                            0L,
                            TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());


            // 分批次插入数据量太大
            int pointsDataLimit = 250;
            List<TJhJxjh> arrayList = new ArrayList<>();
            for (int i = 0; i < tJhJxjhList.size(); i++) {
                arrayList.add(tJhJxjhList.get(i));

                if (pointsDataLimit == arrayList.size() || i == tJhJxjhList.size() - 1) {
                    List insertList = new ArrayList();
                    insertList.addAll(arrayList);
                    arrayList.clear();
                    newFiexedThreadPool.execute(new Runnable() {
                        @Override
                        public void run() {
                            tJhJxjhMapper.insertAll(insertList);
                        }
                    });
                }
            }
            newFiexedThreadPool.shutdown();

        } else {
            //单增0
            TJhJxjh tJhJxjh = new TJhJxjh();
            tJhJxjh.setJx(tJhJxjhDTO.getJx());
            tJhJxjh.setJh(tJhJxjhDTO.getJh().get(0));
            tJhJxjhMapper.insert(tJhJxjh);
        }


       /* tJhJxjhDTO.getJh().stream().forEach(oneJh -> {
            tJhJxjh.setJh(oneJh);
            tJhJxjhMapper.insert(tJhJxjh);
        });*/
    }

    /**
     * 机型件号删除
     * 判断是否是全部删除还是单条删除
     * 在中间表删除数据
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deletejxjh(TJhJxjhDTO tJhJxjhDTO) {
        if (tJhJxjhDTO.isAll()) {
            //全删
            tJhJxjhMapper.delete(tJhJxjhDTO.getJx());
        } else {
            //单删
            tJhJxjhMapper.deleteByPrimaryKey(tJhJxjhDTO.getJx(), tJhJxjhDTO.getJh().get(0));
        }
    /*    tJhJxjhDTO.getJh().stream().forEach(oneJh -> {
            tJhJxjhMapper.deleteByPrimaryKey(tJhJxjhDTO.getJx(), oneJh);
        });*/
    }

    /**
     * \
     * 编辑单机安装数
     */
    @Override
    public void updatedjazs(TJhJxjhDjazsDTO tJhJxjhDjazsDTO) {
        tJhJxjhMapper.updatedjazs(new TJhJxjh(tJhJxjhDjazsDTO.getJx(), tJhJxjhDjazsDTO.getJh(), tJhJxjhDjazsDTO.getDjazs()));
    }

    @Override
    public List<TJhJx> selectById(String id) {
        TJhJxQuery tJhJxQuery = new TJhJxQuery();
        tJhJxQuery.setPid(id);
        List<TJhJx> list = tJhJxMapper.list(tJhJxQuery);
        return list;
    }

    @Override
    public List<TJhJx> getList(TJhJxQuery query) {
        //获取角色下的机型
        String roleId = SysUserUtils.getUser().getRoleId();
        RestResultVo<List<String>> moder = remoteAccountService.getRoleNuderModer(roleId);
        if (moder.getResult()==null || moder.getResult().isEmpty()){
            return null;
        }
        query.setIds(moder.getResult());
        return new ListCommon<TJhJxQuery, TJhJx>(query,
                (q) -> tJhJxMapper.list(q)).get();
    }


}
