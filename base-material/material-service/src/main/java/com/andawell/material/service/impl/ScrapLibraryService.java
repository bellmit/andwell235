package com.andawell.material.service.impl;

import com.andawell.common.util.BusinessException;
import com.andawell.material.dto.*;
import com.andawell.material.entity.TCkBfk;
import com.andawell.material.entity.TCkCk;
import com.andawell.material.entity.TCkDx;
import com.andawell.material.enumeration.RepairStatus;
import com.andawell.material.mapper.TCkBfkMapper;
import com.andawell.material.mapper.TCkDxMapper;
import com.andawell.material.query.TCkDxQuery;
import com.andawell.material.service.IRepairedLibraryService;
import com.andawell.material.service.IScrapLibraryService;
import com.andawell.material.service.TCkDxService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.util.Utils;
import com.andawell.material.utils.ValidableList;
import com.andawell.material.vo.TCkDxStatusVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static com.andawell.material.constant.BusinessConstant.*;

/***
 * @author lhb
 * @Date: 2020/5/18 15:56
 * @Description:
 * @version : V1.0
 */
@Service
@Slf4j
public class ScrapLibraryService extends BaseLibraryService implements IScrapLibraryService {


     @Autowired
     TCkBfkMapper tCkBfkMapper;

     @Autowired
     IRepairedLibraryService repairedLibraryService;

     @Autowired
     IRepairedLibraryService iRepairedLibraryService;

     @Autowired
    TCkDxService tCkDxService;

     @Autowired
     TCkDxMapper tCkDxMapper;

    /**
     * 报废入库
     * @param scrapInforDTO
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveScrapContract(ScrapInforDTO scrapInforDTO) {
        // 保存crk和crk清单 ， 待修出库出入库信息
        scrapInforDTO.getSystemNoDetailDTO().setLbjm("DXZBFCK");
        super.saveInAndOutList(scrapInforDTO.getSystemNoDetailDTO(),scrapInforDTO.getLibraryMasterDTO(),
                scrapInforDTO.getList());
        // 设定类别
        scrapInforDTO.getLibraryMasterDTO().setLb(scrapInforDTO.getLb());
        scrapInforDTO.getSystemNoDetailDTO().setLbjm("BFRK");
        //修改类别
        return this.saveScrapForeign(scrapInforDTO);
    }

    /**
     * 报废入库/外来器材报废
     *
     * @param scrapInforDTO
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveScrapForeign(ScrapInforDTO scrapInforDTO) {
        //添加T_Ck_Crk 和 T_Ck_Crkqd
        this.saveInAndOutList(scrapInforDTO.getSystemNoDetailDTO(),scrapInforDTO.getLibraryMasterDTO(),scrapInforDTO.getList());
       // LibraryMasterDTO libraryMasterDTO = scrapInforDTO.getLibraryMasterDTO();
        for (ScrapInAndOutLibraryDetailDTO scrapInAndOutLibraryDetailDTO : scrapInforDTO.getList()) {
            //修改T_Ck_Dx
            TCkDx tCkDx = new TCkDx();
            //修改信息
            tCkDx.setXz("1");
            tCkDx.setCljg(RepairStatus.SCRAP.getCode());
            tCkDx.setCcrq(new Date());
            tCkDx.setClbh(scrapInAndOutLibraryDetailDTO.getClbh());
            /*  //查询数据
            TCkDxQuery tCkDxQuery = new TCkDxQuery();
            List<TCkDxStatusVO> list = tCkDxMapper.list(tCkDxQuery);
            tCkDxQuery.setJx(scrapInAndOutLibraryDetailDTO.getJx());
            tCkDxQuery.setJh(scrapInAndOutLibraryDetailDTO.getJh());
            tCkDxQuery.setXh(scrapInAndOutLibraryDetailDTO.getXh());
            tCkDxQuery.setBh(scrapInAndOutLibraryDetailDTO.getBh());*/
            //数量修改   报废直接是一批报废
            tCkDx.setSl(0l);
            //条件
            tCkDx.setJx(scrapInAndOutLibraryDetailDTO.getJx());
            tCkDx.setJh(scrapInAndOutLibraryDetailDTO.getJh());
            tCkDx.setXh(scrapInAndOutLibraryDetailDTO.getXh());
            tCkDx.setBh(scrapInAndOutLibraryDetailDTO.getBh());
            tCkDxService.updateByStatusKey(tCkDx);

