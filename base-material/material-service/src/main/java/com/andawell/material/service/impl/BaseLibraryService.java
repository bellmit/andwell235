package com.andawell.material.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.andawell.common.entity.search.ListCommon;
import com.andawell.common.entity.search.ListPageCommon;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.util.BusinessException;
import com.andawell.common.util.SysUserUtils;
import com.andawell.material.covert.LibraryInfoDtoCoverDo;
import com.andawell.material.dto.*;
import com.andawell.material.entity.*;
import com.andawell.material.enumeration.WriteOffEnum;
import com.andawell.material.mapper.*;
import com.andawell.material.query.*;
import com.andawell.material.service.AbstractInAndOutLibrary;
import com.andawell.material.service.IBaseLibraryService;
import com.andawell.material.service.ITJhJxService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.util.Utils;
import com.andawell.material.utils.ValidableList;
import com.andawell.material.vo.TCkCrkVO;
import com.andawell.material.vo.TCkCrkqdVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static com.andawell.material.constant.BusinessConstant.*;
import static com.andawell.material.constant.BusinessConstant.CUt_AFTER_EXAMINATION_FAIL;
import static com.andawell.material.util.Utils.getSysYear;

/***
 * @author lhb
 * @Date: 2020/5/18 11:31
 * @Description:
 * @version : V1.0
 */
@Slf4j
@Service
public class BaseLibraryService extends AbstractInAndOutLibrary implements IBaseLibraryService {


    @Autowired
    TCkCkMapper tCkCkMapper;

    @Autowired
    TCkCrkMapper tCkCrkMapper;

    @Autowired
    TCkCrkqdMapper tCkCrkqdMapper;

    @Autowired
    ITJhJxService itJhJxService;

    @Autowired
    TCkCrklbMapper tCkCrklbMapper;

    @Autowired
    TroubleShootService troubleShootService;

    @Autowired
    TSqliteFfMapper tSqliteFfMapper;

    @Autowired
    TCkCrkTemporayMapper tCkCrkTemporayMapper;

    @Autowired
    TCkCrkqdTemporayMapper tCkCrkqdTemporayMapper;

