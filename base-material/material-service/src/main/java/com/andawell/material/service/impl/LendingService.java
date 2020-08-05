package com.andawell.material.service.impl;


import cn.hutool.core.bean.BeanUtil;
import com.andawell.common.entity.search.ListPageCommon;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.util.BusinessException;
import com.andawell.material.dto.*;
import com.andawell.material.entity.*;
import com.andawell.material.mapper.*;
import com.andawell.material.query.TCkWjkQuery;
import com.andawell.material.service.ILendingService;
import com.andawell.material.vo.TCkWjkVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static com.andawell.material.constant.BusinessConstant.*;

/***
 * @author lhb
 * @Date: 2020/4/26 17:29
 * @Description:
 * @version : V1.0
 */
@Service
@Slf4j
public class LendingService extends BaseLibraryService implements ILendingService {


    @Autowired
    TCkWjkMapper tCkWjkMapper;


    /**
     * 外借出库
     *
     * @param outLibraryInfoDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveOutLibraryInfo(OutLibraryInfoDTO outLibraryInfoDTO) {

        super.saveOutLibraryInfo(outLibraryInfoDTO);
        // 插入油封数据
        List<OutLibraryDetailDTO> detailDTOList = outLibraryInfoDTO.getList();

        for (OutLibraryDetailDTO dto : detailDTOList) {
            try {

                TCkWjk record = new TCkWjk();
                record.setSl(dto.getCksl());
                // 查询条件
                BeanUtil.copyProperties(dto,record);
                record.setBh(outLibraryInfoDTO.getLibraryMasterDTO().getBh());
                record.setRkrq(dto.getWjrq());

                // 出库人
               // record.setSr
                if(StringUtils.isNotBlank(dto.getXxh())){
                    record.setXh(dto.getXxh());
                }
                // 相关业务 设定
                // TODO: 2020/5/15
               // record.setGhrq("");
                 tCkWjkMapper.insertSelective(record);
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
                throw new BusinessException(String.format(LIBRARY_ALREADY_EXIT,dto.getJx(),
                        dto.getJh(),dto.getXh()));
            }
        }
        return true;
    }

    /**
     * 外借入库
     *
     * @param libraryInfoDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveInLibraryInfo(LibraryInfoDTO libraryInfoDTO) {
        // 存储ckck数据
        List<InAndOutLibraryDetailDTO> detailDTOList = libraryInfoDTO.getList();

        for (InAndOutLibraryDetailDTO dto : detailDTOList) {
            try {
                TCkWjk record = tCkWjkMapper.selectByPrimaryKey(dto.getDwid(),
                        dto.getJx(),
                        dto.getJh(),
                        dto.getXh(),
                        dto.getZl(),
                        dto.getXz(),
                        dto.getBh());
               if (record == null){
                   throw new BusinessException(String.format(LIBRARY_NOT_EXIT,dto.getJx(),
                           dto.getJh(),dto.getXh()));
               }
                // 更新数值
                // 归还数量
                record.setGhsl(dto.getSl());
                // 归还日期
                record.setGhrq(libraryInfoDTO.getLibraryMasterDTO().getRkrq());

                tCkWjkMapper.updateByPrimaryKeySelective(record);
            }catch (BusinessException e){
                e.printStackTrace();
                log.error(e.getMessage());
                throw new BusinessException(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
                throw new BusinessException(String.format(LIBRARY_ALREADY_EXIT,dto.getJx(),
                        dto.getJh(),dto.getXh()));
            }
        }

        return super.saveInLibraryInfo(libraryInfoDTO);
    }

    /**
     * 入库页面
     *
     * @param query
     * @return
     */
    @Override
    public ListPageVo<TCkWjkQuery, TCkWjkVO> getListPage(TCkWjkQuery query) {
        return new ListPageCommon<TCkWjkQuery, TCkWjkVO>
                (query, (q) -> tCkWjkMapper.getList(q)).getVo();
    }
}