            //添加T_CK_BFK
            TCkBfk tCkBfk = BeanUtils.dtoTODO(scrapInAndOutLibraryDetailDTO, TCkBfk.class);
            tCkBfk.setBh(scrapInforDTO.getLibraryMasterDTO().getBh());
           /* if(scrapInforDTO.getSystemNoDetailDTO().getIsGetSystemNo() !=null && scrapInforDTO.getSystemNoDetailDTO().getIsGetSystemNo() == true){
                libraryMasterDTO.setBh(Utils.getNextNoBySystemNo(libraryMasterDTO.getBh()));
            }*/
            try {
                tCkBfkMapper.insert(tCkBfk);
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
                throw  new BusinessException(String.format(THEATER_ALLOCATION,
                        scrapInAndOutLibraryDetailDTO.getJh(),scrapInAndOutLibraryDetailDTO.getXh(),
                        scrapInAndOutLibraryDetailDTO.getJx(),scrapInAndOutLibraryDetailDTO.getDwid()));
            }

        }
        return true;
    }

    /**
     * 保存出库信息
     *
     * @param outLibraryInfoDTO @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveOutLibraryInfo(OutLibraryInfoDTO outLibraryInfoDTO) {

        List<OutLibraryDetailDTO> detailDTOList = outLibraryInfoDTO.getList();

        ValidableList<InAndOutLibraryDetailDTO> list = new ValidableList<>();

        for (OutLibraryDetailDTO outLibraryDetailDTO : detailDTOList) {
            //    // 报废核减 t-ck_bfk
            TCkBfk tCkBfk =
                    tCkBfkMapper.selectByPrimaryKey(
                            outLibraryDetailDTO.getBh(),
                            outLibraryDetailDTO.getJh(),
                            outLibraryDetailDTO.getXh(),
                            outLibraryDetailDTO.getJx(),
                            outLibraryDetailDTO.getDwid());
            try {
                // 跟新数据
                /*Long count = tCkBfk.getSl()-outLibraryDetailDTO.getCksl();
                // 抛出异常
                if(count<0){
                    throw  new BusinessException(
                            String.format(OUT_OF_MEMORY,
                                    outLibraryDetailDTO.getJh(),outLibraryDetailDTO.getXh()));
                }*/
                tCkBfk.setSl(0l);
                tCkBfk.setBz(tCkBfk.getBz()!=null?tCkBfk.getBz():""+","+outLibraryDetailDTO.getBz());
                // 组装数据
                InAndOutLibraryDetailDTO inAndOutLibraryDetailDTO = new InAndOutLibraryDetailDTO();
                org.springframework.beans.BeanUtils.copyProperties(tCkBfk,inAndOutLibraryDetailDTO);
                list.add(inAndOutLibraryDetailDTO);
                tCkBfkMapper.updateByPrimaryKeySelective(tCkBfk);
            }catch (BusinessException e){
                e.printStackTrace();
                log.error(e.getMessage());
                throw  new BusinessException(
                        String.format(CUt_AFTER_EXAMINATION_FAIL,
                                outLibraryDetailDTO.getJh(),outLibraryDetailDTO.getXh()));
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
                throw  new BusinessException(String.format(CUt_AFTER_EXAMINATION_FAIL,
                        outLibraryDetailDTO.getJh(),outLibraryDetailDTO.getXh()));

            }
        }
        //crk和crkqd保存
        Boolean isSuccess =  super.saveInAndOutList(outLibraryInfoDTO.getSystemNoDetailDTO(),
                outLibraryInfoDTO.getLibraryMasterDTO(), list);
        return isSuccess;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean writeNewOutnound(WriteOffDTO writeOffDTO) {
        //报废库数量减少
        TCkBfk tCkBfk =
                tCkBfkMapper.selectByPrimaryKey
                        (writeOffDTO.getBh(),writeOffDTO.getJh(),writeOffDTO.getXh(),writeOffDTO.getJx(),writeOffDTO.getDwid());
        tCkBfk.setSl(tCkBfk.getSl()-writeOffDTO.getSl());
        tCkBfkMapper.updateByPrimaryKeySelective(tCkBfk);
        //ckck增加数量 crk crkqd添加
        return iRepairedLibraryService.writeRotate(writeOffDTO);
    }

    @Override
    public Boolean writeOutnound(WriteOffDTO writeOffDTO) {
        //查询报废信息
        TCkBfk tCkBfks =
                tCkBfkMapper.selectByPrimaryKey
                        (writeOffDTO.getBh(), writeOffDTO.getJh(),
                                writeOffDTO.getXh(),
                                writeOffDTO.getJx(),
                                writeOffDTO.getDwid());
        if(tCkBfks == null){
            throw  new BusinessException(
                    String.format(LIBRARY_NOT_EXIT,writeOffDTO.getJx(),writeOffDTO.getJh(),writeOffDTO.getXh()));
        }

        TCkBfk tCkBfk = tCkBfks;

        //判断是出库还是入库
        if (writeOffDTO.getCrk()) {
            //报废库数量添加
            tCkBfk.setSl(tCkBfk.getSl() + writeOffDTO.getSl());
        }else {
            // 报废入库 减回来
            tCkBfk.setSl(tCkBfk.getSl() - writeOffDTO.getSl());
        }
        tCkBfkMapper.updateByPrimaryKeySelective(tCkBfk);
        //添加crk crkqd
        return super.saveAndUpdateInAndOutWriteOff(writeOffDTO);
    }
}
