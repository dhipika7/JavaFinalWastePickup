package com.example.Wastepickupfinal.service;

import com.example.Wastepickupfinal.models.zone;
import com.example.Wastepickupfinal.repository.zonerepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class zoneservice {

    @Autowired
    private zonerepository zonerepository;

    public zone addZone(zone zone) {
        return zonerepository.save(zone);
    }

    public List<zone> getAllZones() {
        return zonerepository.findAll();
    }

    public zone getZoneById(Long id) {
        return zonerepository.findById(id).orElse(null);
    }

    public void deleteZone(Long id) {
        zonerepository.deleteById(id);
    }
}