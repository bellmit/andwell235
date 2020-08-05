package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.TGzDhDTO;
import com.andawell.material.entity.TGzDh;
import com.andawell.material.service.ITGzDhService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/***
 * @author shs
 * @Date: 2020/5/7 14:18
 * @Description:航材到货跟踪  （航材到货登记，航材入库确认，航材情况查询）
 * @version : V1.0
 */
@Api(value = "航材到货跟踪接口", tags = "航材到货跟踪接口")
@RestController
@RequestMapping(value = "sys/tgzdh")
public class TGzDhController {
    @Autowired
    private ITGzDhService tGzDhService;

    /***
     * @author shs
     * @Date: 2020/5/7 14:18
     * @Description:航材到货登记，实现航材到货数据的单个或批量录入
     */
    @ApiOperation(value = "航材到货登记")
    @PostMapping(value = "insert")
    @SysLog(value = "航材到货登记", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<String> insert(@RequestBody List<TGzDh> tGzDh) {
        try {
            for (int i = 0; i < tGzDh.size(); i++) {
                TGzDh tGzDhAll = tGzDh.get(i);
                if (StringUtils.isEmpty(tGzDhAll.getJx())) {
                    return new RestResultVo<String>(RestStatus.BAD_REQUEST,
                            NoticeConstant.RESPONSE_PARAMS_ERROR_MESSAGE);
                }
                if (StringUtils.isEmpty(tGzDhAll.getYdh())) {
                    return new RestResultVo<String>(RestStatus.BAD_REQUEST,
                            NoticeConstant.RESPONSE_PARAMS_ERROR_MESSAGE);
                }
            }
            tGzDhService.insertTGzDhList(tGzDh);
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
     * @Date: 2020/5/7 16:18
     * @Description: 航材入库确认，实现对入库文号，入库日期的完善
     *
     */
    @ApiOperation(value = "航材入库确认")
    @PutMapping(value = "update")
    @SysLog(value = "航材入库确认", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<String> update(@RequestBody @Valid TGzDhDTO tGzDhDTO) {
        try {
            tGzDhService.updateTGzDh(tGzDhDTO);
            return new RestResultVo<String>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }
    }
}
