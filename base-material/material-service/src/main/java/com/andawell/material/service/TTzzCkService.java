package com.andawell.material.service;

import com.andawell.material.entity.TTzzCk;

import java.util.List;

public interface TTzzCkService {

    void insert(TTzzCk tTzzCk);

    List<String> listJhAndXh();

    void update(TTzzCk tTzzCk);

    String getSl(String jh, String xh);

    void insertAll(List<String[]> List);


}
