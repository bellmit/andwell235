package com.andawell.common.entity.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SysLog {
    /**
     *   值
     * @return
     */
    String value() default "";

    /**
     *  操作类型
     * @return
     */
    String operationType() default "";
    /**
     * 操作描述
     */
    String operationDescription() default "";
}
