package com.andawell.purchase.controller;
import com.alibaba.excel.EasyExcel;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.annotation.SysLog;
import com.andawell.common.entity.constant.LogTypeConstant;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.util.BusinessException;
import com.andawell.common.util.FileUtils;
import com.andawell.common.util.ValidableList;
import com.andawell.purchase.constant.NoticeConstant;
import com.andawell.purchase.dto.LtXqDTO;
import com.andawell.purchase.dto.TCgMlQdDTO;
import com.andawell.purchase.dto.TDhJhqdDTO;
import com.andawell.purchase.dto.excel.LtXqExcelDTO;
import com.andawell.purchase.dto.excel.TDhJhqdExcelDTO;
import com.andawell.purchase.listener.DhJhQdExcelListener;
import com.andawell.purchase.listener.LtXqExcelListener;
import com.andawell.purchase.query.TDhJhQuery;
import com.andawell.purchase.query.TDhLtxqQuery;
import com.andawell.purchase.query.TDhLtxqTempQuery;
import com.andawell.purchase.service.ITDhJhQdService;
import com.andawell.purchase.vo.TDhJhVO;
import com.andawell.purchase.vo.TDhJhqdVO;
import com.andawell.purchase.vo.TDhLtxqTempVO;
import com.andawell.purchase.vo.TDhLtxqVO;
import com.andawell.purchase.dto.TDhJhDTO;
import com.andawell.purchase.service.ITDhJhService;
import com.andawell.purchase.query.TDhJhqdQuery;
import com.andawell.purchase.vo.excel.TDhJhqdExcelVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;


/***
 * @author lhb
 * @Date: 2020/6/2 13:40
 * @Description:
 * @version : V1.0
 */
@Api(value = "订货计划管理", tags = "订货计划管理")
@RestController
@RequestMapping(value = "sys/dhjh")
@Slf4j
public class TDhJhController {

    @Autowired
    ITDhJhService iTDhJhService;

    @Autowired
    private ITDhJhQdService tDhJhqdService;


    @ApiOperation(value = "订货计划清单明细",notes = "订货计划清单明细")
    @GetMapping("dhjhqd/listPage")
    public RestResultVo<ListPageVo<TDhJhqdQuery, TDhJhqdVO>> listPage(TDhJhqdQuery query) {
        return new RestResultVo<ListPageVo<TDhJhqdQuery, TDhJhqdVO>>(RestStatus.SUCCESS,
                NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,
                tDhJhqdService.listPage(query));
    }


    @ApiOperation(value = "下载导入旅团需求模板",notes = "下载导入旅团需求模板")
    @PostMapping(value = "/uploadltxqExcel")
    @SysLog(value = "下载导入旅团需求模板",operationType = LogTypeConstant.LOG_EXPORT_TYPE)
    public void uploadltxqExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        //使用流读取excel模板
        /*  InputStream inputStream = this.getClass().getResourceAsStream("/excel/directoryof.xlsx");*/
        ClassPathResource classPath = new ClassPathResource("excel/passengerneed.xlsx");
        InputStream is = classPath.getInputStream();

