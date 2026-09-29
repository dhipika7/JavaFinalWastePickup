package com.example.Wastepickupfinal.models;

import jakarta.persistence.*;

@Entity
public class zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double minimumScore;

    public zone() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMinimumScore() {
        return minimumScore;
    }

    public void setMinimumScore(double minimumScore) {
        this.minimumScore = minimumScore;
    }
}