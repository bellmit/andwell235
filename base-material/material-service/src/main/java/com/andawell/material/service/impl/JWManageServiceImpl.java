package com.andawell.material.service.impl;

import com.andawell.common.util.BusinessException;
import com.andawell.material.dto.JWManageDTO;
import com.andawell.material.entity.TCkBfk;
import com.andawell.material.entity.TCkCk;
import com.andawell.material.entity.TCkDx;
import com.andawell.material.mapper.TCkBfkMapper;
import com.andawell.material.mapper.TCkCkMapper;
import com.andawell.material.mapper.TCkDxMapper;
import com.andawell.material.service.JWManageService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.utils.ValidableList;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.ArrayStack;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.andawell.material.constant.BusinessConstant.INVENTORY_ALREADY_EXIST;

/***
 * @author hwd
 * @Date: 2020-05-15 10:43
 * @Description:
 * @version : V1.0
 */
@Service
@Slf4j
public class JWManageServiceImpl implements JWManageService {


    @Autowired
    private TCkCkMapper tCkCkMapper;


    @Autowired
    private TCkDxMapper tCkDxMapper;


    @Autowired
    private TCkBfkMapper tCkBfkMapper;

    /**
     * 根据主信息修改全部明细的架位号和仓库号
     */
    @Transactional(rollbackFor = Exception.class)
    public Boolean jwAllUpdate(JWManageDTO jwManageDTO) {
        //根据主信息拿到相关明细
        List<TCkCk> listByjhjxzl = tCkCkMapper.getListByjhjxzl(jwManageDTO.getJx(), jwManageDTO.getJh(), jwManageDTO.getZl());
        if (!listByjhjxzl.isEmpty()) {
            for (TCkCk tCkCk : listByjhjxzl) {
                //修改架位号 和 仓库号
                tCkCk.setJwh(jwManageDTO.getJwh());
                tCkCk.setCkdm(jwManageDTO.getCkdm());
                //保存信息
                try {
                    int i = tCkCkMapper.updateByPrimaryKeySelective(tCkCk);
                    if(i<=0)
                    {
                        return false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error(e.getMessage());
                    throw new BusinessException(tCkCk.getJh() + "修改失败");
                }
            }
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean jwOneUpdate(JWManageDTO jwManageDTO) {
        //对单位ID 和 xz 进行判空

        if(StringUtils.isNotEmpty(jwManageDTO.getDwid())&& StringUtils.isNotEmpty(jwManageDTO.getXz())&&
        StringUtils.isNotEmpty(jwManageDTO.getXh()))
        {
            //进行修改
            TCkCk tCkCk = BeanUtils.dtoTODO(jwManageDTO, TCkCk.class);
            //修改架位号 和 仓库号
            tCkCk.setJwh(jwManageDTO.getJwh());
            tCkCk.setCkdm(jwManageDTO.getCkdm());
            try {
                int i = tCkCkMapper.updateByPrimaryKeySelective(tCkCk);
                if(i<=0)
                {
                   return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
                throw new BusinessException(tCkCk.getJh() + "修改失败");
            }

        }else {
            throw  new BusinessException(jwManageDTO.getJh()+"的DWid或者xz为空");
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean pendHCJWManage(List<JWManageDTO> jwManageDTOs) {
        //修改待修库
        //修改价位号 和 仓库代码
        for (JWManageDTO jwManageDTO : jwManageDTOs) {
            if(StringUtils.isNotEmpty(jwManageDTO.getDwid())&& StringUtils.isNotEmpty(jwManageDTO.getXz())&&
                    StringUtils.isNotEmpty(jwManageDTO.getXh())&&StringUtils.isNotEmpty(jwManageDTO.getBh()))
            {
                TCkDx tCkDx = BeanUtils.dtoTODO(jwManageDTO, TCkDx.class);
                try {
                    int i = tCkDxMapper.updateByPrimaryKeySelective(tCkDx);
                    if(i<=0)
                    {
                        return false;
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                    log.error(e.getMessage());
                    throw new BusinessException(jwManageDTO.getJh() + "修改失败");
                }
            }else
            {
                throw new BusinessException(jwManageDTO.getJh() + "参数不全");
            }
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean discardJWManage(List<JWManageDTO> jwManageDTOs) {
        //修改报废库
        //修改价位号 和 仓库代码
        for (JWManageDTO jwManageDTO : jwManageDTOs) {
            if(StringUtils.isNotEmpty(jwManageDTO.getDwid())&& StringUtils.isNotEmpty(jwManageDTO.getXh())
                    &&StringUtils.isNotEmpty(jwManageDTO.getBh()))
            {
                TCkBfk tCkBfk = BeanUtils.dtoTODO(jwManageDTO, TCkBfk.class);
                try {
                    int count = tCkBfkMapper.updateByPrimaryKeySelective(tCkBfk);
                    if(count<=0)
                    {
                        return false;
                    }

                }catch (Exception e) {
                    e.printStackTrace();
                    log.error(e.getMessage());
                    throw new BusinessException(jwManageDTO.getJh() + "修改失败-数据库异常");
                }
            }else
            {
                throw new BusinessException(jwManageDTO.getJh() + "参数不全");
            }
        }
        return true;
    }
}
