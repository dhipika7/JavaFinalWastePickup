package com.example.Wastepickupfinal.models;

import jakarta.persistence.*;

@Entity
public class household {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private boolean flagged;

    @ManyToOne
    private zone zone;

    public household() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public zone getZone() {
        return zone;
    }

    public void setZone(zone zone) {
        this.zone = zone;
    }
}