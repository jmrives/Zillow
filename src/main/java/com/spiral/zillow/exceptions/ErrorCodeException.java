package com.spiral.zillow.exceptions;

import java.util.HashMap;
import java.util.Map;

public class ErrorCodeException extends IllegalStateException {
    private String rootClassName;
    private int errorCode;
    private String errorMessage;

    public ErrorCodeException(String apiName, int code, String message) {
        this.rootClassName = apiName;
        this.errorCode = code;
        this.errorMessage = message;
    }

    public String getMessage() {
        return rootClassName + " " + errorCode + ": " + errorMessage;
    }

    public String getRootClassName() {
        return rootClassName;
    }

    public void setRootClassName(String rootClassName) {
        this.rootClassName = rootClassName;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
