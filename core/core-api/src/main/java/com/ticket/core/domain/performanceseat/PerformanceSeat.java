package com.ticket.core.domain.performanceseat;

public class PerformanceSeat {
    private final int count;

    public PerformanceSeat(final int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public boolean canReservation() {
        return this.count > 0;
    }

}
