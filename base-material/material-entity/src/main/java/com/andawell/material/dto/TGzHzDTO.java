package com.andawell.material.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @ClassName: TGzHz
 * @Description:
 * @author: Mybatis Generator
 * @date 2020年05月09日 上午09:28:46
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TGzHzDTO {

    /**
     * 机型
     */
    private String jx;
    /**
     * ID
     */
    private String id;

    /**
     * 编号
     */
    private String bh;

    /**
     * 入库文号
     */
    private String wh;

    /**
     * 发付单位
     */
    private String ffdw;

    /**
     * 接收单位
     */
    private String jsdw;

    /**
     * 份数
     */
    private Integer fs;

    /**
     * 页数
     */
    private Integer ys;

    /**
     * 日期
     */
    @NotNull(message = "日期不能为空")
    @ApiModelProperty(value = "rq",required = true)
    private Date rq;

    /**
     * 发单人
     */

    private String fdr;

    /**
     * 备注
     */
    private String bz;

    /**
     * 发货人
     */
    @NotBlank(message = "发货人不能为空")
    @ApiModelProperty(value = "fhr",required = true)
    private String fhr;
    /**
     * 日期
     */
    private Date fhrq;
    /**
     * 运单号
     */
    @NotBlank(message = "运单号不能为空")
    @ApiModelProperty(value = "ydh",required = true)
    private String ydh;
    /**
     * 承运单位
     */
    @NotBlank(message = "承运单位不能为空")
    @ApiModelProperty(value = "cydw",required = true)
    private String cydw;



}