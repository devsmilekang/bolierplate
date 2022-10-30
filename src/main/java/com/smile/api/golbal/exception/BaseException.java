package com.smile.api.golbal.exception;

import com.smile.api.golbal.error.ExceptionError;

import java.io.Serial;

public class BaseException extends RuntimeException implements ExceptionError {

    @Serial
    private static final long serialVersionUID = -4008000856035525861L;

    private String errorCode;
    private int status;

    BaseException(){
        super();
    }
    BaseException(String code){
        super();
        this.errorCode = code;
    }

    BaseException(String code, String message) {
        super(message);
        this.errorCode = code;
    }

    BaseException(String code, String message, int status) {
        super(message);
        this.errorCode = code;
        this.status = status;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public String getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getErrorMsg() {
        return this.getMessage();
    }
}
