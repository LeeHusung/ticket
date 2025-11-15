package com.ticket.member;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MemberTest {

    @Test
    public void 정상_입력값이면_Member가_생성된다() {
        //given
        String email = "test@test.com";
        String password = "1234";
        String name = "ANONYMOUS";

        //when
        Member member = Member.register(email, password, name);

        //then
        assertThat(email).isEqualTo(member.getEmail());
        assertThat(password).isEqualTo(member.getPassword());
        assertThat(name).isEqualTo(member.getName());
    }


}
