package com.ticket.core.api.controller.v1;

import com.ticket.core.api.controller.v1.request.AddReservationRequest;
import com.ticket.core.domain.member.MemberDetails;
import com.ticket.core.domain.reservation.ReservationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(final ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    /**
     * 예매
     * @param request
     */
    @PostMapping("/api/v1/reserve/{performanceId}")
    public void reserve(MemberDetails memberDetails, @PathVariable Long performanceId, @RequestBody @Valid AddReservationRequest request) {
        reservationService.reserve(request.toNewReservation(memberDetails.getMemberId(), performanceId));
    }
}
