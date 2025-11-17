package com.ticket.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberCreateRequest {

    private String email;
    private String password;
    private String name;

    public MemberCreateCommand toCommand() {
        return new MemberCreateCommand(email, password, name);
    }

    @AllArgsConstructor
    @Getter
    static public class MemberCreateCommand {
        private String email;
        private String password;
        private String name;
    }
}
