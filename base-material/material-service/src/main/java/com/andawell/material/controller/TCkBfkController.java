package com.andawell.material.controller;

import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.OutLibraryInfoDTO;
import com.andawell.material.entity.TCkBfk;
import com.andawell.material.query.TCkBfkQuery;
import com.andawell.material.query.TCkWsyfQuery;
import com.andawell.material.service.ITCkBfkService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.vo.TCfVO;
import com.andawell.material.vo.TCkBfkVO;
import com.andawell.material.vo.TCkDxzbfVO;
import com.andawell.material.vo.TCkWsyfVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Date： 2020/5/8 10:26
 */
@Api(value = "报废信息接口", tags = "报废信息接口")
@RestController
@RequestMapping(value = "sys/tckbfk")
public class TCkBfkController {
    @Autowired
    private ITCkBfkService itCkBfkService;




    /**
     *@Author: liuys
     *@Data: 2020/5/13
     *@Description: 报废出库列表查询
     */
    @ApiOperation(value = "报废出库列表查询-报废入库")
    @GetMapping(value = "warehousing/list")
    public RestResultVo<List<TCkDxzbfVO>> warehousingList(@Valid TCkBfkQuery tCkBfkQuery) {
        return new RestResultVo<List<TCkDxzbfVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                itCkBfkService.warehousingList(tCkBfkQuery));
    }


    /**
     *@Author: liuys
     *@Data: 2020/5/13
     *@Description: 报废出库列表查询
     */
    @ApiOperation(value = "报废出库列表查询-报废出库")
    @GetMapping(value = "outnound/list")
    public RestResultVo<ListPageVo<TCkBfkQuery,TCkBfkVO>> outnoundList( @Valid TCkBfkQuery tCkBfkQuery) {
        return new RestResultVo<ListPageVo<TCkBfkQuery,TCkBfkVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                itCkBfkService.outnoundList(tCkBfkQuery));
    }

}
