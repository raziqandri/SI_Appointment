package com.example.appointment.Repository;

import com.example.appointment.Model.StaffModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffDb extends JpaRepository<StaffModel, Long> {
    StaffModel findByJenis(int jenis);
}
