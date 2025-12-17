package com.ticket.core.domain.seat;

import com.ticket.core.support.exception.CoreException;
import com.ticket.core.support.exception.ErrorType;

import java.util.List;

public class SeatIds {
    private final List<Long> values;

    public SeatIds(final List<Long> values) {
        validate(values);
        this.values = List.copyOf(values);
    }

    private void validate(final List<Long> values) {
        if (values == null || values.isEmpty()) {
            throw new CoreException(ErrorType.NOT_FOUND_DATA);
        }
    }

    public List<Long> getValues() {
        return values;
    }

    public int size() {
        return values.size();
    }
}
