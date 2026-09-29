package com.example.Wastepickupfinal.controller;

import com.example.Wastepickupfinal.models.household;
import com.example.Wastepickupfinal.service.householdservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/households")
public class householdcontroller {

    @Autowired
    private householdservice householdservice;

    @PostMapping
    public household addHousehold(@RequestBody household household) {
        return householdservice.addHousehold(household);
    }

    @GetMapping
    public List<household> getAllHouseholds() {
        return householdservice.getAllHouseholds();
    }

    @GetMapping("/{id}")
    public household getHouseholdById(@PathVariable Long id) {
        return householdservice.getHouseholdById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteHousehold(@PathVariable Long id) {
        householdservice.deleteHousehold(id);
        return "Household deleted successfully";
    }
}