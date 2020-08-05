package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TJhImage;
import com.andawell.material.service.ITJhImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author: zje
 * @date: 2020/5/7
 * @description:
 */

@Api(value = "件号儿图片接口", tags = "件号儿图片接口")
@RestController
@RequestMapping(value = "sys/TJHIMAGE")
public class TJhImageController {

    @Autowired
    ITJhImageService ITJhImageService;

    /**
     *@Auther:zje
     *@Date:2020/5/8
     *@Description:查询图片
     *@Param:
     *@return:
     */
    @ApiOperation(value = "查询图片")
    @GetMapping(value = "getImage")
    public RestResultVo<TJhImage> getImage(String jh,HttpServletResponse response){
        try {
            TJhImage jhImage = ITJhImageService.select(jh, response);
            return new RestResultVo<TJhImage>(RestStatus.SUCCESS,
                        NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                        jhImage);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
        }
    }

    /**
     *@Auther:zje
     *@Date:2020/5/8
     *@Description:新增图片
     *@Param:
     *@return:
     */
    @ApiOperation(value = "新增图片")
    @PostMapping(value = "insert")
    @SysLog(value = "新增图片",operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo insert(TJhImage tJhImage,@RequestParam("file")MultipartFile file) {
        try {
            ITJhImageService.insert(tJhImage,file);
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
     *@Date:2020/5/8
     *@Description:编辑图片
     *@Param:
     *@return:
     */
    @ApiOperation(value = "編輯图片")
    @PutMapping(value = "update")
    @SysLog(value = "編輯图片",operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo update(TJhImage jhImage, MultipartFile file) {
        try {
            ITJhImageService.update(jhImage,file);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        }
    }

    /**
     *@Auther:zje
     *@Date:2020/5/8
     *@Description:删除图片
     *@Param:
     *@return:
     */
    @ApiOperation(value = "删除图片")
    @DeleteMapping(value = "delete/{jh}")
    @SysLog(value = "删除图片",operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo delete(@PathVariable("jh") String jh){
        try {
            ITJhImageService.delete(jh);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }

}
