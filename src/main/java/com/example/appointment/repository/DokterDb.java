package com.example.appointment.repository;

import com.example.appointment.model.DokterModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DokterDb extends JpaRepository<DokterModel, Long> {

}
