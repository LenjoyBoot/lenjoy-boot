package cn.lenjoy.boot.framework.web.config.web.core;

import cn.lenjoy.boot.framework.common.base.response.BaseRes;
import cn.lenjoy.boot.framework.common.exception.BaseException;
import cn.lenjoy.boot.framework.common.util.result.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.nio.file.AccessDeniedException;
import java.util.List;

import static cn.lenjoy.boot.framework.common.constant.StringPattern.*;
import static cn.lenjoy.boot.framework.common.exception.ErrorCodeMsg.*;

/**
 * @description: 全局异常捕获
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 20 星期三
 * @version: 1.0.0
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public BaseRes<String> exceptionHandler(MissingServletRequestParameterException e) {
        log.warn("[MissingServletRequestParameterException]", e);
        return ResultUtils.fail(FAILED.getCode(), String.format(PARAMS_PATTERN, e.getParameterName()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public BaseRes<String> exceptionHandler(MethodArgumentTypeMismatchException e) {
        log.warn("[MethodArgumentTypeMismatchException]", e);
        return ResultUtils.fail(FAILED.getCode(), String.format(PARAMS_PATTERN, e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseRes<String> exceptionHandler(MethodArgumentNotValidException e) {
        log.warn("[MethodArgumentNotValidException]", e);
        return failFieldErrors(e.getFieldErrors());
    }

    @ExceptionHandler(BindException.class)
    public BaseRes<String> exceptionHandler(BindException e) {
        log.warn("[BindException]", e);
        return failFieldErrors(e.getFieldErrors());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public BaseRes<String> exceptionHandler(ConstraintViolationException e) {
        log.warn("[ConstraintViolationException]", e);
        ConstraintViolation<?> constraintViolation = e.getConstraintViolations().iterator().next();
        return ResultUtils.fail(BAD_REQUEST.getCode(), String.format(PARAMS_PATTERN, constraintViolation.getMessage()));
    }

    @ExceptionHandler(ValidationException.class)
    public BaseRes<String> exceptionHandler(ValidationException e) {
        log.warn("[ValidationException]", e);
        return ResultUtils.fail(BAD_REQUEST);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public BaseRes<String> exceptionHandler(NoHandlerFoundException e) {
        log.warn("[NoHandlerFoundException]", e);
        return ResultUtils.fail(NOT_FOUND.getCode(), String.format(URL_PATTERN, e.getRequestURL()));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public BaseRes<String> exceptionHandler(HttpRequestMethodNotSupportedException e) {
        log.warn("[HttpRequestMethodNotSupportedException]", e);
        return ResultUtils.fail(NOT_FOUND.getCode(), String.format(METHOD_PATTERN, e.getMessage()));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public BaseRes<String> exceptionHandler(AccessDeniedException e) {
        log.warn("[AccessDeniedException]", e);
        return ResultUtils.fail(FORBIDDEN);
    }

    @ExceptionHandler(BaseException.class)
    public BaseRes<String> exceptionHandler(BaseException e) {
        log.warn("[BaseException]", e);
        return ResultUtils.fail(e.getCode(), e.getMsg());
    }

    @ExceptionHandler(Exception.class)
    public BaseRes<String> exceptionHandler(Exception e) {
        log.warn("[Exception]", e);
        // 异常打印
        return ResultUtils.fail(FAILED);
    }

    private BaseRes<String> failFieldErrors(List<FieldError> fieldErrors) {
        StringBuilder errMsg = new StringBuilder();
        fieldErrors.forEach(err-> errMsg.append(err.getDefaultMessage()).append(";"));
        errMsg.deleteCharAt(errMsg.length() - 1);
        return ResultUtils.fail(BAD_REQUEST.getCode(), String.format(PARAMS_PATTERN, errMsg));
    }
}
