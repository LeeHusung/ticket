package com.ticket.storage.db.core;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "PERFORMANCE")
public class PerformanceEntity {

    @Id @GeneratedValue
    private Long id;

    private Long showId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private LocalDateTime reserveOpenTime;

    private LocalDateTime reserveCloseTime;

    public Long getId() {
        return id;
    }

    public Long getShowId() {
        return showId;
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
}
