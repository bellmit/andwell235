package com.andawell.material.service.impl;

import com.andawell.common.util.BusinessException;
import com.andawell.material.dto.*;
import com.andawell.material.entity.TCkBfk;
import com.andawell.material.entity.TCkWsyf;
import com.andawell.material.mapper.TCkWsyfMapper;
import com.andawell.material.service.IRepairedLibraryService;
import com.andawell.material.util.BeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static com.andawell.material.constant.BusinessConstant.LIBRARY_NOT_EXIT;
import static com.andawell.material.constant.BusinessConstant.OPERATION_FAIL;

/***
 * @author lhb
 * @Date: 2020/5/18 15:13
 * @Description:
 * @version : V1.0
 */
@Slf4j
@Service("callOilSeaService")
public class CallOilSeaService extends BaseLibraryService {

    @Autowired
    TCkWsyfMapper tCkWsyfMapper;

    /**
     * 保存入库信息
     *
     * @param libraryInfoDTO @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveInLibraryInfo(LibraryInfoDTO libraryInfoDTO) {
        // 完善油封数据
        List<InAndOutLibraryDetailDTO> detailDTOList = libraryInfoDTO.getList();

        LibraryMasterDTO libraryMasterDTO = libraryInfoDTO.getLibraryMasterDTO();

        for (InAndOutLibraryDetailDTO dto : detailDTOList) {
            try {

                TCkWsyf record = new TCkWsyf();
                // 查询条件
                record.setBh(dto.getCkbh());
                record.setJh(dto.getJh());
                record.setDwid(libraryMasterDTO.getDwid());
                record.setJx(libraryMasterDTO.getJx());
                record.setXh(dto.getXh());
                record.setZl(dto.getZl());
                record.setXz((short) 0);
                // 更新数值
                record.setRkbh(libraryMasterDTO.getBh());
                record.setRq(new Date());
                tCkWsyfMapper.updateByPrimaryKeySelective(record);
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
                throw  new BusinessException(OPERATION_FAIL);
            }
        }

        return super.saveInLibraryInfo(libraryInfoDTO);
    }

    /**
     * 保存出库信息
     *
     * @param outLibraryInfoDTO @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveOutLibraryInfo(OutLibraryInfoDTO outLibraryInfoDTO) {
        // 插入油封数据
        List<OutLibraryDetailDTO> detailDTOList = outLibraryInfoDTO.getList();

        LibraryMasterDTO libraryMasterDTO = outLibraryInfoDTO.getLibraryMasterDTO();
        String systemNumber =
                this.getSystemNumber(outLibraryInfoDTO.getSystemNoDetailDTO());
        // 是否重新获取
        outLibraryInfoDTO.getSystemNoDetailDTO().setIsUpdate(false);
        libraryMasterDTO.setBh(systemNumber);
        for (OutLibraryDetailDTO dto : detailDTOList) {
            try {

                TCkWsyf record = new TCkWsyf();
                // 查询条件
                record.setBh(libraryMasterDTO.getBh());
                record.setRkbh(libraryMasterDTO.getBh());
                record.setJh(dto.getJh());
                record.setDwid(libraryMasterDTO.getDwid());
                record.setJx(libraryMasterDTO.getJx());
                record.setHl(dto.getHl());
                record.setXh(dto.getXh());
                record.setJsdw(libraryMasterDTO.getJsdw());
                record.setZl(dto.getZl());
                record.setSl(Math.toIntExact(dto.getCksl()));
                record.setXz((short) 0);
                record.setRkbh(libraryMasterDTO.getBh());
                record.setRq(new Date());
                tCkWsyfMapper.insertSelective(record);
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
                throw  new BusinessException(" insert return factory is error");
            }
        }

        return super.saveOutLibraryInfo(outLibraryInfoDTO);
    }

    @Transactional(rollbackFor = Exception.class)
    public Boolean writeReturnFactoryOut(WriteOffDTO writeOffDTO) {
        TCkWsyf tCkWsyf =
                tCkWsyfMapper.selectByPrimaryKey
                        (writeOffDTO.getBh(),writeOffDTO.getJx(),writeOffDTO.getJh(),
                                writeOffDTO.getXh(),writeOffDTO.getZl(),Short.valueOf("0"),writeOffDTO.getDwid());
        if(tCkWsyf == null){
            throw new BusinessException(String.format(LIBRARY_NOT_EXIT,writeOffDTO.getJh(),writeOffDTO.getJh(),
                    writeOffDTO.getXh()));
        }
        if (writeOffDTO.getCrk()) {
            tCkWsyf.setSl(0);
        }else {
            tCkWsyf.setRkbh(null);
            tCkWsyf.setRq(null);
        }
        int n = tCkWsyfMapper.updateByPrimaryKeySelective(tCkWsyf);
        if(n<=0){
            throw new BusinessException(String.format(LIBRARY_NOT_EXIT,writeOffDTO.getJh(),writeOffDTO.getJh(),
                    writeOffDTO.getXh()));
        }
        return super.baseCkCkWriteOff(writeOffDTO);
    }
}
