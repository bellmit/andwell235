package com.andawell.material.service.impl;

import com.andawell.common.util.BusinessException;
import com.andawell.material.covert.LibraryInfoDtoCoverDo;
import com.andawell.material.dto.*;
import com.andawell.material.entity.TCkDx;
import com.andawell.material.entity.TCkSx;
import com.andawell.material.enumeration.RepairStatus;
import com.andawell.material.mapper.TCkBfkMapper;
import com.andawell.material.mapper.TCkDxMapper;
import com.andawell.material.mapper.TCkSxMapper;
import com.andawell.material.service.IRepairedLibraryService;
import com.andawell.material.utils.ValidableList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.andawell.material.constant.BusinessConstant.*;


/***
 * @author lhb
 * @Date: 2020/5/6 13:22
 * @Description:
 * @version : V1.0
 */
@Service
@Slf4j
public class RepairedLibraryService extends BaseLibraryService implements IRepairedLibraryService {


    @Autowired
    TCkDxMapper tCkDxMapper;

    @Autowired
    TCkSxMapper tCkSxMapper;

    @Autowired
    TCkBfkMapper tCkBfkMapper;

    /**
     * 待修入库
     *
     * @param repairedLibraryDTO@return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveRepairedStockInfo(RepairedLibraryDTO repairedLibraryDTO) {
        Boolean isSuccess = super.saveInAndOutList(repairedLibraryDTO.getSystemNoDetailDTO(),
                repairedLibraryDTO.getLibraryMasterDTO(), repairedLibraryDTO.getList());
        // 存储ckck数据
        String systemNo = repairedLibraryDTO.getLibraryMasterDTO().getBh();
        List<RepairedLibraryDetailDTO> detailDTOList = repairedLibraryDTO.getList();
        List<TCkDx> tCkDxList =
                LibraryInfoDtoCoverDo.getTckDxListDo(repairedLibraryDTO.getLibraryMasterDTO(), detailDTOList);
        for (TCkDx tCkDx : tCkDxList) {
            try {
                tCkDx.setBh(systemNo);
                tCkDxMapper.insertSelective(tCkDx);
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
                throw new BusinessException("该单位:" + tCkDx.getDwid() + "，机型:" + tCkDx.getJx() + "，件号:" + tCkDx.getJh() + "，质量:" + tCkDx.getZl() + "，选择标志位:" + tCkDx.getXz() + "已存在");
            }
        }
        return isSuccess;
    }

    /**
     * 待修退修入库
     *
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean repairReturnStatus(RepairedLibraryDTO libraryMasterDTO) {
        //保存ckck crk crkqd  和dx的数据
        this.saveRepairedStockInfo(libraryMasterDTO);
        for (RepairedLibraryDetailDTO repairedLibraryDetailDTO : libraryMasterDTO.getList()) {
            repairedLibraryDetailDTO.setCljg(RepairStatus.RETREAT.getCode());
            //修改送修的状态
            repairedStatus(repairedLibraryDetailDTO, libraryMasterDTO.getLibraryMasterDTO());
        }
        return true;
    }

    /**
     * 修改待修状态
     *
     * @param repairedLibraryDetailDTO
     * @param libraryMasterDTO
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean repairedStatus(RepairedLibraryDetailDTO repairedLibraryDetailDTO, LibraryMasterDTO libraryMasterDTO) {
        TCkSx tCkSx = new TCkSx();
        tCkSx.setClbh(libraryMasterDTO.getBh());
        //维修类型  1.送修 2.报废 3.退修 4.修复
        //当前状态是：3.退修
        tCkSx.setCljg(repairedLibraryDetailDTO.getCljg());
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try {
            date = dateFormat.parse(date.toString());
        } catch (ParseException e) {
            date = null;
        }
        tCkSx.setClsj(date);
        //修改条件  BH，JH，XH，DWID，JX，XZ
        tCkSx.setBh(repairedLibraryDetailDTO.getBh());
        tCkSx.setJh(repairedLibraryDetailDTO.getJh());
        tCkSx.setXh(repairedLibraryDetailDTO.getXh());
        tCkSx.setDwid(libraryMasterDTO.getDwid());
        tCkSx.setJx(repairedLibraryDetailDTO.getJx());
        //选择
        tCkSx.setXxz("1");
        int n = tCkSxMapper.updateByPrimaryKeySelective(tCkSx);
        if(n <=0){
            throw new BusinessException("送修数据没有查到，无法退修");
        }
        return true;
    }

    /**
     * ckck 冲销
     * @param writeOffDTO
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Boolean repairedWriteOff(WriteOffDTO writeOffDTO){
        TCkDx tCkDx =
                tCkDxMapper.selectByPrimaryKey
                        (writeOffDTO.getBh(),
                                writeOffDTO.getJh(),
                                writeOffDTO.getXh(),
                                writeOffDTO.getXz(),
                                writeOffDTO.getJx(),
                                writeOffDTO.getDwid());
        // 出库 是加回来
        tCkDx.setSl(tCkDx.getSl()+writeOffDTO.getSl());
        if(!writeOffDTO.getCrk()){
            // 入库 减回来
            tCkDx.setSl(tCkDx.getSl()-writeOffDTO.getSl());
        }
        tCkDxMapper.updateByPrimaryKeySelective(tCkDx);
        return super.saveAndUpdateInAndOutWriteOff(writeOffDTO);
    }


    /**
     * 待修发付出库
     *
     * @param outLibraryInfoDTO @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveOutLibraryInfo(OutLibraryInfoDTO outLibraryInfoDTO) {
        List<OutLibraryDetailDTO> detailDTOList = outLibraryInfoDTO.getList();

        ValidableList<InAndOutLibraryDetailDTO> list = new ValidableList<>();
        for (OutLibraryDetailDTO outLibraryDetailDTO : detailDTOList) {
            // 查询出待修  核减数量
            TCkDx tCkDx =
                    tCkDxMapper.selectByPrimaryKey(
                            outLibraryDetailDTO.getBh(),
                            outLibraryDetailDTO.getJh(),
                            outLibraryDetailDTO.getXh(),
                            outLibraryDetailDTO.getXz(),
                            outLibraryDetailDTO.getJx(),
                            outLibraryDetailDTO.getDwid());
            try {
                // 跟新数据
                Long count = tCkDx.getSl() - outLibraryDetailDTO.getCksl();

                // 抛出异常
                if (count < 0) {
                    throw new BusinessException(
                            String.format(OUT_OF_MEMORY,
                                    tCkDx.getJh(), tCkDx.getXh()));
                }

                tCkDx.setSl(count);
                tCkDx.setBz(tCkDx.getBz() != null ? tCkDx.getBz() : "");
                // 在修状态 21 待修
                tCkDx.setZl("22");
                //  选择;0为未送修 1为已送修
                tCkDx.setXxz("1");
                // 组装数据
                InAndOutLibraryDetailDTO inAndOutLibraryDetailDTO = new InAndOutLibraryDetailDTO();
                org.springframework.beans.BeanUtils.copyProperties(tCkDx, inAndOutLibraryDetailDTO);
                list.add(inAndOutLibraryDetailDTO);
                tCkDxMapper.updateByPrimaryKeySelective(tCkDx);
            } catch (BusinessException e) {
                e.printStackTrace();
                log.error(e.getMessage());
                throw new BusinessException(
                        String.format(CUt_AFTER_EXAMINATION_FAIL,
                                tCkDx.getJh(), tCkDx.getXh()));
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
                throw new BusinessException(String.format(CUt_AFTER_EXAMINATION_FAIL,
                        outLibraryDetailDTO.getJh(), outLibraryDetailDTO.getXh()));

            }
        }
        //crk和crkqd保存
        Boolean isSuccess = super.saveInAndOutList(outLibraryInfoDTO.getSystemNoDetailDTO(),
                outLibraryInfoDTO.getLibraryMasterDTO(), list);
        return isSuccess;
    }

    /**
     * @Author: liuys
     * @Data: 2020/5/21
     * @Description: （冲销）全新可用转待修出库
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean writeRotate(WriteOffDTO writeOffDTO) {
        //待修库数量减少，全新库数量添加
        TCkDx tCkDx =
                tCkDxMapper.selectByPrimaryKey
                        (writeOffDTO.getBh(), writeOffDTO.getJh(), writeOffDTO.getXh(), writeOffDTO.getXz(), writeOffDTO.getJx(), writeOffDTO.getDwid());
        tCkDx.setSl(tCkDx.getSl() - writeOffDTO.getSl().intValue());
        tCkDxMapper.updateByPrimaryKeySelective(tCkDx);
        //修改ckck 添加crk crkqd
        return this.baseCkCkWriteOff(writeOffDTO);
    }

    /**
     * @Author: liuys
     * @Data: 2020/5/23
     * @Description: 冲销待修发付出库
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean writeToRepairOut(WriteOffDTO writeOffDTO) {
        TCkDx tCkDx =
                tCkDxMapper.selectByPrimaryKey
                        (writeOffDTO.getBh(), writeOffDTO.getJh(), writeOffDTO.getXh(), writeOffDTO.getXz(), writeOffDTO.getJx(), writeOffDTO.getDwid());
        tCkDx.setSl(tCkDx.getSl() + writeOffDTO.getSl().intValue());

        tCkDxMapper.updateByPrimaryKeySelective(tCkDx);
        //添加crk crkqd
        return this.saveAndUpdateInAndOutWriteOff(writeOffDTO);
    }

    @Transactional(rollbackFor = Exception.class)
    public Boolean repairedReturnWriteOff(WriteOffDTO writeOffDTO) {
        // 待修退修发付入库
        TCkSx tCkSx =
                tCkSxMapper.selectByPrimaryClBh
                        (writeOffDTO.getBh(),
                                writeOffDTO.getJh(),
                                writeOffDTO.getXh(),
                                writeOffDTO.getDwid(),
                                writeOffDTO.getJx(),
                                "1");
        if(tCkSx == null){
            throw new BusinessException(String.format(LIBRARY_NOT_EXIT,writeOffDTO.getJh(),writeOffDTO.getJh(),
                    writeOffDTO.getXh()));
        }
        tCkSx.setSl(0L);
        // 选择 (0:送修未返回 1：送修已返回)
        tCkSx.setXxz("0");
        tCkSx.setCljg(RepairStatus.REPAIR.getCode());
        tCkSx.setClsj(new Date());

        int n = tCkSxMapper.updateByPrimaryKeySelective(tCkSx);

        // 退回待修的数据
        if(n<=0){
            throw new BusinessException(String.format(LIBRARY_NOT_EXIT,writeOffDTO.getJh(),writeOffDTO.getJh(),
                    writeOffDTO.getXh()));
        }
        TCkDx tCkDx =
                tCkDxMapper.selectByPrimaryKey
                        (tCkSx.getDxbh(),
                                tCkSx.getJh(),
                                tCkSx.getXh(),
                                "1", tCkSx.getJx(),
                                tCkSx.getDwid());
        if(tCkDx == null){
            throw new BusinessException(String.format(LIBRARY_DX_NOT_EXIT,writeOffDTO.getJh(),writeOffDTO.getJh(),
                    writeOffDTO.getXh()));
        }
        tCkDx.setXxz("0");
        tCkDx.setSl(0L);
        tCkDx.setCljg("0");
        tCkDxMapper.updateByPrimaryKeySelective(tCkDx);
        return super.saveAndUpdateInAndOutWriteOff(writeOffDTO);
    }
}
