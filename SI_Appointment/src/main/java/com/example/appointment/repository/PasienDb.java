package com.example.appointment.repository;

import java.util.List;

import com.example.appointment.model.PasienModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasienDb extends JpaRepository<PasienModel, Long> {
    List<PasienModel> findByStatusPasienJenisIsContaining(String jenis);
}