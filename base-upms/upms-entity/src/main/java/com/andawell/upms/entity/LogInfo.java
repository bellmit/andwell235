package com.andawell.upms.entity;

import com.andawell.common.entity.enumeration.RequestExecuteStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/***
 * @ClassName: LogInfo
 * @Description:
 * @Auther: PC
 * @Date: 2019/12/4 9:09
 * @version : V1.0
 */
@Data
@ToString
public class LogInfo {
    /**
     * ID
     */
    private String id;
    /**
     * 账户账号
     */
    private String username;
    /**
     * 账户姓名
     */
    private String name;
    /**
     * 操作内容
     */
    private String operation;
    /**
     * 操作类型
     */
    private String type;
    /**
     * 执行时常
     */
    private Long time;
    /**
     * 执行方法
     */
    private String method;
    /**
     * 请求的URI
     */
    private String requestUri;
    /**
     * 请求Ip
     */
    private String ip;
    /**
     * 请求参数
     */
    private String params;
    /**
     * 返回参数
     */
    private String returnValue;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
     * 执行状态
     */
    private RequestExecuteStatus status;
    /**
     * 来源标识
     */
    private String authFlag;
    /**
     * 异常代码
     */
    private String exceptionCode;
    /**
     * 异常详情
     */
    private String exceptionDetail;


}
