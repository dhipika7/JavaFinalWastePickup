package com.example.Wastepickupfinal.controller;

import com.example.Wastepickupfinal.models.zone;
import com.example.Wastepickupfinal.service.zoneservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zones")
public class zonecontroller {

    @Autowired
    private zoneservice zoneservice;

    @PostMapping
    public zone addZone(@RequestBody zone zone) {
        return zoneservice.addZone(zone);
    }

    @GetMapping
    public List<zone> getAllZones() {
        return zoneservice.getAllZones();
    }

    @GetMapping("/{id}")
    public zone getZoneById(@PathVariable Long id) {
        return zoneservice.getZoneById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteZone(@PathVariable Long id) {
        zoneservice.deleteZone(id);
        return "Zone deleted successfully";
    }

    @PutMapping("/{id}")
    public zone updateZone(
            @PathVariable Long id,
            @RequestBody zone zone) {

        return zoneservice.updateZone(id, zone);
    }
}