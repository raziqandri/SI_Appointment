package com.example.appointment.repository;

import java.util.List;

import com.example.appointment.model.StaffModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffDb extends JpaRepository<StaffModel, Long> {
    List<StaffModel> findByJenisAndFlagGroup(int jenis, int flagGroup);
}
