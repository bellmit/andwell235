package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.util.BusinessException;
import com.andawell.common.util.FileUtils;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.ReviseZqdbDTO;
import com.andawell.material.dto.TDbDbAndQdDTO;
import com.andawell.material.dto.TDbsjSqDTO;
import com.andawell.material.dto.TheaterAllocationDTO;
import com.andawell.material.dto.groups.First;
import com.andawell.material.entity.VDw;
import com.andawell.material.query.TDbLtsqQuery;
import com.andawell.material.query.TSjSqQuery;
import com.andawell.material.service.ITDbLtsqService;
import com.andawell.material.service.ZoneTransferService;
import com.andawell.material.util.Utils;
import com.andawell.material.utils.ValidableList;
import com.andawell.material.vo.BursaryVO;
import com.andawell.material.vo.TDbJgdbVO;
import com.andawell.material.vo.TDbLtsqVO;
import com.github.pagehelper.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

/***
 * @author hwd
 * @Date: 2020-05-22 14:06
 * @Description:战区调拨
 * @version : V1.0
 */
@Slf4j
@Api(value = "调拨管理-战区和机关调拨", tags = "调拨管理-战区和机关调拨")
@RestController
@RequestMapping(value = "sys/tdbltdbjg")
public class ZoneTransferController {

    @Autowired
    private ZoneTransferService zoneTransfer;

    @Autowired
    private ITDbLtsqService tDbLtsqService;

    @Value("${upload.path}")
    private String filepath;


    /**
     * 展示旅团调拨申请详细信息 接口
     */
    @ApiOperation(value = "展示旅团调拨申请详细信息")
    @GetMapping(value = "get/list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bh", value = "申请单号", dataType = "String", required = true)})
    public RestResultVo<List<BursaryVO>> getLTSQList(String bh){
        return new RestResultVo<List<BursaryVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                zoneTransfer.getLTSQQDList(bh));
    }

    /**
     *@Author: liuys
     *@Data: 2020/5/25
     *@Description: 战区调拨申请保存
     */
    @ApiOperation(value = "战区调拨申请保存")
    @PostMapping(value = "save/theater/allocation")
    @SysLog(value = "战区调拨申请保存", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<Boolean> saveTheaterAllocation(@RequestBody @Valid TheaterAllocationDTO theaterAllocationDTO) {
        Boolean aBoolean = zoneTransfer.saveTheaterAllocation(theaterAllocationDTO);
        return  Utils.getAddResult(aBoolean);
    }

    /**
     * 战区调拨转向上申请-生成调拨单
     */
    @ApiOperation(value = "战区调拨-转向上申请-生成调拨单")
    @PostMapping(value = "save/SuperiorAllot")
    @SysLog(value = "战区调拨-上级申请", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<Boolean> saveSuperiorApplication(@RequestBody @Valid TheaterAllocationDTO theaterAllocationDTO) {
        Boolean aBoolean = zoneTransfer.saveSuperiorApplication(theaterAllocationDTO);
        return  Utils.getAddResult(aBoolean);
    }

    /***
     * @author hwd
     * @Date: 2020/5/14 16:50
     * @Description:机关调拨--调拨编号
     * @return
     */
    @ApiOperation(value = "获取调拨编号", notes = "获取调拨编号", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "getBh")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "1：部队调拨/2：工厂调拨", dataType = "String", required = true)})
    public RestResultVo<String> getAllotBh(String type) {
        if (type.isEmpty()){
            throw new BusinessException("编号类型不能为空");
        }
        return new RestResultVo<String>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tDbLtsqService.getAllotBh(type));
    }


    /***
     * @author hwd
     * @Date: 2020/5/14 16:50
     * @Description:保存机关调拨
     * @return
     */
    @ApiOperation(value = "保存机关/战区主动调拨", notes = "保存机关/战区主动调拨")
    @PostMapping(value = "save")
    @SysLog(value = "保存机关调拨", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<Boolean> saveAllot(@RequestBody @Validated({First.class}) TDbDbAndQdDTO tDbDbAndQdDTO) {
        Boolean aBoolean = tDbLtsqService.saveAllot(tDbDbAndQdDTO);
        return  Utils.getAddResult(aBoolean);
    }

    /**
     *@Author: liuys
     *@Data: 2020/5/26
     *@Description: 查询战区下旅团下的申请查询
     */
    @ApiOperation(value = "战区调拨-旅团列表查询")
    @GetMapping(value = "get/allocation/list")
    public RestResultVo<ListPageVo<TDbLtsqQuery, TDbLtsqVO>> getTheaterAllocation(TDbLtsqQuery tDbLtsqQuery) {
        return new RestResultVo<ListPageVo<TDbLtsqQuery, TDbLtsqVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                zoneTransfer.getAllocationList(tDbLtsqQuery));
    }

    /**
     * 战区调拨展示向上申请
     */
    @ApiOperation(value = "战区调拨-获取战区调拨向上申请清单")
    @GetMapping(value = "get/Superior")

    public RestResultVo<ListPageVo<TSjSqQuery, TDbJgdbVO>> getSuperiorApplicationList(TSjSqQuery tSjSqQuery) {
        return new RestResultVo<ListPageVo<TSjSqQuery, TDbJgdbVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                zoneTransfer.getTDbJgdbList(tSjSqQuery));
    }

    /**
     * 战区调拨处理向上申请
     */
    @ApiOperation(value = "战区调拨-保存向上申请")
    @PostMapping(value = "save/Superior")
    @SysLog(value = "战区调拨-保存向上申请", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<Boolean> saveSuperiorApplication(@RequestBody @Valid TDbsjSqDTO tDbsjSqDTO) {
        Boolean aBoolean = zoneTransfer.saveSuperiorApplication(tDbsjSqDTO);
        return  Utils.getAddResult(aBoolean);
    }

    /**
     * 手动修改战区调拨状态 改为已处理
     */
    @ApiOperation(value = "战区调拨-手动修改战区调拨状态")
    @PostMapping(value = "update/Superior")
    @SysLog(value = "战区调拨-手动修改战区调拨状态", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<Boolean> updateSuperior(@RequestBody @Valid ValidableList<ReviseZqdbDTO> reviseZqDbDTOS) {
        Boolean aBoolean = zoneTransfer.updateSuperior(reviseZqDbDTOS);
        return  Utils.getReciseResult(aBoolean);
    }

    /**
     * 文件上传
     */
    @ApiOperation(value = "文件上传")
    @PostMapping(value = "upload")
    @SysLog(value = "文件上传", operationType = LogTypeConstant.LOG_UPLOAD_TYPE)
    public  RestResultVo<String> upload(MultipartFile multipartFile) {
        String upload = FileUtils.upload(multipartFile, filepath);
        Boolean isSuccess = StringUtil.isNotEmpty(upload)?true:false;
        return Utils.getLeadResult(isSuccess);
    }



    /**
     * 获取战区下的单位id
     */
    @ApiOperation(value = "获取战区下的单位id")
    @GetMapping(value = "getUserDW")
    public RestResultVo<List<VDw>> getUserDW()
    {
        return new RestResultVo<List<VDw>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                zoneTransfer.getUserBranchDw());
    }

}
