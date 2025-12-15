package com.ticket.core.domain.reservation;

import com.ticket.core.domain.member.Member;
import com.ticket.core.domain.member.MemberFinder;
import com.ticket.core.enums.EntityStatus;
import com.ticket.core.enums.PerformanceSeatState;
import com.ticket.core.enums.PerformanceState;
import com.ticket.core.support.exception.ErrorType;
import com.ticket.core.support.exception.NotFoundException;
import com.ticket.storage.db.core.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {

    private final MemberFinder memberFinder;
    private final ShowRepository showRepository;
    private final PerformanceRepository performanceRepository;
    private final PerformanceSeatRepository performanceSeatRepository;
    private final ReservationRepository reservationRepository;
    private final ReservationDetailRepository reservationDetailRepository;

    public ReservationService(final MemberFinder memberFinder,
                              final ShowRepository showRepository,
                              final PerformanceRepository performanceRepository,
                              final PerformanceSeatRepository performanceSeatRepository,
                              final ReservationRepository reservationRepository,
                              final ReservationDetailRepository reservationDetailRepository
    ) {
        this.memberFinder = memberFinder;
        this.showRepository = showRepository;
        this.performanceRepository = performanceRepository;
        this.performanceSeatRepository = performanceSeatRepository;
        this.reservationRepository = reservationRepository;
        this.reservationDetailRepository = reservationDetailRepository;
    }

    @Transactional
    public void reserve(final NewReservation newReservation) {
        final Member foundMember = memberFinder.find(newReservation.getMemberId());
        final ShowEntity foundShow = showRepository.findByIdAndStatus(newReservation.getShowId(), EntityStatus.ACTIVE)
                .orElseThrow(() -> new NotFoundException(ErrorType.NOT_FOUND_DATA));
        final PerformanceEntity foundPerformance = performanceRepository.findByIdAndShowIdAndStateAndStatus(
                        newReservation.getPerformanceId(),
                        foundShow.getId(),
                        PerformanceState.ACTIVE,
                        EntityStatus.ACTIVE)
                .orElseThrow(() -> new NotFoundException(ErrorType.NOT_FOUND_DATA));

        final List<PerformanceSeatEntity> performanceSeats = performanceSeatRepository.findByPerformanceIdAndSeatIdInAndState(
                foundPerformance.getId(),
                newReservation.getSeatIds(),
                PerformanceSeatState.AVAILABLE
        );

        performanceSeats.forEach(PerformanceSeatEntity::reserve);

        final Reservation reservation = new Reservation(
                foundMember.getId(),
                foundShow.getId(),
                foundPerformance.getId(),
                newReservation.getSeatIds(),
                LocalDateTime.now()
        );

//        final ReservationEntity savedReservation = reservationRepository.save(new ReservationEntity(
//                foundMember.getId(),
//                foundShow.getId(),
//                foundPerformance.getId()));
//        reservationDetailRepository.saveAll(
//                performanceSeats.stream()
//                        .map(p -> new ReservationDetailEntity(savedReservation.getId(), p.getId()))
//                        .toList()
//        );
    }
}
