package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.TGzFhDTO;
import com.andawell.material.entity.TGzFh;
import com.andawell.material.service.ITGzFhService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/***
 * @author shs
 * @Date: 2020/5/8 14:18
 * @Description:航材发货跟踪  （航材发货登记，航材发货确认，发货情况查询）
 * @version : V1.0
 */
@Api(value = "航材发货跟踪", tags = "航材发货跟踪")
@RestController
@RequestMapping(value = "sys/tgzfh")
public class TGzFhController {
    @Autowired
    private ITGzFhService tGzFhService;

    /***
     * @author shs
     * @Date: 2020/5/9 9:25
     * @Description:航材发货信息录入
     *
     */
    @ApiOperation(value = "航材发货登记")
    @PostMapping(value = "insert")
    @SysLog(value = "航材发货登记", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<String> insert(@RequestBody List<TGzFh> tGzFh) {
        try {
            tGzFhService.insert(tGzFh);
            return new RestResultVo<String>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }

    /***
     * @author shs
     * @Date: 2020/5/9 9:25
     * @Description:航材发货确认，修改状态值
     *
     */
    @ApiOperation(value = "航材发货确认")
    @PutMapping(value = "update")
    @SysLog(value = "航材发货登记", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<String> update(@RequestBody List<String> list) {
        try {
            tGzFhService.update(list);
            return new RestResultVo<String>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }
    }
}
