package com.ticket.support.exception;

public class NotFoundException extends RuntimeException {

    private final ErrorType errorType;
    private final Object data;

    public NotFoundException(final ErrorType errorType) {
        this(errorType, null);
    }

    public NotFoundException(final ErrorType errorType, Object data) {
        super(errorType.getMessage());
        this.errorType = errorType;
        this.data = data;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public Object getData() {
        return data;
    }
}
