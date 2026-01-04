package com.ticket.core.domain.hold;

import com.ticket.core.domain.member.Member;
import com.ticket.core.domain.member.MemberFinder;
import com.ticket.core.domain.performance.Performance;
import com.ticket.core.domain.performance.PerformanceFinder;
import com.ticket.core.domain.performanceseat.PerformanceSeatFinder;
import com.ticket.core.support.exception.CoreException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SuppressWarnings("NonAsciiCharacters")
@ExtendWith(MockitoExtension.class)
class HoldServiceV1Test {

    @InjectMocks
    private HoldServiceV1 holdService;
    @Mock
    private MemberFinder memberFinder;
    @Mock
    private PerformanceFinder performanceFinder;
    @Mock
    private PerformanceSeatFinder performanceSeatFinder;

    @Test
    void 선점_요청한_좌석_중_하나라도_불가능하면_전체가_실패한다() {
        // given
        Long memberId = 1L;
        Long performanceId = 2L;
        List<Long> seatIds = List.of(1L, 2L);

        Member member = mock(Member.class);

        Performance performance = mock(Performance.class);
        when(performance.getId()).thenReturn(performanceId);

        when(memberFinder.find(memberId)).thenReturn(member);
        when(performanceFinder.findOpenPerformance(performanceId)).thenReturn(performance);
        when(performanceSeatFinder.findAvailablePerformanceSeats(seatIds, performanceId))
                .thenReturn(Collections.emptyList());
        NewSeatHold newSeatHold = new NewSeatHold(memberId, performanceId, seatIds);

        // when & then
        assertThatThrownBy(() -> holdService.hold(newSeatHold))
                .isInstanceOf(CoreException.class);
    }
}