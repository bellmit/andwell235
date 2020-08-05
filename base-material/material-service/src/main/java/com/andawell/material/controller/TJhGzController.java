package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.TJhGzzDTO;
import com.andawell.material.query.TJhDjQuery;
import com.andawell.material.query.TJhGzQuery;
import com.andawell.material.query.TJhQuery;
import com.andawell.material.service.ITJhGzService;
import com.andawell.material.vo.TJhGzVO;
import com.andawell.material.vo.TSrJhGzVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/***
 * @author shs
 * @Date: 2020/5/18 14:55
 * @Description:件号关注 （旅团，机关件号查询，件号删除，件号添加）
 * @version : V1.0
 */
@Api(value = "件号关注", tags = "件号关注")
@RestController
@RequestMapping(value = "sys/tjhgz")
public class TJhGzController {
    @Autowired
    private ITJhGzService tJhGzService;

    /***
     * @author shs
     * @Date: 2020/5/18 14:55
     * @Description:机号关注添加
     * @return
     */
    @ApiOperation(value = "公有机号关注添加")
    @PostMapping(value = "insert")
    @SysLog(value = "机号关注添加", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<String> insert(@RequestBody @Valid  TJhGzzDTO tJhGzzDTO) {
        try {
            tJhGzService.insert(tJhGzzDTO);
            return new RestResultVo<String>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<String>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_INSERT_REPEAT_MESSAGE);
        }
    }
    /***
     * @author shs
     * @Date: 2020/6/1 14:55
     * @Description:私有机号关注添加
     * @return
     */
    @ApiOperation(value = "私有机号关注添加")
    @PostMapping(value = "insertSy")
    @SysLog(value = "机号关注添加", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<String> insertSy(@RequestBody @Valid TJhGzzDTO tJhGzzDTO) {
        try {
            tJhGzService.insertSy(tJhGzzDTO);
            return new RestResultVo<String>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<String>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_INSERT_REPEAT_MESSAGE);
        }
    }

    /***
     * @author shs
     * @Date: 2020/5/19 9:55
     * @Description:机号关注删除
     * @return
     */
    @ApiOperation(value = "件号关注删除")
    @DeleteMapping(value = "delete/{jh}")
    @SysLog(value = "件号关注删除", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo<String> delete(@PathVariable("jh") String jh) {
        try {
            tJhGzService.delete(jh);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_NOTFOUND_MESSAGE);
        }

    }
    /***
     * @author shs
     * @Date: 2020/5/18 14:55
     * @Description:机号关注添加
     * @return
     */
    @ApiOperation(value = "机号关注查询")
    @GetMapping(value = "list")
    public RestResultVo<List<TJhGzVO>> list(TJhGzQuery tJhGzQuery) {
        try {
            List<TJhGzVO> list = tJhGzService.list(tJhGzQuery);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE, list);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
        }
    }
    /***
     * @author shs
     * @Date: 2020/7/1 14:55
     * @Description:私人件号关注查询
     * @return
     */
    @ApiOperation(value = "私人件号关注查询")
    @GetMapping(value = "srlist")
    public RestResultVo<List<TSrJhGzVO>> srlist() {
        try {
            List<TSrJhGzVO> list = tJhGzService.srlist();
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE, list);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
        }
    }
}
