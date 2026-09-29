package com.example.Wastepickupfinal.service;

import com.example.Wastepickupfinal.models.schedule;
import com.example.Wastepickupfinal.repository.schedulerepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class scheduleservice {

    @Autowired
    private schedulerepository schedulerepository;

    public schedule addSchedule(schedule schedule) {
        return schedulerepository.save(schedule);
    }

    public List<schedule> getAllSchedules() {
        return schedulerepository.findAll();
    }

    public schedule getScheduleById(Long id) {
        return schedulerepository.findById(id).orElse(null);
    }

    public void deleteSchedule(Long id) {
        schedulerepository.deleteById(id);
    }
}