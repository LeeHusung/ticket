package com.ticket.storage.db.core;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class ReservationEntity {

    @Id @GeneratedValue
    private Long id;

    private Long memberId;

    private Long performanceId;

    private List<Long> seatIds;

    protected ReservationEntity() {}

    public ReservationEntity(final Long memberId, final Long performanceId, final List<Long> seatIds) {
        this.memberId = memberId;
        this.performanceId = performanceId;
        this.seatIds = seatIds;
    }

    public Long getId() {
        return id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public Long getPerformanceId() {
        return performanceId;
    }

    public List<Long> getSeatIds() {
        return seatIds;
    }
}
