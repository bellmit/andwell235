package com.andawell.material.service.impl;

import com.andawell.common.util.BusinessException;
import com.andawell.material.dto.InAndOutLibraryDetailDTO;
import com.andawell.material.dto.LibraryInfoDTO;
import com.andawell.material.dto.LibraryMasterDTO;
import com.andawell.material.dto.WriteOffDTO;
import com.andawell.material.entity.*;
import com.andawell.material.mapper.TZclhHbjlMapper;
import com.andawell.material.query.RotateQuery;
import com.andawell.material.service.IRotateService;
import com.andawell.material.utils.ValidableList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.andawell.material.constant.BusinessConstant.LIBRARY_NOT_EXIT;

/***
 * @author lhb
 * @Date: 2020/4/26 17:29
 * @Description:
 * @version : V1.0
 */
@Service
@Slf4j
public class RotateServiceImpl extends BaseLibraryService implements IRotateService {


    @Autowired
    TZclhHbjlMapper tZclhHbjlMapper;

    /**
     * 保存轮换入库信息
     *
     * @param libraryInfoDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean rotateTypeSaveStockInfo(LibraryInfoDTO libraryInfoDTO) throws Exception {
        //储存底层入库信息
        Boolean isTrue = super.saveInLibraryInfo(libraryInfoDTO);
        if(isTrue){
            // 更新转换转换记录入库
            LibraryMasterDTO libraryMasterDTO = libraryInfoDTO.getLibraryMasterDTO();
            ValidableList<InAndOutLibraryDetailDTO> list = libraryInfoDTO.getList();
            for (InAndOutLibraryDetailDTO dto : list) {
                TZclhHbjl tZclhHbjl =  tZclhHbjlMapper.selectByPrimaryKey(dto.getBh(),
                        libraryMasterDTO.getJsdw(),
                        dto.getJx(),
                        dto.getJh(),
                        dto.getXh(),
                        dto.getZl(),
                        dto.getXz());
                if(tZclhHbjl == null){
                    throw new BusinessException("轮换记录未查询到，请核实信息");
                }
                // 跟新信息完善轮换入库记录
                tZclhHbjl.setRkbh(libraryMasterDTO.getBh());
                tZclhHbjl.setLrsl(dto.getSl());
                tZclhHbjl.setLrzl(dto.getZl());
                tZclhHbjl.setLrxh(dto.getXxh());
                tZclhHbjl.setLrccrq(dto.getCcrq());
                tZclhHbjl.setLryfrq(dto.getYfrq());
                tZclhHbjl.setLryfqx(dto.getYfqx());
                tZclhHbjl.setLrdj(dto.getDj());
                tZclhHbjl.setHl(dto.getHl());
                tZclhHbjl.setBz(dto.getBz());
                tZclhHbjlMapper.updateByPrimaryKeySelective(tZclhHbjl);
            }

        }
        return isTrue;
    }

    /**
     * 根据条件查询轮换列表
     *
     * @param rotateQuery
     * @return
     */
    @Override
    public List<TZclhHbjl> getRotateListByQuery(RotateQuery rotateQuery) {

        List<TZclhHbjl>  tZclhHbjlList =
                tZclhHbjlMapper.selectByCondition(rotateQuery);

        return tZclhHbjlList;
    }

    /**
     * ckck 冲销
     *
     * @param writeOffDTO
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean rotateCkCkWriteOff(WriteOffDTO writeOffDTO) {
        TZclhHbjl tZclhHbjl = null;

        if(writeOffDTO.getCrk()){
            // 冲销掉 轮换信息
             tZclhHbjl =  tZclhHbjlMapper.selectByPrimaryKey(writeOffDTO.getBh(),
                    writeOffDTO.getFfdw(),
                    writeOffDTO.getJx(),
                    writeOffDTO.getJh(),
                    writeOffDTO.getXh(),
                    writeOffDTO.getZl(),
                    writeOffDTO.getXz());
            if(tZclhHbjl == null){
                throw new BusinessException(String.format(LIBRARY_NOT_EXIT,writeOffDTO.getJh(),writeOffDTO.getJh(),
                        writeOffDTO.getXh()));
            }
            // 轮换出库冲销
            tZclhHbjl.setSl(tZclhHbjl.getSl()-writeOffDTO.getSl());
        }
        if(!writeOffDTO.getCrk()){
            // 冲销掉 轮换信息
            tZclhHbjl =  tZclhHbjlMapper.selectByPrimaryKeyRkBh(writeOffDTO.getBh(),
                    writeOffDTO.getFfdw(),
                    writeOffDTO.getJx(),
                    writeOffDTO.getJh(),
                    writeOffDTO.getXh(),
                    writeOffDTO.getZl(),
                    writeOffDTO.getXz());
            if(tZclhHbjl == null){
                throw new BusinessException(String.format(LIBRARY_NOT_EXIT,writeOffDTO.getJh(),writeOffDTO.getJh(),
                        writeOffDTO.getXh()));
            }
            //  轮换入库冲销
            tZclhHbjl.setLrsl(tZclhHbjl.getSl()-writeOffDTO.getSl());
        }

        int n =  tZclhHbjlMapper.updateByPrimaryKeySelective(tZclhHbjl);
        if(n<=0){
            throw new BusinessException(String.format(LIBRARY_NOT_EXIT,writeOffDTO.getJh(),writeOffDTO.getJh(),
                    writeOffDTO.getXh()));
        }
        return super.baseCkCkWriteOff(writeOffDTO);
    }
}
