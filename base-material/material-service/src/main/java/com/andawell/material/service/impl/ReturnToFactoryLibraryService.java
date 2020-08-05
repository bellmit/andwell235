package com.andawell.material.service.impl;

import com.andawell.common.util.BusinessException;
import com.andawell.material.dto.*;
import com.andawell.material.entity.TCkCk;
import com.andawell.material.entity.TCkFcsj;
import com.andawell.material.entity.TCkWsyf;
import com.andawell.material.mapper.TCkFcsjMapper;
import com.andawell.material.service.IRepairedLibraryService;
import com.andawell.material.utils.ValidableList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static com.andawell.material.constant.BusinessConstant.*;

/***
 * @author lhb
 * @Date: 2020/5/18 15:08
 * @Description:
 * @version : V1.0
 */
@Slf4j
@Service
public class ReturnToFactoryLibraryService extends BaseLibraryService {



    @Autowired
    TCkFcsjMapper ckFcsjMapper;


    /**
     * 保存入库信息
     *
     * @param libraryInfoDTO @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveInLibraryInfo(LibraryInfoDTO libraryInfoDTO) {


        // 存储ckck数据
        List<InAndOutLibraryDetailDTO> detailDTOList = libraryInfoDTO.getList();

        LibraryMasterDTO libraryMasterDTO = libraryInfoDTO.getLibraryMasterDTO();

        for (InAndOutLibraryDetailDTO dto : detailDTOList) {
            try {

                TCkFcsj record = new TCkFcsj();
                // 查询条件
                record.setBh(dto.getCkbh());
                record.setSjjh(dto.getJh());
                record.setDwid(libraryMasterDTO.getDwid());
                record.setJx(libraryMasterDTO.getJx());
                record.setSjxh(dto.getXh());
                record.setZl(dto.getZl());
                record.setXz("0");
                // 更新数值
                record.setSjjh(dto.getXjh());
                record.setSjxh(dto.getXh());
                record.setBz(dto.getBz()!=null?dto.getBz():"");
                record.setRkrq(new Date());
                ckFcsjMapper.updateByPrimaryKeySelective(record);
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
                throw  new BusinessException(String.format(IMPROVE_RETURN_INFORMATION_FAIL,dto.getJh(),dto.getXh()));
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

        // 更新ckck数据
        List<OutLibraryDetailDTO> detailDTOList = outLibraryInfoDTO.getList();

        String bh =  this.getSystemNumber(outLibraryInfoDTO.getSystemNoDetailDTO());

        outLibraryInfoDTO.getSystemNoDetailDTO().setIsUpdate(false);

        outLibraryInfoDTO.getLibraryMasterDTO().setBh(bh);

        LibraryMasterDTO libraryMasterDTO = outLibraryInfoDTO.getLibraryMasterDTO();

        ValidableList<InAndOutLibraryDetailDTO> list = new ValidableList<>();
        for (OutLibraryDetailDTO outLibraryDetailDTO : detailDTOList) {
            TCkCk tCkCk =
                    tCkCkMapper.selectByPrimaryKey(
                            outLibraryDetailDTO.getDwid(),
                            outLibraryDetailDTO.getJx(),
                            outLibraryDetailDTO.getJh(),
                            outLibraryDetailDTO.getXh(),
                            outLibraryDetailDTO.getZl(),

                            "0");
            if(tCkCk == null){
                throw  new BusinessException(
                        String.format(LIBRARY_NOT_EXIT,libraryMasterDTO.getJx(),outLibraryDetailDTO.getJh(),outLibraryDetailDTO.getXh()));
            }

            try {
                // 查询出ckck  核减数量
                // 抛出异常

                long count = tCkCk.getSl()-outLibraryDetailDTO.getCksl();
                if(count<0){
                    throw  new BusinessException(
                            String.format(OUT_OF_MEMORY,
                                    tCkCk.getJh(),tCkCk.getXh()));
                }
                // 跟新数据
                tCkCk.setSl(count);
                tCkCk.setBz((tCkCk.getBz()!=null?tCkCk.getBz():"")+","+outLibraryDetailDTO.getBz());
                // 组装数据
                InAndOutLibraryDetailDTO inAndOutLibraryDetailDTO = new InAndOutLibraryDetailDTO();
                org.springframework.beans.BeanUtils.copyProperties(tCkCk,inAndOutLibraryDetailDTO);
                list.add(inAndOutLibraryDetailDTO);
                tCkCkMapper.updateByPrimaryKeySelective(tCkCk);

                TCkFcsj record = new TCkFcsj();
                record.setBh(libraryMasterDTO.getBh());
                record.setDwid(libraryMasterDTO.getDwid());
                record.setJx(libraryMasterDTO.getJx());
                record.setXz("0");
                record.setSl(Math.toIntExact(tCkCk.getSl()));
                record.setSjyy(outLibraryDetailDTO.getReason());
                record.setRkrq(libraryMasterDTO.getRkrq());
                org.springframework.beans.BeanUtils.copyProperties(tCkCk,record);
                //record.setSjyy();
                ckFcsjMapper.insertSelective(record);

            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
                throw  new BusinessException(
                        String.format(IMPROVE_RETURN_INFORMATION_FAIL,tCkCk.getJh(),tCkCk.getXh()));
            }
        }
        //crk和crkqd保存
        Boolean isSuccess =  super.saveInAndOutList(outLibraryInfoDTO.getSystemNoDetailDTO(),
                outLibraryInfoDTO.getLibraryMasterDTO(), list);
        return isSuccess;
    }

    /**
     *@Author: liuys
     *@Data: 2020/5/20
     *@Description: （冲销）返厂升级
     */
    @Transactional(rollbackFor = Exception.class)
    public Boolean writeOilSeaInOut(WriteOffDTO writeOffDTO) {
        TCkFcsj tCkFcsj =
                ckFcsjMapper.selectByPrimaryKey
                        (writeOffDTO.getBh(),writeOffDTO.getDwid(),writeOffDTO.getJx(),writeOffDTO.getJh(),
                                writeOffDTO.getXh(),writeOffDTO.getZl(),writeOffDTO.getXz());
        if(tCkFcsj == null){
            throw new BusinessException(String.format(LIBRARY_NOT_EXIT,writeOffDTO.getJh(),writeOffDTO.getJh(),
                    writeOffDTO.getXh()));
        }
        if (writeOffDTO.getCrk()) {
            // 出库冲销
            tCkFcsj.setSl(0);
        }else {
            // 入库冲销
            tCkFcsj.setSjjh(null);
            tCkFcsj.setSjxh(null);
            tCkFcsj.setBz("");
            tCkFcsj.setRkrq(null);
        }
        int n = ckFcsjMapper.updateByPrimaryKey(tCkFcsj);
        if(n<=0){
            throw new BusinessException(String.format(LIBRARY_NOT_EXIT,writeOffDTO.getJh(),writeOffDTO.getJh(),
                    writeOffDTO.getXh()));
        }
        return super.baseCkCkWriteOff(writeOffDTO);
    }
}
