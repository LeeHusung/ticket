package com.ticket.storage.db.core;

import com.ticket.core.enums.PerformanceSeatState;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.List;

public interface PerformanceSeatRepository extends JpaRepository<PerformanceSeatEntity, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<PerformanceSeatEntity> findByPerformanceIdAndSeatIdInAndState(Long performanceId, List<Long> seatIds, PerformanceSeatState state);
}
