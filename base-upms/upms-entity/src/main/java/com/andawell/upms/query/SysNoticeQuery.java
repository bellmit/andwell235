package com.andawell.upms.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@ApiModel("系统公共查询条件")
@Accessors(chain = true)
public class SysNoticeQuery extends PageDto {
    @ApiModelProperty(value = "ID", name = "id", dataType = "String")
    private String id;

    @ApiModelProperty(value = "按标题模糊查询", name = "noticeTitle", dataType = "String")
    private String noticeTitle;

    /**
     * 状态（“未发布”，“发布”）
     */
    @ApiModelProperty(value = "状态", name = "status", dataType = "String")
    private String status;

}
