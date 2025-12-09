package com.ticket.core.domain.member.vo;

import com.ticket.core.support.exception.CoreException;
import com.ticket.core.support.exception.ErrorType;

public class Password {
    private static final int MINIMUM_PASSWORD_LENGTH = 4;

    private final String value;

    public Password(final String value) {
        validate(value);
        this.value = value;
    }

    private void validate(final String rawValue) {
        if (rawValue == null) {
            throw new CoreException(ErrorType.INVALID_PASSWORD);
        }
        if (rawValue.trim().isEmpty()) {
            throw new CoreException(ErrorType.INVALID_PASSWORD);
        }
        if (rawValue.length() < MINIMUM_PASSWORD_LENGTH) {
            throw new CoreException(ErrorType.INVALID_PASSWORD);
        }
    }

    public String getValue() {
        return value;
    }
}
