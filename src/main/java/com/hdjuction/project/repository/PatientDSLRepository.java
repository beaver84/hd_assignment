package com.hdjuction.project.repository;

import com.hdjuction.project.model.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDSLRepository{
    Page<Patient> findAllV2(String patientName, String patientNo, String birthday, Pageable pageable);
}
