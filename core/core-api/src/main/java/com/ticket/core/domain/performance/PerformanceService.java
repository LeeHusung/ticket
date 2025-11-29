package com.ticket.core.domain.performance;

import com.ticket.core.support.exception.ErrorType;
import com.ticket.core.support.exception.NotFoundException;
import com.ticket.storage.db.core.PerformanceEntity;
import com.ticket.storage.db.core.PerformanceRepository;
import org.springframework.stereotype.Service;

@Service
public class PerformanceService {

    private final PerformanceRepository performanceRepository;

    public PerformanceService(final PerformanceRepository performanceRepository) {
        this.performanceRepository = performanceRepository;
    }

    public Performance findById(final Long id) {
        final PerformanceEntity performanceEntity = performanceRepository.findById(id).orElseThrow(() -> new NotFoundException(ErrorType.NOT_FOUND));
        return new Performance(performanceEntity.getId(), performanceEntity.getStartTime(), performanceEntity.getEndTime(), performanceEntity.getReserveOpenTime(), performanceEntity.getReserveCloseTime());
    }
}
