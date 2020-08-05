package com.andawell.material.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
* @ClassName: TCkCrkqd
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月06日 下午04:28:25
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HcSfCxTjQuery extends PageDto {
    @ApiModelProperty(name = "jx", value = "机型")
    private String jx;

    @ApiModelProperty(name = "jh", value = "器材型号")
    private String jh;

    @ApiModelProperty(name = "rq_start", value = "开始日期")
    private String rq_start;

    @ApiModelProperty(name = "rq_end", value = "截止日期")
    private String rq_end;
    /**
     * 所属战区dwid
     * */
    @ApiParam(value = "所属战区dwid", name = "dwid")
    private String dwid;
}