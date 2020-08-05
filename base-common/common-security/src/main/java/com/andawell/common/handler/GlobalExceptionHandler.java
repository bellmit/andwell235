package com.andawell.common.handler;

import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.common.util.BusinessException;
import com.andawell.common.util.PropertyException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	/**
	 * 全局异常.
	 *
	 * @param e the e
	 * @return R
	 */
/*	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.OK)
	public RestResultVo handleGlobalException(Exception e) {
		logger.error("全局异常信息 ex={}", e.getMessage(), e);
		return RestResultVo.builder()
			.message(e.getLocalizedMessage())
			.statusCode(RestStatus.ERROR)
			.build();
	}*/

    /**
     * AccessDeniedException
     *
     * @param e the e
     * @return R
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.OK)
    public RestResultVo handleAccessDeniedException(AccessDeniedException e) {
        String msg = SpringSecurityMessageSource.getAccessor()
                .getMessage("AbstractAccessDecisionManager.accessDenied"
                        , e.getMessage());
        logger.error("拒绝授权异常信息 ex={}", msg, e);
        return RestResultVo.builder()
                .message("拒绝访问")
                .statusCode(RestStatus.UNAUTHORIZED)
                .build();
    }

    /**
     * validation Exception
     *
     * @param exception
     * @return R
     */
    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    @ResponseStatus(HttpStatus.OK)
    //@ResponseBody
    public RestResultVo handleBodyValidException(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
//        final String[] errorMessage = {null};
////        fieldErrors.stream().forEach(fieldError -> {
////            logger.info("参数绑定异常,ex = {}", fieldError.getDefaultMessage());
////            errorMessage[0] = fieldError.getDefaultMessage();
////        });
        logger.info("参数绑定异常,{} = {}", fieldErrors.get(0).getField(),
                fieldErrors.get(0).getDefaultMessage());
//            errorMessage[0] = fieldError.getDefaultMessage();
        return RestResultVo.builder()
                .message(String.format("参数绑定异常,%s = %s",
                        fieldErrors.get(0).getField(),fieldErrors.get(0).getDefaultMessage()))
                .statusCode(RestStatus.ERROR)
                .build();
    }
   /* *//**
     * 索引相同异常
     *
     * @param exception
     * @return
     *//*
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    @ResponseStatus(HttpStatus.OK)
    public RestResultVo handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException exception) {
        logger.error("数据重复", exception.getMessage());
        return RestResultVo.builder()
                .message("数据重复")
                .statusCode(RestStatus.ERROR)
                .build();
    }*/
    /**
     * 异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.OK)
    public RestResultVo handleBusinessException(BusinessException exception) {
        logger.error("数据重复", exception.getMessage());
        return RestResultVo.builder()
                .message(exception.getMessage())
                .statusCode(RestStatus.ERROR)
                .build();
    }


    @ExceptionHandler(PropertyException.class)
    @ResponseStatus(HttpStatus.OK)
    public RestResultVo handlePropertyException(PropertyException exception) {
        logger.error("导入导出失败", exception.getMessage());
        return RestResultVo.builder()
                .message(exception.getMessage())
                .statusCode(RestStatus.ERROR)
                .build();
    }
}
