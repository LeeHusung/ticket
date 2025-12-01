package com.ticket.core.domain.seat;

import com.ticket.storage.db.core.SeatRepository;
import org.springframework.stereotype.Service;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    public SeatService(final SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

}
