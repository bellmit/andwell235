package com.andawell.material.controller;/**
 * @Date： 2020/5/11 14:47
 */

import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TJhZylx;
import com.andawell.material.entity.response.TCkCkBO;
import com.andawell.material.query.TCkSxLikeQuery;
import com.andawell.material.query.TJhZylxQuery;
import com.andawell.material.service.ITJhZylxService;
import com.andawell.material.util.BeanUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *@Auther:liuys
 *@Date:2020/5/11 14:47
 *@Description:
 */
@Api(value = "专业类别", tags = "专业类别")
@RestController
@RequestMapping(value = "sys/tjhzylx")
public class TJhZylxController {
    @Autowired
    private ITJhZylxService itJhZylxService;

    /**
     *@Author: liuys
     *@Data: 2020/5/11
     *@Description: 查询所有专业类别
     */
    @ApiOperation(value = "查询所有专业类别", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "list")
    public RestResultVo<List<TJhZylx>> list(TJhZylxQuery query) {
        return new RestResultVo<List<TJhZylx>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                BeanUtils.copyList(itJhZylxService.list(query), TJhZylx.class));
    }

}
