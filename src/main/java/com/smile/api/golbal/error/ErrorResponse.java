package com.smile.api.golbal.error;

public class ErrorResponse implements ExceptionError{

    private final int statusCode;
    private final String errorCode;
    private final String errorMsg;

    public ErrorResponse(int statusCode, String errorCode, String errorMsg) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public int getStatus() {
        return statusCode;
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMsg() {
        return errorMsg;
    }
}
