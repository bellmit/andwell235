package com.andawell.search.controller;

import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.search.constant.NoticeConstant;
import com.andawell.search.dto.SearchParamQuery;
import com.andawell.search.entity.XmlSearchAccount;
import com.andawell.search.entity.XmlTable;
import com.andawell.search.entity.XmlTableHeader;
import com.andawell.search.entity.XmlTableList;
import com.andawell.search.query.CommonListSqlQuery;
import com.andawell.search.query.SearchInfoQuery;
import com.andawell.search.query.XmlSearchAccountQuery;
import com.andawell.search.service.SearchInfoService;
import com.andawell.search.service.XmlSearchAccountService;
import com.andawell.search.util.ExcelExportUtils;
import com.andawell.search.util.SearchSqlConvert;
import com.andawell.search.util.XmlUtil;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "info/table")
@Api(value = "表格查询", tags = "表格查询")
public class SearchInfoController {

    @Autowired
    private XmlSearchAccountService xmlSearchAccountService;
    @Autowired
    private SearchInfoService searchInfoService;

    @PostMapping(value = "data/listPage")
    public RestResultVo ListPage(@RequestBody SearchParamQuery dto) {
        if (StringUtils.isEmpty(dto.getTableName())) {
            return new RestResultVo(RestStatus.ERROR, NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
        }
        if (StringUtils.isEmpty(dto.getXmlName())) {
            return new RestResultVo(RestStatus.ERROR, NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
        }
        XmlTable xmlTable = getXmlTable(dto);
        CommonListSqlQuery commonListSqlQuery = new CommonListSqlQuery();
        commonListSqlQuery.setSql(xmlTable.getXmlTableInfo().getSql());
        commonListSqlQuery.setCommonListQuery(dto.getCommonListQuery());
        commonListSqlQuery.setPageIndex(dto.getPageIndex());
        commonListSqlQuery.setPageSize(dto.getPageSize());
        commonListSqlQuery.setSortField(dto.getSortField());
        commonListSqlQuery.setSortOrder(dto.getSortOrder());

        //String sql = ConvertSearchSql.getSql(commonListSqlQuery, xmlTable.getXmlTableConfig().getTableColumns());
        String sql = SearchSqlConvert.getSql(commonListSqlQuery, xmlTable.getXmlTableConfig().getTableColumns());
        SearchInfoQuery searchInfoQuery = new SearchInfoQuery();
        searchInfoQuery.setSql(sql);
        searchInfoQuery.setPageIndex(dto.getPageIndex());
        searchInfoQuery.setPageSize(dto.getPageSize());
        ListPageVo<SearchInfoQuery, Map<String, Object>> listPageData = searchInfoService.listPage(searchInfoQuery);
        List<Map<String, Object>> newData = getMap(xmlTable.getXmlTableConfig().getTableColumns().getColumns(), listPageData.getList());
        listPageData.setList(newData);
        return new RestResultVo(RestStatus.SUCCESS, NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE, listPageData);
    }

    @PostMapping(value = "data/list")
    public RestResultVo List(@RequestBody SearchParamQuery dto) {
        if (StringUtils.isEmpty(dto.getTableName())) {
            return new RestResultVo(RestStatus.ERROR, NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
        }
        if (StringUtils.isEmpty(dto.getXmlName())) {
            return new RestResultVo(RestStatus.ERROR, NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
        }
        XmlTable xmlTable = getXmlTable(dto);
        CommonListSqlQuery commonListSqlQuery = new CommonListSqlQuery();
        commonListSqlQuery.setSql(xmlTable.getXmlTableInfo().getSql());
        commonListSqlQuery.setCommonListQuery(dto.getCommonListQuery());
        commonListSqlQuery.setPageIndex(dto.getPageIndex());
        commonListSqlQuery.setPageSize(dto.getPageSize());
        commonListSqlQuery.setSortField(dto.getSortField());
        commonListSqlQuery.setSortOrder(dto.getSortOrder());
        //String sql = ConvertSearchSql.getSql(commonListSqlQuery, xmlTable.getXmlTableConfig().getTableColumns());
        String sql = SearchSqlConvert.getSql(commonListSqlQuery, xmlTable.getXmlTableConfig().getTableColumns());
        List<Map<String, Object>> list = searchInfoService.list(new SearchInfoQuery().setSql(sql));

        return new RestResultVo(RestStatus.SUCCESS, NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE, getMap(xmlTable.getXmlTableConfig().getTableColumns().getColumns(), list));
    }

    @GetMapping(value = "header/list")
    public RestResultVo headerList(SearchParamQuery dto) {
        try {

            if (StringUtils.isEmpty(dto.getTableName())) {
                return new RestResultVo(RestStatus.ERROR, NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
            }
            if (StringUtils.isEmpty(dto.getXmlName())) {
                return new RestResultVo(RestStatus.ERROR, NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
            }
            XmlTable xmlTable = getXmlTable(dto);
            if (xmlTable != null) {
                return new RestResultVo(RestStatus.SUCCESS, NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE, xmlTable.getXmlTableConfig().getTableColumns());
            } else {
                return new RestResultVo(RestStatus.ERROR, NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR, NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
        }

    }

    @PostMapping("/data/export")
    public RestResultVo tableDataExport(@RequestBody SearchParamQuery query, HttpServletRequest request, HttpServletResponse response) throws Exception {

        XmlTable xmlTable = getXmlTable(query);
        List<XmlTableHeader> xmlTableHeaders = xmlTable.getXmlTableConfig().getTableColumns().getColumns();
        List<String> ss = xmlTableHeaders.stream()
                .filter(xmlTableHeader -> xmlTableHeader.getShow())
                .map(XmlTableHeader::getProp)
                .collect(Collectors.toList());

        List<String> sm = xmlTableHeaders
                .stream()
                .filter(xmlTableHeader -> xmlTableHeader.getShow())
                .map(XmlTableHeader::getLabel)
                .collect(Collectors.toList());
        String[] properties = new String[ss.size()];
        ss.toArray(properties);

        String[] titles = new String[ss.size()];
        sm.toArray(titles);
        String caption = xmlTable.getXmlTableInfo().getCaption();

        CommonListSqlQuery commonListSqlQuery = new CommonListSqlQuery();
        commonListSqlQuery.setSql(xmlTable.getXmlTableInfo().getSql());
        commonListSqlQuery.setCommonListQuery(query.getCommonListQuery());
        commonListSqlQuery.setPageIndex(query.getPageIndex());
        commonListSqlQuery.setPageSize(query.getPageSize());
        commonListSqlQuery.setSortField(query.getSortField());
        commonListSqlQuery.setSortOrder(query.getSortOrder());
        String sql = SearchSqlConvert.getSql(commonListSqlQuery, xmlTable.getXmlTableConfig().getTableColumns());
        List<Map<String, Object>> data = searchInfoService.list(new SearchInfoQuery().setSql(sql));

        ExcelExportUtils excelExport2 = new ExcelExportUtils();
        excelExport2.setData(getMap(xmlTable.getXmlTableConfig().getTableColumns().getColumns(), data));
        excelExport2.setHeardKey(properties);
        excelExport2.setFontSize(20);
        excelExport2.setSheetName(caption);
        excelExport2.setTitle(caption);
        excelExport2.setHeardList(titles);
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/x-download");
            String filedisplay = caption + ".xls";
            //防止文件名含有中文乱码
            filedisplay = new String(filedisplay.getBytes("UTF-8"), "UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + filedisplay);
            OutputStream out = response.getOutputStream();
            excelExport2.exportExport(request, response);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new RestResultVo(RestStatus.SUCCESS, NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE, excelExport2);
    }

    @PostMapping(value = "xml/insert")
    public RestResultVo insert(@RequestBody XmlSearchAccount xmlSearchAccount) {
        xmlSearchAccountService.insert(xmlSearchAccount);
        return new RestResultVo(RestStatus.SUCCESS, NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
    }


    private XmlTable getXmlTable(SearchParamQuery query) {
        XmlTable xmlTable = null;
        List<XmlSearchAccount> xmlSearchAccounts = xmlSearchAccountService.list(new XmlSearchAccountQuery().setTableName(query.getXmlName()));
        if (xmlSearchAccounts == null || xmlSearchAccounts.size() < 0) {
            return null;
        }
        String xml = xmlSearchAccounts.get(0).getContent();
        // System.out.println(xml);
        XmlTableList xmlTableList = XmlUtil.toBean(xml, XmlTableList.class);
        if (xmlTableList != null) {
            List<XmlTable> xmlTables = xmlTableList.getXmlTable();
            Optional<XmlTable> xmlTableOptional = xmlTables.stream().filter(q ->
                    q.getXmlTableInfo().getTableName().equals(query.getTableName())
            ).findFirst();
            if (xmlTableOptional.isPresent()) {
                xmlTable = xmlTableOptional.get();
            }
        }
        return xmlTable;
    }


    private List<Map<String, Object>> getMap(List<XmlTableHeader> xmlTableHeaderList, List<Map<String, Object>> dataList) {
        if (dataList == null || dataList.size() < 0) {
            return null;
        }
        if (xmlTableHeaderList == null || xmlTableHeaderList.size() < 0) {
            return null;
        }
        List<Map<String, Object>> newDataList = new LinkedList<>();
        for (Map<String, Object> data : dataList) {
            Map<String, Object> newData = new HashMap<>();
            for (XmlTableHeader xmlTableHeader : xmlTableHeaderList) {
                String x = xmlTableHeader.getProp().toUpperCase();
                Object obj = data.get(x);
                if (obj == null) {
                    newData.put(xmlTableHeader.getProp(), obj);
                } else if (obj instanceof Date) {
                    String dateFormat = null;
                    if (StringUtils.isEmpty(xmlTableHeader.getDateFormat())) {
                        dateFormat = "yyyy-MM-dd hh:mm:ss";
                    } else {
                        dateFormat = xmlTableHeader.getDateFormat();
                    }
                    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
                    String dateStr = sdf.format((Date) obj);
                    newData.put(xmlTableHeader.getProp(), dateStr);
                } else {
                    newData.put(xmlTableHeader.getProp(), obj);
                }
            }
            newDataList.add(newData);
        }
        return newDataList;
    }

}
