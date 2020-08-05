package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TXtBzlb;
import com.andawell.material.service.ITXtBzlbService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zje
 * @date: 2020/5/20
 * @description: 币种类别管理
 */

@Api(value = "币种类别管理", tags = "币种类别管理")
@RestController
@RequestMapping(value = "sys/txtbzlb")
public class TXtBzlbController {

    @Autowired
    private ITXtBzlbService xtBzlbService;

    /**
     *@Auther: zje
     *@Date: 2020/5/21
     *@Description: 添加货币种类
     *@Param: xtBzlb
     *@return:
     */
    @ApiOperation(value = "添加货币种类", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "insert")
    @SysLog(value = "添加货币种类", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo insert(@RequestBody TXtBzlb xtBzlb){
        try {
            TXtBzlb tXtBzlb = xtBzlbService.selectByMc(xtBzlb.getMc());
            if (tXtBzlb != null){
                return new RestResultVo(RestStatus.ERROR,
                        NoticeConstant.RESPONSE_EXIST_ALREADY_MESSAGE);
            }
            xtBzlbService.insert(xtBzlb);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }

    /**
     *@Auther: zje
     *@Date: 2020/5/21
     *@Description: 修改货币种类
     *@Param: xtBzlb
     *@return:
     */
    @ApiOperation(value = "修改货币种类", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PutMapping(value = "update")
    @SysLog(value = "五金出库保存", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo update(@RequestBody TXtBzlb xtBzlb){
        try {
            xtBzlbService.update(xtBzlb);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }
    }

    /**
     *@Auther: zje
     *@Date: 2020/5/21
     *@Description: 删除货币种类
     *@Param: id
     *@return:
     */
    @ApiOperation(value = "删除货币种类", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @DeleteMapping(value = "delete/{id}")
    @SysLog(value = "删除货币种类", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo delete(@PathVariable("id") String id){
        try {
            xtBzlbService.delete(id);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }
}
