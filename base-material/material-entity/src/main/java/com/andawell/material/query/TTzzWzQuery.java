package com.andawell.material.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
* @ClassName: TTzzWz
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月13日 上午11:13:51
*/
@Data
@Accessors(chain = true)
@ApiModel("通专装查询")
public class TTzzWzQuery extends PageDto {
    /**
     * 件号
     */
    @ApiModelProperty(name = "jh", value = "件号", dataType = "String")
    private String jh;

    /**
     * 名称
     */
    @ApiModelProperty(name = "mc", value = "名称", dataType = "String")
    private String mc;

    /**
     * 单位
     */
    @ApiModelProperty(name = "dw", value = "单位", dataType = "String")
    private String dw;

    /**
     * 类别  车辆物资、其他物资
     */
    @ApiModelProperty(name = "lb", value = "类别", dataType = "String")
    private String lb;
}