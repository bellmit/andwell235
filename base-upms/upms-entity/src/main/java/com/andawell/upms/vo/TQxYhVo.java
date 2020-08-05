package com.andawell.upms.vo;/**
 * @Date： 2020/7/1 13:20
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 *@Auther:liuys
 *@Date:2020/7/1 13:20
 *@Description:
 */
@Data
@ApiModel("人员权限")
public class TQxYhVo {
    /**
     * ID
     */
    @ApiModelProperty(name = "id", value = "id", dataType = "String")
    private String id;

    /**
     * 用户名
     */
    @ApiModelProperty(name = "yhm", value = "用户名", dataType = "String")
    private String yhm;

    /**
     * 登录名
     */
    @ApiModelProperty(name = "dlm", value = "登录名", dataType = "String")
    private String dlm;

    /**
     * 单位
     */
    @ApiModelProperty(name = "dw", value = "单位", dataType = "String")
    private String dw;

    /**
     * 职务
     */
    @ApiModelProperty(name = "zw", value = "职务", dataType = "String")
    private String zw;

    /**
     * 级别
     */
    @ApiModelProperty(name = "jb", value = "级别", dataType = "String")
    private String jb;

    /**
     * 机型
     */
    @ApiModelProperty(name = "jx", value = "机型", dataType = "String")
    private String jx;

    /**
     * 出身日期
     */
    @ApiModelProperty(name = "csrq", value = "出身日期", dataType = "String")
    private Date csrq;

    /**
     * 入伍日期
     */
    @ApiModelProperty(name = "rwrq", value = "入伍日期", dataType = "String")
    private Date rwrq;

    /**
     * 政治面貌
     */
    @ApiModelProperty(name = "zzmm", value = "政治面貌", dataType = "String")
    private String zzmm;

    /**
     * 入党团日期
     */
    private Date rdtrq;

    /**
     * 角色
     */
    private String js;

    /**
     * 创建日期
     */
    private Date cjsj;

    /**
     * 修改日期
     */
    private Date xgsj;

    /**
     * 审批权限标记，一旦被标记，表示有航材请领出库的审批权限。
     */
    private String spqx;
}
