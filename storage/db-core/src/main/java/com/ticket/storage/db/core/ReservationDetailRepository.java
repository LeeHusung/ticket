package com.ticket.storage.db.core;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationDetailRepository extends JpaRepository<ReservationDetailEntity, Long> {
    long countByReservationIdIn(final List<Long> reservationIds);
}
