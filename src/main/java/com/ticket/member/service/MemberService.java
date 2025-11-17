package com.ticket.member.service;

import com.ticket.member.Member;
import com.ticket.member.dto.MemberCreateRequest;
import com.ticket.member.dto.MemberResponse;
import com.ticket.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberResponse register(final MemberCreateRequest.MemberCreateCommand memberCreateCommand) {
        final Member member = Member.register(memberCreateCommand.getEmail(), passwordEncoder.encode(memberCreateCommand.getPassword()), memberCreateCommand.getName());
        memberRepository.save(member);
        return MemberResponse.of(member);
    }
}
