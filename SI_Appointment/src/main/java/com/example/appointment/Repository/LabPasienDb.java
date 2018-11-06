package com.example.appointment.Repository;

import com.example.appointment.Model.LabPasienModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabPasienDb extends JpaRepository<LabPasienModel, Long> {
}
