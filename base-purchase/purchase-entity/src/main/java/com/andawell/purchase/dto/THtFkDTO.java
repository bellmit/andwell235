package com.andawell.purchase.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
* @ClassName: THtFk
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月01日 下午04:30:05
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("合同付款")
public class THtFkDTO {

    /**
     * 合同号
     */
    @NotBlank(message = "合同号不能为空")
    @ApiModelProperty(value = "合同号",required = true)
    private String hth;

    /**
     * 货款价格
     */
    @NotBlank(message = "货款价格不能为空")
    @ApiModelProperty(value = "货款价格",required = true)
    private String hkjg;

    /**
     * 付款日期
     */
    @NotNull(message = "付款日期不能为空")
    @ApiModelProperty(value = "付款日期",required = true)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date fkrq;

    /**
     * 运保单位
     */
    @NotBlank(message = "运保单位不能为空")
    @ApiModelProperty(value = "运保单位",required = true)
    private String ybdl;

    /**
     * 备注
     */
    private String bz;

    /**
     * 入库单号
     */
    @NotNull(message = "入库单号不能为空")
    @ApiModelProperty(value = "入库单号",required = true)
    private List<String> rkdh;



}