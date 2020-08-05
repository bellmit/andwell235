package com.andawell.upms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName: TQxYh
 * @Description:
 * @author: Mybatis Generator
 * @date 2020年05月08日 下午01:32:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TQxYh {
    /**
     * ID
     */
    private String id;

    /**
     * 用户名
     */
    private String yhm;

    /**
     * 登录名
     */
    private String dlm;

    /**
     * 登录密码
     */
    private String dlmm;

    /**
     * 单位
     */
    private String dw;

    /**
     * 职务
     */
    private String zw;

    /**
     * 级别
     */
    private String jb;

    /**
     * 机型
     */
    private String jx;

    /**
     * 出身日期
     */
    private Date csrq;

    /**
     * 入伍日期
     */
    private Date rwrq;

    /**
     * 政治面貌
     */
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