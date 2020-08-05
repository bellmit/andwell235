package com.andawell.material.entity;

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
public class TGzHz {

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
    @NotNull(message = "份数不能为空")
    @ApiModelProperty(value = "fs",required = true)
    private Integer fs;

    /**
     * 页数
     */
    @NotNull(message = "页数不能为空")
    @ApiModelProperty(value = "ys",required = true)
    private Integer ys;

    /**
     * 日期
     */
    private Date rq;

    /**
     * 发单人
     */
    @NotNull(message = "发单人不能为空")
    @ApiModelProperty(value = "fdr",required = true)
    private String fdr;

    /**
     * 备注
     */
    private String bz;



    /**
     * 发货人
     */
    private String fhr;
    /**
     * 日期
     */
    private Date fhrq;
    /**
     * 运单号
     */
    private String ydh;
    /**
     * 承运单位
     */
    private String cydw;



}