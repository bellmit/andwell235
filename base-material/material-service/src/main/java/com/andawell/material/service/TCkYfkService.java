package com.andawell.material.service;

import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.material.dto.OutYFRegisterDTO;
import com.andawell.material.entity.TCkSyyl;
import com.andawell.material.entity.TXtFcff;
import com.andawell.material.query.OutYFQuery;
import com.andawell.material.vo.CompanyVO;
import com.andawell.material.vo.TCkYfkVO;

import java.util.List;

/***
 * @author hwd
 * @Date: 2020-05-08 11:57
 * @Description:
 * @version : V1.0
 */
public interface TCkYfkService {


    public List<TXtFcff> getFcList();


    public List<TCkSyyl> getList();

    public void saveMx(List<OutYFRegisterDTO> outYFRegisterDTO);

    public List<TCkYfkVO> getYFList(OutYFQuery outYFQuery);
}
