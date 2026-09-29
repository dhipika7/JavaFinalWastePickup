package com.example.Wastepickupfinal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.Wastepickupfinal.models.household;
import com.example.Wastepickupfinal.models.pickuplog;
import com.example.Wastepickupfinal.models.schedule;
import com.example.Wastepickupfinal.repository.householdrepository;
import com.example.Wastepickupfinal.repository.pickuplogrepository;
import com.example.Wastepickupfinal.repository.schedulerepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class pickuplogservice {

    @Autowired
    private pickuplogrepository pickuplogrepository;

    @Autowired
    private householdrepository householdrepository;

    @Autowired
    private schedulerepository schedulerepository;

    public pickuplog addPickupLog(pickuplog pickuplog) {

        if (pickuplog.getSegregationScore() < 0 ||
                pickuplog.getSegregationScore() > 100) {
            throw new IllegalArgumentException(
                    "Segregation score must be between 0 and 100");
        }

        if (pickuplog.getHousehold() == null ||
                pickuplog.getHousehold().getId() == null) {
            throw new IllegalArgumentException(
                    "Household is required");
        }

        household household = householdrepository
                .findById(pickuplog.getHousehold().getId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Household not found"));

        if (pickuplog.getPickupTime() == null) {
            throw new IllegalArgumentException(
                    "Pickup time is required");
        }

        LocalDateTime pickupTime = pickuplog.getPickupTime();

        String pickupDay = pickupTime.getDayOfWeek().name();
        boolean validSchedule = false;

        List<schedule> schedules = schedulerepository.findAll();

        for (schedule schedule : schedules) {

            if (schedule.getZone() != null &&
                    schedule.getZone().getId().equals(household.getZone().getId()) &&
                    schedule.getDay().equalsIgnoreCase(pickupDay) &&
                    !pickupTime.toLocalTime().isBefore(schedule.getStartTime()) &&
                    !pickupTime.toLocalTime().isAfter(schedule.getEndTime())) {

                validSchedule = true;
                break;
            }
        }

        if (!validSchedule) {
            throw new IllegalArgumentException(
                    "Pickup is outside the scheduled collection time");
        }

        pickuplog.setHousehold(household);

        pickuplog savedPickupLog = pickuplogrepository.save(pickuplog);

        List<pickuplog> pickupLogs = pickuplogrepository.findAll();

        int totalScore = 0;
        int count = 0;

        for (pickuplog log : pickupLogs) {

            if (log.getHousehold() != null &&
                    log.getHousehold().getId().equals(household.getId())) {

                totalScore += log.getSegregationScore();
                count++;
            }
        }

        double averageScore = (double) totalScore / count;

        household.setFlagged(
                averageScore < household.getZone().getMinimumScore()
        );

        householdrepository.save(household);

        return savedPickupLog;
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

    public Map<String, Double> getZoneWiseAverageScores() {

        List<pickuplog> pickupLogs = pickuplogrepository.findAll();

        Map<String, List<Integer>> zoneScores = new HashMap<>();

        for (pickuplog log : pickupLogs) {

            if (log.getHousehold() != null &&
                    log.getHousehold().getZone() != null) {

                String zoneName = log.getHousehold().getZone().getName();

                zoneScores
                        .computeIfAbsent(zoneName, k -> new ArrayList<>())
                        .add(log.getSegregationScore());
            }
        }

        Map<String, Double> averages = new HashMap<>();

        for (Map.Entry<String, List<Integer>> entry : zoneScores.entrySet()) {

            double average = entry.getValue()
                    .stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElse(0.0);

            averages.put(entry.getKey(), average);
        }

        return averages;
    }
}