package com.andawell.material.controller;

import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.service.ICompanyService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.vo.CompanyVO;
import com.andawell.upms.query.TXtDwQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date： 2020/4/27 14:29
 */
@RestController
@Api(value = "单位接口",tags="单位接口")
@RequestMapping(value = "sys/company")
public class CompanyController {

    @Autowired
    private ICompanyService companyService;

    @ApiOperation(value = "军方单位")
    @GetMapping(value = "list")
    public RestResultVo<List<CompanyVO>> getList() {
        return new RestResultVo<List<CompanyVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                companyService.getList(null));
    }

    @ApiOperation(value = "全新其他单位树结构列表，全部单位")
    @GetMapping(value = "tree/list")
    public RestResultVo<List<CompanyVO>> getCurrencyList() {
        return new RestResultVo<List<CompanyVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                companyService.getTreeList());
    }

    @ApiOperation(value = "全新发付单位和轮换树结构列表，单位是军方")
    @GetMapping(value = "payment/tree/list")
    public RestResultVo<List<CompanyVO>> getPaymentTreeList() {
        return new RestResultVo<List<CompanyVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                companyService.getPaymentTreeList());
    }

    @ApiOperation(value = "查询当前单位下的下一级单位")
    @GetMapping(value = "get/children")
    public RestResultVo<List<CompanyVO>> getChildren() {
        return new RestResultVo<List<CompanyVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                BeanUtils.copyList(companyService.getChildren(),CompanyVO.class));
    }

}
