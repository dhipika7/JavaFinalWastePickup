package com.example.Wastepickupfinal.models;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
public class schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String day;

    private LocalTime startTime;

    private LocalTime endTime;

    @ManyToOne
    private zone zone;

    public schedule() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public zone getZone() {
        return zone;
    }

    public void setZone(zone zone) {
        this.zone = zone;
    }
}