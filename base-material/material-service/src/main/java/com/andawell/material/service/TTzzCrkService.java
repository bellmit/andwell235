package com.andawell.material.service;

import com.andawell.material.entity.TTzzCrk;

import java.util.List;

public interface TTzzCrkService {

    void insert(TTzzCrk tTzzCrk);

    List<String> listBh();

    String getMaxWh(String wh);
}
