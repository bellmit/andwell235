package com.andawell.material.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: yzy
 * @Description:
 * @Date: created in 2020/5/25 13:16
 */
@Data
@ApiModel("盘库查询")
public class PKCXQuery extends PageDto {

    @ApiModelProperty(name = "dcrq", value = "导出日期(yyyy-MM-dd HH:mm:ss)")
    private String  dcrq;
}
