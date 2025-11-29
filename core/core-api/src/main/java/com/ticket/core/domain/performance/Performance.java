package com.ticket.core.domain.performance;

import com.ticket.core.support.exception.CoreException;
import com.ticket.core.support.exception.ErrorType;

import java.time.LocalDateTime;

public class Performance {

    private final Long id;
    private final LocalDateTime startTime; //TODO 나중에 회차 시간이 변경될 수 있지 않을까? final 괜찮나?
    private final LocalDateTime endTime;
    private final LocalDateTime reserveOpenTime;
    private final LocalDateTime reserveCloseTime;

    public Performance(Long id, LocalDateTime startTime, LocalDateTime endTime, LocalDateTime reserveOpenTime, LocalDateTime reserveCloseTime) {
        if (startTime.isAfter(endTime)) {
            throw new CoreException(ErrorType.IS_NOT_VALID_PERFORMANCE);
        }
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.reserveOpenTime = reserveOpenTime;
        this.reserveCloseTime = reserveCloseTime;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public LocalDateTime getReserveOpenTime() {
        return reserveOpenTime;
    }

    public LocalDateTime getReserveCloseTime() {
        return reserveCloseTime;
    }

    public boolean isPastPerformance(LocalDateTime now) {
        return now.isAfter(endTime);
    }

    public boolean notYetCanReserveTime(final LocalDateTime now) {
        return reserveOpenTime.isAfter(now);
    }
}
