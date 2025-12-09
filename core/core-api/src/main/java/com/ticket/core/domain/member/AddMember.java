package com.ticket.core.domain.member;

import com.ticket.core.domain.member.vo.Password;
import com.ticket.core.enums.Role;

public class AddMember {

    private final String email;
    private final Password password;
    private final String name;
    private final Role role;

    public AddMember(final String email, final String rawPassword, final String name, final Role role) {
        this.email = email;
        this.password = new Password(rawPassword);
        this.name = name;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public Password getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }
}
