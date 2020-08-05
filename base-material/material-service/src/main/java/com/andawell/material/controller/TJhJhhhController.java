package com.andawell.material.controller;


import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.TJhJhhhDTO;
import com.andawell.material.dto.TJhPtjhDTO;
import com.andawell.material.entity.TJhJhhh;
import com.andawell.material.service.ITJhJhhhService;
import com.andawell.material.service.ITJhPtjhService;
import com.andawell.material.utils.ValidableList;
import com.andawell.upms.entity.SysAccountInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.objects.NativeJSON;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Auther:gzh
 * @Date:2020/5/20 13:59
 * @Description: 通用件号儿接口
 */
@Api(value = "通用件号接口", tags = "通用件号接口")
@RestController
@RequestMapping(value = "sys/tjhjhhh")
public class TJhJhhhController {

    @Autowired
    private ITJhJhhhService iTJhJhhhService;


    @ApiOperation(value = "通用件号保存", notes = "通用件号保存", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "insert")
    @SysLog(value = "通用件号保存", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo insert(@RequestBody @Valid ValidableList<TJhJhhhDTO> tJhJhhhDTO) {

        try {

            for (TJhJhhhDTO oneTJhJhhh:tJhJhhhDTO){

                if(!oneTJhJhhh.getThjh().isEmpty()){
                    //件号与替换件号不能相同
                    if(oneTJhJhhh.getJh().equals(oneTJhJhhh.getThjh())){
                        return  new RestResultVo(RestStatus.ERROR,
                                NoticeConstant.RESPONSE_JHTHJH_REPEAT_MESSAGE);
                    }
                }
                //判重
                if (iTJhJhhhService.selectTJhJhhh(oneTJhJhhh) != null) {
                    return  new RestResultVo(RestStatus.ERROR,
                            NoticeConstant.RESPONSE_INSERT_REPEAT_MESSAGE);
                }



            }

            iTJhJhhhService.insert(tJhJhhhDTO);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }


    }


    @ApiOperation(value = "删除通用件号", notes = "删除通用件号", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @DeleteMapping(value = "delete")
    @SysLog(value = "删除通用件号", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo delete(@RequestBody @Valid TJhJhhhDTO tJhJhhhDTO) {
        try {
            iTJhJhhhService.delete(tJhJhhhDTO);
            return new RestResultVo<SysAccountInfo>(RestStatus.SUCCESS, NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<SysAccountInfo>(RestStatus.BAD_REQUEST, NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }


}
