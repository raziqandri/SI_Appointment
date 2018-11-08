package com.example.appointment.repository;

import com.example.appointment.model.LabPasienModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabPasienDb extends JpaRepository<LabPasienModel, Long> {
}
