package com.andawell.upms.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel("日志信息查询条件")
@Accessors(chain = true)
public class LogInfoQuery extends PageDto {
    @ApiModelProperty(value = "ID", name = "id", dataType = "String")
    private String id;

    @ApiModelProperty(value = "姓名", name = "name", dataType = "String")
    private String nameLike;
    /**
     * 账户信息
     */
    @ApiModelProperty(value = "账户信息查询", name = "username", dataType = "String")
    private String username;
    /**
     * 操作类型
     */
    @ApiModelProperty(value = "操作类型查询", name = "type", dataType = "String")
    private String type;
    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间", name = "startTime", dataType = "Date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间", name = "endTime", dataType = "Date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
}
