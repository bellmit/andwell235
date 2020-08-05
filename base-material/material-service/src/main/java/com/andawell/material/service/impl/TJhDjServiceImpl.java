package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.material.dto.TJhDjDTO;
import com.andawell.material.entity.*;
import com.andawell.material.mapper.TJhDjMapper;
import com.andawell.material.query.TJhDjQuery;
import com.andawell.material.service.ITJhDjService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.vo.TJhDjVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/***
 * @author shs
 * @Date: 2020/5/26 17:29
 * @Description:
 * @version : V1.0
 */
@Service
public class TJhDjServiceImpl implements ITJhDjService {
    @Autowired
    private TJhDjMapper tJhDjMapper;

    /***
     * @author shs
     * @Date: 2020/5/26 17:29
     * @Description:
     * 1.根据前端传入的件号信息
     * 2.将信息插入大件信息表中
     * 3.返回成功提示
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(TJhDjDTO tJhDjDTO) {
        TJhDj tJhDj = BeanUtils.dtoTODO(tJhDjDTO, TJhDj.class);
        tJhDjMapper.insertSelective(tJhDj);
    }

    @Override
    public List<TJhDjVO> list(TJhDjQuery query) {
        return new ListCommon<TJhDjQuery, TJhDjVO>(query,
                (q) -> tJhDjMapper.list(q)).get();
    }

    /***
     * @author shs
     * @Date: 2020/5/26 17:29
     * @Description:
     * 1.根据前端传入的大件id信息
     * 2.将对应id大件信息删除
     * 3.返回成功删除提示
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String jh = list.get(i);
            tJhDjMapper.deleteByPrimaryKey(jh);
        }
    }

}
