package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.TWxNlqdDTO;
import com.andawell.material.entity.TWxNlqd;
import com.andawell.material.query.TWxNlqdQuery;
import com.andawell.material.query.TWxNlqdTempQuery;
import com.andawell.material.service.ITWxNlqdService;
import com.andawell.material.util.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * @author: zje
 * @date: 2020/5/9
 * @description:修理能力
 */
@Api(value = "维修接口", tags = "修理能力接口")
@RestController
@RequestMapping(value = "sys/tWxNlqd")
public class TWxNlqdController {

    @Autowired
    private ITWxNlqdService wxNlqdService;

//    @Autowired
//    private TWxNlqdMapper wxNlqdMapper;
    
    /**
     *@Auther:zje
     *@Date:2020/5/9
     *@Description:添加维修单位
     *@Param:
     *@return:
     */
    @ApiOperation(value = "增加维修单位")
    @PostMapping(value = "insert")
    @SysLog(value = "增加维修单位", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo insert(@RequestBody @Valid TWxNlqdDTO wxNlqdDTO){
        try {
            TWxNlqd wxNlqd = wxNlqdService.getWxnlqd(wxNlqdDTO);
            if (wxNlqd != null){
                return new RestResultVo(RestStatus.ERROR,
                        NoticeConstant.RESPONSE_EXIST_ALREADY_MESSAGE);
            }
            wxNlqdService.insert(wxNlqdDTO);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }

    /**
     *@Auther:zje
     *@Date:2020/5/9
     *@Description:编辑维修单位
     *@Param:
     *@return:
     */
    @ApiOperation(value = "修改维修单位")
    @PutMapping(value = "update")
    @SysLog(value = "修改维修单位", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo update(@RequestBody TWxNlqdDTO wxNlqdDTO){
        try {
            wxNlqdService.update(wxNlqdDTO);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }
    }

    /**
     *@Auther:zje
     *@Date:2020/5/9
     *@Description:删除机型件号
     *@Param:
     *@return:
     */
    @ApiOperation(value = "删除机型件号维修单位")
    @DeleteMapping(value = "delete/{pId}/{cfId}")
    @SysLog(value = "删除机型件号维修单位", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo delete(@PathVariable("pId") Integer pId,@PathVariable("cfId") String cfId){
        try {
            wxNlqdService.delete(pId,cfId);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }

    /**
     *@Auther:zje
     *@Date:2020/5/9
     *@Description:全部删除
     *@Param:
     *@return:
     */
    @ApiOperation(value = "删除机型件号及维修能力")
    @DeleteMapping(value = "deleteAll/{id}")
    @SysLog(value = "删除机型件号及维修能力", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo deleteAll(@PathVariable("id") Integer id){
        try {
            wxNlqdService.deleteAll(id);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }

//    @ApiOperation(value = "查询维修能力")
//    @GetMapping(value = "get")
//    public RestResultVo<List<TWxNlqd>> get(Integer id){
//        List<TWxNlqd> tWxNlqds = wxNlqdMapper.selectByPId(id);
//        return new RestResultVo<>(RestStatus.SUCCESS,
//                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
//                tWxNlqds);
//    }

    @ApiOperation(value = "下发")
    @PostMapping(value = "transmission")
    @SysLog(value = "下发", operationType = LogTypeConstant.LOG_DOWNLOAD_TYPE)
    public RestResultVo<String> transmission(HttpServletResponse response, @RequestBody List<TWxNlqdQuery> tWxNlqdQuery) {
        Boolean aBoolean=wxNlqdService.transmission(response,tWxNlqdQuery);
        return Utils.getAddResult(aBoolean);
    }

    @ApiOperation(value = "上传")
    @PostMapping(value = "add/upload")
    @SysLog(value = "上传", operationType = LogTypeConstant.LOG_IMPORT_TYPE)
    public RestResultVo<Boolean> upload(@RequestParam("file") MultipartFile multipartFile) {
        Boolean aBoolean = wxNlqdService.upload(multipartFile);
        return Utils.getAddResult(aBoolean);
    }

    @ApiOperation(value = "数据的保存")
    @PostMapping(value = "add/data/locally")
    @SysLog(value = "数据的保存", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<String> dataLocally(@RequestBody List<TWxNlqdTempQuery> tWxNlqdTempQuery) {
        Boolean aBoolean=wxNlqdService.dataLocally(tWxNlqdTempQuery);
        return Utils.getAddResult(aBoolean);
    }

    @ApiOperation(value = "数据的删除")
    @DeleteMapping(value = "delete/data/locally")
    @SysLog(value = "数据的删除", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo<String> deleteDataLocally(@RequestBody List<TWxNlqdTempQuery> tWxNlqdTempQuery) {
        Boolean aBoolean=wxNlqdService.deleteDataLocally(tWxNlqdTempQuery);
        return Utils.getAddResult(aBoolean);
    }

}
