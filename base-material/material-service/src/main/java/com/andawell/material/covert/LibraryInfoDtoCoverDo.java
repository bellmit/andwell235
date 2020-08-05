package com.andawell.material.covert;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.andawell.material.dto.InAndOutLibraryDetailDTO;
import com.andawell.material.dto.LibraryInfoDTO;
import com.andawell.material.dto.LibraryMasterDTO;
import com.andawell.material.dto.RepairedLibraryDetailDTO;
import com.andawell.material.entity.TCkCk;
import com.andawell.material.entity.TCkCrk;
import com.andawell.material.entity.TCkCrkqd;
import com.andawell.material.entity.TCkDx;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import java.util.ArrayList;
import java.util.List;

/***
 * @author lhb
 * @Date: 2020/4/28 15:03
 * @Description:
 * @version : V1.0
 */
@Slf4j
public class LibraryInfoDtoCoverDo {

    public static TCkCrk getTCkCrkDo(LibraryMasterDTO libraryMasterDTO){
        TCkCrk ckCrk = new TCkCrk();
        try {
            BeanUtils.copyProperties(libraryMasterDTO,ckCrk);
            // 日期入库日期
            ckCrk.setRq(libraryMasterDTO.getRkrq());
            ckCrk.setFjlx(libraryMasterDTO.getJx());
           // ckCrk.setDwid();
        }catch (Exception e){
            e.printStackTrace();
            log.error("转换异常",e);
        }
        return ckCrk;
    }

    public static List<TCkCk> getTckckListDo(LibraryMasterDTO libraryMasterDTO,
                                             List<InAndOutLibraryDetailDTO> detailDTOList){
        List<TCkCk> tCkCkList = new ArrayList<>();
        try {
            for (InAndOutLibraryDetailDTO detailDTO : detailDTOList) {
                TCkCk tckCk = new TCkCk();
                BeanUtil.copyProperties(libraryMasterDTO,tckCk);
                BeanUtil.copyProperties(detailDTO,tckCk);
                if(StringUtils.isBlank(detailDTO.getDwid())){
                    tckCk.setDwid(libraryMasterDTO.getDwid());
                }
                if(org.apache.commons.lang.StringUtils.isNotBlank(detailDTO.getXxh())){
                    tckCk.setXh(detailDTO.getXxh());
                }
                if(org.apache.commons.lang.StringUtils.isNotBlank(detailDTO.getXjh())){
                    tckCk.setJh(detailDTO.getJh());
                }
                if(tckCk.getXz() == null){
                    tckCk.setXz("0");
                }
                tckCk.setRkrq(libraryMasterDTO.getRkrq());
                tCkCkList.add(tckCk);
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("转换异常",e);
        }
        return tCkCkList;
    }

    public static List<TCkDx> getTckDxListDo(LibraryMasterDTO libraryMasterDTO,
                                             List<RepairedLibraryDetailDTO> detailDTOList){
        List<TCkDx> tCkCkList = new ArrayList<>();
        try {
            for (RepairedLibraryDetailDTO detailDTO : detailDTOList) {
                TCkDx tckCk = new TCkDx();
                BeanUtil.copyProperties(libraryMasterDTO,tckCk,CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
                BeanUtil.copyProperties(detailDTO,tckCk);

                tCkCkList.add(tckCk);
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("转换异常",e);
        }
        return tCkCkList;
    }

    public static List<TCkCrkqd> getTCkCrkqdListDo(TCkCrk ckCrk,LibraryMasterDTO libraryMasterDTO,
                                                List<?> detailDTOList){
        List<TCkCrkqd> tCkCkList = new ArrayList<>();
        try {

            for (Object detailDTO : detailDTOList) {
                TCkCrkqd tCkCrkqd = new TCkCrkqd();
                BeanUtil.copyProperties(libraryMasterDTO,tCkCrkqd);
                BeanUtil.copyProperties(detailDTO,tCkCrkqd,CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
                tCkCrkqd.setRq(libraryMasterDTO.getRkrq());
                if(StringUtils.isBlank(tCkCrkqd.getDwid())){
                    tCkCrkqd.setDwid(libraryMasterDTO.getDwid());
                }
                if(org.apache.commons.lang.StringUtils.isNotBlank(tCkCrkqd.getXxh())){
                    tCkCrkqd.setXh(tCkCrkqd.getXxh());
                }
                if(org.apache.commons.lang.StringUtils.isNotBlank(tCkCrkqd.getXjh())){
                    tCkCrkqd.setJh(tCkCrkqd.getXjh());
                }
                tCkCrkqd.setBh(ckCrk.getBh());
                tCkCkList.add(tCkCrkqd);
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("转换异常",e);
        }
        return tCkCkList;
    }


}
