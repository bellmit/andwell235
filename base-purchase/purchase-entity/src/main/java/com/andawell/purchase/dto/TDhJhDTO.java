package com.andawell.purchase.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
* @ClassName: TDhJh
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月01日 下午04:30:05
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("订货计划")
public class TDhJhDTO {
    /**
     * 计划编号(JH-BH-时间戳)
     */
    private String bh;

    /**
     * 计划名称
     */
    @NotBlank(message = "计划名称不能为空")
    @ApiModelProperty(value = "计划名称",required = true)
    private String jhmc;

    /**
     * 计划年份
     */
    private String jhnf;

    /**
     * 计划说明
     */
    @NotBlank(message = "计划说明不能为空")
    @ApiModelProperty(value = "计划说明",required = true)
    private String jhsm;

    /**
     * 创建日期
     */
    private Date cjrq;

    /**
     * 修改日期
     */
    private Date xgrq;

    /**
     * 1.草稿(暂留字段）2.发布  3. 删除
     */
    private Short status;
}