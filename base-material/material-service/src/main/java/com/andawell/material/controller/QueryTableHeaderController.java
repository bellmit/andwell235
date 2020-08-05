package com.andawell.material.controller;

import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.dto.TCkSxXLNLDTO;
import com.andawell.material.entity.TXtDw;
import com.andawell.material.service.ICompanyService;
import com.andawell.material.service.ITCkSxService;
import com.andawell.search.constant.NoticeConstant;
import com.andawell.search.dto.SearchParamQuery;
import com.andawell.search.entity.XmlSearchAccount;
import com.andawell.search.entity.XmlTable;
import com.andawell.search.entity.XmlTableHeader;
import com.andawell.search.entity.XmlTableList;
import com.andawell.search.query.XmlSearchAccountQuery;
import com.andawell.search.service.XmlSearchAccountService;
import com.andawell.search.util.XmlUtil;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/***
 * @author lhb
 * @Date: 2020/7/6 16:32
 * @Description:
 * @version : V1.0
 */
@Api(value = "动态表头查询", tags = " 动态表头查询API")
@RestController
@RequestMapping(value = "/query/dynamicMeter")
public class QueryTableHeaderController {

    @Autowired
    XmlSearchAccountService xmlSearchAccountService;

    @Autowired
    ICompanyService companyService;

    @Autowired
    ITCkSxService tCkSxService;

