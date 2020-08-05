package com.andawell.material.service.impl;

import com.andawell.common.util.BusinessException;
import com.andawell.material.constant.BusinessConstant;
import com.andawell.material.dto.LibraryMasterDTO;
import com.andawell.material.dto.NewRepairedDTO;
import com.andawell.material.dto.OutLibraryDetailDTO;
import com.andawell.material.dto.OutLibraryInfoDTO;
import com.andawell.material.entity.TCkCk;
import com.andawell.material.entity.TCkDx;
import com.andawell.material.entity.TZclhHbjl;
import com.andawell.material.mapper.TCkDxMapper;
import com.andawell.material.mapper.TZclhHbjlMapper;
import com.andawell.material.service.ITransFormationLibraryService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.utils.ValidableList;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.andawell.material.constant.BusinessConstant.INVENTORY_ALREADY_EXIST;
import static com.andawell.material.constant.BusinessConstant.OUT_OF_MEMORY;

/***
 * @author lhb
 * @Date: 2020/5/18 16:20
 * @Description:
 * @version : V1.0
 */
@Service
@Slf4j
public class TransFormationLibraryService extends BaseLibraryService implements ITransFormationLibraryService {


    @Autowired
    TCkDxMapper tCkDxMapper;

    @Autowired
    TZclhHbjlMapper tZclhHbjlMapper;

    @Autowired
    ScrapLibraryService scrapLibraryService;
    /**
     * @param newRepairedDTO
     * @Author: liuys
     * @Data: 2020/5/11
     * @Description: 全新可用出库/全新转待修
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean newRepair(NewRepairedDTO newRepairedDTO) {
        LibraryMasterDTO libraryMasterDTO = newRepairedDTO.getLibraryMasterDTO();
        ValidableList<OutLibraryDetailDTO> list = newRepairedDTO.getList();
        for (OutLibraryDetailDTO outLibraryDetailDTO : list) {
            //先查询 dwid jx jh xh zl 查询
            TCkCk tCkCk = tCkCkMapper.selectByDwidAndJxAndJhAndXhAndZl(outLibraryDetailDTO.getDwid(), outLibraryDetailDTO.getJx(), outLibraryDetailDTO.getJh(), outLibraryDetailDTO.getXh(), outLibraryDetailDTO.getZl());
            if (tCkCk==null){
                throw  new BusinessException(
                        String.format(OUT_OF_MEMORY,
                                tCkCk.getJh(),tCkCk.getXh()));
            }
            //添加
            if (newRepairedDTO.getList().size()==0){
                throw new BusinessException(String.format(BusinessConstant.CHOICE_ONE));
            }
            TCkDx tCkDx = BeanUtils.dtoTODO(outLibraryDetailDTO, TCkDx.class);
            String documentNo = getDocumentNo(newRepairedDTO.getSystemNoDetailDTO());
            tCkDx.setBh(documentNo);
            tCkDxMapper.insertSelective(tCkDx);
        }
        OutLibraryInfoDTO outLibraryInfoDTO = new OutLibraryInfoDTO();
        outLibraryInfoDTO.setLibraryMasterDTO(newRepairedDTO.getLibraryMasterDTO());
        outLibraryInfoDTO.setList(newRepairedDTO.getList());
        outLibraryInfoDTO.setSystemNoDetailDTO(newRepairedDTO.getSystemNoDetailDTO());
        //先记入
        super.saveOutLibraryInfo(outLibraryInfoDTO);
        //在记出
        newRepairedDTO.getLibraryMasterDTO().setLb(newRepairedDTO.getLb());
        for (OutLibraryDetailDTO outLibraryDetailDTO : newRepairedDTO.getList()) {
            outLibraryDetailDTO.setZl(outLibraryDetailDTO.getNewzl());
        }
        newRepairedDTO.getSystemNoDetailDTO().setIsGetSystemNo(true);
        return super.saveInAndOutList(newRepairedDTO.getSystemNoDetailDTO(),newRepairedDTO.getLibraryMasterDTO(),list);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean rotateOut(OutLibraryInfoDTO outLibraryInfoDTO) {
        //先添加主表
        Boolean state = super.saveOutLibraryInfo(outLibraryInfoDTO);
        LibraryMasterDTO libraryMasterDTO = outLibraryInfoDTO.getLibraryMasterDTO();
        //获取保存的bh保存到t_zclh_hbjl
        String bh = libraryMasterDTO.getBh();
        ValidableList<OutLibraryDetailDTO> list = outLibraryInfoDTO.getList();
        for (OutLibraryDetailDTO outLibraryDetailDTO : list) {
            TZclhHbjl tZclhHbjl = new TZclhHbjl();
            org.springframework.beans.
                    BeanUtils.copyProperties(outLibraryDetailDTO,tZclhHbjl);
            tZclhHbjl.setBh(bh);
            tZclhHbjl.setJx(outLibraryDetailDTO.getJx());
            tZclhHbjl.setSl(outLibraryDetailDTO.getCksl());
            tZclhHbjl.setJh(outLibraryDetailDTO.getJh());
           // tZclhHbjl.setHclb(outLibraryDetailDTO.geth);
            tZclhHbjl.setZl(outLibraryDetailDTO.getZl());
            tZclhHbjl.setXh(outLibraryDetailDTO.getXh());
            tZclhHbjl.setXz("0");
            tZclhHbjl.setLhdw(libraryMasterDTO.getFfdw());
            tZclhHbjlMapper.insertSelective(tZclhHbjl);
        }
        return state;
    }
}
