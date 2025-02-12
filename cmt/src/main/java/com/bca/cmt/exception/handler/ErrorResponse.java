package com.bca.cmt.exception.handler;

public class ErrorResponse {

    private String errorCode;
    private String message;
    private Object additionalInfo;

    public ErrorResponse(String errorCode, String message, Object additionalInfo) {
        this.errorCode = errorCode;
        this.message = message;
        this.additionalInfo = additionalInfo;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public Object getAdditionalInfo() {
        return additionalInfo;
    }
}
