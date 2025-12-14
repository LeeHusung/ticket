package com.ticket.core.api.controller.v1.request;

import com.ticket.core.domain.reservation.NewReservation;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class AddReservationRequest {

    @NotEmpty
    private List<Long> seatIds;

    public List<Long> getSeatIds() {
        return seatIds;
    }

    public NewReservation toNewReservation(final Long memberId, final Long performanceId) {
        return new NewReservation(memberId, performanceId, seatIds);
    }
}
