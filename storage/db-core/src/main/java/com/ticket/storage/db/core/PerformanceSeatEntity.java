package com.ticket.storage.db.core;

import com.ticket.core.enums.PerformanceSeatStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "PERFORMANCE_SEAT")
public class PerformanceSeatEntity {

    @Id @GeneratedValue
    private Long id;

    private Long performanceId;

    private Long seatId;

    @Enumerated(EnumType.STRING)
    private PerformanceSeatStatus status;

    protected PerformanceSeatEntity() {}

    public Long getId() {
        return id;
    }

    public Long getPerformanceId() {
        return performanceId;
    }

    public Long getSeatId() {
        return seatId;
    }

    public PerformanceSeatStatus getStatus() {
        return status;
    }
}
