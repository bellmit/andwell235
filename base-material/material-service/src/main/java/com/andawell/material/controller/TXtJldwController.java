package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TXtJldw;
import com.andawell.material.query.TXtJldwQuery;
import com.andawell.material.service.ITXtJldwService;
import com.andawell.material.util.BeanUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *@Auther:zje
 *@Date:2020/5/11
 *@Description:
 */

@Api(value = "计量单位", tags = "计量单位")
@RestController
@RequestMapping(value = "sys/txtjldw")
public class TXtJldwController {

    @Autowired
    private ITXtJldwService itXtJldwService;

    /**
     *@Auther:zje
     *@Date:2020/5/12
     *@Description:查询计量单位
     *@Param:
     *@return:
     */
    @ApiOperation(value = "查询所有计量单位", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "list")
    public RestResultVo<List<TXtJldw>> list(TXtJldwQuery query) {
        return new RestResultVo<List<TXtJldw>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                BeanUtils.copyList(itXtJldwService.list(query), TXtJldw.class));
    }

    /**
     *@Auther:zje
     *@Date:2020/5/20
     *@Description:添加计量单位
     *@Param:xtJldw
     *@return:
     */
    @ApiOperation(value = "添加计量单位", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "insert")
    @SysLog(value = "添加计量单位", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo insert(@RequestBody TXtJldw xtJldw){
        try {
            TXtJldw tXtJldw = itXtJldwService.selectByMc(xtJldw.getMc());
            if(tXtJldw != null){
                return new RestResultVo(RestStatus.ERROR,
                        NoticeConstant.RESPONSE_EXIST_ALREADY_MESSAGE);
            }
            itXtJldwService.insert(xtJldw);
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
     *@Description: 修改计量单位
     *@Param: xtJldw
     *@return:
     */
    @ApiOperation(value = "修改计量单位", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PutMapping(value = "update")
    @SysLog(value = "修改计量单位", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo update(@RequestBody TXtJldw xtJldw){
        try {
            itXtJldwService.update(xtJldw);
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
     *@Description: 删除计量单位
     *@Param: id
     *@return:
     */
    @ApiOperation(value = "删除计量单位", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @DeleteMapping(value = "delete/{id}")
    @SysLog(value = "删除计量单位", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo delete(@PathVariable("id") String id){
        try {
            itXtJldwService.delete(id);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }
}
