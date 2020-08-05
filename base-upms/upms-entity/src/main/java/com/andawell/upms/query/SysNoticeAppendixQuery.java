package com.andawell.upms.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@ApiModel("系统公告附件查询条件")
@Accessors(chain = true)
public class SysNoticeAppendixQuery extends PageDto {
    @ApiModelProperty(value = "系统公告id", name = "sNoticeId", dataType = "String")
    private String sNoticeId;
}
