package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.dto.TDbLtsqDTO;
import com.andawell.material.dto.WriteOffDTO;
import com.andawell.material.entity.TXtJldw;
import com.andawell.material.service.impl.*;
import com.andawell.material.util.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/***
 * @author lhb
 * @Date: 2020/5/20 13:00
 * @Description:
 * @version : V1.0
 */
@Api(value = "冲销管理", tags = "冲销管理")
@RestController
@RequestMapping(value = "sys/writeOff")
public class WriteOffLibraryController {

    @Autowired
    private BaseLibraryService baseLibraryService;

    @Autowired
    private ContractLibraryService contractLibraryService;

    @Autowired
    ScrapLibraryService scrapLibraryService;

    @Autowired
    private RotateServiceImpl rotateService;

    @Autowired
    private SendRepairLibraryService sendRepairLibraryService;

    @Autowired
    RepairedLibraryService repairedLibraryService;

    @Autowired
    CallOilSeaService callOilSeaService;

    @Autowired
    ReturnToFactoryLibraryService returnToFactoryLibraryService;


    @ApiOperation(value = "全新其他-可用其他-领用-可用发付-出入库冲销")
    @PostMapping(value = "update/baseWriteOff")
    @SysLog(value = "全新其他-可用其他-领用-可用发付-出入库冲销", operationType = LogTypeConstant.LOG_PUT_IN_AND_OUT_WRITE)
    public RestResultVo<Boolean> list(@RequestBody @Valid WriteOffDTO writeOffDTO) {
        Boolean aBoolean = baseLibraryService.baseCkCkWriteOff(writeOffDTO);
        return Utils.getAddResult(aBoolean);
    }

    @ApiOperation(value = "合同多到-合同-出入库冲销")
    @PostMapping(value = "update/contractWriteOff")
    @SysLog(value = "合同多到-合同-出入库冲销", operationType = LogTypeConstant.LOG_PUT_IN_AND_OUT_WRITE)
    public RestResultVo<Boolean> contractWriteOffIn(@RequestBody @Valid WriteOffDTO writeOffDTO) {
        Boolean aBoolean = contractLibraryService.saveAndUpdateInAndOutWriteOff(writeOffDTO);
        return Utils.getAddResult(aBoolean);
    }

    @ApiOperation(value = "全新-可用-轮换-出入库冲销")
    @PostMapping(value = "update/rotationWriteOff")
    @SysLog(value = "全新-可用-轮换-出入库冲销", operationType = LogTypeConstant.LOG_PUT_IN_AND_OUT_WRITE)
    public RestResultVo<Boolean> rotationWriteOffIn(@RequestBody @Valid WriteOffDTO writeOffDTO) {
        Boolean aBoolean = rotateService.rotateCkCkWriteOff(writeOffDTO);
        return Utils.getAddResult(aBoolean);
    }


    @ApiOperation(value = "全新-可用-送修-出入库冲销")
    @PostMapping(value = "update/sendRepairWriteOff")
    @SysLog(value = "全新-可用-送修-出入库冲销", operationType = LogTypeConstant.LOG_PUT_IN_AND_OUT_WRITE)
    public RestResultVo<Boolean> sendRepairWriteOffIn(@RequestBody @Valid WriteOffDTO writeOffDTO) {
        Boolean aBoolean = null;
        if (writeOffDTO.getCrk()) {
            // 出库 冲销
            aBoolean = sendRepairLibraryService.sendRepairWriteOffOut(writeOffDTO);
        } else {
            aBoolean = sendRepairLibraryService.sendRepairWriteOffIn(writeOffDTO);
        }

        return Utils.getAddResult(aBoolean);
    }

    /**
     * @Author: liuys
     * @Data: 2020/5/20
     * @Description: 转报废出库
     */
    @ApiOperation(value = "全新可用/转报废出库-出入库冲销")
    @PostMapping(value = "update/roteRepairedWriteOff")
    @SysLog(value = "全新可用/转报废出库-出入库冲销", operationType = LogTypeConstant.LOG_PUT_IN_AND_OUT_WRITE)
    public RestResultVo<Boolean> writeOutnound(@RequestBody @Validated WriteOffDTO writeOffDTO) {
        return Utils.getAddResult(scrapLibraryService.writeOutnound(writeOffDTO));
    }


