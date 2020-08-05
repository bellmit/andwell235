package com.andawell.upms.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Author:PCJ
 * @Date:2020/5/9
 * @Version:V1.0.0
 */
@Data
@Accessors(chain = true)
@ApiModel("厂方查询")
public class TCfQuery {
    @ApiModelProperty(name = "id", value = "id", dataType = "String")
    private String id;

    @ApiModelProperty(name = "lb", value = "lb", dataType = "String")
    private String lb;

    @ApiModelProperty(name = "mc", value = "mc", dataType = "String")
    private String mc;

    @ApiModelProperty(name = "jm", value = "jm", dataType = "String")
    private String jm;

    @ApiModelProperty(name = "zylb", value = "zylb", dataType = "String")
    private String zylb;

    @ApiModelProperty(name = "bz", value = "bz", dataType = "String")
    private String bz;

    @ApiModelProperty(name = "bzmc", value = "bzmc", dataType = "String")
    private String bzmc;

    @ApiModelProperty(name = "zhmc", value = "zhmc", dataType = "String")
    private String zhmc;

    @ApiModelProperty(name = "zh", value = "zh", dataType = "String")
    private String zh;

    @ApiModelProperty(name = "khyh", value = "khyh", dataType = "String")
    private String khyh;

    @ApiModelProperty(name = "gj", value = "gj", dataType = "String")
    private String gj;

    @ApiModelProperty(name = "cs", value = "cs", dataType = "String")
    private String cs;

    @ApiModelProperty(name = "dz", value = "dz", dataType = "String")
    private String dz;

    @ApiModelProperty(name = "yb", value = "yb", dataType = "String")
    private String yb;

    @ApiModelProperty(name = "lxr", value = "lxr", dataType = "String")
    private String lxr;

    @ApiModelProperty(name = "dh", value = "dh", dataType = "String")
    private String dh;

    @ApiModelProperty(name = "cz", value = "cz", dataType = "String")
    private String cz;

    @ApiModelProperty(name = "yj", value = "yj", dataType = "String")
    private String yj;

    @ApiModelProperty(name = "zs", value = "zs", dataType = "String")
    private String zs;

    @ApiModelProperty(name = "zsrq", value = "zsrq", dataType = "Date")
    private Date zsrq;

    @ApiModelProperty(name = "wxzs", value = "wxzs", dataType = "String")
    private String wxzs;

    @ApiModelProperty(name = "wxzsrq", value = "wxzsrq", dataType = "Date")
    private Date wxzsrq;

    @ApiModelProperty(name = "bmzz", value = "bmzz", dataType = "String")
    private String bmzz;

    @ApiModelProperty(name = "bmksrq", value = "bmksrq", dataType = "Date")
    private Date bmksrq;

    @ApiModelProperty(name = "pid", value = "pid", dataType = "String")
    private String pid;

    @ApiModelProperty(name = "zzhm", value = "zzhm", dataType = "String")
    private String zzhm;

    @ApiModelProperty(name = "bfrq", value = "bfrq", dataType = "Date")
    private Date bfrq;

    @ApiModelProperty(name = "wxzsksrq", value = "wxzsksrq", dataType = "Date")
    private Date wxzsksrq;

    @ApiModelProperty(name = "bmjsrq", value = "bmjsrq", dataType = "Date")
    private Date bmjsrq;

    @ApiModelProperty(name = "jgdw", value = "jgdw", dataType = "String")
    private String jgdw;
}
