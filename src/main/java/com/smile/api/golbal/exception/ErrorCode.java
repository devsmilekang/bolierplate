package com.smile.api.golbal.exception;

public enum ErrorCode {
    INVALID_PARAMETER(400, "9000", "Invalid Request Data"),
    METHOD_NOT_ALLOWED(405, "9001", "method not allowed"),
    SYSTEM_ERROR(500, "9999", "예기치않은 시스템 오류");

    private final int statusCode;
    private final String errorCode;
    private final String errorMsg;

    ErrorCode(int statusCode, String errorCode, String errorMsg) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }


    public int getStatusCode() {
        return statusCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
