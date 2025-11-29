package com.ticket.core.domain.reservation;

import java.time.LocalDateTime;
import java.util.List;

public class Reservation {
    private final Long userId;
    private final Long performanceId;
    private final List<Long> seatIds;
    private final LocalDateTime reservationTime;

    public Reservation(final Long userId, final Long performanceId, final List<Long> seatIds, final LocalDateTime reservationTime) {
        this.userId = userId;
        this.performanceId = performanceId;
        this.seatIds = seatIds;
        this.reservationTime = reservationTime;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getPerformanceId() {
        return performanceId;
    }

    public List<Long> getSeatIds() {
        return seatIds;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }
}
