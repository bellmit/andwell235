package com.andawell.material.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author: zje
 * @date: 2020/6/1
 * @description:
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TDbJgdbDTO {

    @ApiModelProperty(value = "文号", name = "wh", dataType = "String")
    @NotBlank(message = "调拨依据不能为空")
    private String wh;

    @ApiModelProperty(value = "申请单号", name = "sqdh", dataType = "String")
    private String sqdh;

    @ApiModelProperty(value = "机型", name = "jx", dataType = "String")
    @NotBlank(message = "机型不能为空")
    private String jx;

    @ApiModelProperty(value = "运输方式", name = "ysfs", dataType = "Integer")
    private Integer ysfs;

    @ApiModelProperty(value = "申请单位", name = "sqdw", dataType = "String")
    private String sqdw;

    @ApiModelProperty(value = "发付单位", name = "ffdw", dataType = "String")
    private String ffdw;

    @ApiModelProperty(value = "接收单位", name = "jsdw", dataType = "String")
    private String jsdw;

    @ApiModelProperty(value = "调拨单号", name = "dbdh", dataType = "String")
    private String dbdh;

    @ApiModelProperty(value = "调拨类型", name = "dblx", dataType = "String")
    private Integer dblx;

    private List<TDbJgdbqdDTO> dbJgdbqdDTOS;
}
