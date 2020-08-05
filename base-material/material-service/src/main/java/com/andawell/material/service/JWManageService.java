package com.andawell.material.service;

import com.andawell.material.dto.JWManageDTO;
import com.andawell.material.utils.ValidableList;

import java.util.List;

/***
 * @author hwd
 * @Date: 2020-05-15 10:43
 * @Description:
 * @version : V1.0
 */
public interface JWManageService {


    public Boolean jwAllUpdate(JWManageDTO jwManageDTO);
    public Boolean jwOneUpdate(JWManageDTO jwManageDTO);
    public Boolean pendHCJWManage(List<JWManageDTO> jwManageDTOs);

    public Boolean discardJWManage(List<JWManageDTO> jwManageDTOs);
}
