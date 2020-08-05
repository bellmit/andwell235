package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.LibraryInfoDTO;
import com.andawell.material.dto.TCkCrkqdDTO;
import com.andawell.material.mapper.TCkCrkqdMapper;
import com.andawell.material.service.ITCkCrkqdService;
import com.andawell.material.vo.ZbKcVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author: zje
 * @date: 2020/5/15
 * @description:
 */

@Api(value = "战备周转管理", tags = "战备周转管理")
@RestController
@RequestMapping(value = "sys/tckcrkqd")
public class TCkCrkqdController {

    @Autowired
    private ITCkCrkqdService itCkCrkqdService;

    /**
     *@Auther:zje
     *@Date:2020/5/15
     *@Description:周转转战备添加
     *@Param:
     *@return:
     */
    @PostMapping("insertZB")
    @ApiOperation(value = "周转转战备添加")
    @SysLog(value = "周转转战备添加", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo insertZB(@RequestBody @Valid TCkCrkqdDTO ckCrkqdDTO){
        try {
            itCkCrkqdService.insertZB(ckCrkqdDTO);
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
     *@Date:2020/5/15
     *@Description:战备转周转添加
     *@Param:
     *@return:
     */
    @PostMapping("insertZZ")
    @ApiOperation(value = "战备转周转添加")
    @SysLog(value = "战备转周转添加", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo insertZZ(@RequestBody @Valid TCkCrkqdDTO ckCrkqdDTO){
        try {
            itCkCrkqdService.insertZZ(ckCrkqdDTO);
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
     *@Date: 2020/5/26
     *@Description: 战备库存替换查询
     *@Param:
     *@return:
     */
    @GetMapping("get")
    @ApiOperation(value = "战备库存替换查询")
    public RestResultVo<List<ZbKcVO>> list(String jh){
        try {
            List<ZbKcVO> zbKcVOS = itCkCrkqdService.list(jh);
            return new RestResultVo<>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                    zbKcVOS);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
        }
    }

    @GetMapping("get/CkNo")
    @ApiOperation(value = "获取出库文号")
    public RestResultVo<String> getCkNo(){
        try {
            String CkNo = itCkCrkqdService.getCkNo();
            return new RestResultVo<>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                    CkNo);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
        }
    }

    @GetMapping("get/rkNo")
    @ApiOperation(value = "获取入库文号")
    public RestResultVo<String> getrkNo(){
        try {
            String rkNo = itCkCrkqdService.getrkNo();
            return new RestResultVo<>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                    rkNo);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
        }
    }
}
