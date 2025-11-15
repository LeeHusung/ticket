package com.ticket.member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String name;
    private String password;

    public static Member register(final String email, final String password, final String name) {
        return new Member(email, password, name);
    }

    private Member(final String email, final String password, final String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
}
