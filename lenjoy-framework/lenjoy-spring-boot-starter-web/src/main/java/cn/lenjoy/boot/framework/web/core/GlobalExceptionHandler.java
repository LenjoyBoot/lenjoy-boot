package cn.lenjoy.boot.framework.web.core;

import cn.lenjoy.boot.framework.common.base.response.BaseRes;
import cn.lenjoy.boot.framework.common.exception.BaseException;
import cn.lenjoy.boot.framework.common.util.result.ResultUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.ServletException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.nio.file.AccessDeniedException;
import java.sql.SQLSyntaxErrorException;
import java.util.List;
import java.util.concurrent.CompletionException;

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
        return ResultUtils.fail(FAILED.getCode(), String.format("缺少 Servlet 请求参数异常:%s", e.getParameterName()));
    }

    @ExceptionHandler(ServletException.class)
    public BaseRes<String> exceptionHandler(ServletException e) {
        log.warn("[ServletException]", e);
        return ResultUtils.fail(FAILED.getCode(), String.format("服务 Servlet 程序异常:%s", e.getMessage()));
    }

    @ExceptionHandler(TypeMismatchException.class)
    public BaseRes<String> exceptionHandler(TypeMismatchException e) {
        log.warn("[TypeMismatchException]", e);
        return ResultUtils.fail(FAILED.getCode(), String.format("类型不匹配异常:%s", e.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public BaseRes<String> exceptionHandler(IllegalArgumentException e) {
        log.warn("[IllegalArgumentException]", e);
        return ResultUtils.fail(FAILED.getCode(), String.format("非法参数异常:%s", e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public BaseRes<String> exceptionHandler(MethodArgumentTypeMismatchException e) {
        log.warn("[MethodArgumentTypeMismatchException]", e);
        return ResultUtils.fail(FAILED.getCode(), String.format("方法参数类型不匹配异常:%s", e.getMessage()));
    }

    @ExceptionHandler(JsonProcessingException.class)
    public BaseRes<String> exceptionHandler(JsonProcessingException e) {
        log.warn("[JsonProcessingException]", e);
        return ResultUtils.fail(FAILED.getCode(), String.format("Json转换异常:%s", e.getMessage()));
    }

    @ExceptionHandler(SQLSyntaxErrorException.class)
    public BaseRes<String> exceptionHandler(SQLSyntaxErrorException e) {
        log.warn("[SQLSyntaxErrorException]", e);
        return ResultUtils.fail(FAILED.getCode(), String.format("SQL 语法错误异常:%s", e.getMessage()));
    }

    @ExceptionHandler(CompletionException.class)
    public BaseRes<String> exceptionHandler(CompletionException e) {
        log.warn("[CompletionException]", e);
        return ResultUtils.fail(FAILED.getCode(), String.format("完成异常:%s", e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseRes<String> exceptionHandler(MethodArgumentNotValidException e) {
        log.warn("[MethodArgumentNotValidException]", e);
        StringBuilder errMsg = new StringBuilder();
        List<FieldError> fieldErrors = e.getFieldErrors();
        fieldErrors.forEach(err-> errMsg.append(err.getDefaultMessage()).append(";"));
        errMsg.deleteCharAt(errMsg.length() - 1);
        return ResultUtils.fail(BAD_REQUEST.getCode(), String.format("方法参数无效异常:%s", errMsg));
    }

    @ExceptionHandler(BindException.class)
    public BaseRes<String> exceptionHandler(BindException e) {
        log.warn("[BindException]", e);
        StringBuilder errMsg = new StringBuilder();
        List<FieldError> fieldErrors = e.getFieldErrors();
        fieldErrors.forEach(err-> errMsg.append(err.getDefaultMessage()).append(";"));
        errMsg.deleteCharAt(errMsg.length() - 1);
        return ResultUtils.fail(BAD_REQUEST.getCode(), String.format("绑定异常:%s", errMsg));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public BaseRes<String> exceptionHandler(ConstraintViolationException e) {
        log.warn("[ConstraintViolationException]", e);
        ConstraintViolation<?> constraintViolation = e.getConstraintViolations().iterator().next();
        return ResultUtils.fail(BAD_REQUEST.getCode(), String.format("约束违反异常:%s", constraintViolation.getMessage()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public BaseRes<String> exceptionHandler(HttpMessageNotReadableException e) {
        log.warn("[HttpMessageNotReadableException]", e);
        return ResultUtils.fail(BAD_REQUEST.getCode(), String.format("Http 消息不可读异常:%s", e.getMessage()));
    }

    @ExceptionHandler(ValidationException.class)
    public BaseRes<String> exceptionHandler(ValidationException e) {
        log.warn("[ValidationException]", e);
        return ResultUtils.fail(BAD_REQUEST.getCode(), String.format("验证异常:%s", e.getMessage()));
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public BaseRes<String> exceptionHandler(NoHandlerFoundException e) {
        log.warn("[NoHandlerFoundException]", e);
        return ResultUtils.fail(NOT_FOUND.getCode(), String.format("未找到处理程序异常:%s", e.getRequestURL()));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public BaseRes<String> exceptionHandler(HttpRequestMethodNotSupportedException e) {
        log.warn("[HttpRequestMethodNotSupportedException]", e);
        return ResultUtils.fail(NOT_FOUND.getCode(), String.format("Http 请求方法不支持异常:%s", e.getMessage()));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public BaseRes<String> exceptionHandler(AccessDeniedException e) {
        log.warn("[AccessDeniedException]", e);
        return ResultUtils.fail(FORBIDDEN.getCode(), String.format("访问被拒绝异常:%s", e.getMessage()));
    }

    @ExceptionHandler(BaseException.class)
    public BaseRes<String> exceptionHandler(BaseException e) {
        log.warn("[BaseException]", e);
        return ResultUtils.fail(e.getCode(), String.format("业务处理异常:%s", e.getMsg()));
    }

    @ExceptionHandler(Exception.class)
    public BaseRes<String> exceptionHandler(Exception e) {
        log.warn("[Exception]", e);
        return ResultUtils.fail(FAILED.getCode(), String.format("未知异常:%s", e.getMessage()));
    }
}
