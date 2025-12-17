package com.ticket.core.domain.reservation;

import com.ticket.core.domain.seat.SeatIds;

public class NewReservation {

    private final Long performanceId;
    private final SeatIds seatIds;

    public NewReservation(final Long performanceId, final SeatIds seatIds) {
        this.performanceId = performanceId;
        this.seatIds = seatIds;
    }

    public Long getPerformanceId() {
        return performanceId;
    }

    public SeatIds getSeatIds() {
        return seatIds;
    }
}
