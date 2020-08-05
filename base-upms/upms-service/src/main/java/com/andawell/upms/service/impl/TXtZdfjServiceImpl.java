package com.andawell.upms.service.impl;

import com.andawell.common.util.BusinessException;
import com.andawell.upms.constant.NoticeConstant;
import com.andawell.upms.entity.TXtZdfj;
import com.andawell.upms.entity.ZdfjDTO;
import com.andawell.upms.mapper.TXtZdfjMapper;
import com.andawell.upms.query.TXtZdfjQuery;
import com.andawell.upms.service.TXtZdfjService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Service
public class TXtZdfjServiceImpl implements TXtZdfjService {

    @Autowired
    private TXtZdfjMapper tXtZdfjMapper;
    @Override
    public void insert(TXtZdfj tXtZdfj) {
        tXtZdfjMapper.insert(tXtZdfj);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ZdfjDTO zdfjDTO) {
        String ymc = zdfjDTO.getYmc();
        String xmc = zdfjDTO.getXmc();
        List<TXtZdfj> list = list(new TXtZdfjQuery().setMc(ymc));
        if (list.isEmpty()) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_MESSAGE+":"+ymc);
        }
        List<TXtZdfj> listX = list(new TXtZdfjQuery().setMc(xmc));
        if (!listX.isEmpty()) {
            throw new BusinessException(NoticeConstant.RESPONSE_NAME_REPEAT_MESSAGE+":"+xmc);
        }
        TXtZdfj zdfj = new TXtZdfj();
        zdfj.setDwid(zdfjDTO.getDwid());
        zdfj.setZdid(zdfjDTO.getZdid());
        zdfj.setMc(xmc);
        tXtZdfjMapper.delete(ymc);
        int i=tXtZdfjMapper.insert(zdfj);
        if (i < 1){
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_MESSAGE+":"+xmc);
        }
    }

    @Override
    public void deleteByMc(String mc) {
        int i=tXtZdfjMapper.delete(mc);
        if (i < 1) {
            throw new BusinessException(NoticeConstant.RESPONSE_NOTFOUND_MESSAGE+":"+mc);
        }
    }

    @Override
    public List<TXtZdfj> list(TXtZdfjQuery query) {
        return tXtZdfjMapper.list(query);
    }

}
