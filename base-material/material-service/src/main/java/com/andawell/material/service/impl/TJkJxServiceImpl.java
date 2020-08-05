package com.andawell.material.service.impl;

import com.andawell.common.util.BusinessException;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TJkJx;
import com.andawell.material.mapper.TJkJxMapper;
import com.andawell.material.service.TJkJxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author:PCJ
 * @Date:2020/5/22
 * @Version:V1.0.0
 */
@Service
@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class TJkJxServiceImpl implements TJkJxService {

    @Autowired
    private TJkJxMapper tJkJxMapper;
    /***
     * @author pcj
     * @Date: 2020/7/13 17:29
     * @Description:
     * 1.获取到前端传的数据
     * 2.如果结果大于一条编辑成功
     */
    @Override
    public void update(TJkJx tJkJx) {
        int i = tJkJxMapper.updateByPrimaryKeySelective(tJkJx);
        if (i < 1) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_MESSAGE);
        }
    }
}
