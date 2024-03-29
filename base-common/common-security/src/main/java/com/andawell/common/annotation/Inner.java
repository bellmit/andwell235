package com.andawell.common.annotation;

import java.lang.annotation.*;

/**
 * @author dcy
 * @date 2019/4/22
 *    服务调用不进行权限验证
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Inner {

	/**
	 * 是否AOP统一处理
	 *
	 * @return false, true
	 */
	boolean value() default true;

	/**
	 * 需要特殊判空的字段(预留)
	 *
	 * @return {}
	 */
	String[] field() default {};
}
