package com.andawell.material.service.impl;

import com.andawell.common.util.BusinessException;
import com.andawell.material.dto.*;
import com.andawell.material.entity.TCkDx;
import com.andawell.material.entity.TCkSx;
import com.andawell.material.enumeration.RepairStatus;
import com.andawell.material.mapper.TCkDxMapper;
import com.andawell.material.mapper.TCkSxMapper;
import com.andawell.material.service.ISendRepairLibraryService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.utils.ValidableList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static com.andawell.material.constant.BusinessConstant.LIBRARY_DX_NOT_EXIT;
import static com.andawell.material.constant.BusinessConstant.LIBRARY_NOT_EXIT;

/***
 * @author lhb
 * @Date: 2020/5/18 14:22
 * @Description:
 * @version : V1.0
 */
@Service
@Slf4j
public class SendRepairLibraryService extends BaseLibraryService implements ISendRepairLibraryService {


    @Autowired
    TCkSxMapper tCkSxMapper;

    @Autowired
    TCkDxMapper tCkDxMapper;

    /**
     * 保存入库信息
     *
     * @param repairReturnInfoDTO @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveInLibraryInfo(RepairReturnInfoDTO repairReturnInfoDTO) {

        //插入T_CK_CK 插入T_CK_CRK 插入T_CK_XF
        LibraryInfoDTO libraryInfoDTO = new LibraryInfoDTO();
        ValidableList<InAndOutLibraryDetailDTO> list = BeanUtils.copyValidableList(repairReturnInfoDTO.getList(), InAndOutLibraryDetailDTO.class);
        libraryInfoDTO.setLibraryMasterDTO(repairReturnInfoDTO.getLibraryMasterDTO());
        libraryInfoDTO.setList(list);
        libraryInfoDTO.setSystemNoDetailDTO(repairReturnInfoDTO.getSystemNoDetailDTO());
        Boolean state = super.saveInLibraryInfo(libraryInfoDTO);
        //保存数据后修改状态
        LibraryMasterDTO libraryMasterDTO = repairReturnInfoDTO.getLibraryMasterDTO();
        for (RepairReturnDTO repairReturnDTO : repairReturnInfoDTO.getList()) {
            TCkSx tCkSx = new TCkSx();
            //选择
            tCkSx.setXxz("1");
            //维修类型  1.送修 2.报废 3.退修 4.修复
            tCkSx.setCljg(RepairStatus.REPAIRED.getCode());
            tCkSx.setClsj(repairReturnDTO.getClsj());
            tCkSx.setClbh(libraryInfoDTO.getLibraryMasterDTO().getBh());
            //查询条件->根据机型 件号 序号 编号 修改数据
            tCkSx.setBh(repairReturnDTO.getBh());
            tCkSx.setJx(libraryMasterDTO.getJx());
            tCkSx.setJh(repairReturnDTO.getJh());
            tCkSx.setXz("0");
            tCkSx.setDwid(repairReturnDTO.getDwid());
            tCkSx.setXh(repairReturnDTO.getXh());
            //tCkSx.setDwid(repairReturnDTO.getDw());
            int n =  tCkSxMapper.updateByPrimaryKeySelective(tCkSx);
            if(n<=0){
               throw new BusinessException("未查到送修数据");
            }
        }
        return state;
    }

    /**
     * 保存出库信息
     *
     * @param  @return
     */

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveOutLibraryInfo(LibraryInfoDTO libraryInfoDTO) {
        LibraryMasterDTO libraryMasterDTO = libraryInfoDTO.getLibraryMasterDTO();

        ValidableList<InAndOutLibraryDetailDTO> list =
                libraryInfoDTO.getList();

        Boolean isSuccess =
               super.saveInAndOutList(libraryInfoDTO.getSystemNoDetailDTO(), libraryMasterDTO,list);

        for (InAndOutLibraryDetailDTO dto : list) {
            //插入送修数据
            TCkSx tCkSx = new TCkSx();
            org.springframework.beans.BeanUtils.copyProperties(dto,tCkSx);
            tCkSx.setCxdw(libraryMasterDTO.getJsdw());
            // 在修
            tCkSx.setZl("22");
            tCkSx.setSxrq(libraryInfoDTO.getLibraryMasterDTO().getRkrq());
            tCkSx.setDxbh(dto.getBh());
            tCkSx.setCljg(RepairStatus.REPAIR.getCode());
            tCkSx.setBh(libraryMasterDTO.getBh());
            tCkSx.setXz(RepairStatus.TO_BE_REPAIR.getCode());
            tCkSxMapper.insertSelective(tCkSx);

            // 修改 T_CK_DX

            TCkDx tCkDx = tCkDxMapper.selectByPrimaryKey(
                    dto.getBh(),
                    dto.getJh(),
                    dto.getXh(),
                    dto.getXz(),
                    dto.getJx(),dto.getDwid());

            if(tCkDx ==  null){
                throw new BusinessException(String.format(LIBRARY_NOT_EXIT,dto.getJh(),dto.getJh(),
                        dto.getXh()));
            }
            // 修改数据 update T_CK_DX set XZ=1,cljg=1,clrq=,clbh=
            // where jx=机型 and jh=件号 and xh=序号 and BH=编号
            tCkDx.setZl("22");
            tCkDx.setXxz("1");
            tCkDx.setCljg(RepairStatus.REPAIR.getCode());
            tCkDx.setClbh(dto.getBh());
            tCkDx.setClsj(libraryMasterDTO.getRkrq());
            int n = tCkDxMapper.updateByPrimaryKeySelective(tCkDx);
            if(n<=0){
                throw new BusinessException(String.format(LIBRARY_NOT_EXIT,dto.getJh(),dto.getJh(),
                        dto.getXh()));
            }
        }
        return isSuccess;
    }

