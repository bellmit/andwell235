package com.andawell.material.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author: zje
 * @date: 2020/5/29
 * @description:
 */

@Data
@Accessors(chain = true)
@ApiModel("机关调拨查询条件")
public class TDbJgdbQuery extends PageDto {

    private String sqdw;

    private String jx;

    private String rq;

    private String clzt;
}
