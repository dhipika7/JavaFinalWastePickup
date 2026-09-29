package com.example.Wastepickupfinal.controller;

import com.example.Wastepickupfinal.models.schedule;
import com.example.Wastepickupfinal.service.scheduleservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class schedulecontroller {

    @Autowired
    private scheduleservice scheduleservice;

    @PostMapping
    public schedule addSchedule(@RequestBody schedule schedule) {
        return scheduleservice.addSchedule(schedule);
    }

    @GetMapping
    public List<schedule> getAllSchedules() {
        return scheduleservice.getAllSchedules();
    }

    @GetMapping("/{id}")
    public schedule getScheduleById(@PathVariable Long id) {
        return scheduleservice.getScheduleById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteSchedule(@PathVariable Long id) {
        scheduleservice.deleteSchedule(id);
        return "Schedule deleted successfully";
    }
}