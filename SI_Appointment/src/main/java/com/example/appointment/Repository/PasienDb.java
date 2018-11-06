package com.example.appointment.Repository;

import com.example.appointment.Model.PasienModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasienDb extends JpaRepository<PasienModel, Long> {
    PasienModel findByStatusPasien(int status);
}