    @GetMapping(value = "header/list")
    public RestResultVo headerList(SearchParamQuery dto) {
        try {

            if (StringUtils.isEmpty(dto.getTableName())) {
                return new RestResultVo(RestStatus.ERROR, com.andawell.search.constant.NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
            }
            if (StringUtils.isEmpty(dto.getXmlName())) {
                return new RestResultVo(RestStatus.ERROR, com.andawell.search.constant.NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
            }
            XmlTable xmlTable = getXmlTable(dto);
            // 增加动态的表

            dynamicMeterTableHeader(xmlTable);

            if (xmlTable != null) {
                return new RestResultVo(RestStatus.SUCCESS, com.andawell.search.constant.NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE, xmlTable.getXmlTableConfig().getTableColumns());
            } else {
                return new RestResultVo(RestStatus.ERROR, com.andawell.search.constant.NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR, NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
        }
    }

    // 动态增加 战区
    private void dynamicMeterTableHeader(XmlTable xmlTable){


        String[] strings = {"A","B","C","D","E","F","G","H","I","G","Q"};


        // 获取机关下的 所哟战区
        List<TXtDw> list = companyService.getChildren();

        for (int i = 0; i < list.size(); i++) {
            XmlTableHeader xmlTableHeader = new XmlTableHeader();
            // 唯一标识 dwId + 数字
            xmlTableHeader.setProp("dwId"+list.get(i).getId());
            xmlTableHeader.setAlign("center");
            xmlTableHeader.setLabel("所属战区"+strings[i]);
            xmlTableHeader.setWidth("120");
            xmlTableHeader.setMinWidth("30");
            xmlTableHeader.setFilters(false);
            xmlTableHeader.setFixed(false);
            xmlTableHeader.setSortable(false);
            xmlTableHeader.setIsEdit(false);
            xmlTableHeader.setEditType("input");
            xmlTableHeader.setShow(true);
            xmlTableHeader.setParent("false");
            xmlTable.getXmlTableConfig().getTableColumns().getColumns().add(xmlTableHeader);
            XmlTableHeader xmlTableHeader1 = new XmlTableHeader();
            // 唯一标识 dwId + 数字
            xmlTableHeader1.setProp("dwId"+list.get(i).getId()+"sl");
            xmlTableHeader1.setAlign("center");
            xmlTableHeader1.setLabel("数量");
            xmlTableHeader1.setWidth("120");
            xmlTableHeader1.setMinWidth("30");
            xmlTableHeader1.setFilters(false);
            xmlTableHeader1.setFixed(false);
            xmlTableHeader1.setSortable(false);
            xmlTableHeader1.setIsEdit(false);
            xmlTableHeader1.setEditType("input");
            xmlTableHeader1.setShow(true);
            xmlTableHeader1.setParent("false");
            xmlTable.getXmlTableConfig().getTableColumns().getColumns().add(xmlTableHeader1);

        }

    }

    private XmlTable getXmlTable(SearchParamQuery query) {
        XmlTable xmlTable = null;
        List<XmlSearchAccount> xmlSearchAccounts = xmlSearchAccountService.list
                (new XmlSearchAccountQuery().setTableName(query.getXmlName()));
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

    /**
     * 承修商表头
     * @param dto
     * @return
     */
    @GetMapping(value = "CXSheader/list")
    public RestResultVo headerListCXS(SearchParamQuery dto) {
        try {

            if (StringUtils.isEmpty(dto.getTableName())) {
                return new RestResultVo(RestStatus.ERROR, com.andawell.search.constant.NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
            }
            if (StringUtils.isEmpty(dto.getXmlName())) {
                return new RestResultVo(RestStatus.ERROR, com.andawell.search.constant.NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
            }
            XmlTable xmlTable = getXmlTable(dto);
            // 增加动态的表

            dynamicCXSTableHeader(xmlTable);

            if (xmlTable != null) {
                return new RestResultVo(RestStatus.SUCCESS, com.andawell.search.constant.NoticeConstant.RESPONSE_FIND_SUCCESS_MESSAGE, xmlTable.getXmlTableConfig().getTableColumns());
            } else {
                return new RestResultVo(RestStatus.ERROR, com.andawell.search.constant.NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new RestResultVo(RestStatus.ERROR, NoticeConstant.RESPONSE_FIND_ERROR_MESSAGE);
        }
    }

    // 动态增加 承修商
    private void dynamicCXSTableHeader(XmlTable xmlTable){


        String[] strings = {"A","B","C","D","E","F","G","H","I","G","Q"};


        // 获取机关下的 所哟战区
//        List<TXtDw> list = companyService.getChildren();
        List<TCkSxXLNLDTO> list = tCkSxService.getList();

        for (int i = 0; i < list.size(); i++) {
            XmlTableHeader xmlTableHeader = new XmlTableHeader();
            // 唯一标识 dwId + 数字
            xmlTableHeader.setProp("dwId"+list.get(i).getDwid());
            xmlTableHeader.setAlign("center");
            xmlTableHeader.setLabel("承修商"+strings[i]);
            xmlTableHeader.setWidth("120");
            xmlTableHeader.setMinWidth("30");
            xmlTableHeader.setFilters(false);
            xmlTableHeader.setFixed(false);
            xmlTableHeader.setSortable(false);
            xmlTableHeader.setIsEdit(false);
            xmlTableHeader.setEditType("input");
            xmlTableHeader.setShow(true);
            xmlTableHeader.setParent("false");
            xmlTable.getXmlTableConfig().getTableColumns().getColumns().add(xmlTableHeader);

            XmlTableHeader xmlTableHeader1 = new XmlTableHeader();
            // 唯一标识 dwId + 数字
            xmlTableHeader1.setProp("dwId"+list.get(i).getDwid()+"avgTime");
            xmlTableHeader1.setAlign("center");
            xmlTableHeader1.setLabel("平均修理时长");
            xmlTableHeader1.setWidth("120");
            xmlTableHeader1.setMinWidth("30");
            xmlTableHeader1.setFilters(false);
            xmlTableHeader1.setFixed(true);
            xmlTableHeader1.setSortable(false);
            xmlTableHeader1.setIsEdit(false);
            xmlTableHeader1.setEditType("input");
            xmlTableHeader1.setShow(true);
            xmlTableHeader1.setParent("false");
            xmlTable.getXmlTableConfig().getTableColumns().getColumns().add(xmlTableHeader1);

            XmlTableHeader xmlTableHeader2 = new XmlTableHeader();
            // 唯一标识 dwId + 数字
            xmlTableHeader2.setProp("dwId"+list.get(i).getDwid()+"maxTime");
            xmlTableHeader2.setAlign("center");
            xmlTableHeader2.setLabel("最长修理时长");
            xmlTableHeader2.setWidth("120");
            xmlTableHeader2.setMinWidth("30");
            xmlTableHeader2.setFilters(false);
            xmlTableHeader2.setFixed(true);
            xmlTableHeader2.setSortable(true);
            xmlTableHeader2.setIsEdit(false);
            xmlTableHeader2.setEditType("input");
            xmlTableHeader2.setShow(true);
            xmlTableHeader2.setParent("false");
            xmlTable.getXmlTableConfig().getTableColumns().getColumns().add(xmlTableHeader2);

        }

    }
}
