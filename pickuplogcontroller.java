package com.example.Wastepickupfinal.controller;

import com.example.Wastepickupfinal.models.pickuplog;
import com.example.Wastepickupfinal.service.pickuplogservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pickuplogs")
public class pickuplogcontroller {

    @Autowired
    private pickuplogservice pickuplogservice;

    @PostMapping
    public pickuplog addPickupLog(@RequestBody pickuplog pickuplog) {
        return pickuplogservice.addPickupLog(pickuplog);
    }

    @GetMapping
    public List<pickuplog> getAllPickupLogs() {
        return pickuplogservice.getAllPickupLogs();
    }

    @GetMapping("/{id}")
    public pickuplog getPickupLogById(@PathVariable Long id) {
        return pickuplogservice.getPickupLogById(id);
    }

    @DeleteMapping("/{id}")
    public String deletePickupLog(@PathVariable Long id) {
        pickuplogservice.deletePickupLog(id);
        return "Pickup log deleted successfully";
    }
}