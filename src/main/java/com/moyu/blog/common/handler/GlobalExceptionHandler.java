package com.moyu.blog.common.handler;

import cn.hutool.core.util.StrUtil;
import com.moyu.blog.common.convention.errorcode.BaseErrorCode;
import com.moyu.blog.common.convention.result.Result;
import com.moyu.blog.common.convention.result.Results;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author LiuRC
 * @date 2024/8/5
 * description 全局异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 拦截参数验证异常
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result<?> MethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException ex) {
        StringBuilder errorMsg = new StringBuilder();
        // 循环获取多个错误信息，并用;隔开
        ex.getBindingResult().getFieldErrors().forEach(item -> {
            errorMsg.append(item.getField()).append(item.getDefaultMessage()).append(";");
        });
        String msg = errorMsg.toString();
        log.error("[{}] {} [ex] {}", request.getMethod(), getUrl(request), msg);
        return Results.failure(BaseErrorCode.SERVICE_ERROR.code(), msg.substring(0, msg.length() - 1));
    }

    /**
     * 拦截未捕获异常，防止返回到前端用户看到敏感信息
     */
    @ExceptionHandler(value = Throwable.class)
    public Result<?> defaultErrorHandler(HttpServletRequest request, Throwable ex) {
        log.error("[{}] {} ", request.getMethod(), getUrl(request), ex);
        return Results.failure(BaseErrorCode.SERVICE_ERROR.code(), BaseErrorCode.SERVICE_ERROR.message());
    }

    private String getUrl(HttpServletRequest request) {
        if (StrUtil.isBlank(request.getQueryString())) {
            return request.getRequestURL().toString();
        }
        return request.getRequestURL().toString() + "?" + request.getQueryString();
    }

}
