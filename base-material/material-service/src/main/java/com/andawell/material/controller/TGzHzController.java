package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.TCkCrkDTO;
import com.andawell.material.dto.TGzHzDTO;
import com.andawell.material.entity.TGzHz;
import com.andawell.material.service.ITCkCrkService;
import com.andawell.material.service.ITGzHzService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/***
 * @author shs
 * @Date: 2020/5/9 9:18
 * @Description:回执跟踪功能  （入库回执跟踪登记，入库回执查询，出库回执跟踪）
 * @version : V1.0
 */
@Api(value = "回执跟踪", tags = "回执跟踪")
@RestController
@RequestMapping(value = "sys/tgzhz")
public class TGzHzController {
    @Autowired
    private ITGzHzService tGzHzService;
    @Autowired
    private ITCkCrkService tCkCrkService;

    /***
     * @author shs
     * @Date: 2020/5/9 9:25
     * @Description:入库回执跟总信息录入
     *
     */
    @ApiOperation(value = "入库回执跟踪登记")
    @PostMapping(value = "insert")
    @SysLog(value = "入库回执跟踪登记", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<String> insert(@RequestBody @Valid List<TGzHz> tGzHzDTO) {
        try {
            tGzHzService.insert(tGzHzDTO);
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
     * @Description:入库回执跟总信息录入
     *
     */
    @ApiOperation(value = "入库回执查询添加")
    @PostMapping(value = "inserttgzhz")
    @SysLog(value = "入库回执跟踪登记", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<List<TCkCrkDTO>> inserttgzhz(@RequestBody @Valid List<TGzHzDTO> tGzHzDTO) {
        try {
            tGzHzService.inserttgzhz(tGzHzDTO);
            return new RestResultVo<List<TCkCrkDTO>>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }

    /***
     * @author shs
     * @Date: 2020/5/9 9：50
     * @Description:出库回执信息的修改
     *
     */
    @ApiOperation(value = "出库回执跟踪")
    @PutMapping(value = "update")
    @SysLog(value = "入库回执跟踪", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<String> update(@RequestBody @Valid TCkCrkDTO tCkCrkDTO) {
        try {
            tGzHzService.updateTCkCrk(tCkCrkDTO);
            return new RestResultVo<String>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }
    }

    /***
     * @author shs
     * @Date: 2020/6/19 9：50
     * @Description:出库回执查询修改
     *
     */
    @ApiOperation(value = "出库回执跟踪")
    @PutMapping(value = "updateckcrk")
    @SysLog(value = "入库回执跟踪", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<String> updateckcrk(@RequestBody @Valid TCkCrkDTO tCkCrkDTO) {
        try {
            tCkCrkService.updateTCkCrk(tCkCrkDTO);
            return new RestResultVo<String>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }
    }

    /***
     * @author shs
     * @Date: 2020/5/9 9：50
     * @Description:出库回执信息的修改
     *
     */
    @ApiOperation(value = "入库回执查询")
    @PutMapping(value = "updaterkhz")
    @SysLog(value = "入库回执查询", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<String> updaterkhz(@RequestBody @Valid TGzHzDTO tGzHz) {
        try {
            tGzHzService.updaterkhz(tGzHz);
            return new RestResultVo<String>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }
    }
}
