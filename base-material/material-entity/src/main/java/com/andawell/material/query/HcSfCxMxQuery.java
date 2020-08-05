package com.andawell.material.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: TCkCrkqd
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月06日 下午04:28:25
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HcSfCxMxQuery extends PageDto {
    /**
     * 机型
     * */
    @ApiModelProperty(value = "机型", name = "jx")
    private String jx;
    /**
     * 件号
     * */
    @ApiModelProperty(value = "件号", name = "jh")
    private String jh;
    /**
     * 所属战区dwid
     * */
    @ApiModelProperty(value = "所属战区dwid", name = "dwid")
    private String dwid;

    @ApiModelProperty(name = "rq_start", value = "开始日期")
    private String rq_start;

    @ApiModelProperty(name = "rq_end", value = "截止日期")
    private String rq_end;

}