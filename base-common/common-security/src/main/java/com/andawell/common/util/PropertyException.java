package com.andawell.common.util;/**
 * @Date： 2020/6/2 9:35
 */

/**
 *@Auther:liuys
 *@Date:2020/6/2 09:35
 *@Description: 属性异常
 */
public class PropertyException extends RuntimeException {
    private  static final long serialVersionUID= -107363039147403126L;

    public PropertyException() {
    }

    public PropertyException(String msg) {
        super(msg);
    }

    public PropertyException(Throwable cause) {
        super(cause);
    }

    public PropertyException(String msg,Throwable cause) {
        super(msg,cause);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
