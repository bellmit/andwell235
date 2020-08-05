package com.andawell.material.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
* @ClassName: TCkFcsj
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月08日 上午09:12:14
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "返厂升级查询")
@Accessors(chain = true)
public class TCkFcsjQuery extends PageDto {
    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private String bh;

    /**
     * 单位代码
     */
    @ApiModelProperty(value = "单位代码")
    private String dwid;

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
     * 航材类别
     */
    @ApiModelProperty(value = "航材类别")
    private Integer hclb;

}