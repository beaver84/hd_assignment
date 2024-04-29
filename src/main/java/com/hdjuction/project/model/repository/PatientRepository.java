package com.hdjuction.project.model.repository;

import com.hdjuction.project.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
