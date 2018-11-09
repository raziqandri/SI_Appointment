package com.example.appointment.repository;

import com.example.appointment.model.TagihanPasienModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusPasienDb extends JpaRepository<TagihanPasienModel, Long> {
}