    /**
     * 保存入库信息
     *
     *1.保存t_ck_crk和t_ck_crkqd信息的保存
     * 2.保存t_ck_ck信息报
     *
     * @param libraryInfoDTO@return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveInLibraryInfo(LibraryInfoDTO libraryInfoDTO) {

        //crk和crkqd保存
        Boolean isSuccess = saveInAndOutList(libraryInfoDTO.getSystemNoDetailDTO(),
                libraryInfoDTO.getLibraryMasterDTO(), libraryInfoDTO.getList());
        // 存储ckck数据
        List<InAndOutLibraryDetailDTO> detailDTOList = libraryInfoDTO.getList();

        List<TCkCk> tCkCkList =
                LibraryInfoDtoCoverDo.getTckckListDo(libraryInfoDTO.getLibraryMasterDTO(), detailDTOList);
        for (TCkCk ckCk : tCkCkList) {
            try {
                tCkCkMapper.insertSelective(ckCk);
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
                throw new BusinessException(String.format(INVENTORY_ALREADY_EXIST, ckCk.getJh(), ckCk.getXh()));
            }
        }
        return isSuccess;
    }


    /**
     * 保存出入库清单
     *
     * @param systemNoDetailDTO
     * @param libraryMasterDTO
     * @param list
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveInAndOutList(SystemNoDetailDTO systemNoDetailDTO, LibraryMasterDTO libraryMasterDTO, ValidableList list) {

        if (list.getList() == null || list.getList().size() <= 0 || null == libraryMasterDTO) {
            log.error("request param is not null");
            return false;
        }
        // 存储crk 出入库主表

        if (systemNoDetailDTO.getIsUpdate()!=null && systemNoDetailDTO.getIsUpdate()) {
            libraryMasterDTO.setBh(this.getSystemNumber(systemNoDetailDTO));
        }

        if (systemNoDetailDTO.getIsGetSystemNo() != null && systemNoDetailDTO.getIsGetSystemNo() == true) {
            libraryMasterDTO.setBh(Utils.getNextNoBySystemNo(libraryMasterDTO.getBh()));
        }

        TCkCrk ckCrk = LibraryInfoDtoCoverDo.getTCkCrkDo(libraryMasterDTO);
        if (systemNoDetailDTO.getState() == null) {
            ckCrk.setWh(this.getDocumentNo(systemNoDetailDTO));
        } else {
            //
            ckCrk.setWh(troubleShootService.outNumber(systemNoDetailDTO.getState()));
        }
        ckCrk.setFjlx(libraryMasterDTO.getJx());
        ckCrk.setCjrq(new Date(System.currentTimeMillis()));
        try {
            tCkCrkMapper.insertSelective(ckCrk);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            /**
             * 编号+bh，单位id+dwid
             */
            throw new BusinessException(String.format(INVENTORY_ALREADY_EXIST,
                    ckCrk.getBh(), ckCrk.getDwid()));
        }
        List<TCkCrkqd> tCkCrkqdList =
                LibraryInfoDtoCoverDo.getTCkCrkqdListDo(ckCrk, libraryMasterDTO, list);
        for (TCkCrkqd tCkCrkqd : tCkCrkqdList) {
            try {
                tCkCrkqd.setCjrq(new Date(System.currentTimeMillis()));

                tCkCrkqdMapper.insertSelective(tCkCrkqd);
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
                /**
                 * 机型:+tCkCrkqd.getJx()，红冲标示tCkCrkqd.getCxsgin()，单位tCkCrkqd.getDwid()，选择"+tCkCrkqd.getXz()
                 */
                throw new BusinessException(String.format(INVENTORY_ALREADY_EXIST,
                        tCkCrkqd.getJh(), tCkCrkqd.getXh()));
            }
        }
        return true;
    }

    /**
     * 保存出库信息
     *
     * @param outLibraryInfoDTO@return
     */

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveOutLibraryInfo(OutLibraryInfoDTO outLibraryInfoDTO) {
        // 更新ckck数据
        List<OutLibraryDetailDTO> detailDTOList = outLibraryInfoDTO.getList();

        ValidableList<InAndOutLibraryDetailDTO> list = new ValidableList<>();

        for (OutLibraryDetailDTO outLibraryDetailDTO : detailDTOList) {
            // 查询出ckck  核减数量
            TCkCk tCkCk =
                    tCkCkMapper.selectByPrimaryKey(
                            outLibraryDetailDTO.getDwid(),
                            outLibraryDetailDTO.getJx(),
                            outLibraryDetailDTO.getJh(),
                            outLibraryDetailDTO.getXh(),
                            outLibraryDetailDTO.getZl(),
                            "0");
            try {

                // 跟新数据
                Long count = tCkCk.getSl() - outLibraryDetailDTO.getCksl();

                // 抛出异常
                if (count < 0) {
                    throw new BusinessException(
                            String.format(OUT_OF_MEMORY,
                                    tCkCk.getJh(), tCkCk.getXh()));
                }

                tCkCk.setSl(tCkCk.getSl() - outLibraryDetailDTO.getCksl());

                // 组装数据
                InAndOutLibraryDetailDTO inAndOutLibraryDetailDTO = new InAndOutLibraryDetailDTO();
                org.springframework.beans.BeanUtils.copyProperties(tCkCk, inAndOutLibraryDetailDTO);
                list.add(inAndOutLibraryDetailDTO);
                tCkCkMapper.updateByPrimaryKeySelective(tCkCk);
            } catch (BusinessException e) {
                e.printStackTrace();
                log.error(e.getMessage());
                throw new BusinessException(
                        String.format(CUt_AFTER_EXAMINATION_FAIL,
                                tCkCk.getJh(), tCkCk.getXh()));
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
                throw new BusinessException(CUt_AFTER_EXAMINATION_FAIL);
            }
        }
        //crk和crkqd保存
        Boolean isSuccess = saveInAndOutList(outLibraryInfoDTO.getSystemNoDetailDTO(),
                outLibraryInfoDTO.getLibraryMasterDTO(), list);
        return isSuccess;

    }

    /**
     * ckck 冲销
     *
     * @param writeOffDTO
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Boolean baseCkCkWriteOff(WriteOffDTO writeOffDTO) {
        TCkCk tCkCk =
                tCkCkMapper.selectByPrimaryKey
                        (writeOffDTO.getDwid(), writeOffDTO.getJx(),
                                writeOffDTO.getJh(), writeOffDTO.getXh(),
                                writeOffDTO.getZl(), writeOffDTO.getXz());
        if (tCkCk == null) {
            throw new BusinessException(String.format(LIBRARY_NOT_EXIT, writeOffDTO.getJx(),
                    writeOffDTO.getJh(), writeOffDTO.getXh()));
        }
        // 出库 是加回来
        tCkCk.setSl(tCkCk.getSl() + writeOffDTO.getSl());
        if (!writeOffDTO.getCrk()) {
            // 入库 减回来
            tCkCk.setSl(tCkCk.getSl() - writeOffDTO.getSl());
        }
        tCkCkMapper.updateByPrimaryKeySelective(tCkCk);
        return this.saveAndUpdateInAndOutWriteOff(writeOffDTO);
    }

    /**
     * 冲销出入库
     *
     * @param writeOffDTO@return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveAndUpdateInAndOutWriteOff(WriteOffDTO writeOffDTO) {

        TCkCrkqd tCkCrkqd = tCkCrkqdMapper.selectByPrimaryKey(writeOffDTO.getBh(),
                writeOffDTO.getJx(),
                writeOffDTO.getJh(),
                writeOffDTO.getXh(),
                writeOffDTO.getCxsgin(),
                writeOffDTO.getDwid(),
                writeOffDTO.getXz());
        if (tCkCrkqd == null) {
            throw new BusinessException(String.format(LIBRARY_NOT_EXIT, writeOffDTO.getJx(),
                    writeOffDTO.getJh(), writeOffDTO.getXh()));
        }

        if (writeOffDTO.getLb().startsWith("10")) {
            // 1.根据选择的数据进行行级别的数据冲销。即一次处理一行数据。
            // 2.判断选择需要进行入库冲销的数据，是否已经出库。判断条件：无出库记录，
            // 或有出库记录但出库日期小于选择数据的入库日期，否则不允许冲销。  类别lb 以10入库 ，20 出库
            TCkCrkqdQuery tCkCrkqdQuery = new TCkCrkqdQuery();
            tCkCrkqdQuery.setBh(writeOffDTO.getBh());
            // 2. 受否小于出库日期
            List<TCkCrkqdVO> list = this.getTckCrkQdList(tCkCrkqdQuery);
            if (list != null && list.size() > 0) {
                if (list.get(0).getLb().startsWith("20")) {
                    throw new BusinessException(String.format(LIBRARY_NOT_WRITE_FAIL, writeOffDTO.getJx(),
                            writeOffDTO.getJh(), writeOffDTO.getXh()));
                }
            }
        }

        try {
            // 跟新数据
            // 冲销值的改变
            tCkCrkqd.setXcxsgin(WriteOffEnum.REVERSED.getName());
            tCkCrkqdMapper.updateByPrimaryKeySelective(tCkCrkqd);
            // 插入数据
            tCkCrkqd.setSl(Math.abs(tCkCrkqd.getSl()));
            tCkCrkqd.setCxsgin(WriteOffEnum.WRITE_OFF_RECORD.getName());
            tCkCrkqd.setCjrq(new Date(System.currentTimeMillis()));
            tCkCrkqdMapper.insertSelective(tCkCrkqd);
        } catch (Exception e) {
            log.error("write off is error");
            e.printStackTrace();
            throw new BusinessException("write off is error");
        }

        return true;
    }

    /**
     * 冲销 出入库列表
     *
     * @param tCkCrkQuery
     * @return
     */
    @Override
    public ListPageVo<TCkCrkQuery, TCkCrkVO> getTCkCrkVOList(TCkCrkQuery tCkCrkQuery) {
        return new ListPageCommon<TCkCrkQuery, TCkCrkVO>
                (tCkCrkQuery, (q) -> tCkCrkMapper.getList(q)).getVo();
    }

    /**
     * |
     * 冲销出入库列表
     *
     * @param tCkCrkqdQuery
     * @return
     */
    @Override
    public List<TCkCrkqdVO> getTckCrkQdList(TCkCrkqdQuery tCkCrkqdQuery) {
        return new ListCommon<TCkCrkqdQuery, TCkCrkqdVO>
                (tCkCrkqdQuery, (q) -> tCkCrkqdMapper.getList(q)).get();
    }

    /**
     * 获取系统编号
     *
     * @param systemNoDetailDTO
     * @return
     */
    @Override
    public String getSystemNumber(SystemNoDetailDTO systemNoDetailDTO) {

        SystemNumberQuery systemNumberQuery =
                new SystemNumberQuery(systemNoDetailDTO.getLbjm(), systemNoDetailDTO.getDwid());
        //获取数据库最新数据
        TCkCrk tCkCrk = this.selectByNew(systemNoDetailDTO.getLbjm().toUpperCase()
                + Utils.SING + systemNoDetailDTO.getDwid(), null);
        if (tCkCrk == null) {
            tCkCrk = new TCkCrk();
        }

        String systemNumber =
                Utils.getSystemNumberByRule(systemNumberQuery, tCkCrk.getBh());
        return systemNumber;
    }

    /**
     * 获取系统文号
     *
     * @param systemNoDetailDTO
     * @return
     */
    @Override
    public String getDocumentNo(SystemNoDetailDTO systemNoDetailDTO) {
        //获取数据库最新数据
        TJhJx tJhJx = itJhJxService.getTJhJxById(systemNoDetailDTO.getJxid());
        // t_jh_JX:0取本级的JM，1取上级的JM
        if (tJhJx != null && tJhJx.getSgin() == 1) {
            tJhJx = itJhJxService.getTJhJxById(tJhJx.getPid());
        }
        // 查出上一条序列文号记录
        TCkCrk tCkCrk = this.selectByNew(null, tJhJx.getJm().toUpperCase()
                + systemNoDetailDTO.getZllb().toUpperCase() + getSysYear().substring(2, getSysYear().length()));
        String documentNo =
                Utils.getDocumentNo(tJhJx, tCkCrk == null ? null : tCkCrk.getWh(), systemNoDetailDTO.getZllb());
        return documentNo;
    }

    /**
     * 获取系统文号
     *
     * @param whNo
     * @return
     */
    @Override
    public Boolean isExit(String whNo) {
        List<TSqliteFf> list = tSqliteFfMapper.selectByWh(whNo);
        if (list != null && !list.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 获取出入库 crk最新行数据
     *
     * @return
     */
    @Override
    public TCkCrk selectByNew(String number, String wh) {
        return tCkCrkMapper.selectByNew(number, wh);
    }

    /**
     * get 出入库类别
     *
     * @return
     */
    @Override
    public ListPageVo<TCkCrklbQuery, TCkCrklb> getReceiptCategoryList(TCkCrklbQuery query) {
        return new ListPageCommon<TCkCrklbQuery, TCkCrklb>(query, (q) ->
                tCkCrklbMapper.list(q)).getVo();
    }

    /**
     * @Author: liuys
     * @Data: 2020/6/18
     * @Description: 出入库预览
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String getPreview(AccessPreviewQuery accessPreviewQuery) {
        ValidableList<InAndOutLibraryDetailDTO> list = accessPreviewQuery.getList();
        LibraryMasterDTO libraryMasterDTO = accessPreviewQuery.getLibraryMasterDTO();
        SystemNoDetailDTO systemNoDetailDTO = accessPreviewQuery.getSystemNoDetailDTO();
        //如果是全新和可用的数据进行判断库中是否存在
        if (accessPreviewQuery.getState() != null && accessPreviewQuery.getState() == true) {
            if (accessPreviewQuery.getSystemNoDetailDTO().getZllb().equals("QX") || accessPreviewQuery.getSystemNoDetailDTO().getZllb().equals("KY")) {
                for (InAndOutLibraryDetailDTO inAndOutLibraryDetailDTO : list) {
                    //入库的ckck信息查询
                    TCkCk tCkCk = tCkCkMapper.selectByPrimaryKey(systemNoDetailDTO.getDwid(), libraryMasterDTO.getJx(), inAndOutLibraryDetailDTO.getJh(),
                            inAndOutLibraryDetailDTO.getXh(), inAndOutLibraryDetailDTO.getZl(), inAndOutLibraryDetailDTO.getXz());
                    if (tCkCk != null) {
                        throw new BusinessException(String.format(INVENTORY_ALREADY_EXIST,
                                inAndOutLibraryDetailDTO.getJh(), inAndOutLibraryDetailDTO.getXh()));
                    }
                }
            }
        }
        //编号
        String bh = this.getPreviewNumber(systemNoDetailDTO);
        //crk和crkqd保存
        if (list.getList() == null || list.getList().

                size() <= 0 || null == libraryMasterDTO) {
            log.error("request param is not null");
            return null;
        }
        //存储crk临时表数据
        libraryMasterDTO.setBh(bh);
        if (systemNoDetailDTO.getIsGetSystemNo() != null && systemNoDetailDTO.getIsGetSystemNo() == true) {
            libraryMasterDTO.setBh(Utils.getNextNoBySystemNo(libraryMasterDTO.getBh()));
        }

        TCkCrkTemporay tCkCrkTemporay = BeanUtils.dtoTODO(libraryMasterDTO, TCkCrkTemporay.class);
        tCkCrkTemporay.setWh(this.

                getDocumentNo(systemNoDetailDTO));
        tCkCrkTemporay.setFjlx(libraryMasterDTO.getJx());
        tCkCrkTemporay.setCjrq(new

                Date(System.currentTimeMillis()));
        String userId = SysUserUtils.getUserId();
        tCkCrkTemporay.setDlr(userId);
        tCkCrkTemporay.setRq(new

                Date());
        tCkCrkTemporay.setCjrq(new

                Date());
        try {
            tCkCrkTemporayMapper.insertSelective(tCkCrkTemporay);
        } catch (
                Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            /**
             * 编号+bh，单位id+dwid
             */
            throw new BusinessException(String.format(INVENTORY_ALREADY_EXIST,
                    tCkCrkTemporay.getBh(), tCkCrkTemporay.getDwid()));
        }

        List<TCkCrkqdTemporay> tCkCrkqdTemporays = BeanUtils.copyList(list, TCkCrkqdTemporay.class);
        for (
                TCkCrkqdTemporay tCkCrkqdTemporay : tCkCrkqdTemporays) {
            try {
                tCkCrkqdTemporay.setCxsgin("0");
                tCkCrkqdTemporay.setBh(tCkCrkTemporay.getBh());
                tCkCrkqdTemporay.setDlr(userId);
                tCkCrkqdTemporay.setXz(tCkCrkqdTemporay.getXz() == null ? "1" : tCkCrkqdTemporay.getXz());
                tCkCrkqdTemporay.setDwid(tCkCrkTemporay.getDwid());
                if (tCkCrkqdTemporay.getSl() != null && tCkCrkqdTemporay.getDj() != null) {
                    BigDecimal sl = new BigDecimal(tCkCrkqdTemporay.getSl());
                    BigDecimal zj = tCkCrkqdTemporay.getDj().multiply(sl);
                    tCkCrkqdTemporay.setZj(zj);
                }
                tCkCrkqdTemporayMapper.insertSelective(tCkCrkqdTemporay);
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
                /**
                 * 机型:+tCkCrkqd.getJx()，红冲标示tCkCrkqd.getCxsgin()，单位tCkCrkqd.getDwid()，选择"+tCkCrkqd.getXz()
                 */
                throw new BusinessException(String.format(INVENTORY_ALREADY_EXIST,
                        tCkCrkqdTemporay.getJh(), tCkCrkqdTemporay.getXh()));
            }
        }
        return bh;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String getOutPreview(OutAccessPreviewQuery outAccessPreviewQuery) {
        ValidableList<InAndOutLibraryDetailDTO> inAndOutLibraryDetailDTOS = new ValidableList<InAndOutLibraryDetailDTO>();
        for (OutLibraryDetailDTO outLibraryDetailDTO : outAccessPreviewQuery.getList()) {
            InAndOutLibraryDetailDTO inAndOutLibraryDetailDTO = BeanUtils.dtoTODO(outLibraryDetailDTO, InAndOutLibraryDetailDTO.class);
            inAndOutLibraryDetailDTO.setSl(outLibraryDetailDTO.getCksl());
            inAndOutLibraryDetailDTOS.add(inAndOutLibraryDetailDTO);
        }
        AccessPreviewQuery accessPreviewQuery = BeanUtils.dtoTODO(outAccessPreviewQuery, AccessPreviewQuery.class);
        accessPreviewQuery.setList(inAndOutLibraryDetailDTOS);
        return this.getPreview(accessPreviewQuery);
    }


    @Transactional(rollbackFor = Exception.class)
    public Boolean delPreview(String userId) {
        int delete = tCkCrkTemporayMapper.deleteByDlr(userId);
        int del = tCkCrkqdTemporayMapper.deleteByDlr(userId);
        return true;
    }


    public String getPreviewNumber(SystemNoDetailDTO systemNoDetailDTO) {

        SystemNumberQuery systemNumberQuery =
                new SystemNumberQuery(systemNoDetailDTO.getLbjm(), systemNoDetailDTO.getDwid());
        //获取数据库最新数据
        TCkCrkTemporay tCkCrkTemporay = tCkCrkTemporayMapper.selectByNew(systemNoDetailDTO.getLbjm().toUpperCase()
                + Utils.SING + systemNoDetailDTO.getDwid(), null);
        if (tCkCrkTemporay == null) {
            tCkCrkTemporay = new TCkCrkTemporay();
        }
        TCkCrk tCkCrk = BeanUtils.dtoTODO(tCkCrkTemporay, TCkCrk.class);
        String systemNumber =
                Utils.getSystemNumberByRule(systemNumberQuery, tCkCrk.getBh());
        return systemNumber;
    }

}
