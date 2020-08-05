package com.andawell.search.controller;

import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.search.constant.NoticeConstant;
import com.andawell.search.task.InitXml;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * @author lhb
 * @Date: 2020/6/16 11:36
 * @Description:
 * @version : V1.0
 */
@Api(value = "Xml表头注入", tags = "Xml表头注入（不允许直接操作数据库) API")
@RestController
@RequestMapping(value = "sys/xmlOperation")
public class OperationXmlController {

    @Autowired
    InitXml initXml;

    @GetMapping
    @ApiOperation(value = "xml注入")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "xmlName",
                    value = "表头 xmlName",
                    dataType = "String",
                    required = true)
    })
    public RestResultVo updateOrInsert(String xmlName){
        try {
            initXml.updateOrInsert(xmlName);
            return  new RestResultVo<Boolean>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_IMPORT_SUCCESS_MESSAGE);
        }catch (Exception e){
            e.printStackTrace();
            return new RestResultVo<Boolean>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_IMPORT_ERROR_MESSAGE);
        }

    }

    @GetMapping("/updateALl")
    @ApiOperation(value = "xml注入 所有文件都注入，请谨慎注入")
    public RestResultVo updateOrInsertAll(){
        try {
            initXml.updateOrInsertAll();
            return  new RestResultVo<Boolean>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_IMPORT_SUCCESS_MESSAGE);
        }catch (Exception e){
            e.printStackTrace();
            return new RestResultVo<Boolean>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_IMPORT_ERROR_MESSAGE);
        }
    }
}
