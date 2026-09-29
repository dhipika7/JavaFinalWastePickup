package com.example.Wastepickupfinal.service;

import com.example.Wastepickupfinal.models.pickuplog;
import com.example.Wastepickupfinal.repository.pickuplogrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class pickuplogservice {

    @Autowired
    private pickuplogrepository pickuplogrepository;

    public pickuplog addPickupLog(pickuplog pickuplog) {
        return pickuplogrepository.save(pickuplog);
    }

    public List<pickuplog> getAllPickupLogs() {
        return pickuplogrepository.findAll();
    }

    public pickuplog getPickupLogById(Long id) {
        return pickuplogrepository.findById(id).orElse(null);
    }

    public void deletePickupLog(Long id) {
        pickuplogrepository.deleteById(id);
    }
}