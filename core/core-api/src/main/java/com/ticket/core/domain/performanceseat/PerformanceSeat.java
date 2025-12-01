package com.ticket.core.domain.performanceseat;

import java.util.concurrent.atomic.AtomicInteger;

public class PerformanceSeat {
    private final Long id;
    private final Long performanceId;
    private final Long seatId;
    private final AtomicInteger performanceSeatCount;

    public PerformanceSeat(final Long id, final Long performanceId, final Long seatId, final AtomicInteger performanceSeatCount) {
        this.id = id;
        this.performanceId = performanceId;
        this.seatId = seatId;
        this.performanceSeatCount = performanceSeatCount;
    }

    private boolean canReservation() {
        return this.performanceSeatCount.get() > 0;
    }

    public Long getId() {
        return id;
    }

    public Long getPerformanceId() {
        return performanceId;
    }

    public Long getSeatId() {
        return seatId;
    }

    public AtomicInteger getPerformanceSeatCount() {
        return performanceSeatCount;
    }

}
