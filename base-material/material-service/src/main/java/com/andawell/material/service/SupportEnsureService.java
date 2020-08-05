package com.andawell.material.service;

import com.andawell.material.dto.ManualCreationDTO;
import com.andawell.material.dto.TZyBzqdmxDTO;
import com.andawell.material.entity.TZyDy;
import com.andawell.material.entity.TZyFjs;
import com.andawell.material.entity.TZyRwsc;
import com.andawell.material.entity.TZyRwxz;

import java.util.List;

/***
 * @author hwd
 * @Date: 2020-05-20 13:33
 * @Description:
 * @version : V1.0
 */
public interface SupportEnsureService {

    public List<TZyDy> getTZyDyList();

    public List<TZyRwxz> getTZyRwxzList();

    public List<TZyFjs> getTZyFjsList();

    public List<TZyRwsc> getTZyRwscList();
    public Boolean saveMessage(List<TZyBzqdmxDTO> tZyBzqdmxDTOS);

    public void deleteMessage(List<TZyBzqdmxDTO> tZyBzqdmxDTOS);

    public void setMessage(ManualCreationDTO message);
}
