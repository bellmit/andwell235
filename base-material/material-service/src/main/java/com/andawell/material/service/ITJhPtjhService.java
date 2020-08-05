package com.andawell.material.service;


import com.andawell.material.dto.TJhJxDTO;
import com.andawell.material.dto.TJhJxjhDTO;
import com.andawell.material.dto.TJhPtjhDTO;
import com.andawell.material.entity.TJhJx;
import com.andawell.material.entity.TJhJxlx;
import com.andawell.material.entity.TJhPtjh;
import com.andawell.material.query.TJhJxlxQuery;
import com.andawell.material.vo.AircaftModelTreelVO;

import java.util.List;

/**
 * 件号配套件号管理
 */
public interface ITJhPtjhService {


    void insert(TJhPtjhDTO tJhPtjhDTO);

    void delete(TJhPtjhDTO tJhPtjhDTO);

    TJhPtjh select(TJhPtjhDTO tJhPtjhDTO);
}
