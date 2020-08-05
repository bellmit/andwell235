package com.andawell.common.entity.enumeration;

/***
 * @ClassName: RequestExecuteStatus
 * @Description:
 * @author DCY
 * @Date: 2019/12/4 9:36
 * @version : V1.0
 */
public enum RequestExecuteStatus {
    Y("成功"),
    N("失败");

    private RequestExecuteStatus(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