    /**
     * @Author: liuys
     * @Data: 2020/5/20
     * @Description: 转报废出库
     */
    @ApiOperation(value = "全新可用/转待修出库-出入库冲销")
    @PostMapping(value = "update/writeRotate")
    @SysLog(value = "全新可用/转待修出库-出入库冲销", operationType = LogTypeConstant.LOG_PUT_IN_AND_OUT_WRITE)
    public RestResultVo<Boolean> writeRotate(@RequestBody @Validated WriteOffDTO writeOffDTO) {
        return Utils.getAddResult(repairedLibraryService.writeRotate(writeOffDTO));
    }

    /**
     * @Author: liuys
     * @Data: 2020/5/20
     * @Description: 出入库冲销
     */
    @ApiOperation(value = "全新可用/返厂升级-出入库冲销")
    @PostMapping(value = "update/writeOilSeaInOut")
    @SysLog(value = "全新可用/返厂升级-出入库冲销", operationType = LogTypeConstant.LOG_PUT_IN_AND_OUT_WRITE)
    public RestResultVo<Boolean> writeOilSeaInOut(@RequestBody @Validated WriteOffDTO writeOffDTO) {
        return Utils.getAddResult(returnToFactoryLibraryService.writeOilSeaInOut(writeOffDTO));
    }

    /**
     * @Author: liuys
     * @Data: 2020/5/20
     * @Description: 出入库冲销
     */
    @ApiOperation(value = "全新-可用/外送油封-出入库冲销")
    @PostMapping(value = "update/writeReturnFactoryOut")
    @SysLog(value = "全新-可用/外送油封-出入库冲销", operationType = LogTypeConstant.LOG_PUT_IN_AND_OUT_WRITE)
    public RestResultVo<Boolean> writeReturnFactoryOut(@RequestBody @Validated WriteOffDTO writeOffDTO) {
        return Utils.getAddResult(callOilSeaService.writeReturnFactoryOut(writeOffDTO));
    }

    @ApiOperation(value = "待修-待修发付-出入库冲销")
    @PostMapping(value = "update/repairedWriteOff")
    @SysLog(value = "待修-待修发付-出入库冲销", operationType = LogTypeConstant.LOG_PUT_IN_AND_OUT_WRITE)
    public RestResultVo<Boolean> repairedWriteOff(@RequestBody @Validated WriteOffDTO writeOffDTO) {
        return Utils.getAddResult(repairedLibraryService.repairedWriteOff(writeOffDTO));
    }

    @ApiOperation(value = "待修退修入库冲销")
    @PostMapping(value = "update/repairedReturnWriteOff")
    @SysLog(value = "待修退修入库冲销", operationType = LogTypeConstant.LOG_PUT_IN_AND_OUT_WRITE)
    public RestResultVo<Boolean> repairedReturnWriteOff(@RequestBody @Validated WriteOffDTO writeOffDTO) {
        return Utils.getAddResult(repairedLibraryService.repairedReturnWriteOff(writeOffDTO));
    }


    /**
     *@Author: liuys
     *@Data: 2020/5/20
     *@Description: 冲销送修出库
     */
    @ApiOperation(value = "冲销送修出库")
    @PostMapping(value = "save/write/repairOut")
    @SysLog(value = "冲销送修出库", operationType = LogTypeConstant.LOG_PUT_IN_AND_OUT_WRITE)
    public RestResultVo<Boolean> writerepairOut(@RequestBody @Valid WriteOffDTO writeOffDTO) {
        return Utils.getAddResult(sendRepairLibraryService.sendRepairWriteOffOut(writeOffDTO));
    }


    /**
     *@Author: liuys
     *@Data: 2020/5/23
     *@Description: 冲销报废出库
     */
    @ApiOperation(value = "冲销报废出库-出入库冲销")
    @PostMapping(value = "save/scrap/outnound")
    @SysLog(value = "冲销报废出库-出入库冲销", operationType = LogTypeConstant.LOG_PUT_IN_AND_OUT_WRITE)
    public RestResultVo<Boolean> writeScrapOutnound(@RequestBody @Valid WriteOffDTO writeOffDTO) {
        return Utils.getAddResult(scrapLibraryService.writeOutnound(writeOffDTO));
    }

}
