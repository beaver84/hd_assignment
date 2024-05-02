package com.hdjuction.project.service;

import com.hdjuction.project.config.exception.ApiException;
import com.hdjuction.project.model.dto.PagePatientsRequest;
import com.hdjuction.project.model.dto.PatientRequest;
import com.hdjuction.project.model.dto.PatientResponse;
import com.hdjuction.project.model.entity.Patient;
import com.hdjuction.project.model.entity.Visit;
import com.hdjuction.project.repository.PatientDSLRepository;
import com.hdjuction.project.repository.PatientRepository;
import com.hdjuction.project.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    private final VisitRepository visitRepository;
    private final PatientDSLRepository patientDSLRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository,
                          VisitRepository visitRepository,
                          PatientDSLRepository patientDSLRepository) {
        this.patientRepository = patientRepository;
        this.visitRepository = visitRepository;
        this.patientDSLRepository = patientDSLRepository;
    }

    public Patient getPatientDetail(Long id) {
        return patientRepository.findById(id).orElseThrow(() -> new ApiException(HttpStatus.BAD_REQUEST, "환자를 찾을 수 없습니다."));
    }

    public Long modifyPatient(Long id, PatientRequest patientRequest) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new ApiException(HttpStatus.BAD_REQUEST, "환자를 찾을 수 없습니다."));

        Patient patientBuilder = patient.builder().patientName(patientRequest.getPatientName())
                .patientNo(patientRequest.getPatientNo())
                .sexCode(patientRequest.getSexCode())
                .birthday(patientRequest.getBirthday())
                .telNo(patientRequest.getTelNo())
                .build();
        patientRepository.save(patientBuilder);
        return 1L;
    }

    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    public Long addPatient(PatientRequest patientRequest) {
        Patient patient = new Patient();

        Patient patientBuilder = patient.builder().patientName(patientRequest.getPatientName())
                .patientNo(patientRequest.getPatientNo())
                .sexCode(patientRequest.getSexCode())
                .birthday(patientRequest.getBirthday())
                .telNo(patientRequest.getTelNo())
                .build();
        patientRepository.save(patientBuilder);
        return 1L;
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    public PatientResponse getPatientAndVisitInfo(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ApiException(HttpStatus.BAD_REQUEST, "환자정보가 존재하지 않습니다."));

        List<Visit> visitByPatient = visitRepository.findAllByPatient(patient);

        PatientResponse patientResponse = new PatientResponse();

        return patientResponse.builder()
                .patientName(patient.getPatientName())
                .patientNo(patient.getPatientNo())
                .sexCode(patient.getSexCode())
                .birthday(patient.getSexCode())
                .telNo(patient.getTelNo())
                .visitList(visitByPatient)
                .build();
    }

    public Page<Patient> getPatientsV2(String patientName, String patientNo, String birthday, PagePatientsRequest pageable) {
        return patientDSLRepository.findAllV2(patientName, patientNo, birthday, (Pageable) pageable);
    }
}
