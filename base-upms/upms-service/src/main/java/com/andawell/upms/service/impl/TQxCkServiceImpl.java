package com.andawell.upms.service.impl;


import com.andawell.upms.dto.TQxCkDto;
import com.andawell.upms.entity.TQxCk;
import com.andawell.upms.entity.TXtCk;
import com.andawell.upms.mapper.TQxCkMapper;
import com.andawell.upms.mapper.TXtCkMapper;
import com.andawell.upms.query.TXtCkQuery;
import com.andawell.upms.query.TQxCkQuery;
import com.andawell.upms.service.TQxCKService;
import com.andawell.upms.utils.ValidableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;


/**
 *
 *角色仓库
 * @Date： 2020/5/13 14:12
 */
@Service
public class TQxCkServiceImpl implements TQxCKService {

    @Autowired
    private TQxCkMapper tQxCkMapper;
    @Autowired
    private TXtCkMapper tXtCkMapper;

    /**
     *@Auther:gzh
     *@Date:2020/7/6 9:09
     *@Description:角色新增仓库权限
     * 首先判断是单增还是全增
     * 丹增的话直接插入
     * 多增的话首先先把中间表中对应的数据全部删除
     * 然后在全量的插入
     *@Param:
     *@return:
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(TQxCkDto tQxCkDto) {
      /*  ValidableList<TQxCk> tQxCks = tQxCkDto.getTQxCks();*/
        //判断是全增还是单增
        if(tQxCkDto.isAll()){
            //存放准备全部插入的数据
            List<TQxCk> tQxCkList = new ArrayList<>();
            //查询出来所有的仓库
            TXtCkQuery tXtCkQuery = new TXtCkQuery();
            List<TXtCk> tXtCkList =  tXtCkMapper.list(tXtCkQuery);
            //全增  先根据角色把表全部清空
            tQxCkMapper.deleteByJs(tQxCkDto.getJs());
            //准备要插入的数据
            tXtCkList.stream().forEach(onetXtCk->{
                TQxCk tQxCk = new TQxCk();
                tQxCk.setJs(tQxCkDto.getJs());
                tQxCk.setCkid(onetXtCk.getCkid());
                tQxCk.setDwid(onetXtCk.getDwid());
                tQxCkList.add(tQxCk);
            });

            ExecutorService newFiexedThreadPool = new ThreadPoolExecutor
                    (7,
                            10,
                            0L,
                            TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());

            // 分批次插入数据量太大
            int pointsDataLimit = 250;
            List<TQxCk> arrayList = new ArrayList<>();
            for (int i = 0; i < tQxCkList.size(); i++) {
                arrayList.add(tQxCkList.get(i));

                if (pointsDataLimit == arrayList.size() || i == tQxCkList.size() - 1) {
                    List insertList = new ArrayList();
                    insertList.addAll(arrayList);
                    arrayList.clear();
                    newFiexedThreadPool.execute(new Runnable() {
                        @Override
                        public void run() {
                            tQxCkMapper.insertAll(insertList);
                        }
                    });
                }
            }
            newFiexedThreadPool.shutdown();


            //添加
      /*      tQxCkDto.getTQxCks().stream().forEach(oneTQxCk->{
                        tQxCkMapper.insert(oneTQxCk);
                    }
            );*/
        }else{
            //单增
            TQxCk tQxCk = new TQxCk();
            tQxCk.setDwid(tQxCkDto.getDwid());
            tQxCk.setCkid(tQxCkDto.getCkid());
            tQxCk.setJs(tQxCkDto.getJs());
            tQxCkMapper.insert(tQxCk);
        }


    }
/**
 *@Auther:gzh
 *@Date:2020/7/6 9:13
 *@Description:删除角色仓库
 * 全删的话根据js全部删除
 * 单姗的话根据表中主键进行删除
 *@Param:
 *@return:
 */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(TQxCkDto tQxCkDto) {

        if(tQxCkDto.isAll()){
            //全部删除
            tQxCkMapper.deleteByJs(tQxCkDto.getJs());
        }else{
            //删除一个
            tQxCkMapper.deleteByPrimaryKey(tQxCkDto.getJs(),tQxCkDto.getDwid(),tQxCkDto.getCkid());
        }

/*        tQxCkDto.getTQxCks().stream().forEach(oneTQxCk->{
            tQxCkMapper.deleteByPrimaryKey(oneTQxCk.getJs(),oneTQxCk.getDwid(),oneTQxCk.getCkid());
        });*/
    }

    @Override
    public List<String> getRoleNuderWarehouse(String js) {
        TQxCkQuery tQxCkQuery = new TQxCkQuery();
        tQxCkQuery.setJs(js);
        return tQxCkMapper.list(tQxCkQuery).stream().map(tQxCk -> tQxCk.getCkid()).collect(Collectors.toList());
    }
}
