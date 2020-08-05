package com.andawell.material.controller;


import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TXtHclb;
import com.andawell.material.entity.TXtHcyj;
import com.andawell.material.service.ITXtHcyjService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/***
 * @author shs
 * @Date: 2020/6/3 14:55
 * @Description:航材预警
 * @version : V1.0
 */
@Api(value = "航材预警", tags = "航材预警")
@RestController
@RequestMapping(value = "sys/txthcyj")
public class TXtHcyjController {
    @Autowired
    private ITXtHcyjService tXtHcyjService;


    /***
     * @author shs
     * @Date: 2020/6/3 14:55
     * @Description:航材预警查询
     * @return
     */
    @ApiOperation(value = "航材预警查询")
    @GetMapping(value = "select")
    public RestResultVo<TXtHcyj> select() {
        try {
            TXtHcyj tXtHcyj=tXtHcyjService.select();
            return new RestResultVo<TXtHcyj>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,tXtHcyj);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<TXtHcyj>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
        }
    }

    /***
     * @author shs
     * @Date: 2020/6/3 14:55
     * @Description:航材预警编辑
     * @return
     */
    @ApiOperation(value = "航材预警编辑")
    @PutMapping(value = "update")
    @SysLog(value = "航材预警编辑", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<String> update(@RequestBody  TXtHcyj tXtHcyj) {
        try {
            tXtHcyjService.update(tXtHcyj);
            return new RestResultVo<String>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<String>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }
    }


}
