package com.andawell.common.util;

/***
 * @author lhb
 * @Date: 2020/4/28 17:02
 * @Description:
 * @version : V1.0
 */
public class BusinessException extends RuntimeException {

    private  static final long serialVersionUID= -107363039147403126L;

    public BusinessException() {
    }

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String msg,Throwable cause) {
        super(msg,cause);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
