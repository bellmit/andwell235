package com.andawell.material.service.impl;

import com.andawell.material.dto.*;
import com.andawell.material.entity.THtDhqd;
import com.andawell.material.mapper.THtDhqdMapper;
import com.andawell.material.service.IContractLibraryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/***
 * @author lhb
 * @Date: 2020/5/18 11:58
 * @Description:
 * @version : V1.0
 */
@Service("contractLibraryServiceImp")
public class ContractLibraryService extends BaseLibraryService
        implements IContractLibraryService {


    @Autowired
    THtDhqdMapper tHtDhqdMapper;


    /**
     * 订货合同入库
     *
     * @param contractInfoDTO
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean addContract(ContractInfoDTO contractInfoDTO) {
        //添加完缓存表和入库主信息后，进行核减
        LibraryInfoDTO libraryInfoDTO = contractInfoDTO.getLibraryInfoDTO();
        List<InAndOutLibraryDetailDTO> detailDTOList = libraryInfoDTO.getList();
        for (InAndOutLibraryDetailDTO inAndOutLibraryDetai : detailDTOList) {
            //添加 合同里的已到数量
            tHtDhqdMapper.updeteSlByHtbhAndJxAndJh(inAndOutLibraryDetai.getSl(), contractInfoDTO.getHtbh(),
                    libraryInfoDTO.getLibraryMasterDTO().getJx(), inAndOutLibraryDetai.getJh());

        }
        //将合同号添加到  依据中
        contractInfoDTO.getLibraryInfoDTO().getLibraryMasterDTO().setYj(contractInfoDTO.getHtbh());
        return super.saveInLibraryInfo(contractInfoDTO.getLibraryInfoDTO());
    }

    /**
     * 合同多到
     *
     * @param contractInfoDTO
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean addMultipeContract(ContractInfoDTO contractInfoDTO) {
        LibraryInfoDTO libraryInfoDTO = contractInfoDTO.getLibraryInfoDTO();
        List<InAndOutLibraryDetailDTO> detailDTOList = libraryInfoDTO.getList();
        for (InAndOutLibraryDetailDTO inAndOutLibraryDetai : detailDTOList) {
            //合同多到，计价为0
            inAndOutLibraryDetai.setJj(new BigDecimal(0));
            tHtDhqdMapper.updeteSlByHtbhAndJxAndJh(inAndOutLibraryDetai.getSl(),
                    contractInfoDTO.getHtbh(),
                    libraryInfoDTO.getLibraryMasterDTO().getJx(),
                    inAndOutLibraryDetai.getJh());
        }
        return super.saveInLibraryInfo(libraryInfoDTO);
    }


    /**
     * 冲销合同冲销出入库
     *
     * @param contractWriteOffDto @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveAndUpdateInAndOutWriteOff(ContractWriteOffDto contractWriteOffDto) {
        // tHtDhqdMapper.
        THtDhqd tHtDhqd = tHtDhqdMapper.selectByPrimaryKey(contractWriteOffDto.getHtbh()
        ,contractWriteOffDto.getJx(),contractWriteOffDto.getJh());

        tHtDhqd.setYdsl(tHtDhqd.getYdsl()-contractWriteOffDto.getSl());
        tHtDhqdMapper.updateByPrimaryKeySelective(tHtDhqd);
        WriteOffDTO writeOffDTO = new WriteOffDTO();
        // 修改T_HT_DHQD
        BeanUtils.copyProperties(contractWriteOffDto,writeOffDTO);

        return super.baseCkCkWriteOff(writeOffDTO);
    }
}
