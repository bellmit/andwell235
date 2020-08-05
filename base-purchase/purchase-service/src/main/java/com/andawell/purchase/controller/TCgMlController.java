package com.andawell.purchase.controller;


import com.alibaba.excel.EasyExcel;
import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.util.BusinessException;
import com.andawell.common.util.FileUtils;
import com.andawell.common.util.ValidableList;
import com.andawell.purchase.constant.NoticeConstant;
import com.andawell.purchase.dto.TCgMlDTO;
import com.andawell.purchase.dto.TCgMlQdDTO;
import com.andawell.purchase.dto.groups.Insert;
import com.andawell.purchase.entity.TCgMlQdDrmx;
import com.andawell.purchase.entity.TCsJglx;
import com.andawell.purchase.entity.TXtQclx;
import com.andawell.purchase.enumeration.CategoryEnum;
import com.andawell.purchase.listener.TCgMlQdDrmxExcelListener;
import com.andawell.purchase.query.TCgMlQdQuery;
import com.andawell.purchase.query.TCsJglxQuery;
import com.andawell.purchase.query.TXtQcLxQuery;
import com.andawell.purchase.service.*;
import com.andawell.purchase.vo.TCgMlQdVO;
import com.andawell.search.task.InitXml;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * 采购管理 采购目录管理
 */
@Api(value = "采购目录管理", tags = "采购目录管理")
@RestController
@RequestMapping(value = "sys/tcgml")
public class TCgMlController {

    @Autowired
    ITXtQclxService iTXtQclxService;

    @Autowired
    ITCgMlQdService tCgMlQdService;

    @Autowired
    ITCgMlService tCgMlService;

    @Autowired
    ITCsJglxService itCsJglxService;

    @Autowired
    ITCgMlQdDrmxService iTCgMlQdDrmxService;

    @Autowired
    InitXml initXml;


    @GetMapping
    @ApiOperation(value = "xml注入")
    public void updateOrInsert(String xmlName){
        initXml.updateOrInsert(xmlName);
    }

    @GetMapping("/allWriteXml")
    @ApiOperation(value = "allWriteXml 数据库输出文件")
    public void allWriteXml(){
        initXml.selectAllWriteXml();
    }

