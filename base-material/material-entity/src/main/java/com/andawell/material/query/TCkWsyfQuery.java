package com.andawell.material.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
* @ClassName: TCkWsyf
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月08日 下午04:35:57
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkWsyfQuery extends PageDto {

    /**
     * 出库编号
     */
    @ApiModelProperty(value = "出库编号")
    private String bh;

    /**
     * 机型
     */
    @ApiModelProperty(value = "机型")
    private String jx;

    /**
     * 件号
     */
    @ApiModelProperty(value = "件号")
    private String jh;

    /**
     * 序号
     */
    @ApiModelProperty(value = "序号")
    private String xh;

    /**
     * 所属单位
     */
    @ApiModelProperty(value = "所属单位")
    private String dwid;


}