package com.ticket.core.domain.reservation;

import com.ticket.core.domain.performanceseat.PerformanceSeat;
import com.ticket.core.enums.PerformanceSeatState;
import com.ticket.core.support.IntegrationBase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class ReservationServiceV1Test extends IntegrationBase {

    @Autowired
    @Qualifier("reservationServiceV1")
    private ReservationService reservationService;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ReservationDetailRepository reservationDetailRepository;

    @AfterEach
    void tearDown() {
        reservationDetailRepository.deleteAllInBatch();
        reservationRepository.deleteAllInBatch();
    }

    @Test
    void 예매를_성공한다() {
        // given
        final NewReservation newReservation = new NewReservation(
                savedMembers.getFirst().getId(),
                savedPerformance.getId(),
                List.of(1L)
        );
        // when
        reservationService.addReservation(newReservation);
        final List<PerformanceSeat> reservedSeats = performanceSeatRepository.findAllById(
                savedPerformanceSeats.stream().map(PerformanceSeat::getId).toList()
        );
        // then
        assertThat(reservedSeats).allMatch(seat -> seat.getState() == PerformanceSeatState.RESERVED);
        final List<Reservation> reservations = reservationRepository.findAll();
        assertThat(reservations).hasSize(1);
        assertThat(reservations.getFirst().getMemberId()).isEqualTo(savedMembers.getFirst().getId());

        final List<ReservationDetail> details = reservationDetailRepository.findAll();
        assertThat(details).hasSize(1);
    }
}
