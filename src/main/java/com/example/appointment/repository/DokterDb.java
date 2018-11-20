package com.example.appointment.repository;

import java.util.List;

import com.example.appointment.model.DokterModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DokterDb extends JpaRepository<DokterModel, Long> {
    List<DokterModel> findByFlagGroup(int flagGroup);
}
