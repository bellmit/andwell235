package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.DeliverDTO;
import com.andawell.material.dto.ZQSaveDTO;
import com.andawell.material.query.TDbLtsqQuery;
import com.andawell.material.query.TSjSqQuery;
import com.andawell.material.service.ZoneTransferService;
import com.andawell.material.util.Utils;
import com.andawell.material.utils.ValidableList;
import com.andawell.material.vo.TDbJgdbVO;
import com.andawell.material.vo.TDbLtsqAndQDVO;
import com.andawell.material.vo.TDbSjsqAndQDVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/***
 * @author hwd
 * @Date: 2020-06-06 10:52
 * @Description:战区的上传下发
 * @version : V1.0
 */
@Slf4j
@Api(value = "调拨管理-战区的上传下发", tags = "调拨管理-战区的上传下发")
@RestController
@RequestMapping(value = "sys/uploadAndSend")
public class ZoneUploadAndSendController {

    @Autowired
    private ZoneTransferService zoneTransfer;


    /**
     * 战区调拨下发 T_DB_LTDB T_DB_LTDBQD
     */
    @ResponseBody
    @ApiOperation(value = "战区调拨旅团申请下发返回db文件")
    @PostMapping(value = "ltleading")
    @SysLog(value = "战区调拨旅团申请下发返回db文件", operationType = LogTypeConstant.LOG_DOWNLOAD_TYPE)
    public void fileLTLeading(HttpServletResponse response, @RequestBody @Valid ValidableList<DeliverDTO> deliverDTOS) {
        zoneTransfer.fileLTLeading(response,deliverDTOS);
    }


    /**
     * 战区调拨下发 T_DB_SJSQ T_DB_SJSQQD
     */
    @ResponseBody
    @ApiOperation(value = "战区调拨机关申请上报返回db文件")
    @PostMapping(value = "jgleading")
    @SysLog(value = "战区调拨机关申请上报返回db文件", operationType = LogTypeConstant.LOG_DOWNLOAD_TYPE)
    public void fileJGLeading(HttpServletResponse response,@RequestBody @Valid ValidableList<DeliverDTO> deliverDTOS) {
        zoneTransfer.fileJGLeading(response,deliverDTOS);
    }


    /**
     * 战区调拨上传 接收db文件 读取数据
     * T_DB_LTSQ  T_DB_LTSQQD
     */
    @ApiOperation(value = "战区调拨上传 接收db文件 读取旅团申请数据")
    @PostMapping(value = "ltupload")
    @SysLog(value = "战区调拨上传 接收db文件 读取旅团申请数据", operationType = LogTypeConstant.LOG_UPLOAD_TYPE)
    public RestResultVo<List<TDbLtsqAndQDVO>> fileLTUpload(@RequestParam("file") MultipartFile multipartFile) {
        return new RestResultVo<List<TDbLtsqAndQDVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                zoneTransfer.FileLTUpload(multipartFile));
    }

    /**
     * 战区调拨上传 接收db文件 读取数据
     * T_DB_LTSQ  T_DB_LTSQQD
     */
    @ApiOperation(value = "战区调拨上传 接收db文件 读取机关下发数据")
    @PostMapping(value = "jgupload")
    @SysLog(value = "战区调拨上传 接收db文件 读取机关下发数据", operationType = LogTypeConstant.LOG_UPLOAD_TYPE)
    public RestResultVo<List<TDbSjsqAndQDVO>> fileSJUpload(@RequestParam("file") MultipartFile multipartFile) {
        return new RestResultVo<List<TDbSjsqAndQDVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                zoneTransfer.FileSJUpload( multipartFile));
    }

    /**
     * 将缓存表中的数据存入到逻辑数据库中
     * style 类型 1：表示将旅团申请中数据存入到数据库
     *           2：根据机关中数据修改数据库数据
     */
    @ApiOperation(value = "将缓存表中的数据存入到逻辑数据库中")
    @PostMapping(value = "save")
    @SysLog(value = "将缓存表中的数据存入到逻辑数据库中", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<Boolean> saveMessage(@RequestBody ZQSaveDTO zqSaveDTO) {
        Boolean aBoolean = zoneTransfer.saveMessage(zqSaveDTO);
        return Utils.getAddResult(aBoolean);
    }

//    /**
//     * 手动删除缓存表中数据
//     * 1:旅团 申请删除
//     * 2：上级申请 删除
//     */
//    @ApiOperation(value = "删除")
//    @DeleteMapping(value = "delete")
//    public RestResultVo<Boolean> deleteMessage(@RequestBody TDbLtsqQuery tDbLtsqQuery) {
//        Boolean aBoolean = zoneTransfer.deleteMessage(tDbLtsqQuery.getLtsqdhs(),tDbLtsqQuery.getStyle());
//        return Utils.deleteDataResult(aBoolean);
//    }
}
