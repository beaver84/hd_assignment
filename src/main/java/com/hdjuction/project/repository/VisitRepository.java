package com.hdjuction.project.repository;

import com.hdjuction.project.model.entity.Hospital;
import com.hdjuction.project.model.entity.Patient;
import com.hdjuction.project.model.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long>{

    Visit findByHospital(Hospital hospital);

    Patient findByPatient(Patient patient);

    void deleteByVisitId(Long id);
}
