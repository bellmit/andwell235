package com.andawell.material.service.impl;

import com.andawell.material.mapper.TDbSjsqqdMapper;
import com.andawell.material.service.ITDbSjsqqdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zje
 * @date: 2020/6/4
 * @description:
 */

@Service
public class TDbSjsqqdServiceImpl implements ITDbSjsqqdService {

    @Autowired
    private TDbSjsqqdMapper tDbSjsqqdMapper;

}
