package com.smile.api.golbal.handler;

import com.smile.api.golbal.error.ErrorResponse;
import com.smile.api.golbal.exception.BaseException;
import com.smile.api.golbal.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletResponse;
import java.security.InvalidParameterException;

@RestControllerAdvice
@Slf4j
public class RestControllerExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    protected ErrorResponse systemErrorHandler(Exception ex){
        log.error("Exception Handler Error", ex);
        return new ErrorResponse(ErrorCode.SYSTEM_ERROR.getStatusCode(), ErrorCode.SYSTEM_ERROR.getErrorCode(), ErrorCode.SYSTEM_ERROR.getErrorMsg());
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ErrorResponse handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("handleHttpRequestMethodNotSupportedException", e);
        return new ErrorResponse(ErrorCode.METHOD_NOT_ALLOWED.getStatusCode(), ErrorCode.METHOD_NOT_ALLOWED.getErrorCode(), ErrorCode.METHOD_NOT_ALLOWED.getErrorMsg());
    }

    //@Valid 검증 실패 시 Catch
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({InvalidParameterException.class, MethodArgumentTypeMismatchException.class})
    protected ErrorResponse handleInvalidParameterException(Exception e) {
        log.error("handleInvalidParameterException", e);
        return new ErrorResponse(ErrorCode.INVALID_PARAMETER.getStatusCode(), ErrorCode.INVALID_PARAMETER.getErrorCode(), ErrorCode.INVALID_PARAMETER.getErrorMsg());
    }


    @ExceptionHandler(BaseException.class)
    protected ErrorResponse handleExcpetion(BaseException ex, HttpServletResponse response) {
        response.setStatus(ex.getStatus());
        return new ErrorResponse(ex.getStatus(), ex.getErrorCode(), ex.getErrorMsg());
    }

}
