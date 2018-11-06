package com.example.appointment.Repository;

import com.example.appointment.Model.DokterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DokterDb extends JpaRepository<DokterModel, Long> {
}
