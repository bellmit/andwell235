package com.andawell.search.entity;


import com.andawell.common.entity.dto.CommonEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("xml查询功能的账户表")
public class XmlSearchAccount extends CommonEntityDto {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private String id;

    /**
     * 所属的主XML
     */
    @ApiModelProperty(value = "所属的主XML")
    private String mainid;

    /**
     * 表格名
     */
    @ApiModelProperty(value = "表格名")
    private String tablename;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 所属账户ID
     */
    @ApiModelProperty(value = "所属账户ID")
    private String accountid;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "createBy")
    private String createBy;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "createTime")
    private Date createTime;

    /**
     * 更新人
     */
    @ApiModelProperty(value = "updateBy")
    private String updateBy;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "updateTime")
    private Date updateTime;

    /**
     * 删除人
     */
    @ApiModelProperty(value = "删除人")
    private String deleteBy;

    /**
     * 删除时间
     */
    @ApiModelProperty(value = "删除时间")
    private Date deleteTime;

    /**
     * 删除标识("0":"正常"，“1”:“已删除”)
     */
    @ApiModelProperty(value = " 删除标识(\"0\":\"正常\"，“1”:“已删除”)")
    private String delFlag;

    /**
     * xml主体内容
     */
    @ApiModelProperty(value = " content")
    private String content;
}