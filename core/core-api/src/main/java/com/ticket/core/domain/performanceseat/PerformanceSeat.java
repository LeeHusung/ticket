package com.ticket.core.domain.performanceseat;

import com.ticket.core.domain.performance.Performance;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class PerformanceSeat {
    private final Performance performance;
    private final AtomicInteger count;

    public PerformanceSeat(final Performance performance, final int count) {
        this.performance = performance;
        this.count = new AtomicInteger(count);
    }

    public AtomicInteger getCount() {
        return count;
    }

    private boolean canReservation() {
        return this.count.get() > 0;
    }

    public boolean reserve(final Long userId, final LocalDateTime now) {
        if (!canReservation()) return false;
        if (performance.isPastPerformance(now)) return false;
        this.count.decrementAndGet();
        return true;
    }
}
