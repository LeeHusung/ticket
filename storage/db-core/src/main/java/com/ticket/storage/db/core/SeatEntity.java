package com.ticket.storage.db.core;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class SeatEntity {

    @Id @GeneratedValue
    private Long id;

    private Long performanceId;

    //행
    private String x;

    //열
    private String y;

    private String status;

    public Long getId() {
        return id;
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }
}
