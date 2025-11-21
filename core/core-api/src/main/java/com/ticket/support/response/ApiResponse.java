package com.ticket.support.response;

import com.ticket.support.exception.ErrorMessage;
import com.ticket.support.exception.ErrorType;

public class ApiResponse<T> {

    private final ResultType result;
    private final T data;
    private final ErrorMessage error;

    public ApiResponse(final ResultType result, final T data, final ErrorMessage error) {
        this.result = result;
        this.data = data;
        this.error = error;
    }

    public static <S> ApiResponse<S> error(final ErrorType errorType, final Object data) {
        return new ApiResponse<>(ResultType.ERROR, null, new ErrorMessage(errorType, data));
    }

    public ResultType getResult() {
        return result;
    }

    public T getData() {
        return data;
    }

    public ErrorMessage getError() {
        return error;
    }
}
