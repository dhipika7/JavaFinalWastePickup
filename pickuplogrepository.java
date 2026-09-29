package com.example.Wastepickupfinal.repository;

import com.example.Wastepickupfinal.models.pickuplog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface pickuplogrepository extends JpaRepository<pickuplog, Long> {
}