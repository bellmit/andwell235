package com.andawell.material.controller;

import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.util.FileUtils;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.TCkCrksDTO;
import com.andawell.material.service.ITCkCrkService;
import com.andawell.material.vo.TSqliteFfVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/***
 * @author shs
 * @Date: 2020/5/21 15:39
 * @Description:发付数据处理  （发付数据导入，发付数据导出）
 * @version : V1.0
 */
@Api(value = "出入库信息", tags = "出入库信息")
@RestController
@RequestMapping(value = "sys/tckcrk")
public class TCkCrkController {
    @Autowired
    private ITCkCrkService tckCrkService;
    @Value("${upload.path}")
    private String filepath;

    /***
     * @author shs
     * @Date: 2020/5/21 15:52
     * @Description:发付数据导出
     */
    @ResponseBody
    @ApiOperation(value = "发付数据导出")
    @PostMapping(value = "insert")
    @SysLog(value = "发付数据导出", operationType = LogTypeConstant.LOG_EXPORT_TYPE)
    public void insert(HttpServletResponse response, @RequestBody List<TCkCrksDTO> tCkCrks) throws Exception {
            tckCrkService.insert(response, tCkCrks);
    }

    /***
     * @author shs
     * @Date: 2020/5/26 15:52
     * @Description:发付数据导入
     */
    @ApiOperation(value = "发付数据导入")
    @PostMapping(value = "insertOracle")
    @SysLog(value = "发付数据导入", operationType = LogTypeConstant.LOG_IMPORT_TYPE)
    public RestResultVo<String> insertOracle(@RequestBody List<TCkCrksDTO> tCkCrks) throws Exception {
        try {
            if (tckCrkService.insertOracle(tCkCrks) == 1) {
                return new RestResultVo<String>(RestStatus.ERROR,
                        NoticeConstant.RESPONSE_INSERT_REPEAT_MESSAGE);
            }
            return new RestResultVo<String>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_IMPORT_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_IMPORT_ERROR_MESSAGE);
        }
    }

    /***
     * @author shs
     * @Date: 2020/5/26 16:52
     * @Description:发付数据查询
     *
     * @return
     */
    @ApiOperation(value = "发付数据导入查询")
    @PostMapping(value = "CrCrklist")
    public RestResultVo<List<TSqliteFfVO>> CrCrklist(MultipartFile multipartFile) throws Exception {
        try {
            String upload = FileUtils.upload(multipartFile, filepath);
            List<TSqliteFfVO> tSqliteFfVOS = tckCrkService.CrCrklist(upload);
            return new RestResultVo<List<TSqliteFfVO>>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE, tSqliteFfVOS);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
        }
    }

    /***
     * @author shs
     * @Date: 2020/6/5 15:52
     * @Description:数据删除
     */
    @ApiOperation(value = "发付数据删除")
    @DeleteMapping(value = "delete")
    @SysLog(value = "发付数据删除", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo<String> delete(@RequestBody TCkCrksDTO tCkCrks) throws Exception {
        try {
            tckCrkService.delete(tCkCrks);
            return new RestResultVo<String>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }
}
