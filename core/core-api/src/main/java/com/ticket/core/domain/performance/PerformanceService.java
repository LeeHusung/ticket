package com.ticket.core.domain.performance;

import com.ticket.storage.db.core.PerformanceRepository;
import com.ticket.storage.db.core.SeatRepository;
import org.springframework.stereotype.Service;

@Service
public class PerformanceService {

    private final PerformanceRepository performanceRepository;
    private final SeatRepository seatRepository;

    public PerformanceService(final PerformanceRepository performanceRepository, final SeatRepository seatRepository) {
        this.performanceRepository = performanceRepository;
        this.seatRepository = seatRepository;
    }

    //TODO PerformanceSeat으로 이동 필요
//    public List<Seat> findAllSeatByPerformance(final Long performanceId) {
//        final Long availableCount = seatRepository.countByPerformanceIdAndStatus(performanceId, SeatStatus.AVAILABLE);
//        if (availableCount <= 0) throw new CoreException(ErrorType.NOT_EXIST_AVAILABLE_SEAT);
//        final List<SeatEntity> seatEntities = seatRepository.findByPerformanceId(performanceId);
//        if (seatEntities.isEmpty()) {
//            throw new NotFoundException(ErrorType.NOT_FOUND);
//        }
//        return seatEntities.stream()
//                .map(e -> new Seat(e.getId(),
//                        e.getPerformanceId(),
//                        e.getX(),
//                        e.getY(),
//                        e.getStatus())
//                )
//                .toList();
//    }
}
