package com.andawell.material.service;

import com.andawell.material.dto.LibraryInfoDTO;
import com.andawell.material.dto.TCkCrkqdDTO;
import com.andawell.material.vo.ZbKcVO;

import java.util.List;

/**
 * @author: zje
 * @date: 2020/5/15
 * @description:
 */
public interface ITCkCrkqdService {

    /**
     *@Auther:zje
     *@Date:2020/5/15
     *@Description:周转转战备添加
     *@Param:libraryInfoDTO
     *@return:
     */
    void insertZB(TCkCrkqdDTO ckCrkqdDTO);

    /**
     *@Auther:zje
     *@Date:2020/5/15
     *@Description:战备转周转
     *@Param:
     *@return:
     */
    void insertZZ(TCkCrkqdDTO ckCrkqdDTO);

    List<ZbKcVO> list(String jh);

    String getCkNo();

    String getrkNo();
}
