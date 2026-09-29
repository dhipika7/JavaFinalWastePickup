package com.example.Wastepickupfinal.service;

import com.example.Wastepickupfinal.models.household;
import com.example.Wastepickupfinal.repository.householdrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class householdservice {

    @Autowired
    private householdrepository householdrepository;

    public household addHousehold(household household) {
        return householdrepository.save(household);
    }

    public List<household> getAllHouseholds() {
        return householdrepository.findAll();
    }

    public household getHouseholdById(Long id) {
        return householdrepository.findById(id).orElse(null);
    }

    public void deleteHousehold(Long id) {
        householdrepository.deleteById(id);
    }
}