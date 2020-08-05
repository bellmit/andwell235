package com.andawell.material.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/***
 * @author lhb
 * @Date: 2020/5/12 13:47
 * @Description:
 * @version : V1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkDxOutLibraryVO {

    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private String bh;

    /**
     * 件号
     */
    @ApiModelProperty(value = "件号")
    private String jh;

    /**
     * 件号名称
     */
    @ApiModelProperty(value = "件号名称")
    private String jhmc;

    /**
     * 序号
     */
    @ApiModelProperty(value = "序号")
    private String xh;

    /**
     * 计量单位
     */
    @ApiModelProperty(value = "计量单位")
    private String jldw;


    /**
     * 机型
     */
    @ApiModelProperty(value = "机型")
    private String jx;

    /**
     * 机型名称
     */
    @ApiModelProperty(value = "机型名称")
    private String jxmc;


    /**
     * 质量 21:待修 24:待报废
     */
    private String zl;

    /**
     * 入库日期
     */
    @ApiModelProperty(value = "入库日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date rkrq;




    /**
     * 故障现象
     */
    @ApiModelProperty(value = "故障现象")
    private String gzxx;


    /**
     * 数量
     */
    @ApiModelProperty(value = "库存数量")
    private Integer sl;



    /**
     * 航材类别
     */
    @ApiModelProperty(value = "航材类别id")
    private Integer hclb;


    /**
     * 航材类别
     */
    @ApiModelProperty(value = "航材类别名称")
    private String hclbmc;

    /**
     * 出厂日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date ccrq;

    /**
     * 出厂日期
     */
    @ApiModelProperty(value = "单位Id")
    private String dwid;





}