    /**
     * 送修冲销 入库
     *
     * @param writeOffDTO
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean sendRepairWriteOffIn(WriteOffDTO writeOffDTO) {

        // 入库
        writeOffDTO.setCrk(false);
        TCkSx tCkSx  = tCkSxMapper.selectByPrimaryClBh(writeOffDTO.getBh(),
                writeOffDTO.getJh(),
                writeOffDTO.getXh(),
                writeOffDTO.getDwid(),
                writeOffDTO.getJx(),
                "1");
        if(tCkSx == null){
            throw new BusinessException(String.format(LIBRARY_NOT_EXIT,writeOffDTO.getJh(),writeOffDTO.getJh(),
                    writeOffDTO.getXh()));
        }
        tCkSx.setSl(tCkSx.getSl()-writeOffDTO.getSl());
        // 选择 (0:送修未返回 1：送修已返回)
        tCkSx.setXxz(RepairStatus.TO_BE_REPAIR.getCode());
        // 1.送修 2. 报废 3. 退休 4. 修复
        tCkSx.setCljg(RepairStatus.REPAIR.getCode());
        int n = tCkSxMapper.updateByPrimaryKey(tCkSx);
        if(n<=0){
            throw new BusinessException(String.format(LIBRARY_NOT_EXIT,writeOffDTO.getJh(),writeOffDTO.getJh(),
                    writeOffDTO.getXh()));
        }
        return super.baseCkCkWriteOff(writeOffDTO);
    }



    /**
     *@Author: liuys
     *@Data: 2020/5/22
     *@Description: 冲销送修出库
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean sendRepairWriteOffOut(WriteOffDTO writeOffDTO) {
        //判断是否已经入库,如果已经入库，不能冲销
     /*   TCkSx sx = new TCkSx();
        sx.setCljg("4");
        sx.setJx(writeOffDTO.getJx());
        sx.setXh(writeOffDTO.getXh());
        sx.setDwid(writeOffDTO.getDwid());
        sx.setXz("1");
        sx.setCljg("4");
        TCkSx ckSx =tCkSxMapper.selectQueryOne(sx);
        if (ckSx!=null){
            throw new BusinessException(String.format(UNABLE_TO,writeOffDTO.getJh(),writeOffDTO.getJh(),
                    writeOffDTO.getXh()));
        }*/
        //查询数据是否存在
        TCkSx tCkSx =
                tCkSxMapper.selectByPrimaryKey
                        (writeOffDTO.getBh(),
                                writeOffDTO.getJh(),
                                writeOffDTO.getXh(),
                                writeOffDTO.getDwid(),
                                writeOffDTO.getJx(),
                                writeOffDTO.getXz());
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
        tCkDx.setCljg("0");
        tCkDxMapper.updateByPrimaryKeySelective(tCkDx);
        return super.saveAndUpdateInAndOutWriteOff(writeOffDTO);
    }
}
