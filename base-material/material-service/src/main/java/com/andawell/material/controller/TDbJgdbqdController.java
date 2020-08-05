package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.TDbJgdbDTO;
import com.andawell.material.dto.TDbJgdbqdDTO;
import com.andawell.material.entity.TDbJgdb;
import com.andawell.material.entity.TDbJgdbqd;
import com.andawell.material.enumeration.RepairStatus;
import com.andawell.material.query.TCkCkQuery;
import com.andawell.material.service.ITDbJgdbService;
import com.andawell.material.service.ITDbJgdbqdService;
import com.andawell.material.util.Utils;
import com.andawell.material.vo.TDbSjsqqdVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author: zje
 * @date: 2020/5/28
 * @description:
 */

@Api(value = "机关调拨清单", tags = "机关调拨清单")
@RestController
@RequestMapping(value = "sys/tdbjgdbqd")
public class TDbJgdbqdController {

    @Autowired
    private ITDbJgdbqdService itDbJgdbqdService;

    @Autowired
    private ITDbJgdbService itDbJgdbService;

    /**
     *@Auther: zje
     *@Date: 2020/5/30
     *@Description: 查询机关调拨清单
     *@Param: sqdh
     *@return:
     */
    @ApiOperation(value = "查询机关调拨清单")
    @GetMapping(value = "list")
    public RestResultVo<List<TDbSjsqqdVO>> list(String sqdh){
            List<TDbSjsqqdVO> dbSjsqqdVOS = itDbJgdbqdService.list(sqdh);
            return new RestResultVo<>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                    dbSjsqqdVOS);
    }

    /**
     *@Auther: zje
     *@Date: 2020/5/30
     *@Description: 添加机关调拨清单
     *@Param: dbJgdbqdDTOS
     *@return:
     */
    @ApiOperation(value = "添加机关调拨清单")
    @PostMapping(value = "insert")
    @SysLog(value = "添加机关调拨清单", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo insert(@RequestBody TDbJgdbDTO dbJgdbDTO){
        try {
            TDbJgdb dbJgdb = itDbJgdbService.getJGDB(dbJgdbDTO.getSqdh());
            if (dbJgdb != null){
                return new RestResultVo(RestStatus.ERROR,
                        NoticeConstant.RESPONSE_EXIST_ALREADY_MESSAGE);
            }
            List<TDbJgdbqd> dbJgdbqds = itDbJgdbqdService.getJgdbqd(dbJgdbDTO);
            for (TDbJgdbqd tDbJgdbqd : dbJgdbqds){
                if (tDbJgdbqd != null){
                    return new RestResultVo(RestStatus.ERROR,
                            NoticeConstant.RESPONSE_EXIST_ALREADY_MESSAGE);
                }
            }
            itDbJgdbqdService.insert(dbJgdbDTO);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }

}
