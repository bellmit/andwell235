package com.andawell.material.controller;

import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.LibraryInfoDTO;
import com.andawell.material.entity.TXtXljb;
import com.andawell.material.service.ITXtXljbService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.vo.TXtXljbVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @Date： 2020/5/3 15:51
 */
@Api(value = "维修类别", tags = "维修类别")
@RestController
@RequestMapping(value = "sys/txtxljb")
public class TXtXljbController {

    @Autowired
    private ITXtXljbService itXtXljbService;

    /**
     * 查询所有的维修类别
     * @return
     */
    @ApiOperation(value = "维修类别")
    @GetMapping(value = "list")
    public RestResultVo<List<TXtXljbVO>> list() {
        return new RestResultVo<List<TXtXljbVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE,
                BeanUtils.copyList(itXtXljbService.list(null), TXtXljbVO.class));
    }
}
