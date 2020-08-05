package com.andawell.material.controller;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TCkCrklx;
import com.andawell.material.entity.response.TCkCkBO;
import com.andawell.material.query.TCkCrklxQuery;
import com.andawell.material.service.ITCkCrklxService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.vo.TCkCrklxVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther:liuys
 * @Date:2020/5/11 15:00
 * @Description:
 */
@Api(value = "出库类型", tags = "出库类型")
@RestController
@RequestMapping(value = "sys/tckcrklx")
public class TCkCrklxController {
    @Autowired
    private ITCkCrklxService itCkCrklxService;

    /**
     *@Author: liuys
     *@Data: 2020/5/11
     *@Description: 查询所有出库类型
     */
    @ApiOperation(value = "查询所有出库类型", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "treelist")
    public RestResultVo<List<TCkCrklxVO>> treelist(TCkCrklxQuery query) {
        return new RestResultVo<List<TCkCrklxVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                itCkCrklxService.treelist(query));
    }

    /**
     *@Author: liuys
     *@Data: 2020/5/11
     *@Description: 查询所有出库类型
     */
    @ApiOperation(value = "发付出库/出库类型", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "list")
    public RestResultVo<List<TCkCrklxVO>> list(TCkCrklxQuery query) {
        return new RestResultVo<List<TCkCrklxVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                BeanUtils.copyList(itCkCrklxService.list(query),TCkCrklxVO.class));
    }
}
