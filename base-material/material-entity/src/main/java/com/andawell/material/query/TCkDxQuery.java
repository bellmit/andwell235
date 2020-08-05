package com.andawell.material.query;

import com.andawell.common.entity.dto.PageDto;
import com.github.pagehelper.util.StringUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
@ApiModel("待修库查询")
public class TCkDxQuery extends PageDto
{
    private String bh;

    /**
     * 质量 21:待修 24:待报废 必须匹配
     */
    @ApiModelProperty(name = "zl", value = "质量", dataType = "String")
    private String zl;


    /**
     * 机型 必须匹配
     */
    @ApiModelProperty(name = "jx", value = "机型", dataType = "String")
    private String jx;



    /**
     * 件号 必须匹配
     */
    @ApiModelProperty(name = "jh", value = "件号", dataType = "String")
    private String jh;


    /**
     * 件号名称 必须匹配
     */
    @ApiModelProperty(name = "jhmc", value = "件号名称", dataType = "String")
    private String jhmc;

    /**
     * 序号 模糊匹配
     */
    @ApiModelProperty(name = "xh", value = "序号", dataType = "String")
    private String xh;

    /**
     * 选择 模糊匹配 xz=0
     */
    @ApiModelProperty(name = "xz", value = "选择", dataType = "String")
    private String xz = "0";


    @ApiModelProperty(name = "startTime", value = "开始时间", dataType = "Data")
    private Data startTime ;

    @ApiModelProperty(name = "endTime", value = "结束时间", dataType = "Data")
    private Data endTime ;

    private String xxz;
}
