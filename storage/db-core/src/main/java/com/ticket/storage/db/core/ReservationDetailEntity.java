package com.ticket.storage.db.core;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ReservationDetailEntity {

    @Id @GeneratedValue
    private Long reservationDetailId;

    private Long reservationId;

    private Long performanceSeatId;

    protected ReservationDetailEntity() {}
}
