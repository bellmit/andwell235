package com.andawell.upms.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 系统公告附件
 * @author zoucx
 */
@Data
@ApiModel("系统公告附件")
public class SystemNoticeAppendix {
    @ApiModelProperty(value = "ID", name = "id", dataType = "String")
    private String id;
    @ApiModelProperty(value = "系统公告", name = "sNoticeId", dataType = "String")
    private String sNoticeId;
    @ApiModelProperty(value = "附件名称", name = "appendixName", dataType = "String")
    private String appendixName;
    @ApiModelProperty(value = "附件类型", name = "appendixType", dataType = "String")
    private String appendixType;
    @ApiModelProperty(value = "附件路径", name = "appendixUrl", dataType = "String")
    private String appendixUrl;
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
}
