package com.ticket.core.domain.performance;

import java.time.LocalDateTime;

public class Performance {

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Performance(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean isPastPerformance(LocalDateTime now) {
        return now.isAfter(endTime);
    }
}
