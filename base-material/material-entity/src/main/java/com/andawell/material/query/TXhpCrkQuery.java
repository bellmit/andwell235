package com.andawell.material.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class TXhpCrkQuery extends PageDto {
    /**
     * 编号
     */
    @ApiModelProperty(value = "bh", name = "编号", dataType = "String")
    private String bh;

    /**
     * 批次号
     */
    @ApiModelProperty(value = "pch", name = "批次号", dataType = "String")
    private String pch;

    /**
     * 发付单位
     */
    @ApiModelProperty(value = "ffdw", name = "发付单位", dataType = "String")
    private String ffdw;

    /**
     * 收入单位
     */
    @ApiModelProperty(value = "srdw", name = "收入单位", dataType = "String")
    private String srdw;

    /**
     * 出入库类别
     */
    @ApiModelProperty(value = "lb", name = "出入库类别", dataType = "String")
    private String lb;

    /**
     * 出入库日期
     */
    @ApiModelProperty(value = "rq", name = "出入库日期", dataType = "String")
    private Date rq;

    /**
     * 根据文号
     */
    @ApiModelProperty(value = "gjwh", name = "根据文号", dataType = "String")
    private String gjwh;

    /**
     * 出入库文号
     */
    @ApiModelProperty(value = "wh", name = "出入库文号", dataType = "String")
    private String wh;


}
