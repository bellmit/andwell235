package com.andawell.material.service.impl;
import com.andawell.common.util.BusinessException;
import com.andawell.material.dto.OutYFRegisterDTO;
import com.andawell.material.dto.SystemNoDetailDTO;
import com.andawell.material.entity.*;
import com.andawell.material.mapper.*;
import com.andawell.material.query.OutYFQuery;
import com.andawell.material.service.IBaseLibraryService;
import com.andawell.material.service.TCkYfkService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.vo.TCkYfkVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * @author hwd
 * @Date: 2020-05-08 11:57
 * @Description:
 * @version : V1.0
 */
@Service
@Slf4j
public class TCkYfkServiceImpl implements TCkYfkService {


    @Autowired
    private TXtFcffMapper tXtFcffMapper;

    @Autowired
    private TCkSyylMapper tCkSyylMapper;

    @Autowired
    private TCkYfkMapper tCkYfkMapper;

    @Autowired
    private BaseLibraryService baseLibraryService;

    @Override
    public List<TXtFcff> getFcList()
    {
        return tXtFcffMapper.list(null);
    }

    @Override
    public List<TCkSyyl> getList() {

        return tCkSyylMapper.list(null);
    }

    @Override
    public void saveMx(List<OutYFRegisterDTO> outYFRegisterDTO) {
        for (OutYFRegisterDTO yfRegisterDTO : outYFRegisterDTO) {
            try {
                //生成编号
                String systemNumber = baseLibraryService.getSystemNumber(new SystemNoDetailDTO(yfRegisterDTO.getDwid(), yfRegisterDTO.getJm()));
                TCkYfk tCkYfk = BeanUtils.dtoTODO(yfRegisterDTO, TCkYfk.class);
                tCkYfk.setBh(systemNumber);
                tCkYfk.setXz("5");
                tCkYfkMapper.insertSelective(tCkYfk);
            }catch (Exception e)
            {
                e.printStackTrace();
                log.error(e.getMessage());
                throw  new BusinessException(yfRegisterDTO.getJh()+"新增异常");
            }

        }

    }

    public List<TCkYfkVO> getYFList(OutYFQuery outYFQuery){
        List<TCkYfkVO> outYFList = tCkYfkMapper.getOutYFList(outYFQuery);
        return outYFList;
    }
}


