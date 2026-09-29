package com.example.Wastepickupfinal.repository;

import com.example.Wastepickupfinal.models.household;
import org.springframework.data.jpa.repository.JpaRepository;

public interface householdrepository extends JpaRepository<household, Long> {
}