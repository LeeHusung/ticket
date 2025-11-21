package com.ticket.support;

import com.ticket.support.exception.DuplicateEmailException;
import com.ticket.support.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiControllerAdvice {

    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<ApiResponse<Object>> handleException(DuplicateEmailException e) {
        return ResponseEntity.status(e.getErrorType().getStatus()).body(ApiResponse.error(e.getErrorType(), e.getData()));
    }
}
