package com.ticket.storage.db.core;

import com.ticket.core.enums.PerformanceSeatStatus;
import jakarta.persistence.*;

@Entity
public class PerformanceSeatEntity {

    @Id @GeneratedValue
    private Long id;

    private Long performanceId;

    private Long seatId;

    @Enumerated(EnumType.STRING)
    private PerformanceSeatStatus status;

    protected PerformanceSeatEntity() {}
}
