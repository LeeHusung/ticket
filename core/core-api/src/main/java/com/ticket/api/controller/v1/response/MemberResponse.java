package com.ticket.api.controller.v1.response;

public class MemberResponse {
    private final Long id;
    private final String email;
    private final String name;

    public MemberResponse(final Long id, final String email, final String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
