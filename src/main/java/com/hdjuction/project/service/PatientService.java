package com.hdjuction.project.service;

import com.hdjuction.project.config.exception.ApiException;
import com.hdjuction.project.model.dto.PatientRequest;
import com.hdjuction.project.model.entity.Patient;
import com.hdjuction.project.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
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

    public void deletePatient(String id) {
    }
}
