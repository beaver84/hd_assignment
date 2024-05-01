package com.hdjuction.project.repository;

import com.hdjuction.project.model.entity.Hospital;
import com.hdjuction.project.model.entity.Patient;
import com.hdjuction.project.model.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long>{

    List<Visit> findAllByPatient(Patient patient);
}
