package com.andawell.material.dto;

import com.andawell.material.dto.groups.First;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author lhb
 * @Date: 2020/5/11 10:21
 * @Description:
 * @version : V1.0
 */
@Data
@Accessors(chain = true)
@ApiModel("出库详情")
@NoArgsConstructor
@AllArgsConstructor
public class OutLibraryDetailDTO {



    /**
     * 编号
     */
  //@NotBlank(message = "编号不能为空")
    @ApiModelProperty(value = "编号")
    private String bh;

    /**
     * 出库件号
     */
    @NotBlank(message = "出库件号不能为空")
    @ApiModelProperty(value = "出库件号",required = true)
    private String jh;

    /**
     * 出库序号
     */
    @NotBlank(message = "出库序号不能为空")
    @ApiModelProperty(value = "出库序号",required = true)
    private String xh;

    /**
     * 出库序号
     */
    @ApiModelProperty(value = "新序号")
    private String xxh;

    /**
     * 出库单位
     */
    @NotBlank(message = "出库单位Id不能为空")
    @ApiModelProperty(value = "出库单位Id",required = true)
    private String dwid;


    /**
     * 出库数量
     */
    @NotNull(message = "出库数量不能为空")
    @ApiModelProperty(value = "出库数量",required = true)
    private Long cksl;

    /**
     * 质量ID
     */
    @NotBlank(message = "质量ID不能为空")
    @ApiModelProperty(value = "质量ID",required = true)
    private String zl;

    /**
     * 新备注
     */
    @ApiModelProperty(value = "新备注")
    private String bz;


    /**
     * 新备注
     */
    @NotBlank(message = "机型Id不能为空")
    @ApiModelProperty(value = "机型Id",required = true)
    private String jx;

    /**
     * 原因
     */
    @ApiModelProperty(value = "原因")
    private String reason;

    /**
     * 默认为0
     */
    @ApiModelProperty(value = "选择")
    private String xz = "0";

    /**
     * 中队代码
     */
    @ApiModelProperty(value = "中队代码")
    private String zddm ;
    /**
     * 汇率
     */
  //  @NotNull(message = "汇率不能为空")
    @ApiModelProperty(value = "汇率")
    private BigDecimal hl;

    /**
     * 质量ID
     */
    @ApiModelProperty(value = "转换质量ID")
    private String newzl;

    /**
     * 航材类别
     */
    @ApiModelProperty(value = "航材类别")
    private String hclb;

    /**
     * 外借日期
     */
    @ApiModelProperty(value = "外借日期")
    private Date wjrq;
}
