package com.ticket.support.exception;

import org.springframework.http.HttpStatus;

public enum ErrorType {
    DUPLICATE_EMAIL_ERROR(HttpStatus.CONFLICT, ErrorCode.E409, "중복된 이메일은 불가능합니다.");

    private final HttpStatus status;
    private final ErrorCode errorCode;
    private final String message;

    ErrorType(final HttpStatus status, final ErrorCode errorCode, final String message) {
        this.status = status;
        this.errorCode = errorCode;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
