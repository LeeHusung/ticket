package com.ticket.reservation;

import com.ticket.core.domain.performance.Performance;
import com.ticket.core.domain.performanceseat.PerformanceSeat;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class ReservationTest {

    @Test
    void 재고가_있고_공연_회차_시작_전이면_예매를_성공한다() {
        //given
        Long userId = 1L;
        int seatCount = 4;
        final Performance performance = new Performance(LocalDateTime.now().plusHours(10), LocalDateTime.now().plusHours(15));
        final PerformanceSeat performanceSeat = new PerformanceSeat(performance, seatCount);

        final LocalDateTime currTime = LocalDateTime.now();
        //when
        boolean isReserved = performanceSeat.reserve(userId, currTime);
        //when
        //then
        assertThat(isReserved).isTrue();
    }

    @Test
    void 재고가_없다면_예매를_실패한다() {
        //given
        Long userId = 1L;
        int seatCount = 0;
        final Performance performance = new Performance(LocalDateTime.now().minusHours(10), LocalDateTime.now().minusHours(5));
        final PerformanceSeat performanceSeat = new PerformanceSeat(performance, seatCount);

        final LocalDateTime currTime = LocalDateTime.now();
        //when
        boolean isReserved = performanceSeat.reserve(userId, currTime);
        //then
        assertThat(isReserved).isFalse();
    }

    @Test
    void 현재보다_과거_회차를_예매하려고_하면_실패한다() {
        //given
        Long userId = 1L;
        int seatCount = 0;
        final Performance performance = new Performance(LocalDateTime.now().minusHours(10), LocalDateTime.now().minusHours(5));
        final PerformanceSeat performanceSeat = new PerformanceSeat(performance, seatCount);

        final LocalDateTime currTime = LocalDateTime.now();
        //when
        boolean isReserved = performanceSeat.reserve(userId, currTime);
        //then
        assertThat(isReserved).isFalse();
    }
}
