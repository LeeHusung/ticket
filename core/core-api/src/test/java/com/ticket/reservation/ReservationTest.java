package com.ticket.reservation;

import com.ticket.core.domain.performanceseat.PerformanceSeat;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class ReservationTest {

    @Test
    void 재고가_있다면_예매를_성공한다() {
        //given
        int count = 4;
        final PerformanceSeat performanceSeat = new PerformanceSeat(count);
        //when
        boolean canReservation = performanceSeat.canReservation();
        //then
        assertThat(canReservation).isTrue();
    }
}
