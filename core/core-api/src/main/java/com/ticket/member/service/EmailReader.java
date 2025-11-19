package com.ticket.member.service;

import com.ticket.exception.DuplicateEmailException;
import com.ticket.member.repository.MemberRepository;
import com.ticket.member.vo.Email;
import org.springframework.stereotype.Component;

@Component
public class EmailReader {

    private final MemberRepository memberRepository;

    public EmailReader(final MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Email readEmail(final String email) {
        if (memberRepository.existsByEmailAddress(email)) {
            throw new DuplicateEmailException("중복 이메일은 허용되지 않습니다.");
        }
        return new Email(email);
    }
}
