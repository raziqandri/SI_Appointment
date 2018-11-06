package com.example.appointment.Repository;

import com.example.appointment.Model.TagihanPasienModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagihanPasienDb extends JpaRepository<TagihanPasienModel, Long> {
}
