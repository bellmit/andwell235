package com.andawell.material.service;

import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.material.dto.BatchChangeDTO;
import com.andawell.material.dto.LibraryInfoDTO;
import com.andawell.material.entity.TCkDx;
import com.andawell.material.query.TCkDxQuery;
import com.andawell.material.vo.TCkDxStatusVO;

import java.util.List;

public interface ITCkDxService {

    public ListPageVo<TCkDxQuery,TCkDxStatusVO> list(TCkDxQuery query);

    public void batchChange(BatchChangeDTO batchChangeDTO);


}
