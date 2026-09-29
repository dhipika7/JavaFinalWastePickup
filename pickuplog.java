package com.example.Wastepickupfinal.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class pickuplog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime pickupTime;

    private int segregationScore;

    @ManyToOne
    private household household;

    public pickuplog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(LocalDateTime pickupTime) {
        this.pickupTime = pickupTime;
    }

    public int getSegregationScore() {
        return segregationScore;
    }

    public void setSegregationScore(int segregationScore) {
        this.segregationScore = segregationScore;
    }

    public household getHousehold() {
        return household;
    }

    public void setHousehold(household household) {
        this.household = household;
    }
}