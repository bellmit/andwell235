package com.andawell.material.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Date： 2020/5/6 17:57
 */
@Data
@Accessors(chain = true)
@ApiModel("库存查询统计明细")
public class NewPrpertoryCountQuery extends PageDto {
    /**
     * 机型
     * */
    @ApiParam(value = "机型", name = "jx")
    private String jx;
    /**
     * 件号
     * */
    @ApiParam(value = "件号", name = "jh")
    private String jh;
    /**
     * 所属战区dwid
     * */
    @ApiParam(value = "所属战区dwid", name = "dwid")
    private String dwid;

    /**
     * 所属战区dwid
     * */
    @ApiParam(value = "用户Id", name = "userId")
    private String userId;

}
