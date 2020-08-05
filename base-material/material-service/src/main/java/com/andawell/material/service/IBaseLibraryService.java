package com.andawell.material.service;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.material.dto.*;
import com.andawell.material.entity.TCkCrk;
import com.andawell.material.entity.TCkCrklb;
import com.andawell.material.query.*;
import com.andawell.material.utils.ValidableList;
import com.andawell.material.vo.TCkCrkVO;
import com.andawell.material.vo.TCkCrkqdVO;

import java.util.List;

/***
 * @author lhb
 * @Date: 2020/5/18 11:42
 * @Description:
 * @version : V1.0
 */
public interface IBaseLibraryService {


    /**
     * 获取出入库 crk最新行数据
     * @return
     */
    TCkCrk selectByNew(String number, String wh);


    /**
     * 获取系统编号
     * @return
     */
    String getSystemNumber(SystemNoDetailDTO systemNoDetailDTO);

    /**
     * 获取系统文号
     * @param systemNoDetailDTO
     * @return
     */
    String getDocumentNo(SystemNoDetailDTO systemNoDetailDTO);

    /**
     * 获取系统文号
     * @param whNo
     * @return
     */
     Boolean isExit(String  whNo);

    /**
     * get 出入库类别
     * @return
     */
    ListPageVo<TCkCrklbQuery, TCkCrklb> getReceiptCategoryList(TCkCrklbQuery query);

    /**
     * 保存入库信息
     *
     * @param
     * @return
     */
     Boolean saveInLibraryInfo(LibraryInfoDTO libraryInfoDTO);


    /**
     * 保存出库信息
     *
     * @param
     * @return
     */
    Boolean saveOutLibraryInfo(OutLibraryInfoDTO outLibraryInfoDTO);


    /**
     * 冲销出入库
     *
     * @param
     * @return
     */
    Boolean saveAndUpdateInAndOutWriteOff(WriteOffDTO writeOffDTO);


    /**|
     * 出入库清单列表
     * @param tCkCrkQuery
     * @return
     */
    ListPageVo<TCkCrkQuery, TCkCrkVO> getTCkCrkVOList(TCkCrkQuery tCkCrkQuery);


    /**|
     * 冲销出入库列表
     * @param tCkCrkqdQuery
     * @return
     */
     List<TCkCrkqdVO> getTckCrkQdList(TCkCrkqdQuery tCkCrkqdQuery);


    /**
     * 保存出入库清单
     *
     * @param
     * @return
     */
     Boolean saveInAndOutList(SystemNoDetailDTO systemNoDetailDTO, LibraryMasterDTO libraryMasterDTO, ValidableList list);


     /**
      *@Author: liuys
      *@Data: 2020/6/18
      *@Description: 出入库预览
      */
    String getPreview(AccessPreviewQuery accessPreviewQuery);

/**
 *@Author: liuys
 *@Data: 2020/6/20
 *@Description: 预览前先删除
 */
    Boolean delPreview(String userId);


    String getOutPreview(OutAccessPreviewQuery outAccessPreviewQuery);
}