    @ApiOperation(value = "导入采购目录明细",notes = "导入采购目录明细")
    @PostMapping(value = "/uploadCgmlmx")
    @SysLog(value = "导入采购目录明细",operationType = LogTypeConstant.LOG_IMPORT_TYPE)
    public RestResultVo<Boolean> uploadCgmlmx(MultipartFile file, String mlbh) throws IOException {
        try {
            EasyExcel.read(
                    file.getInputStream(),
                    TCgMlQdDrmx.class,
                    new TCgMlQdDrmxExcelListener(iTCgMlQdDrmxService,mlbh))
                    .sheet().doRead();
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_IMPORT_SUCCESS_MESSAGE);
        }catch (Exception e){
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_IMPORT_ERROR_MESSAGE,e.getMessage());
        }
    }


    @ApiOperation(value = "下载采购目录明细",notes = "下载采购目录明细")
    @PostMapping(value = "/uploadCgmlmxExcel")
    @SysLog(value = "下载采购目录明细",operationType = LogTypeConstant.LOG_EXPORT_TYPE)
    public void uploadCgmlmxExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        //使用流读取excel模板
      /*  InputStream inputStream = this.getClass().getResourceAsStream("/excel/directoryof.xlsx");*/
        ClassPathResource classPath = new ClassPathResource("excel/directoryof.xlsx");
        InputStream is = classPath.getInputStream();

    /*    BufferedInputStream inputStream =(BufferedInputStream)
                this.getClass().getResourceAsStream("/excel/directoryof.xlsx");*/
        String fileName = "采购目录清单明细";
        FileUtils.download(response,is,fileName);

    }




    /**
     *@Auther:gzh
     *@Date:2020/6/23 10:06
     *@Description: 导入采购目录明细全部删除
     */
    @ApiOperation(value = "导入采购目录明细全部删除")
    @DeleteMapping(value = "TCgMlQd/deleteCgmlmxAll")
    @SysLog(value = "导入采购目录明细全部删除",operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo deleteCgmlmxAll() {
        try {
            iTCgMlQdDrmxService.deleteCgmlmxAll();
            return new RestResultVo(RestStatus.SUCCESS, NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        }catch (Exception e){
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }



    /**
     * @Auther:gzh
     * @Date:2020/5/29 15:18
     * @Description: 器材类型下拉
     */
    @ApiOperation(value = "器材类型下拉接口", notes = "器材类型下拉接口", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "get/qclx")
    public RestResultVo<List<TXtQclx>> qclxList(TXtQcLxQuery query) {
        return new RestResultVo<List<TXtQclx>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE,
                iTXtQclxService.qclxList(query));
    }


    /**
     * @Auther:gzh
     * @Date:2020/5/29 15:18
     * @Description: 生效状态是否拥有编辑功能
     */
    @ApiOperation(value = "生效状态是否拥有编辑功能", notes = "生效状态是否拥有编辑功能", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "get/isEdit")
    public RestResultVo<Boolean> isEdit() {

        return new RestResultVo<Boolean>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE, tCgMlService.isEdit());
    }


    /**
     * @Auther:gzh
     * @Date:2020/5/29 15:18
     * @Description: 价格类型下拉
     */
    @ApiOperation(value = "价格类型下拉接口", notes = "价格类型下拉接口", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "get/jglx")
    public RestResultVo<List<TCsJglx>> jglxList(TCsJglxQuery query) {
        return new RestResultVo<List<TCsJglx>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE,
                itCsJglxService.jglxList(query));
    }




    @ApiOperation(value = "采购目录删除接口", notes = "采购目录删除接口", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PutMapping(value = "update/deleteTCMl")
    @SysLog(value = "采购目录删除接口", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo deleteTCMl(@RequestBody Long id) {
        try {
            //id判空
            if (id == null) {
                return new RestResultVo(RestStatus.ERROR,
                        NoticeConstant.RESPONSE_ID_NULL_MESSAGE);
            }
            //数据库删除数据
            tCgMlService.deleteTCMl(id);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE,e.getMessage());
        }

    }



    @ApiOperation(value = "发布接口", notes = "发布接口", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PutMapping(value = "update/fb")
    @SysLog(value = "发布接口", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo issue(@RequestBody Integer id) {
        try {
            //id判空
            if (id == null) {
                return new RestResultVo(RestStatus.ERROR,
                        NoticeConstant.RESPONSE_ID_NULL_MESSAGE);
            }
            //数据库查询id是否存在
            if (tCgMlService.selectId(id) == 0) {
                return new RestResultVo(RestStatus.ERROR,
                        NoticeConstant.RESPONSE_ID_INEXISTENCE_MESSAGE);
            }
            //判断发布的数据是否为修订中要发布
            if (tCgMlService.selectStatusById(id) != CategoryEnum.UNDER_REVISION.getCode()) {
                return new RestResultVo(RestStatus.ERROR,
                        NoticeConstant.RESPONSE_STATUS_XDZ_MESSAGE);
            }
            tCgMlService.issue(id);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_PUBLISH_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_PUBLISH_ERROR_MESSAGE);
        }

    }

    @ApiOperation(value = "批量插入目录清单")
    @PostMapping(value = "TCgMlQd/insert")
    @SysLog(value = "批量插入目录清单", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<String> insertAll(@RequestBody @Valid ValidableList<TCgMlQdDTO> list) throws Exception {
        RestResultVo<String> responseResult;
        try {
            tCgMlQdService.insertAll(list);
            responseResult = new RestResultVo<String>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        }catch (Exception e){
            responseResult = new RestResultVo<String>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE,e.getMessage());
        }
        return responseResult;
    }

    @ApiOperation(value = "更新目录清单")
    @PostMapping(value = "TCgMlQd/updateTCgMlQd")
    @SysLog(value = "更新目录清单", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<String> updateTCgMlQd(@RequestBody @Valid TCgMlQdDTO tCgMlQdDTO) throws Exception {
        RestResultVo<String> responseResult;
        try {
            tCgMlQdService.updateTCgMlQd(tCgMlQdDTO);
            responseResult = new RestResultVo<String>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        }catch (Exception e){
            responseResult = new RestResultVo<String>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE,e.getMessage());
        }
        return responseResult;
    }

    @ApiOperation(value = "删除入目录清单")
    @DeleteMapping(value = "TCgMlQd/deleteTCgMlQd/{id}")
    @SysLog(value = "删除入目录清单", operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo<String> deleteTCgMlQd(@ApiParam(value = "目录清单Id", name = "id") @PathVariable("id") Long id) {
        RestResultVo<String> responseResult;
        try {
            tCgMlQdService.deleteTCgMlQd(id);
            responseResult = new RestResultVo<String>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        }catch (Exception e){
            responseResult = new RestResultVo<String>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE,e.getMessage());
        }
        return responseResult;
    }

    @ApiOperation(value = "编辑目录")
    @PostMapping("cgml/edit")
    @SysLog(value = "编辑目录", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo<Map> edit(@RequestBody @Valid TCgMlDTO tCgMlDTO) {
        try {
            Map map=tCgMlService.edit(tCgMlDTO);
            return new RestResultVo<Map>(RestStatus.SUCCESS,NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE,map);
        } catch (Exception e) {
            e.printStackTrace();
            if ( e instanceof BusinessException) {
                return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE+","+e.getMessage());
            }
            return new RestResultVo<>(RestStatus.ERROR,NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }
    }

    @ApiOperation(value = "查看目录清单明细")
    @GetMapping("cgmlqd/listPage")
    public RestResultVo<ListPageVo<TCgMlQdQuery, TCgMlQdVO>> listPage(TCgMlQdQuery query) {

        return new RestResultVo<ListPageVo<TCgMlQdQuery,TCgMlQdVO>>(RestStatus.SUCCESS
                ,NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE
                ,tCgMlQdService.listPage(query));
    }

    @ApiOperation(value = "新增目录")
    @PostMapping("save/cgml")
    @SysLog(value = "新增目录", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<Boolean> saveCgml(@RequestBody @Validated({Insert.class}) TCgMlDTO tCgMlDTO) {
        try {
            tCgMlService.saveCgml(tCgMlDTO);
            return new RestResultVo<Boolean>(RestStatus.SUCCESS,NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE,true);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo<Boolean>(RestStatus.ERROR, e.getMessage(),false);
        }
    }
}
