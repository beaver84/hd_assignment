package com.hdjuction.project.model.repository;

import com.hdjuction.project.model.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
