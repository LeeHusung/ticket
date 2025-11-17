package com.ticket.member;

import com.ticket.member.dto.MemberCreateRequest;
import com.ticket.member.dto.MemberResponse;
import com.ticket.member.repository.MemberRepository;
import com.ticket.member.service.MemberService;
import com.ticket.member.vo.Email;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SuppressWarnings("NonAsciiCharacters")
@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {

    @InjectMocks
    private MemberService memberService;

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    void 회원가입시_비밀번호는_암호화된_값으로_저장된다() {
        //given
        MemberCreateRequest.MemberCreateCommand memberCreateCommand = new MemberCreateRequest.MemberCreateCommand("test@test.com", "1234", "ANONYMOUS");
        when(passwordEncoder.encode("1234")).thenReturn("ENC(1234)");
        when(memberRepository.save(any(Member.class))).thenAnswer(invocation -> invocation.getArgument(0));
        //when
        final MemberResponse response = memberService.register(memberCreateCommand);
        //then
        verify(passwordEncoder).encode("1234");
        verify(memberRepository).save(argThat(
                member ->
                        member.getEmail().equals(new Email("test@test.com"))
                        && member.getPassword().equals("ENC(1234)")
                        && member.getName().equals("ANONYMOUS"))
        );
        assertThat(response.getEmail()).isEqualTo(memberCreateCommand.getEmail());
        assertThat(response.getName()).isEqualTo(memberCreateCommand.getName());
    }
}