    /*    BufferedInputStream inputStream =(BufferedInputStream)
                this.getClass().getResourceAsStream("/excel/directoryof.xlsx");*/
        String fileName = "导入旅团需求模板";
        FileUtils.download(response,is,fileName);

    }

    @ApiOperation(value = "订货计划发布",notes = "订货计划发布")
    @GetMapping("dhjhqd/orderPlanRelease")
    public RestResultVo orderPlanRelease (@ApiParam(value = "订货计划编号", name = "bh",required = true) @PathVariable("bh") String bh) {
        try {

            //tDhJhqdService.saveList(list);
            iTDhJhService.updateStatus(bh);
            return new RestResultVo<>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_PUBLISH_SUCCESS_MESSAGE);
        }catch (Exception e){
            e.printStackTrace();
            return new RestResultVo<>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_PUBLISH_ERROR_MESSAGE,e.getMessage());
        }
    }

    @ApiOperation(value = "订货计划发布",notes = "订货计划发布")
    @PostMapping("dhjhqd/saveDhJhQdList")
    @SysLog(value = "订货计划发布",operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo saveDhJhQdList (@RequestBody @Valid ValidableList<TDhJhqdDTO> list) {
        try {
            tDhJhqdService.saveList(list);
            return new RestResultVo<>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_PUBLISH_SUCCESS_MESSAGE);
        }catch (Exception e){
            e.printStackTrace();
            return new RestResultVo<>(RestStatus.ERROR, e.getMessage());
        }
    }



    @ApiOperation(value = "查询是否存在草稿订货计划",notes = "查询是否存在草稿订货计划")
    @GetMapping("dhjhqd/getIsInvalid")
    public RestResultVo getIsInvalid () {
        try {
            return new RestResultVo<>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE,iTDhJhService.getInvalid());
        }catch (Exception e){
            e.printStackTrace();
            return new RestResultVo<>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE,e.getMessage());
        }
    }


    @ApiOperation(value = "订货计划清单删除")
    @RequestMapping(value = "dhjhqd/delete/{bh}",method = RequestMethod.DELETE)
    @SysLog(value = "订货计划清单删除",operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo<String> delete(@ApiParam(value = "订货计划编号", name = "bh") @PathVariable("bh") String bh) {

        try {
            if (StringUtils.isEmpty(bh)) {
                throw new BusinessException(NoticeConstant.RESPONSE_CONTEXT_ERROR_MESSAGE);
            }
            tDhJhqdService.delete(bh);
            return new RestResultVo<>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            if ( e instanceof BusinessException) {
                return new RestResultVo<>(RestStatus.ERROR, NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE+","+e.getMessage());
            }
            return new RestResultVo<>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
    }


    @ApiOperation(value = "导入旅团需求",notes = "导入旅团需求")
    @PostMapping(value = "/uploadLtXq")
    @SysLog(value = "导入旅团需求",operationType = LogTypeConstant.LOG_IMPORT_TYPE)
    public RestResultVo<Boolean> uploadLtXq(MultipartFile file,String bh) throws IOException {
        try {
            EasyExcel.read(
                    file.getInputStream(),
                    LtXqExcelDTO.class,
                    new LtXqExcelListener(tDhJhqdService,bh))
                    .sheet("Sheet3").headRowNumber(2).doRead();
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_IMPORT_SUCCESS_MESSAGE);
        }catch (Exception e){
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_IMPORT_ERROR_MESSAGE);
        }
    }

    @ApiOperation(value = "旅团需求Excel列表",notes = "旅团需求Excel")
    @GetMapping(value = "get/LtXqExcelList")
    public RestResultVo<List<TDhLtxqTempVO>> getLtXqExcelList(TDhLtxqTempQuery tDhLtxqQuery){
        return new RestResultVo<List<TDhLtxqTempVO>>(RestStatus.SUCCESS
                , NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE
                ,tDhJhqdService.getLtXqExcelList(tDhLtxqQuery));
    }


    @ApiOperation(value = "删除导入的旅团需求Excel",notes = "删除导入的旅团需求Excel")
    @DeleteMapping(value = "delete/LtXqExcelByBh/{bh}")
    @SysLog(value = "删除导入的旅团需求Excel",operationType = LogTypeConstant.LOG_DELETE_TYPE)
    public RestResultVo<Boolean> LtXqExcelByBh(@ApiParam(value = "订货计划编号", name = "bh",required = true) @PathVariable("bh") String bh){
        try {
            tDhJhqdService.deleteLtXQExcelList(bh);
            return new RestResultVo<Boolean>(RestStatus.SUCCESS
                    , NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE
                    ,true);
        }catch (Exception e){
            e.printStackTrace();
            return new RestResultVo<Boolean>(RestStatus.ERROR
                    , NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE
                    ,false);
        }
    }

    @ApiOperation(value = "保存需求Excel列表",notes = "保存需求Excel列表")
    @PostMapping(value = "save/LtXqExcelList")
    @SysLog(value = "保存需求Excel列表",operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo<Boolean> saveLtXqList(@RequestBody @Valid ValidableList<LtXqDTO> list){
        try {
            tDhJhqdService.saveLtXQList(list);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        }catch (Exception e){
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
    }



    @ApiOperation(value = "导出订货计划",notes = "导出订货计划")
    @GetMapping(value = "/downloadDhJh")
    @SysLog(value = "导出订货计划",operationType = LogTypeConstant.LOG_EXPORT_TYPE)
    public void downLoadDhJh(HttpServletResponse response,String bh) throws IOException {

        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = "订货计划";
        response.setHeader("Content-disposition","attachment;filename="+new String(fileName.getBytes(),"iso-8859-1")+".xlsx");
        EasyExcel.write(response.getOutputStream(), TDhJhqdVO.class).sheet("订货计划")
                .doWrite(data(bh));
    }

    @ApiOperation(value = "导入订货计划",notes = "导入订货计划")
    @PostMapping(value = "/uploadDhJh")
    @SysLog(value = "导入订货计划",operationType = LogTypeConstant.LOG_IMPORT_TYPE)
    public RestResultVo uploadDhJh(MultipartFile file,String bh) throws IOException {
        try {
            EasyExcel.read(
                    file.getInputStream(),
                    TDhJhqdVO.class,
                    new DhJhQdExcelListener(tDhJhqdService,bh))
                    .sheet().doRead();
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_IMPORT_SUCCESS_MESSAGE);
        }catch (Exception e){
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_IMPORT_ERROR_MESSAGE,e.getMessage());
        }
    }


    private List<TDhJhqdVO> data(String bh){
        TDhJhqdQuery tDhJhqdQuery = new TDhJhqdQuery();
        tDhJhqdQuery.setPageSize(0);
        tDhJhqdQuery.setBh(bh);
        tDhJhqdQuery.setStatus("1");
        return tDhJhqdService.listPage(tDhJhqdQuery).getList();
    }

    @ApiOperation(value = "订货计划新增", notes = "订货计划新增", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(value = "post/insert")
    @SysLog(value = "订货计划新增", operationType = LogTypeConstant.LOG_INSERT_TYPE)
    public RestResultVo insert( @RequestBody @Valid TDhJhDTO tDhJhDTO) {
        try {
            iTDhJhService.insert(tDhJhDTO);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE,e.getMessage());
        }

    }

    @ApiOperation(value = "订货计划修改删除", notes = "订货计划修改删除", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PutMapping(value = "put/update")
    @SysLog(value = "订货计划修改删除", operationType = LogTypeConstant.LOG_UPDATE_TYPE)
    public RestResultVo update(@RequestBody @Valid TDhJhDTO tDhJhDTO) {
        try {
            //判断编号不能为空
            if(tDhJhDTO.getBh().isEmpty()){
                return new RestResultVo(RestStatus.ERROR,
                        NoticeConstant.RESPONSE_BH_NULL_MESSAGE);
            }
            //编辑修改
            iTDhJhService.update(tDhJhDTO);
            return new RestResultVo(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }

    }

    @ApiOperation(value = "订货计划清单查看",notes = "订货计划清单查看")
    @GetMapping(value = "get/ltXqList")
    public RestResultVo<List<TDhLtxqVO>> getLtXqList(TDhLtxqQuery tDhLtxqQuery){
        return new RestResultVo<List<TDhLtxqVO>>(RestStatus.SUCCESS
                , NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE
                ,tDhJhqdService.getLtXqList(tDhLtxqQuery));
    }

    @ApiOperation(value = "订货计划编号下拉列表")
    @GetMapping(value = "dhjh/listJhbh")
    public RestResultVo<List<TDhJhVO>> listJhbh(TDhJhQuery query) {

        return new RestResultVo<List<TDhJhVO>>(RestStatus.SUCCESS,NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE
                ,iTDhJhService.listJhbh(query));
    }
}
