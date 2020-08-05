package com.andawell.purchase.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @Author:PCJ
 * @Date:2020/6/2
 * @Version:V1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TDhJhqdQuery extends PageDto {

    /**
     * 订货计划编号
     */
    @ApiModelProperty(value = "订货计划编号",required = true)
    private String bh;

    /**
     * 器材类型
     */
    @ApiModelProperty(value = "器材类型", required = true)
    @NotBlank(message = "器材类型不为NULl")
    private String qclx;

    /**
     * 器材类型
     */
    @ApiModelProperty(value = "是否关联有效采购信息", required = true)
    @NotBlank(message = "是否关联有效采购信息")
    private String status;

}
