package com.andawell.upms.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 系统公告
 * @author  zoucx
 */
@Data
@ApiModel("系统公告")
public class SysNoticeInfo {

    @ApiModelProperty(value = "ID", name = "id", dataType = "String")
    private String id;
    @ApiModelProperty(value = "摘要编号", name = "noticeCode", dataType = "String")
    private String noticeCode;
    @ApiModelProperty(value = "摘要", name = "shortTitle", dataType = "String")
    private String shortTitle;
    @ApiModelProperty(value = "公告标题", name = "noticeTitle", dataType = "String")
    private String noticeTitle;
    @ApiModelProperty(value = "公告内容", name = "noticeContent", dataType = "String")
    private String noticeContent;
    @ApiModelProperty(value = "发布人", name = "publishUserId", dataType = "String")
    private String publishUserId;
    @ApiModelProperty(value = "发布时间", name = "publishTime", dataType = "Date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date publishTime;
    @ApiModelProperty(name = "createId", value = "创建人ID", dataType = "String")
    private String createId;
    @ApiModelProperty(name = "createTime", value = "创建时间", dataType = "Date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    @ApiModelProperty(name = "delFlag", value = "删除标识", dataType = "String")
    private String delFlag;
    @ApiModelProperty(name = "delId", value = "删除人ID", dataType = "String")
    private String delId;
    @ApiModelProperty(name = "delTime", value = "删除时间", dataType = "Date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date delTime;
    @ApiModelProperty(name = "status", value = "状态", dataType = "String")
    private String status;
    @ApiModelProperty(name = "systemNoticeAppendixList", value = "附件列表", dataType = "List<SystemNoticeAppendix>")
    private List<SystemNoticeAppendix> systemNoticeAppendixList;
    @ApiModelProperty(name = "haveAppendixStatus", value = "有附件", dataType = "String")
    private String haveAppendixStatus;


}
