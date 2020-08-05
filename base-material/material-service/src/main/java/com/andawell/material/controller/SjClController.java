package com.andawell.material.controller;


import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.util.FileUtils;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TSjCs;
import com.andawell.material.service.ISjClService;
import com.andawell.material.vo.TDataVO;
import com.andawell.material.vo.TSjCsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/***
 * @author shs
 * @Date: 2020/5/29 15:39
 * @Description:数据导入导出  （发付数据导入，发付数据导出）
 * @version : V1.0
 */
@Api(value = "发付选择性导出", tags = "发付选择性导出")
@RestController
@RequestMapping(value = "sys/sjcl")
public class SjClController {
    public static ApplicationContext applicationContext;
    @Autowired
    private ISjClService sjClService;
    @Value("${upload.path}")
    private String filepath;

    /***
     * @author shs
     * @Date: 2020/5/21 15:52
     * @Description:发付选择性导出
     */
    @ApiOperation(value = "发付选择性导出")
    @PostMapping(value = "insert")
    @SysLog(value = "发付选择性导出", operationType = LogTypeConstant.LOG_EXPORT_TYPE)
    public void insert(HttpServletResponse response, @RequestBody List<String> list) throws Exception {
            sjClService.insert(response, list);
    }

    /***
     * @author shs
     * @Date: 2020/6/9 16:52
     * @Description:参数数据导出
     */
    @ApiOperation(value = "参数数据导出")
    @PostMapping(value = "derivation")
    @SysLog(value = "参数数据导出", operationType = LogTypeConstant.LOG_EXPORT_TYPE)
    public void derivation(HttpServletResponse response, @RequestBody List<String> list) {
            sjClService.derivation(response, list);
    }


    /***
     * @author shs
     * @Date: 2020/6/2 8:52
     * @Description:数据导入
     */
    @ApiOperation(value = "数据导入")
    @PostMapping(value = "insertOracle")
    @SysLog(value = "数据导入", operationType = LogTypeConstant.LOG_IMPORT_TYPE)
    public RestResultVo<String> insertOracle(@RequestBody List<String> list) {
        try {
            String newFile = FileUtils.getNewFile(filepath);
            String replace = newFile.replace("\\", "/");
            sjClService.insertOracle(list, replace);
            return new RestResultVo<String>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_IMPORT_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }

    /***
     * @author shs
     * @Date: 2020/6/8 10:52
     * @Description:数据动态展示
     */
    @ApiOperation(value = "数据动态展示")
    @PostMapping(value = "DataState")
    public RestResultVo<TDataVO> dataStatelist(MultipartFile multipartFile) {
        try {
            String upload = FileUtils.upload(multipartFile, filepath);
            TDataVO dataVO = sjClService.dataStatelist(upload);
            return new RestResultVo<TDataVO>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE, dataVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
        }
    }

    /***
     * @author shs
     * @Date: 2020/6/10 16:52
     * @Description:参数数据导出
     */
    @ApiOperation(value = "参数数据导入")
    @PostMapping(value = "uploading")
    @SysLog(value = "参数数据导入", operationType = LogTypeConstant.LOG_IMPORT_TYPE)
    public RestResultVo<String> uploading(@RequestBody List<String> list) {
        try {
            String newFile = FileUtils.getNewFile(filepath);
            String replace = newFile.replace("\\", "/");
            sjClService.uploading(list, replace);
            return new RestResultVo<String>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_UPLOAD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_UPLOAD_ERROR_MESSAGE);
        }
    }

    /***
     * @author shs
     * @Date: 2020/6/10 16:52
     * @Description:文件传输
     */
    @ApiOperation(value = "文件传输")
    @PostMapping(value = "file")
    @SysLog(value = "文件传输", operationType = LogTypeConstant.LOG_IMPORT_TYPE)
    public RestResultVo<List<TSjCs>> file(MultipartFile multipartFile) {
        try {
            String upload = FileUtils.upload(multipartFile, filepath);
            List<TSjCs> tSjCs = sjClService.filelist(upload);
            return new RestResultVo<List<TSjCs>>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_UPLOAD_SUCCESS_MESSAGE, tSjCs);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_UPLOAD_ERROR_MESSAGE);
        }
    }


    /***
     * @author shs
     * @Date: 2020/6/9 15:52
     * @Description:参数数动态查询
     */
    @ApiOperation(value = "参数数动态查询")
    @GetMapping(value = "cslist")
    public RestResultVo<List<TSjCsVO>> cslist() {
        try {
            List<TSjCsVO> sjCsVO = sjClService.cslist();
            return new RestResultVo<List<TSjCsVO>>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE, sjCsVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
        }
    }


}
