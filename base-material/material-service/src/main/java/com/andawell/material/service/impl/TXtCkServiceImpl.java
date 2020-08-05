package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.util.SysUserUtils;
import com.andawell.material.entity.TXtCk;
import com.andawell.material.mapper.TXtCkMapper;
import com.andawell.material.query.TXtCkQuery;
import com.andawell.material.service.ITXtCkService;
import com.andawell.upms.feign.RemoteAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * @author lhb
 * @Date: 2020/4/26 17:29
 * @Description:
 * @version : V1.0
 */
@Service
public class TXtCkServiceImpl implements ITXtCkService {


    @Autowired
    TXtCkMapper tXtCkMapper;

    @Autowired
    RemoteAccountService remoteAccountService;
    /**
     * 仓库查询接口
     * @param
     * @return
     */
    @Override
    public List<TXtCk> list(TXtCkQuery tXtCkQuery) {
        //根据用户角色查询所有角色下的仓库id
        String roleId = SysUserUtils.getUser().getRoleId();
        RestResultVo<List<String>> res = remoteAccountService.getRoleNuderWarehouse(roleId);
        if (res.getResult()==null || res.getResult().size()==0){
            return null;
        }
        tXtCkQuery.setCkids(res.getResult());
        //查询出所有仓库
        return new ListCommon<TXtCkQuery, TXtCk>(tXtCkQuery,
                (q) -> tXtCkMapper.list(q)).get();
    }
}
