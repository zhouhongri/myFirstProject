package com.b.test.util;

import com.b.test.entry.ErrorCode;
import org.apache.catalina.connector.ClientAbortException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * @author zhr
 * @description 异常统一处理类
 * @date 2018-11-30 10:43
 **/
@ControllerAdvice
@ResponseBody
public class ExceptionHandlerAdvice {

    private Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        logger.error(e.getMessage(), e);
        return ErrorCode.STSTEM_ERROR.getName();
    }

    @ExceptionHandler(NullPointerException.class)
    public ErrorCode handleNullPointerException(NullPointerException e) {
        logger.error(e.getMessage(), e);
        return ErrorCode.PARAM_NULL_ERROR;
    }

    @ExceptionHandler(ClientAbortException.class)
    public String handleClientAbortException(ClientAbortException e) {
        logger.error(e.getMessage(), e);
        return ErrorCode.CONNECTION_OUT_ERROR.getName();
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ErrorCode methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e){
        logger.error(e.getMessage(), e);
        return ErrorCode.METHOD_ARGUMENT_TYPE_ERROR;
    }
}
