package com.example.Wastepickupfinal.repository;

import com.example.Wastepickupfinal.models.schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface schedulerepository extends JpaRepository<schedule, Long> {
}