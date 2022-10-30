package com.smile.api.golbal.error;

public interface ExceptionError {

    int getStatus();

    String getErrorCode();

    String getErrorMsg();
}
