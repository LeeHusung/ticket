package com.ticket.member;

import com.ticket.domain.member.AddMember;
import com.ticket.domain.member.PasswordPolicyValidator;
import com.ticket.storage.db.core.MemberEntity;
import com.ticket.storage.db.core.MemberRepository;
import com.ticket.domain.member.MemberService;
import com.ticket.support.exception.DuplicateEmailException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

@SuppressWarnings("NonAsciiCharacters")
@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {

    @InjectMocks
    private MemberService memberService;

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Spy
    private PasswordPolicyValidator passwordPolicyValidator;

    @Test
    public void 회원을_생성한다() {
        //given
        String email = "test@test.com";
        String password = "1234";
        String name = "ANONYMOUS";
        when(memberRepository.save(any(MemberEntity.class))).thenAnswer(invocation -> invocation.getArgument(0));
        //when
        //service에서 생성된 회원의 id를 리턴하는데, 여기 테스트코드는 npe 에러난다. 생성된 회원이 null이라 service에서 애초에 에러남. 방법은 stub? 엔티티 mock의 id를 세팅해주는 법뿐?
        memberService.register(new AddMember(email, password, name));
        //then
        verify(passwordPolicyValidator).validateAdd(password);
        verify(passwordEncoder).encode(password);
    }

    @Test
    void 회원가입시_비밀번호는_암호화된_값으로_저장된다() {
        //given
        final AddMember addMember = new AddMember("test@test.com", "1234", "ANONYMOUS");
        when(passwordEncoder.encode("1234")).thenReturn("ENC(1234)");
        when(memberRepository.save(any(MemberEntity.class))).thenAnswer(invocation -> invocation.getArgument(0));
        //when
        memberService.register(addMember);
        //then
        verify(passwordEncoder).encode("1234");
        verify(memberRepository).save(argThat(
                member ->
                        member.getEmail().equals("test@test.com")
                        && member.getPassword().equals("ENC(1234)")
                        && member.getName().equals("ANONYMOUS"))
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"123", "lhs"})
    void 비밀번호가_정책에_맞지않으면_회원가입에_실패한다(final String password) {
        //given
        AddMember addMember = new AddMember("test@test.com", password, "ANONYMOUS");
        //then
        assertThatThrownBy(() -> memberService.register(addMember)).isInstanceOf(IllegalArgumentException.class);

        verify(memberRepository, never()).save(any(MemberEntity.class));
        verify(passwordEncoder, never()).encode(anyString());
    }

    @Test
    void 이미_존재하는_이메일이면_회원가입에_실패한다() {
        //given
        final AddMember addMember = new AddMember("test@test.com", "1234", "ANONYMOUS");
        when(memberRepository.existsByEmailAddress("test@test.com")).thenReturn(true);
        //then
        assertThatThrownBy(() -> memberService.register(addMember)).isInstanceOf(DuplicateEmailException.class);
        verify(memberRepository, times(1)).existsByEmailAddress("test@test.com");
        verify(memberRepository, never()).save(any(MemberEntity.class));
        verify(passwordEncoder, never()).encode(anyString());
    }

    //todo
    //1. 비밀번호 테스트는 policytest에? 아니면 여기서?
//    2. 예외 관련 테스트, 클래스 만들기(예외처리기)
}
